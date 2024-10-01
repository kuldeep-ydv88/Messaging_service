package com.example.TwilioDemo.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

@Data
public class SmsRequest {

    @NonNull
    private final String phoneNumber;
    @NonNull
    private final String message;

    public SmsRequest(
           @JsonProperty("phoneNumber") String phoneNumber,
           @JsonProperty("message")  String message) {
        this.phoneNumber = phoneNumber;
        this.message=message;
    }

    @Override
    public String toString() {
        return "SmsRequest{" +
                "phoneNumber= ..." + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

}
