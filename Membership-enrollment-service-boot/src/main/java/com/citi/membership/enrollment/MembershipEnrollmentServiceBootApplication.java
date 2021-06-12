package com.citi.membership.enrollment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MembershipEnrollmentServiceBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MembershipEnrollmentServiceBootApplication.class, args);
	}

	@Bean
	public RestTemplate restTempate() {
		return new RestTemplate();
	}

}
