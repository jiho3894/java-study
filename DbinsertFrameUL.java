package dbcon;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*  검색 기능을 추가하는 학생 관리 프로그램 작성  */ 

public class DbinsertFrameUL extends JFrame implements ActionListener {

	/* 필드 선언  */

	private Connection connection = null; 
	private PreparedStatement pstmt = null; 
	private ResultSet rs = null; 

	/* ui 대입 필드 선언: 텍스트 필드와 버튼  */ 

	private JTextField mKeyword, mName, mDept, mGpa, mYear; 
	private JButton btnSearch, btnPrev, btnNext, btnExit; 

	/*  생성자 선언 --> 필드의 초기화  */ 

	public DBsearchFrame(){
		setTitle("Data Search"); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		mKeyword = new JTextField(15);  /* 검색 키워드  */  
		mName = new JTextField();  /*  이름 */ 
		mDept = new JTextField();  /* 학과 */ 
		mGpa = new JTextField();    /* 학점  */ 
		mYear = new JTextField();   /* 입학년도  */

		btnSearch = new JButton("검색"); 
		btnSearch.addActionListener(this);
		btnPrev = new JButton("이전"); 
		btnPrev.addActionListener(this);
		btnNext = new JButton("다음"); 
		btnNext.addActionListener(this);
		btnExit = new JButton("Exit"); 
		btnExit.addActionListener(this);

		JPanel panel = new JPanel(); 
		panel.setLayout(new GridLayout(0,2, 10, 3));
		panel.add(mKeyword); 
		panel.add(btnSearch); 
		panel.add(new JLabel("NAME", SwingConstants.RIGHT)); 
		panel.add(mName); 
		panel.add(new JLabel("DEPT", SwingConstants.RIGHT)); 
		panel.add(mDept); 
		panel.add(new JLabel("GPA", SwingConstants.RIGHT)); 
		panel.add(mGpa); 
		panel.add(new JLabel("YEAR", SwingConstants.RIGHT)); 
		panel.add(mYear); 
		panel.add(btnPrev);   /*  현재 검색된 데이터의 이전 내용 */ 
		panel.add(btnNext);  /* 현재 검색된 데이터의 다음 내용  */ 
		panel.add(btnExit);   /*  종료 버튼 */ 

		setLayout(new FlowLayout(FlowLayout.CENTER, 10,10)); 
		add(panel); 
		pack(); 
		connect(); 
	}

	/* 데이터베이스 연결 시도 메서드   */ 

	private void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/ssdb?useUnicode=true&characterEncoding=utf8"; 
		String username="soso";   /*  root */ 
		String password="1234"; 

		/*  질의어 처리 */ 
		try {
			connection = DriverManager.getConnection(url, username, password); 
			pstmt = connection.prepareStatement("select * from st where name like ? or dept like ?"); 
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* 연결 종료  */ 
	private void disconnect() throws SQLException {
		if(pstmt !=null ) pstmt.close();
		if(connection !=null) connection.close();
	}
	private void showRecord() throws SQLException{
		mName.setText(rs.getString("NAME"));
		mDept.setText(rs.getString("DEPT"));
		mGpa.setText("" + rs.getFloat("GPA"));
		mYear.setText("" + rs.getInt("YEAR"));
	}
	
	/* 메서드  */ 
	@Override

	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		try {
			if(event.getSource() == btnSearch) {
				String word = mKeyword.getText().trim(); 
				pstmt.setString(1, word+"%");
				pstmt.setString(2, word+"%");
				rs = pstmt.executeQuery(); 
				rs.next(); 
				showRecord(); 
			} else if(event.getSource() == btnPrev) {  /*  현재 검색 리스트에서 이전 내용 */ 
				if(!rs.isFirst()) {
					rs.previous(); 
					showRecord(); 
				}
			} else if(event.getSource() == btnNext) {  /* 현재 검색 리스트에서 다음 내용 */ 
				if(!rs.isLast()) {
					rs.next(); 
					showRecord(); 
				}
			} else if(event.getSource() == btnExit) {  /* 종료 버튼  */ 
				disconnect(); 
				System.exit(0);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		(new DBsearchFrame()).setVisible(true); 
	}
}