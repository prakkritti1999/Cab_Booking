package com.NotificationService.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.NotificationService.dao.Notification;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class TwilioSmsService {

	@Value(value = "${twilio.account_sid}")
	String account_sid;

	@Value("${twilio.auth_token}")
	String auth_token;

	String from_no;

	public void sendSms(Notification bookingDetails) {
		Twilio.init(account_sid,auth_token);
		String message = "\nDear User ! \n"+
						"Your "+bookingDetails.getCab_color().toUpperCase()+" "+ bookingDetails.getCabModel()+"\t"+"("+bookingDetails.getCab_plate_no()+")"+ " cab has been booked. \n"+
						bookingDetails.getDriver_name()+" is on the way to pick you up. \n" +
						"Call him on " + bookingDetails.getDriver_mobNo()+"\n"+
						"Please pay Rs "+bookingDetails.getBaseFare()+" after the ride is completed. \n\n"+
						"Have a Great Ride !!";
		
		
		Message.creator(new PhoneNumber("+91 8076533678"), new PhoneNumber("+18456066371"), message).create();
	}
}
