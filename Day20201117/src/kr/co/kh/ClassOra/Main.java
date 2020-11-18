package kr.co.kh.ClassOra;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Register register = new Register();
		Search search = new Search();
		Delete delete = new Delete();
		Update update = new Update();
		List list = new List();
		Connection conn = null;
		
		Scanner input = new Scanner(System.in);
		
		while (true) { // 반복문
			System.out.println("=====게시판 작성=====");
			System.out.println("R:등록 S:검색 D:삭제 U:수정 L:목록");
			char protocol = input.next().charAt(0);
			try {
				conn = Register.getConnection();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if (protocol == 'r' || protocol == 'R') {// 등록
				try {
					register.setTitleContent();
					register.titleContentProcess();
					register.setAuthor();
					register.setNal();
					register.setReadCount();
					register.boardQuery();
					register.boardExcuter();
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
				
			} // 등록

			else if (protocol == 's' || protocol == 'S') {// 검색
				search.setTitleSearch();
				search.boardSearchTitle();
				try {
					search.boardStmtSql();
					search.boardSearchExecuter();
					search.boardSearchProcess();
					search.boardSearchReadCount();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} // 검색

			else if (protocol == 'd' || protocol == 'D') {// 삭제
				delete.boardDeleteTitle();
				try {
					delete.boardStmtSql();
					delete.boardDeleteExecuter();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} // 삭제

			else if (protocol == 'u' || protocol == 'U') {// 수정
				char option = ' ';
				try {
					update.boardUpdateTitle();
					update.boardStmtSql();
					update.boardUpdateExecuter();
					update.boardUpdateOld();
					option = update.boardUpdateOption();
					if(option == 'n'||option == 'N') 
						continue;
					update.boardUpdateNew();
					update.boardStmtSqlNew();
					update.boardUpdateExecuterNew();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			} // 수정
			else if (protocol == 'l' || protocol == 'L') {// 전체출력
				list.listBoardTitle();
				try {
					list.boardStmtSql();
					list.boardListExecuter();
					list.boardListProcess();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}// 전체출력
		} // 반복문
		
		
		
		
		
		
	}

}
