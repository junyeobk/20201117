package kr.co.kh.ClassMy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Register {
	public static Scanner input;
	public static Connection conn;
	private String titleContent;
	private int indexI;
	private String title;
	private String content;
	private String author;
	private String nal;
	private int readCount;
	private Statement stmt;
	private String sql;
	private int cnt;
	static {
		input = new Scanner(System.in);
	}
	
	public Register() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException { //�ٸ�Ŭ�������� �ٽ� �� �� �ִ�
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysql?characterEncoding=utf8","root","");
		return conn;
	}
	public void setTitleContent() {
		System.out.println("����|����");
		titleContent = input.next();
	}
	public void titleContentProcess() {
		indexI = titleContent.indexOf("|");
		title = titleContent.substring(0, indexI);
		content = titleContent.substring(indexI + 1);// 3~�� //�и� ��
	}
	public void setAuthor() {
		System.out.println("�ۼ��� : ");
		author = input.next();
	}
	public void setNal() {
		System.out.println("��¥ :");
		nal = input.next();
	}
	public void setReadCount() {
		System.out.println("��ȸ�� : ");
		readCount = input.nextInt(); 
	}
	public void boardQuery() throws SQLException {
		stmt = conn.createStatement();
		sql = "insert into BOARD(title,content,author,nal,readCount) values('" + title + "','" + content + "','" + author + "','" + nal + "'," + readCount + ")";
	}
	public void boardExcuter() throws SQLException {
		cnt = stmt.executeUpdate(sql);
		System.out.println(cnt + "�� �Խñ��� ��ϵǾ����ϴ�.");
	}
}

//private Connection conn;
//private Scanner input;
//
//
//public Register(Connection conn, Scanner input) throws SQLException {
//	this.conn = conn;
//	this.input = input;
//	
//	System.out.print("����|����:");
//	String titleContent = input.next();
//	int indexI = titleContent.indexOf("|");
//	String title = titleContent.substring(0, indexI);
//	String content = titleContent.substring(indexI + 1);// 3~�� //�и� ��
//	System.out.print("�ۼ���:");
//	String author = input.next();
//	System.out.print("��¥:");
//	String nal = input.next();
//	System.out.print("��ȸ��:");
//	int readCount = input.nextInt();
//	// 3.�غ�(Statement) 3-1.������ �غ�
//	// 3.�غ� 3-2.�����غ�
//	Statement stmt = conn.createStatement();
//	String sql = "insert into BOARD(title,content,author,nal,readCount) values('" + title + "','" + content + "','" + author + "','" + nal + "'," + readCount + ")";
//	// 4.���� execute
//	int cnt = stmt.executeUpdate(sql);
//	System.out.println(cnt + "�� �Խñ��� ��ϵǾ����ϴ�.");
//	
//}
