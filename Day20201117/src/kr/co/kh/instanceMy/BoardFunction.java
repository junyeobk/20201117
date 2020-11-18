package kr.co.kh.instanceMy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BoardFunction {
	public void register(Scanner input, Connection conn) throws SQLException { // 에러는 파라미터로 잡는다
		System.out.print("제목|내용:");
		String titleContent = input.next();
		int indexI = titleContent.indexOf("|");
		String title = titleContent.substring(0, indexI);
		String content = titleContent.substring(indexI + 1);// 3~끝 //분리 끝
		System.out.print("작성자:");
		String author = input.next();
		System.out.print("날짜:");
		String nal = input.next();
		System.out.print("조회수:");
		int readCount = input.nextInt();
		// 3.준비(Statement) 3-1.공간을 준비
		// 3.준비 3-2.쿼리준비
		Statement stmt = conn.createStatement();
		String sql = "insert into BOARD(title,content,author,nal,readCount) values('" + title + "','" + content + "','" + author + "','" + nal + "'," + readCount + ")";
		// 4.실행 execute
		int cnt = stmt.executeUpdate(sql);
		System.out.println(cnt + "건 게시글이 등록되었습니다.");

	}

	public void search(Scanner input, Connection conn) throws SQLException {
		System.out.print("찾는 게시글 제목 입력 : ");
		String titleSearch = input.next();
		System.out.print("번호\t제목\t내용\t작성자\t날짜\t조회수\n");
		// 3.준비 3-1. 공간준비
		// 3-2. 쿼리준비
		Statement stmt = conn.createStatement();
		String sql = "SELECT NO, TITLE, CONTENT,AUTHOR,NAL,READCOUNT FROM BOARD WHERE TITLE = '" + titleSearch + "'";
		// 4.실행 execute
		ResultSet rs = stmt.executeQuery(sql); // 행을 나타낸다. executeQuery => select에서 주력 // executeUpdate => 등록 삭제 수정
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

	public char update(Scanner input, Connection conn) throws Exception { // Y/N를 리턴해주기 위함
		System.out.print("변경할 게시물의 제목을 입력하세요 : ");
		String titleSearch = input.next();
		// 3.준비 3-1. 공간준비
		// 3-2. 쿼리준비
		Statement stmt = conn.createStatement();
		String sql = "SELECT TITLE,CONTENT,AUTHOR,NAL,READCOUNT FROM BOARD WHERE TITLE ='" + titleSearch + "'";
		// 4.실행 execute
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("===변경하기 전 게시글입니다.===");
		while (rs.next()) {
			String title = rs.getString("title");
			String content = rs.getString("content");
			String author = rs.getString("author");
			String nal = rs.getString("nal");
			int readCount = rs.getInt("readCount");
			System.out.print(title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readCount + "\n");
		}
		System.out.println("정말로 수정하겠습니까?(Y/N)");
		char option = input.next().charAt(0);
		if (option == 'Y' || option == 'y') {
			System.out.print("제목|내용:");
			String titleContent = input.next();
			int indexI = titleContent.indexOf("|");
			String titleUpdate = titleContent.substring(0, indexI);
			String contentUpdate = titleContent.substring(indexI + 1);// 3~끝 //분리 끝
			System.out.print("작성자:");
			String authorUpdate = input.next();
			System.out.print("날짜:");
			String nalUpdate = input.next();
			System.out.print("조회수:");
			int readCountUpdate = input.nextInt();

			stmt = conn.createStatement();
			sql = "UPDATE board SET TITLE = '" + titleUpdate + "',CONTENT = '" + contentUpdate + "', AUTHOR = '"
					+ authorUpdate + "', NAL = '" + nalUpdate + "', READCOUNT = '" + readCountUpdate
					+ "' WHERE TITLE = '" + titleSearch + "'";
			int cnt = stmt.executeUpdate(sql);
			System.out.println(cnt + "건 게시글이 수정되었습니다.");
		}
		return option;

	}

	public void list(Connection conn) throws SQLException {
		System.out.println("===ㄱ게시판 전체출력===");
		System.out.print("번호\t제목\t내용\t작성자\t날짜\t조회수\n");
		// 3.준비 3-1. 공간준비
		// 3-2. 쿼리준비
		Statement stmt = conn.createStatement();
		String sql = "SELECT NO,TITLE,CONTENT,AUTHOR,NAL,READCOUNT FROM BOARD";
		// 4.실행 execute
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
