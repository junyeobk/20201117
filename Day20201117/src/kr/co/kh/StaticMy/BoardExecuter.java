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
		try { //�ѹ� �ε��ϰ� ���� �����ϱ� ���� ó���� ����
			// 1.�ε�(���� = �ڹٿ��� ���� �����ͺ��̽��� �� ���ڴ�.)
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn = null;
		
		while (true) { // �ݺ���
			System.out.println("=====�Խ��� �ۼ�=====");
			System.out.println("R:��� S:�˻� D:���� U:���� L:���");
			char protocol = input.next().charAt(0);

			try {
				// 2.����(Connection) DriverManager.getConnection
				conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysql?characterEncoding=utf8", "root", "");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			

			if (protocol == 'r' || protocol == 'R') {// ���
				try {
					BoardFunction.register(input, conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} // ���
			
			else if (protocol == 's' || protocol == 'S') {// �˻�
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
				
			} // �˻�
			
			else if (protocol == 'd' || protocol == 'D') {// ����
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
			} // ����
			
			else if (protocol == 'u' || protocol == 'U') {// ����
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
				
			} // ����
			else if (protocol == 'l' || protocol == 'L') {// ��ü���
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
			} // ��ü���
		} // �ݺ���
	}

}
