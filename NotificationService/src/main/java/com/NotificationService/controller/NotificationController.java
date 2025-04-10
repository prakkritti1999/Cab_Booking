package com.NotificationService.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.NotificationService.dao.Notification;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
public class NotificationController {

	@Value(value = "${twilio.account_sid}")
	String account_sid;

	@Value("${twilio.auth_token}")
	String auth_token;

	/*
	 * @PostMapping("/send_SMS/") public String sendSMS(@RequestBody Notification
	 * notification) {
	 * 
	 * Twilio.init(account_sid, auth_token);
	 * 
	 * String from_number = notification.getFrom_number(); String to_number =
	 * notification.getTo_number(); String message = notification.getMessage();
	 * 
	 * 
	 * { "to_number": "+91 8076533678", "from_number":"+18456066371", "message" :
	 * "Hello from Twilio" }
	 * 
	 * 
	 * Message.creator(new PhoneNumber(to_number), new PhoneNumber(from_number),
	 * message).create(); return "SMS Send Successfully"; }
	 */
	
}
