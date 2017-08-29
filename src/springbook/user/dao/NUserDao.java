package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import springbook.user.domain.User;

public class NUserDao extends UserDao {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		// N 사 DB connection 생성코드
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook", "spring", "book");
		
		return c;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		NUserDao dao = new NUserDao();
		
		User user = new User();
		user.setId("greenhat");
		user.setName("N사");
		user.setPassword("ordered");
		
		dao.add(user);
		
		System.out.println(user.getId() + " 등록 성공");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId() + " 조회 성공");
	}

}
