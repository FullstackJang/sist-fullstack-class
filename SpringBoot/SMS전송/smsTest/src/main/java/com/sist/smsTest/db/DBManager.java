package com.sist.smsTest.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.smsTest.vo.SmsVo;

public class DBManager {

	private static SqlSessionFactory factory;
	
	static {
		try {
			
			Reader reader = Resources.getResourceAsReader("com\\sist\\smsTest\\db\\dbConfig.xml");
			
			factory = new SqlSessionFactoryBuilder().build(reader);
			
			reader.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}//end catch
	}//end static

	public static List<SmsVo> findAll() {
		
		SqlSession session = factory.openSession();
		
		List<SmsVo> list = session.selectList("sms.findAll");
		
		session.close();
		
		return list;
	}
	
	
	
	
}//class