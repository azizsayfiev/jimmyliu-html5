package tiger.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class mysqlDriver {
	private Connection conn = null;
	PreparedStatement statement = null;

	// connect to MySQL
	public void connSQL() {
		String url = "jdbc:mysql://jimmyliu.desktop.amazon.com:3306/guestbook?characterEncoding=UTF-8&allowMultiQueries=true";
		String username = "root";
		String password = "root"; // ���������������������ݿ� 
		try { 
			Class.forName("com.mysql.jdbc.Driver" ); 
			conn = DriverManager.getConnection( url,username, password ); 
			}
		//����������������쳣
		 catch ( ClassNotFoundException cnfex ) {
			 System.err.println(
			 "װ�� JDBC/ODBC ��������ʧ�ܡ�" );
			 cnfex.printStackTrace(); 
		 } 
		 //�����������ݿ��쳣
		 catch ( SQLException sqlex ) {
			 System.err.println( "�޷��������ݿ�" );
			 sqlex.printStackTrace(); 
		 }
	}

	// disconnect to MySQL
	public void deconnSQL() {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			System.out.println("�ر����ݿ����� ��");
			e.printStackTrace();
		}
	}

	// execute selection language
	public ResultSet selectSQL(String sql) {
		ResultSet rs = null;
		try {
			statement = conn.prepareStatement(sql);
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	// execute insertion language
	public boolean insertSQL(String sql) {
		try {
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("�������ݿ�ʱ����");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("����ʱ����");
			e.printStackTrace();
		}
		return false;
	}
	//execute delete language
	public boolean deleteSQL(String sql) {
		try {
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("�������ݿ�ʱ����");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("����ʱ����");
			e.printStackTrace();
		}
		return false;
	}
	//execute update language
	public boolean updateSQL(String sql) {
		try {
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("�������ݿ�ʱ����");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("����ʱ����");
			e.printStackTrace();
		}
		return false;
	}
	
	// show data in message
	void layoutStyle2(ResultSet rs) {
		System.out.println("-----------------");
		System.out.println("ִ�н��������ʾ:");
		System.out.println("-----------------");
		System.out.println("id" + "/t/t" + "name" + "/t/t" + "message"+ "/t/t" + "date");
		System.out.println("-----------------");
		try {
			while (rs.next()) {
				System.out.println(rs.getInt("id") + "/t/t"
						+ rs.getString("name") + "/t/t"
						+ rs.getString("message")
						 + "/t/t"+ rs.getString("postdate"));
			}
		} catch (SQLException e) {
			System.out.println("��ʾʱ���ݿ����");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("��ʾ����");
			e.printStackTrace();
		}
	}
	/*
	public static void main(String args[]) {

		mysqlDriver h = new mysqlDriver();
		h.connSQL();
		String s = "select * from message";

		String insert = "insert into message(name,message,postdate) values('jimmy','test11','2013-04-05')";
		//String update = "update ju_users set ju_userPWD =123 where ju_userName= 'mm'";
		//String delete = "delete from ju_users where ju_userName= 'mm'";

		if (h.insertSQL(insert) == true) {
			System.out.println("insert successfully");
			ResultSet resultSet = h.selectSQL(s);
			h.layoutStyle2(resultSet);
		}

		if (h.updateSQL(update) == true) {
			System.out.println("update successfully");
			ResultSet resultSet = h.selectSQL(s);	
			h.layoutStyle2(resultSet);
		}
		if (h.insertSQL(delete) == true) {
			System.out.println("delete successfully");
			ResultSet resultSet = h.selectSQL(s);
			h.layoutStyle2(resultSet);
		}
		
		
		h.deconnSQL();
	}*/
}
