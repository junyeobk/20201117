package kr.co.kh.ClassMy;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
	private String titleDelete;
	private Connection conn;
	private Statement stmt;
	private String sql;
	private int cnt;
	
	
	public Delete() {
	}
	public void boardDeleteTitle() {
		System.out.println("������ �Խù��� ���� : ");
		titleDelete = Register.input.next();
	}
	public void boardStmtSql() throws SQLException{
		conn = Register.getConnection();
		stmt = conn.createStatement();
		sql = "delete from board where title='" + titleDelete + "'";
	}
	public void boardDeleteExecuter() throws SQLException {
		cnt = stmt.executeUpdate(sql);
		System.out.println(cnt +"�� �Խñ��� �����Ǿ����ϴ�.");
	}
}

/*public Delete(Connection conn, Scanner input) throws SQLException {
	
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
*/