# **SMS 전송**

## **SMS 호스팅**

- 통큰아이
- 너나우리
https://coolsms.co.kr/
https://www.nunauri.com/


<img src="https://user-images.githubusercontent.com/69107255/110964727-d366e100-8396-11eb-8241-1b04b061f950.png">


## **너나우리 문자전송 dependency**
```xml
		<dependency>
		    <groupId>org.apache.axis</groupId>
		    <artifactId>axis</artifactId>
		    <version>1.4</version>
		</dependency>
		
		<dependency>
		    <groupId>commons-logging</groupId>
		    <artifactId>commons-logging</artifactId>
		    <version>1.2</version>
		</dependency>
		
		<!-- https://mvnrepository.com/artifact/commons-discovery/commons-discovery -->
		<dependency>
		    <groupId>commons-discovery</groupId>
		    <artifactId>commons-discovery</artifactId>
		    <version>0.5</version>
		</dependency>
		
		<!-- https://mvnrepository.com/artifact/javax.xml/jaxrpc -->
		<dependency>
		    <groupId>javax.xml</groupId>
		    <artifactId>jaxrpc</artifactId>
		    <version>1.1</version>
		</dependency>
		
		<!-- https://mvnrepository.com/artifact/javax.xml.soap/saaj-api -->
		<dependency>
		    <groupId>javax.xml.soap</groupId>
		    <artifactId>saaj-api</artifactId>
		    <version>1.3.5</version>
		</dependency>
		
		<!-- https://mvnrepository.com/artifact/wsdl4j/wsdl4j -->
		<dependency>
		    <groupId>wsdl4j</groupId>
		    <artifactId>wsdl4j</artifactId>
		    <version>1.6.3</version>
		</dependency>
```

## UserSms

- smsID, smsPW를 설정해준다.

```java
package kr.co.youiwe.webservice;

public class UserSms {
	public void sendMsg(String from, String to, String msg) {
		
		String smsID = "너나우리 아이디";	
		String smsPW = "너나우리 패스워드";
		
		ServiceSMSSoapProxy sendsms = new ServiceSMSSoapProxy();
		try{		
		String senderPhone= from;		
		String receivePhone= to;		
		String smsContent= msg;
		String test1 = (smsID+smsPW+receivePhone);
		CEncrypt encrypt = new CEncrypt("MD5",test1);
		java.lang.String send=sendsms.sendSMS(smsID,encrypt.getEncryptData(), senderPhone, receivePhone, smsContent);
 		System.out.println("결과코드:"+send);
		}catch(Exception e){
		System.out.println("Exception in main:" +e);
		}
	}
}
```

## Controller
- userSms.sendMsg("너나우리에 등록된 번호", "받는이 전화번호", "문자내용");을 설정
```java
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
			userSms.sendMsg("너나우리에 등록된 번호", phone, r);
		}

		return "OK";
	}
}
```