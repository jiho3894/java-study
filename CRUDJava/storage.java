package storage;

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

public class UI extends JFrame implements ActionListener {
	private Connection connection = null; //연결
	private PreparedStatement stmt = null;
	private ResultSet rs = null; //결과값
	private JComboBox mSelect;  // 목록 선택
	private String[] depts = {"스마트IT", "컴퓨터", "디스플레이", "메카", "자동차"};  // dept 목록
	JTextField mKeyword, mName, mDept, mGpa, mEmail, mYear, mSid;
	JButton btnList, btnSearch, btnPrev, btnNext, btnExit, btnMod, btnRegister, btnDel, btnReset;
	
	/* 첫번째 창 설계*/
	public UI() {
		//제목 설정
		setTitle("41730015 B반 김지호");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		mSid = new JTextField(20);  /* 순분*/
		mKeyword = new JTextField(15);  /* 검색 키워드  */  
		mName = new JTextField();  /*  이름 */ 
		mDept = new JTextField();  /* 학과 */ 
		mGpa = new JTextField();    /* 학점  */ 
		mEmail = new JTextField();  /*이메일*/
		mYear = new JTextField();   /* 입학년도  */
		/* 다른 창으로 이동하기 위한 버튼 */
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
		panel.setLayout(new GridLayout(0,2,10,10)); /* 0,2 크기 설정 10 padding*/
		panel.add(mKeyword);  /* 검색 키워드 입력*/
		panel.add(btnSearch);  /* 키워드 입력한 내용으로 검색하기 */
		
		panel.add(new JLabel("이름", SwingConstants.RIGHT));
		panel.add(mName);
		panel.add(new JLabel("학과", SwingConstants.RIGHT));
		panel.add(mDept);
		panel.add(new JLabel("학점", SwingConstants.RIGHT));
		panel.add(mGpa);
		panel.add(new JLabel("이메일", SwingConstants.RIGHT));
		panel.add(mEmail);
		panel.add(new JLabel("입학년도", SwingConstants.RIGHT));
		panel.add(mYear); 
		panel.add(btnPrev);   /*  현재 검색된 데이터의 이전 내용 */ 
		panel.add(btnNext);  /* 현재 검색된 데이터의 다음 내용  */ 
		panel.add(btnMod);  /* 수정 */
		panel.add(btnDel);    /* 삭제 */
		panel.add(btnExit);    /* 종료 버튼 */ 
		panel.add(btnList);   /* 목록 */
		panel.add(btn1);
		/* 버튼 창을 정확하게 보기위한 color 스타일링*/
		btn1.setBackground(Color.YELLOW);
		btn1.setForeground(Color.RED);
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 10,10)); 
		add(panel); /*모양 가져오기*/
		pack(); 
		connect();
		setVisible(true); /* 화면 true 값 주기*/
		/* 다른 창으로 이동하기 위한 버튼 addActionListener 값 주기*/
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UI2(); /* 이동할 창*/
				setVisible(false); /* 현재 창은 없애기*/
			}
		});
	}
	
	/* 두번째 창 설계*/
	public class UI2 extends JFrame{
		UI2() {
			setTitle("정보 등록 창");/*두번째 창 제목 입력*/
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(0,2,10,10)); /* 0,2컬럼으로 padding값 10주기*/
			setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
			/* 다른 창으로 이동하기 위한 버튼 */
			JButton btn1 = new JButton("검색 창");
			
			/* 값 초기화*/
			mName = new JTextField(10);
			mSelect = new JComboBox<>(depts); 
			mGpa = new JTextField(10);
			mEmail = new JTextField(10);
			mYear = new JTextField(10);
			
			panel.add(new JLabel("이름", SwingConstants.RIGHT));
			panel.add(mName);
			panel.add(new JLabel("학과", SwingConstants.RIGHT)); 
			panel.add(mSelect); 
			panel.add(new JLabel("학점", SwingConstants.RIGHT));
			panel.add(mGpa);
			panel.add(new JLabel("이메일", SwingConstants.RIGHT));
			panel.add(mEmail);
			panel.add(new JLabel("입학년도", SwingConstants.RIGHT));
			panel.add(mYear);
			panel.add(btnRegister);
			panel.add(btnReset);
			panel.add(btnExit);
			panel.add(btn1);
			/* 버튼 창을 정확하게 보기위한 color 스타일링*/
			btn1.setBackground(Color.YELLOW);
			btn1.setForeground(Color.RED);
			
			add(panel);
			pack();
			connect();
			/*창을 보여주기*/
	        setVisible(true);
	        
	        /* 다른 창으로 이동하기 위한 버튼 addActionListener 값 주기*/
	        btn1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new UI(); /* 이동할창*/
					setVisible(false);  /* 현재 값은 false 줘서 창 없애기 */
				}
			});
		}
	}

	/* mysql db 연동*/
	private void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url= "jdbc:mysql://localhost:3306/kimdb?allowPublicKeyRetrieval=true&useSSL=false&useSSL=false&useUnicode=true&characterEncoding=utf8";
		String username="kimjiho";  /*username*/
		String password="1234";  /*password*/
		/*  질의어 처리 */ 
		try {
			connection = DriverManager.getConnection(url, username, password); 
			stmt = connection.prepareStatement("select * from st where s_name like ? or s_dept like ?");  /*이후에 검색창에 사용하기 위한 select문 값 담기*/
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* 연결 종료  */ 
	/* setText 값을 이용해서 현재 적혀있는 내용 삭제하기*/
	private void reset() throws SQLException {
		mSid.setText("");
		mName.setText("");
		mDept.setText("");
		mEmail.setText("");
		mGpa.setText("");
		mYear.setText("");
	}
	
	 /* exit 눌렀시 종료 시켜주기 */
	private void disconnect() throws SQLException {
		if(stmt !=null ) stmt.close();
		if(connection !=null) connection.close();
	}
	
	 /* mysql에 담겨있는 table data list 보여주기 */
	private void showRecord() throws SQLException{ 
		mSid.setText(rs.getString("s_id"));
		mName.setText(rs.getString("s_name"));
		mDept.setText(rs.getString("s_dept"));
		mEmail.setText("" + rs.getString("s_email"));
		mGpa.setText("" + rs.getFloat("s_gpa"));
		mYear.setText("" + rs.getInt("s_year"));
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		try {
			if(event.getSource() == btnRegister) { /* 등록 창 구현*/
				String sql = "insert into st (s_name,s_dept,s_gpa,s_email,s_year) values('" +
						mName.getText().trim()+"','" +
						mSelect.getSelectedItem().toString().trim()+"','" +
						mGpa.getText().trim()+"','"+
						mEmail.getText().trim()+"','"+
						mYear.getText().trim() + "')";
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
				mKeyword.setText(""); /* 다음 목록 창을 위해 검색 리스트에 담은 값 리셋*/
			} else if(event.getSource() == btnPrev) {  /*  현재 검색 리스트에서 이전 내용 */ 
				try {
					if(!rs.isFirst()) {
						rs.previous();  /* 창 이전으로 가기*/
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
						rs.next();  /* 창 이후로 가기*/
						showRecord(); 
					} else {
						System.out.println("마지막 페이지 입니다.");
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("목록이 없습니다.");
				}
			}  else if(event.getSource() == btnMod) {  /* 수정 하기 */
				/* update 문 사용하기 */
				String sql = "update st set s_name='"+mName.getText()+"', s_dept='"+mDept.getText()+"', s_gpa='"+mGpa.getText()+"', s_email='"+mEmail.getText()+"',s_year='"+mYear.getText()+"' where s_id=" +mSid.getText();
				stmt.execute(sql);
				System.out.println("수정완료.");
				reset(); /* 수정 성공시 값을 초기화 시켜준다*/
			}  else if(event.getSource() == btnDel) { /* 삭제 하기*/
				/* delete문 사용하기 */
				String sql = "delete from st where s_id = " + mSid.getText() + "";
				stmt.execute(sql);
				System.out.println("삭제완료.");
				reset(); /* 수정 성공시 값을 초기화 시켜준다*/
			}  else if(event.getSource() == btnList) {  /* 리스트 띄우기*/
				String word = mKeyword.getText(); 
				stmt.setString(1, word+"%");
				stmt.setString(2, word+"%");
				/* 검색 창 빈값일시 목록창이 나오도록 설계하였음*/
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
			} else if(event.getSource() == btnReset) {  /* 리셋 버튼*/
				/*위에서 만든 reset 가져오기*/
				reset();
			}
			/*오류시 오류상태말고 오류 문구가 뜨도록 설계*/
		} catch(SQLException e) {
			System.out.println("정보를 받지 못했습니다.");
		}
	}
	/* 맨 처음 실행시 처음으로 나오는 화면 상태 구현 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UI();
	}
}

