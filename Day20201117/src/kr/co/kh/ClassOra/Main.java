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
		
		while (true) { // �ݺ���
			System.out.println("=====�Խ��� �ۼ�=====");
			System.out.println("R:��� S:�˻� D:���� U:���� L:���");
			char protocol = input.next().charAt(0);
			try {
				conn = Register.getConnection();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if (protocol == 'r' || protocol == 'R') {// ���
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
				
			} // ���

			else if (protocol == 's' || protocol == 'S') {// �˻�
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
			} // �˻�

			else if (protocol == 'd' || protocol == 'D') {// ����
				delete.boardDeleteTitle();
				try {
					delete.boardStmtSql();
					delete.boardDeleteExecuter();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} // ����

			else if (protocol == 'u' || protocol == 'U') {// ����
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
				
				
			} // ����
			else if (protocol == 'l' || protocol == 'L') {// ��ü���
				list.listBoardTitle();
				try {
					list.boardStmtSql();
					list.boardListExecuter();
					list.boardListProcess();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}// ��ü���
		} // �ݺ���
		
		
		
		
		
		
	}

}
