package j20240826.contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDBConnection {
	private static final String DRIVER_CLASS = "oracle.jdbc.OracleDriver";
	
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
	private static final String USERNAME = "shop";
	private static final String PASSWORD = "1234";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER_CLASS);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("오라클 드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("데이터베이스에 접속할 수 없습니다.");
		}
		
		return conn;
	}
	
	// Connection 구현객체를 닫는 메서드(리소스 반납)
	public static void closeConnection(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Connection객체를 닫는 데 실패하였습니다.");
			}
		}
	}
}
