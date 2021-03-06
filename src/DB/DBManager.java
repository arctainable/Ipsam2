package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			// jdbc/myoracle이란 이름을 객체를 찾아서 DataSource가 받는다.
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			// ds가 생성되었으므로 Connection을 구합니다.
			conn = ds.getConnection();
			
//			String DB_URL = "jdbc:oracle:thin:@115.93.111.4:1521:XE";
//			String DB_USER = "c##ipsam";
//			String DB_PASSWORD= "1234";			
//			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// select을 수행한 후 리소스 해제를 위한 메소드
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// DML(insert, update, delete)을 수행한 후 리소스 해제를 위한 메소드
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
