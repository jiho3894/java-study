package connectDB;

import java.awt.Color;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DBSearchUI extends JFrame implements ActionListener {
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private JComboBox mSelect; 
	private String[] depts = {"스마트IT", "컴퓨터", "디스플레이", "메카", "자동차"}; 
	JTextField mKeyword, mName, mDept, mGpa, mYear, mSid;
	JButton btnList, btnSearch, btnPrev, btnNext, btnExit, btnMod, btnRegister, btnDel, btnReset;
	
	public DBSearchUI() {
		setTitle("41730015 B반 김지호");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		mSid = new JTextField(20);
		mKeyword = new JTextField(15);  /* 검색 키워드  */  
		mName = new JTextField();  /*  이름 */ 
		mDept = new JTextField();  /* 학과 */ 
		mGpa = new JTextField();    /* 학점  */ 
		mYear = new JTextField();   /* 입학년도  */
		JButton btn1 = new JButton("등록 창");
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		btnPrev = new JButton("이전");
		btnPrev.addActionListener(this);
		btnNext = new JButton("다음");
		btnNext.addActionListener(this);
		btnMod = new JButton("수정");
		btnMod.addActionListener(this);
		btnDel = new JButton("삭제");
		btnDel.addActionListener(this);
		btnRegister = new JButton("등록");
		btnRegister.addActionListener(this);
		btnExit = new JButton("종료");
		btnExit.addActionListener(this);
		btnReset = new JButton("다시 입력");
		btnReset.addActionListener(this);
		btnList = new JButton("목록");
		btnList.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2,10,10));
		panel.add(mKeyword);
		panel.add(btnSearch);
		
