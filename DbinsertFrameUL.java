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

/*  �˻� ����� �߰��ϴ� �л� ���� ���α׷� �ۼ�  */ 

public class DbinsertFrameUL extends JFrame implements ActionListener {

	/* �ʵ� ����  */

	private Connection connection = null; 
	private PreparedStatement pstmt = null; 
	private ResultSet rs = null; 

	/* ui ���� �ʵ� ����: �ؽ�Ʈ �ʵ�� ��ư  */ 

	private JTextField mKeyword, mName, mDept, mGpa, mYear; 
	private JButton btnSearch, btnPrev, btnNext, btnExit; 

	/*  ������ ���� --> �ʵ��� �ʱ�ȭ  */ 

	public DBsearchFrame(){
		setTitle("Data Search"); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		mKeyword = new JTextField(15);  /* �˻� Ű����  */  
		mName = new JTextField();  /*  �̸� */ 
		mDept = new JTextField();  /* �а� */ 
		mGpa = new JTextField();    /* ����  */ 
		mYear = new JTextField();   /* ���г⵵  */

		btnSearch = new JButton("�˻�"); 
		btnSearch.addActionListener(this);
		btnPrev = new JButton("����"); 
		btnPrev.addActionListener(this);
		btnNext = new JButton("����"); 
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
		panel.add(btnPrev);   /*  ���� �˻��� �������� ���� ���� */ 
		panel.add(btnNext);  /* ���� �˻��� �������� ���� ����  */ 
		panel.add(btnExit);   /*  ���� ��ư */ 

		setLayout(new FlowLayout(FlowLayout.CENTER, 10,10)); 
		add(panel); 
		pack(); 
		connect(); 
	}

	/* �����ͺ��̽� ���� �õ� �޼���   */ 

	private void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/ssdb?useUnicode=true&characterEncoding=utf8"; 
		String username="soso";   /*  root */ 
		String password="1234"; 

		/*  ���Ǿ� ó�� */ 
		try {
			connection = DriverManager.getConnection(url, username, password); 
			pstmt = connection.prepareStatement("select * from st where name like ? or dept like ?"); 
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* ���� ����  */ 
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
	
	/* �޼���  */ 
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
			} else if(event.getSource() == btnPrev) {  /*  ���� �˻� ����Ʈ���� ���� ���� */ 
				if(!rs.isFirst()) {
					rs.previous(); 
					showRecord(); 
				}
			} else if(event.getSource() == btnNext) {  /* ���� �˻� ����Ʈ���� ���� ���� */ 
				if(!rs.isLast()) {
					rs.next(); 
					showRecord(); 
				}
			} else if(event.getSource() == btnExit) {  /* ���� ��ư  */ 
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