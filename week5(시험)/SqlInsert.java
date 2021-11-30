package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pstmt = null;
		String url= "jdbc:mysql://localhost:3306/kimdb?useUnicode=true&characterEncoding=utf8";
		String username = "jiho";
		String password = "1234";
		String sql = "insert into st (name, dept, gpa, year) value(?,?,?,?)";
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
			connection = DriverManager.getConnection(url, username, password);
			pstmt = connection.prepareStatement(sql);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
						"번째 이름 : " + rs.getString(2) +
						", 학과 : " + rs.getString(3) +
						", 학점 : " + rs.getString(4) +
						", 입학년도 : " + rs.getString(5));
			}
			stmt.close();
			System.out.println("종료");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("pstmt 오류");
				}
			} if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("connectino 오류");
				}
			}
		}
	}

}
