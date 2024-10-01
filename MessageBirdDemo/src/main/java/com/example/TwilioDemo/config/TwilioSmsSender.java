package com.example.TwilioDemo.config;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service("twilio")
public class TwilioSmsSender implements SmsSender {


    private final twilioConfiguration twilioConfiguration;

    private static final Logger LOGGER= LoggerFactory.getLogger(TwilioSmsSender.class);
    @Autowired
    public TwilioSmsSender(com.example.TwilioDemo.config.twilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {
        if (isPhoneNumberValid(smsRequest.getPhoneNumber())) {
//            String otp = generateRandomOtp();
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            String message =  " This is your  otp for verification " + smsRequest.getMessage();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            LOGGER.info("Send sms {}", smsRequest);
        } else {
            throw new IllegalArgumentException(
                    "Phone number [" + smsRequest.getPhoneNumber() + "] is not a valid number");
        }

    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        //TODO implement
        return true;
    }

    private String generateRandomOtp() {
        Random random = new Random();
        int otp = 10000 + random.nextInt(90000);
        return String.valueOf(otp);
    }

}
