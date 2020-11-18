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

	public static Connection getConnection() throws SQLException { //다른클래스에서 다시 쓸 수 있다
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysql?characterEncoding=utf8","root","");
		return conn;
	}
	public void setTitleContent() {
		System.out.println("제목|내용");
		titleContent = input.next();
	}
	public void titleContentProcess() {
		indexI = titleContent.indexOf("|");
		title = titleContent.substring(0, indexI);
		content = titleContent.substring(indexI + 1);// 3~끝 //분리 끝
	}
	public void setAuthor() {
		System.out.println("작성자 : ");
		author = input.next();
	}
	public void setNal() {
		System.out.println("날짜 :");
		nal = input.next();
	}
	public void setReadCount() {
		System.out.println("조회수 : ");
		readCount = input.nextInt(); 
	}
	public void boardQuery() throws SQLException {
		stmt = conn.createStatement();
		sql = "insert into BOARD(title,content,author,nal,readCount) values('" + title + "','" + content + "','" + author + "','" + nal + "'," + readCount + ")";
	}
	public void boardExcuter() throws SQLException {
		cnt = stmt.executeUpdate(sql);
		System.out.println(cnt + "건 게시글이 등록되었습니다.");
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
//	System.out.print("제목|내용:");
//	String titleContent = input.next();
//	int indexI = titleContent.indexOf("|");
//	String title = titleContent.substring(0, indexI);
//	String content = titleContent.substring(indexI + 1);// 3~끝 //분리 끝
//	System.out.print("작성자:");
//	String author = input.next();
//	System.out.print("날짜:");
//	String nal = input.next();
//	System.out.print("조회수:");
//	int readCount = input.nextInt();
//	// 3.준비(Statement) 3-1.공간을 준비
//	// 3.준비 3-2.쿼리준비
//	Statement stmt = conn.createStatement();
//	String sql = "insert into BOARD(title,content,author,nal,readCount) values('" + title + "','" + content + "','" + author + "','" + nal + "'," + readCount + ")";
//	// 4.실행 execute
//	int cnt = stmt.executeUpdate(sql);
//	System.out.println(cnt + "건 게시글이 등록되었습니다.");
//	
//}
