package com.sist.smsTest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sist.smsTest.db.DBManager;
import com.sist.smsTest.vo.SmsVo;

@Repository
public class SmsDao {

	public List<SmsVo> findAll() {
		return DBManager.findAll();
	}
	

}
