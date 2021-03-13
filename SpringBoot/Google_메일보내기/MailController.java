package com.bit.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailController {

	@Autowired
	private MailSender javaMailSender;

	public void setJavaMailSender(MailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	@RequestMapping("/mail.do")
	public String mail()
	{
		String r  = "";
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setSubject("회원가입안내");
		mailMessage.setFrom("");
		mailMessage.setText("회원가입을 환영합니다.");
		mailMessage.setTo("rola70@nate.com");
		try {
			javaMailSender.send(mailMessage);
		}catch (Exception e) {
			// TODO: handle exception'
			System.out.println(e.getMessage());
		}
		return r;
	}
	
}





