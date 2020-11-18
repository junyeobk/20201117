package kr.co.kh.ClassOra;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Update {
	
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
	private char option;
	private String titleContent;
	private String titleUpdate;
	private String contentUpdate;
	private String authorUpdate;
	private String nalUpdate;
	private int readCountUpdate;
	private int cnt;
	
	public Update() {
	}
	public void boardUpdateTitle() {
		System.out.print("������ �Խù��� ������ �Է��ϼ��� : ");
		titleSearch = Register.input.next();
	}
	public void boardStmtSql() throws SQLException {
		conn = Register.getConnection();
		stmt = conn.createStatement();
		sql = "SELECT TITLE,CONTENT,AUTHOR,NAL,READCOUNT FROM BOARD WHERE TITLE ='" + titleSearch + "'";
	}
	public void boardUpdateExecuter() throws SQLException {
		rs = stmt.executeQuery(sql);
	}
	public void boardUpdateOld() throws SQLException {
		System.out.println("===�����ϱ� �� �Խñ��Դϴ�.===");
		while (rs.next()) {
			title = rs.getString("title");
			content = rs.getString("content");
			author = rs.getString("author");
			nal = rs.getString("nal");
			readCount = rs.getInt("readCount");
			System.out.print(title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readCount + "\n");
		}
	}
	public char boardUpdateOption() {
		System.out.println("������ �����ϰڽ��ϱ�?(Y/N)");
		option = Register.input.next().charAt(0);
		return option;
	}
	public void boardUpdateNew() {
		if (option == 'Y' || option == 'y') {
			System.out.print("����|����:");
			titleContent = Register.input.next();
			int indexI = titleContent.indexOf("|");
			titleUpdate = titleContent.substring(0, indexI);
			contentUpdate = titleContent.substring(indexI + 1);// 3~�� //�и� ��
			System.out.print("�ۼ���:");
			authorUpdate = Register.input.next();
			System.out.print("��¥:");
			nalUpdate = Register.input.next();
			System.out.print("��ȸ��:");
			readCountUpdate = Register.input.nextInt();
		}
	}
	public void boardStmtSqlNew() throws SQLException {
		conn = Register.getConnection();
		stmt = conn.createStatement();
		sql = "UPDATE board SET TITLE = '" + titleUpdate + "',CONTENT = '" + contentUpdate + "', AUTHOR = '"+ authorUpdate + "', NAL = '" + nalUpdate + "', READCOUNT = " + readCountUpdate+ " WHERE TITLE = '" + titleSearch + "'";
	}
	public void boardUpdateExecuterNew() throws SQLException {
		cnt = stmt.executeUpdate(sql);
		System.out.println(cnt + "�� �Խñ��� �����Ǿ����ϴ�.");
	}
}
/*
	conn = Register.getConnection();
	stmt = conn.createStatement();
	sql = "UPDATE board SET TITLE = '" + titleUpdate + "',CONTENT = '" + contentUpdate + "', AUTHOR = '"
					+ authorUpdate + "', NAL = '" + nalUpdate + "', READCOUNT = '" + readCountUpdate
					+ "' WHERE TITLE = '" + titleSearch + "'";
	int cnt = stmt.executeUpdate(sql);
	System.out.println(cnt + "�� �Խñ��� �����Ǿ����ϴ�.");
	return option;
}
*/
