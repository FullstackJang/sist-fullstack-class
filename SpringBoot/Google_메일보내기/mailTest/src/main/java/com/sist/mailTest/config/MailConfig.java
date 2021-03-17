package com.sist.mailTest.config;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

@Configuration
public class MailConfig {
	
	@Bean
	public SimpleMailMessage mailMessage() {
		return new SimpleMailMessage();
	}
	
	@Bean
	public SimpleDateFormat dateFormat() {
		return new SimpleDateFormat();
	}
	
	@Bean
	public Calendar cal() {
		return Calendar.getInstance();
	}
	
}
