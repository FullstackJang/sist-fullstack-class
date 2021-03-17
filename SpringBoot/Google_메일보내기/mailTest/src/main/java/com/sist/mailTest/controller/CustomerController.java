package com.sist.mailTest.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.mailTest.dao.MailTestDao;
import com.sist.mailTest.vo.MailTestVo;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CustomerController {
	
	private final MailTestDao dao;
	private final MailSender javaMailSender;
	private final Calendar cal;
	private final SimpleMailMessage mailMessage;

	@GetMapping("/sendMail.do")
	public String send() {
		String OK = "OK";
		
		List<MailTestVo> list = dao.findAll();
		
		try {
			
			String name = "";
			String to = "";
			String title = "";
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH);
			String text = "";
			int tot = 0;
			
			for (MailTestVo vo : list) {
				name = vo.getName();
				to = vo.getEmail();
				tot = vo.getTot();
				
				title = name+"님, " + year + "년" + month + "월 명세서입니다.[장일규]";
				text = name + "님의 "+ year + "년 " + month + "월의 요금은" + tot +"원 입니다.";			
				
				mailMessage.setSubject(title);
				mailMessage.setFrom("jewelrye6");
				mailMessage.setText(text);
				System.out.println(to);
				mailMessage.setTo(to);
				
				javaMailSender.send(mailMessage);
				
			}//end for
			
		}catch (Exception e) {
			e.printStackTrace();
		}//end catch

		return OK;
	}//send
	
	
}//class
