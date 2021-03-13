package com.sist.smsTest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.smsTest.dao.SmsDao;
import com.sist.smsTest.vo.SmsVo;

import kr.co.youiwe.webservice.UserSms;

@RestController
public class SmsController {

	private final SmsDao dao;
	
	public SmsController(SmsDao dao) {
		this.dao = dao;
	}

	@GetMapping("/sms.do")
	public String smsSend() {
		
		List<SmsVo> list = dao.findAll();
		
		String name = "";
		String phone = "";
		int tot = 0;
		String r ="";
		
		UserSms userSms = new UserSms();
		
		for (SmsVo vo : list) {
			name = vo.getName();
			phone = vo.getPhone();
			tot = vo.getTot();
			
			r = name + "님, 이번달 결제 금액은" + tot +"입니다.";
			userSms.sendMsg("", phone, r);
		}

		return "OK";
	}
}
