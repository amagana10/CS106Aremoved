package com.wwex.springbootsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.wwex.springbootsample")
public class SpringBootSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSampleApplication.class, args);
	}

}