//		panel.add(new JLabel("SID", SwingConstants.RIGHT));
//		panel.add(mSid);
		panel.add(new JLabel("이름", SwingConstants.RIGHT));
		panel.add(mName);
		panel.add(new JLabel("학과", SwingConstants.RIGHT));
		panel.add(mDept);
		panel.add(new JLabel("학점", SwingConstants.RIGHT));
		panel.add(mGpa);
		panel.add(new JLabel("입학년도", SwingConstants.RIGHT));
		panel.add(mYear); 
		panel.add(btnPrev);   /*  현재 검색된 데이터의 이전 내용 */ 
		panel.add(btnNext);  /* 현재 검색된 데이터의 다음 내용  */ 
		panel.add(btnMod);  /*수정*/
		panel.add(btnDel);    /*삭제*/
		panel.add(btnExit);    /*  종료 버튼 */ 
		panel.add(btnList);
		panel.add(btn1);
		btn1.setBackground(Color.YELLOW);
		btn1.setForeground(Color.RED);
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 10,10)); 
		add(panel); 
		pack(); 
		connect();
		setVisible(true);
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Part2();
				setVisible(false);
			}
		});
	}
	
	public class Part2 extends JFrame{
		Part2() {
			setTitle("정보 등록 창");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(0,2,10,10));
			setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
			JButton btn1 = new JButton("검색 창");
			
			/* textField 초기화*/
			mName = new JTextField(10);
			mSelect = new JComboBox<>(depts); 
			mGpa = new JTextField(10);
			mYear = new JTextField(10);
			
			panel.add(new JLabel("이름", SwingConstants.RIGHT));
			panel.add(mName);
			panel.add(new JLabel("학과", SwingConstants.RIGHT)); 
			panel.add(mSelect); 
			panel.add(new JLabel("학점", SwingConstants.RIGHT));
			panel.add(mGpa);
			panel.add(new JLabel("입학년도", SwingConstants.RIGHT));
			panel.add(mYear);
			panel.add(btnRegister);
			panel.add(btnReset);
			panel.add(btnExit);
			panel.add(btn1);
			btn1.setBackground(Color.YELLOW);
			btn1.setForeground(Color.RED);
			
			add(panel);
			pack();
			connect();
			
	        setVisible(true);
	        
	        btn1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new DBSearchUI();
					setVisible(false);
				}
			});
		}
	}

	private void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url= "jdbc:mysql://localhost:3306/41730015db?useSSL=false&useUnicode=true&characterEncoding=utf8";
		String username="kimjiho";   /*  root */ 
		String password="1234"; 
		/*  질의어 처리 */ 
		try {
			connection = DriverManager.getConnection(url, username, password); 
			stmt = connection.prepareStatement("select * from st where name like ? or dept like ?"); 
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* 연결 종료  */ 
	private void reset() throws SQLException {
		mSid.setText("");
		mName.setText("");
		mDept.setText("");
		mGpa.setText("");
		mYear.setText("");
	}
	
	private void disconnect() throws SQLException { /* 종료 */
		if(stmt !=null ) stmt.close();
		if(connection !=null) connection.close();
	}
	
	private void showRecord() throws SQLException{  /* 목록 보여주기 */
		mSid.setText(rs.getString("SID"));
		mName.setText(rs.getString("NAME"));
		mDept.setText(rs.getString("DEPT"));
		mGpa.setText("" + rs.getFloat("GPA"));
		mYear.setText("" + rs.getInt("YEAR"));
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		try {
			if(event.getSource() == btnRegister) { /* 등록하기*/
				String sql = "insert into st (name,dept,gpa,year) values('" +
						mName.getText().trim()+"','" +
						mSelect.getSelectedItem().toString().trim()+"'," +
						mGpa.getText().trim()+","+
						mYear.getText().trim() + ")";
				stmt.execute(sql);
				System.out.println("등록완료.");
				reset();
			} else if(event.getSource() == btnSearch) { /* 검색 리스트*/
				String word = mKeyword.getText(); 
				stmt.setString(1, word+"%");
				stmt.setString(2, word+"%");
				if(!word.isEmpty()) {
					rs = stmt.executeQuery(); 
					rs.next();
					showRecord(); 
				} else {
					System.out.println("글자를 입력해주세요");
				}
			} else if(event.getSource() == btnPrev) {  /*  현재 검색 리스트에서 이전 내용 */ 
				try {
					if(!rs.isFirst()) {
						rs.previous(); 
						showRecord(); 
					} else {
						System.out.println("처음 페이지 입니다.");
					}
				} catch (Exception e) {
					System.out.println("목록이 없습니다.");
				}
			} else if(event.getSource() == btnNext) {  /* 현재 검색 리스트에서 다음 내용 */ 
				try {
					if(!rs.isLast()) {
						rs.next(); 
						showRecord(); 
					} else {
						System.out.println("마지막 페이지 입니다.");
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("목록이 없습니다.");
				}
			}  else if(event.getSource() == btnMod) {
				String sql = "update st set name='"+mName.getText()+"', dept='"+mDept.getText()+"', gpa='"+mGpa.getText()+"', year='"+mYear.getText()+"' where sid=" +mSid.getText();;
				stmt.execute(sql);
				System.out.println("수정완료.");
				reset();
			}  else if(event.getSource() == btnDel) {
				String sql = "delete from st where sid = " + mSid.getText() + "";
				stmt.execute(sql);
				System.out.println("삭제완료.");
				reset();
			}  else if(event.getSource() == btnList) {
				String word = mKeyword.getText(); 
				stmt.setString(1, word+"%");
				stmt.setString(2, word+"%");
				if(word.isEmpty()) {
					rs = stmt.executeQuery(); 
					rs.next();
					showRecord(); 
				} else {
					System.out.println("오류 발생");
				}
			}  else if(event.getSource() == btnExit) {  /* 종료 버튼  */ 
				disconnect(); 
				System.exit(0);
			} else if(event.getSource() == btnReset) {
				reset();
			}
		} catch(SQLException e) {
			System.out.println("정보가 없습니다.");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DBSearchUI();
	}
}
