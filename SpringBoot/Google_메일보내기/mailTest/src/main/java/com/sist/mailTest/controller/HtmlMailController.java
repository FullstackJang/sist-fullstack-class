package com.sist.mailTest.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HtmlMailController {

	private JavaMailSender javaMailSender;

	public HtmlMailController(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@GetMapping("/htmlMail.do")
	public String send() {
		javaMailSender.send(new MimeMessagePreparator() {
			
			
			String text ="";
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				message.setFrom("구글보내는계정");
				message.setTo("받는이");
				message.setSubject("html 메일 보내기 연습");
				text = "<h2>회원가입 성공!</h2>";
				text += "<img src='cid:ball'>";
				
				message.setText(text,true);
				message.addInline("ball", new ClassPathResource("img/ball1.jpg"));
				
			}
		});
		
		return "OK";
	}
	
	
	
	
}
