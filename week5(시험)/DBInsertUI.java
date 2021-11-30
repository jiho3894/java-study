package connectDB;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DBInsertUI extends JFrame implements ActionListener {
	private Connection connection = null;
	private Statement stmt = null;
	private JTextField mName, mGpa, mYear;
	private JComboBox<String> mDept;
	private String[] depts = {"스마트IT" , "컴퓨터", "디스플레이", "메카", "자동차"};
	private JButton btnRegister, btnReset, btnExit;
	
	public DBInsertUI() {
		setTitle("데이터 등록");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2,10,5));
		
		/* textField 초기화*/
		mName = new JTextField(10);
		mDept = new JComboBox<>(depts);
		mGpa = new JTextField(10);
		mYear = new JTextField(10);
		
		/* button */
		btnRegister = new JButton("등록");
		btnRegister.addActionListener(this);
		btnReset = new JButton("취소");
		btnReset.addActionListener(this);
		btnExit = new JButton("종료");
		btnExit.addActionListener(this);
		
		panel.add(new JLabel("NAME", SwingConstants.RIGHT));
		panel.add(mName);
		panel.add(new JLabel("DEPT", SwingConstants.RIGHT));
		panel.add(mDept);
		panel.add(new JLabel("GPA", SwingConstants.RIGHT));
		panel.add(mGpa);
		panel.add(new JLabel("YEAR", SwingConstants.RIGHT));
		panel.add(mYear);
		
		panel.add(btnRegister);
		panel.add(btnReset);
		panel.add(btnExit);
		
		setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		add(panel);
		pack();
		connect();
		
	}
	/* 데이터베이스 연동*/
	private void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url= "jdbc:mysql://localhost:3306/kimdb?useUnicode=true&characterEncoding=utf8";
		String username = "jiho";
		String password = "1234";
		try {
			connection = DriverManager.getConnection(url, username, password);
			stmt = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		(new DBInsertUI()).setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource() == btnRegister) {
			String sql = "insert into st (name,dept,gpa,year) values('" +
					mName.getText().trim()+"','" +
					mDept.getSelectedItem().toString().trim()+"'," +
					mGpa.getText().trim()+","+
					mYear.getText().trim() + ")";
			try {
				stmt.execute(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
