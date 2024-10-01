package com.example.TwilioDemo.config;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioIntializer {
    private final static Logger LOGGER= LoggerFactory.getLogger(TwilioIntializer.class);
    private final twilioConfiguration twilioConfig;
    @Autowired
    public TwilioIntializer(twilioConfiguration twilioConfig) {
        this.twilioConfig = twilioConfig;
        Twilio.init(
                twilioConfig.getAccountSid(),
                twilioConfig.getAuthToken()
        );
        LOGGER.info("Twilio initialized ... with accountSid {}",twilioConfig.getAccountSid());
    }
}
