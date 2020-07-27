package com.bit2020.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {
	public static void main(String[] args){
		Connection connection = null;
		Statement stmt = null;
		try {
			// 1. JDBC Driver(MariaDB Driver)
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 2. �����ϱ�
			String url = "jdbc:mysql://127.0.0.1:3306/webdb?characterEncoding=utf8";
			connection = DriverManager.getConnection(url, "webdb", "webdb");
		
			// 3. Statement ��ü ����
			stmt = connection.createStatement();
			
			// 4. SQL ����
			String firstName = "��";
			String lastName = "����";
			String email = "yunn1209@gmail.com";
			String sql = "insert into emaillist values(null, '" + 
			firstName + "', '" + lastName + "', '" + email + "')";
			
			int count = stmt.executeUpdate(sql);
			if(count == 1) {
				System.out.println("����!");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("����" + e);

		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(connection != null)
					connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
