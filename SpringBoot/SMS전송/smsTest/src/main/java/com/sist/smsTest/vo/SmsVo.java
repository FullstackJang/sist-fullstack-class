package com.sist.smsTest.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SmsVo {

	private int no;
	private String name;
	private String email;
	private String phone;
	private int tot;
}
