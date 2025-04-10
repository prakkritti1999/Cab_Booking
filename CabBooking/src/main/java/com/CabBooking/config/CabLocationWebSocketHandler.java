package com.CabBooking.config;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
public class CabLocationWebSocketHandler implements WebSocketHandler {

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("🚖 WebSocket Connected: " + session.getId());

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Runnable sendLocationUpdates = new Runnable() {
            double latitude = 28.6139;  // Example: Start near India Gate, Delhi
            double longitude = 77.2090;
            int counter = 0;

            @Override
            public void run() {
                if (counter >= 12) { // Run for 2 minutes (updates every 10 sec)
                    try {
                        session.sendMessage(new TextMessage("{\"status\": \"RIDE_COMPLETED\"}"));
                        session.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    scheduler.shutdown();
                    return;
                }

                latitude += Math.random() * 0.009;  // Simulate movement
                longitude += Math.random() * 0.009;

                try {
                    String locationJson = "{\"latitude\": " + latitude + ", \"longitude\": " + longitude + "}";
                    session.sendMessage(new TextMessage(locationJson));
                    System.out.println("📡 Sent Location: " + locationJson);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                counter++;
            }
        };

        scheduler.scheduleAtFixedRate(sendLocationUpdates, 0, 10, TimeUnit.SECONDS); // Every 10 sec	
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}
}
