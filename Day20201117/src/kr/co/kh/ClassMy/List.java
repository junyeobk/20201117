package kr.co.kh.ClassMy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class List {

	private Connection conn;
	private Statement stmt;
	private String sql;
	private ResultSet rs;

	public List() {
	}

	public void listBoardTitle() {
		System.out.println("===ㄱ게시판 전체출력===");
		System.out.print("번호\t제목\t내용\t작성자\t날짜\t조회수\n");
	}

	public void boardStmtSql() throws SQLException {
		conn = Register.getConnection();
		stmt = conn.createStatement();
		sql = "SELECT NO,TITLE,CONTENT,AUTHOR,NAL,READCOUNT FROM BOARD"; //order by no asc
	}

	public void boardListExecuter() throws SQLException {
		rs = stmt.executeQuery(sql);
	}

	public void boardListProcess() throws SQLException {
		while (rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String author = rs.getString("author");
			String nal = rs.getString("nal");
			int readCount = rs.getInt("readCount");
			System.out.print(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readCount + "\n");
		}
	}

}

/*
 * public List(Connection conn, Scanner input) throws SQLException {
 * 
 * System.out.println("===ㄱ게시판 전체출력===");
 * System.out.print("번호\t제목\t내용\t작성자\t날짜\t조회수\n"); // 3.준비 3-1. 공간준비 // 3-2.
 * 쿼리준비 Statement stmt = conn.createStatement(); String sql =
 * "SELECT NO,TITLE,CONTENT,AUTHOR,NAL,READCOUNT FROM BOARD"; // 4.실행 execute
 * ResultSet rs = stmt.executeQuery(sql); while (rs.next()) {
 * 
 * int no = rs.getInt("no"); String title = rs.getString("title"); String
 * content = rs.getString("content"); String author = rs.getString("author");
 * String nal = rs.getString("nal"); int readCount = rs.getInt("readCount");
 * System.out.print(no + "\t" + title + "\t" + content + "\t" + author + "\t" +
 * nal + "\t" + readCount + "\n"); } }
 */
