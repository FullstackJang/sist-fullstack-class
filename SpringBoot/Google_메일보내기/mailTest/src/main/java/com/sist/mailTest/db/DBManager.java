package com.sist.mailTest.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.mailTest.vo.MailTestVo;

public class DBManager {
	
	private static SqlSessionFactory factory;
	
	static {
		
		try {
			
			Reader reader = Resources.getResourceAsReader("com\\sist\\mailTest\\db\\dbConfig.xml");
			
			factory = new SqlSessionFactoryBuilder().build(reader);
			
			reader.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}//end catch
		
		
		
		
	}//end static

	public static List<MailTestVo> findAll() {
		
		SqlSession session = factory.openSession();
		
		List<MailTestVo> list = session.selectList("mail.findAll");
		
		session.close();
		
		return list;
	}

}
