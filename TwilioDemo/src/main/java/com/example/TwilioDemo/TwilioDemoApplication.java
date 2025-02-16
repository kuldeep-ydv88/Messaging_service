package com.example.TwilioDemo;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableEncryptableProperties
public class TwilioDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwilioDemoApplication.class, args);
	}

}
