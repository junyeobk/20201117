package kr.co.kh.ClassOra;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Search {

	private String titleSearch;
	private Connection conn;
	private Statement stmt;
	private String sql;
	private ResultSet rs;
	private String title;
	private String content;
	private String author;
	private String nal;
	private int readCount;

	public Search() {
	}

	public void setTitleSearch() {
		System.out.print("ã�� �Խñ� ���� �Է� : ");
		titleSearch = Register.input.next();
	}

	public void boardSearchTitle() {
		System.out.print("��ȣ\t����\t����\t�ۼ���\t��¥\t��ȸ��\n");
	}

	public void boardStmtSql() throws SQLException {
		conn = Register.getConnection();
		stmt = conn.createStatement();
		sql = "SELECT NO, TITLE, CONTENT,AUTHOR,NAL,READCOUNT FROM BOARD WHERE TITLE = '" + titleSearch + "'";
	}

	public void boardSearchExecuter() throws SQLException {
		rs = stmt.executeQuery(sql);
	}
	public void boardSearchProcess() throws SQLException {
		while (rs.next()) {
			int no = rs.getInt("no");
			title = rs.getString("title");
			content = rs.getString("content");
			author = rs.getString("author");
			nal = rs.getString("nal");
			readCount = rs.getInt("readCount");
			System.out.print(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readCount + "\n");
			readCount++;
		}
	}
	public void boardSearchReadCount() throws SQLException {
		stmt = conn.createStatement();
		sql = "UPDATE BOARD SET readCount = " + readCount + " WHERE title = '" + titleSearch + "'";
		int count = stmt.executeUpdate(sql);
		System.out.println(count+"���� �˻��Ǿ����ϴ�.");
	}
}
