package kr.co.kh.StaticMy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BoardExecuter {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		try { //한번 로드하고 연결 유지하기 위해 처음에 선언
			// 1.로드(적재 = 자바에게 내가 데이터베이스를 뭘 쓰겠다.)
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn = null;
		
		while (true) { // 반복문
			System.out.println("=====게시판 작성=====");
			System.out.println("R:등록 S:검색 D:삭제 U:수정 L:목록");
			char protocol = input.next().charAt(0);

			try {
				// 2.연결(Connection) DriverManager.getConnection
				conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysql?characterEncoding=utf8", "root", "");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			

			if (protocol == 'r' || protocol == 'R') {// 등록
				try {
					BoardFunction.register(input, conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} // 등록
			
			else if (protocol == 's' || protocol == 'S') {// 검색
				try {
					BoardFunction.search(input, conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			} // 검색
			
			else if (protocol == 'd' || protocol == 'D') {// 삭제
				try {
					BoardFunction.delete(input, conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} // 삭제
			
			else if (protocol == 'u' || protocol == 'U') {// 수정
				char result = ' ';
				try {
					result = BoardFunction.update(input, conn);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(result == 'n'||result == 'N')
					continue;
				
			} // 수정
			else if (protocol == 'l' || protocol == 'L') {// 전체출력
				try {
					BoardFunction.list(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} // 전체출력
		} // 반복문
	}

}
