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
		System.out.println("삭제할 게시물의 제목 : ");
		titleDelete = Register.input.next();
	}
	public void boardStmtSql() throws SQLException{
		conn = Register.getConnection();
		stmt = conn.createStatement();
		sql = "delete from board where title='" + titleDelete + "'";
	}
	public void boardDeleteExecuter() throws SQLException {
		cnt = stmt.executeUpdate(sql);
		System.out.println(cnt +"건 게시글이 삭제되었습니다.");
	}
}

/*public Delete(Connection conn, Scanner input) throws SQLException {
	
	System.out.println("삭제할 게시물의 제목 : ");
	String titleDelete = input.next();
	// 3.준비 3-1. 공간준비
	// 3-2. 쿼리준비
	Statement stmt = conn.createStatement();
	String sql = "delete from board where title='" + titleDelete + "'";
	// 4.실행 execute
	int cnt = stmt.executeUpdate(sql); // 실행
	System.out.println(cnt + "건 게시글이 삭제되었습니다.");
}
*/