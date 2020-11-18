package kr.co.kh.instanceMy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BoardFunction {
	public void register(Scanner input, Connection conn) throws SQLException { // ������ �Ķ���ͷ� ��´�
		System.out.print("����|����:");
		String titleContent = input.next();
		int indexI = titleContent.indexOf("|");
		String title = titleContent.substring(0, indexI);
		String content = titleContent.substring(indexI + 1);// 3~�� //�и� ��
		System.out.print("�ۼ���:");
		String author = input.next();
		System.out.print("��¥:");
		String nal = input.next();
		System.out.print("��ȸ��:");
		int readCount = input.nextInt();
		// 3.�غ�(Statement) 3-1.������ �غ�
		// 3.�غ� 3-2.�����غ�
		Statement stmt = conn.createStatement();
		String sql = "insert into BOARD(title,content,author,nal,readCount) values('" + title + "','" + content + "','" + author + "','" + nal + "'," + readCount + ")";
		// 4.���� execute
		int cnt = stmt.executeUpdate(sql);
		System.out.println(cnt + "�� �Խñ��� ��ϵǾ����ϴ�.");

	}

	public void search(Scanner input, Connection conn) throws SQLException {
		System.out.print("ã�� �Խñ� ���� �Է� : ");
		String titleSearch = input.next();
		System.out.print("��ȣ\t����\t����\t�ۼ���\t��¥\t��ȸ��\n");
		// 3.�غ� 3-1. �����غ�
		// 3-2. �����غ�
		Statement stmt = conn.createStatement();
		String sql = "SELECT NO, TITLE, CONTENT,AUTHOR,NAL,READCOUNT FROM BOARD WHERE TITLE = '" + titleSearch + "'";
		// 4.���� execute
		ResultSet rs = stmt.executeQuery(sql); // ���� ��Ÿ����. executeQuery => select���� �ַ� // executeUpdate => ��� ���� ����
		int readCount = 0;
		while (rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String author = rs.getString("author");
			String nal = rs.getString("nal");
			readCount = rs.getInt("readCount");
			System.out.print(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readCount + "\n");
			readCount++;
		}
		stmt = conn.createStatement();
		sql = "UPDATE BOARD SET readCount = " + readCount + " WHERE title = '" + titleSearch + "'";
		stmt.executeUpdate(sql);
	}

	public void delete(Scanner input, Connection conn) throws SQLException {
		System.out.println("������ �Խù��� ���� : ");
		String titleDelete = input.next();
		// 3.�غ� 3-1. �����غ�
		// 3-2. �����غ�
		Statement stmt = conn.createStatement();
		String sql = "delete from board where title='" + titleDelete + "'";
		// 4.���� execute
		int cnt = stmt.executeUpdate(sql); // ����
		System.out.println(cnt + "�� �Խñ��� �����Ǿ����ϴ�.");
	}

	public char update(Scanner input, Connection conn) throws Exception { // Y/N�� �������ֱ� ����
		System.out.print("������ �Խù��� ������ �Է��ϼ��� : ");
		String titleSearch = input.next();
		// 3.�غ� 3-1. �����غ�
		// 3-2. �����غ�
		Statement stmt = conn.createStatement();
		String sql = "SELECT TITLE,CONTENT,AUTHOR,NAL,READCOUNT FROM BOARD WHERE TITLE ='" + titleSearch + "'";
		// 4.���� execute
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("===�����ϱ� �� �Խñ��Դϴ�.===");
		while (rs.next()) {
			String title = rs.getString("title");
			String content = rs.getString("content");
			String author = rs.getString("author");
			String nal = rs.getString("nal");
			int readCount = rs.getInt("readCount");
			System.out.print(title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readCount + "\n");
		}
		System.out.println("������ �����ϰڽ��ϱ�?(Y/N)");
		char option = input.next().charAt(0);
		if (option == 'Y' || option == 'y') {
			System.out.print("����|����:");
			String titleContent = input.next();
			int indexI = titleContent.indexOf("|");
			String titleUpdate = titleContent.substring(0, indexI);
			String contentUpdate = titleContent.substring(indexI + 1);// 3~�� //�и� ��
			System.out.print("�ۼ���:");
			String authorUpdate = input.next();
			System.out.print("��¥:");
			String nalUpdate = input.next();
			System.out.print("��ȸ��:");
			int readCountUpdate = input.nextInt();

			stmt = conn.createStatement();
			sql = "UPDATE board SET TITLE = '" + titleUpdate + "',CONTENT = '" + contentUpdate + "', AUTHOR = '"
					+ authorUpdate + "', NAL = '" + nalUpdate + "', READCOUNT = '" + readCountUpdate
					+ "' WHERE TITLE = '" + titleSearch + "'";
			int cnt = stmt.executeUpdate(sql);
			System.out.println(cnt + "�� �Խñ��� �����Ǿ����ϴ�.");
		}
		return option;

	}

	public void list(Connection conn) throws SQLException {
		System.out.println("===���Խ��� ��ü���===");
		System.out.print("��ȣ\t����\t����\t�ۼ���\t��¥\t��ȸ��\n");
		// 3.�غ� 3-1. �����غ�
		// 3-2. �����غ�
		Statement stmt = conn.createStatement();
		String sql = "SELECT NO,TITLE,CONTENT,AUTHOR,NAL,READCOUNT FROM BOARD";
		// 4.���� execute
		ResultSet rs = stmt.executeQuery(sql);
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
