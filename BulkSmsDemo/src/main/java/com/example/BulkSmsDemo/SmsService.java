package com.example.BulkSmsDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpHeaders;




@Service
public class SmsService {
    private final BulkSmsConfig bulkSmsConfig;
    @Autowired
    public SmsService(BulkSmsConfig bulkSmsConfig) {
        this.bulkSmsConfig = bulkSmsConfig;
    }
    public void sendSms(String phoneNumber, String message){
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = bulkSmsConfig.getApiUrl();
        String apiKey = bulkSmsConfig.getApiKey();

        HttpHeaders headers = new HttpHeaders();

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("to", phoneNumber);
        requestBody.put("body", message);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(apiUrl, requestEntity, String.class);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            System.out.println("SMS sent successfully!");
        } else {
            System.out.println("Failed to send SMS. Response: " + responseEntity.getBody());
        }





    }


}
