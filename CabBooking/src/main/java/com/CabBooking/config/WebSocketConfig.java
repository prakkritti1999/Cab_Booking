package com.CabBooking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	
	private final CabLocationWebSocketHandler webSocketHandler;

    public WebSocketConfig(CabLocationWebSocketHandler webSocketHandler) {
        this.webSocketHandler = webSocketHandler;
    }
    
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// TODO Auto-generated method stub
		 registry.addHandler(webSocketHandler, "/cab-location").setAllowedOrigins("*");
	}

}
