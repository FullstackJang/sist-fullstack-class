package com.sist.mailTest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sist.mailTest.db.DBManager;
import com.sist.mailTest.vo.MailTestVo;

@Repository
public class MailTestDao {

	public List<MailTestVo> findAll() {
		return DBManager.findAll();
	}

}
