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
		System.out.println("===���Խ��� ��ü���===");
		System.out.print("��ȣ\t����\t����\t�ۼ���\t��¥\t��ȸ��\n");
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
 * System.out.println("===���Խ��� ��ü���===");
 * System.out.print("��ȣ\t����\t����\t�ۼ���\t��¥\t��ȸ��\n"); // 3.�غ� 3-1. �����غ� // 3-2.
 * �����غ� Statement stmt = conn.createStatement(); String sql =
 * "SELECT NO,TITLE,CONTENT,AUTHOR,NAL,READCOUNT FROM BOARD"; // 4.���� execute
 * ResultSet rs = stmt.executeQuery(sql); while (rs.next()) {
 * 
 * int no = rs.getInt("no"); String title = rs.getString("title"); String
 * content = rs.getString("content"); String author = rs.getString("author");
 * String nal = rs.getString("nal"); int readCount = rs.getInt("readCount");
 * System.out.print(no + "\t" + title + "\t" + content + "\t" + author + "\t" +
 * nal + "\t" + readCount + "\n"); } }
 */
