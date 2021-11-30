package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDB {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.print("데이터베이스 연결시도 성공");
		} catch(ClassNotFoundException e) {
			System.out.print("데이터베이스 연결시도 실패");
			System.exit(0);
		}
		String url= "jdbc:mysql://localhost:3306/kimdb";
		String username = "jiho";
		String password = "1234";
		java.sql.Connection connection = null;
		System.out.println("데이터베이스 연결중입니다.");
		try {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("데이터베이스 연결 완료했습니다.");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결시도 실패");
			System.exit(0);
		}
		String query = "select * from st";
		Statement stmt;
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getInt(1) +
						"- 이름 : " + rs.getString(2) +
						", 학과 : " + rs.getString(3) +
						", 학점 : " + rs.getString(4) +
						", 입학년도 : " + rs.getString(5));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("연결 종료합니다.");
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					
				}
			}
		}
	}

}
