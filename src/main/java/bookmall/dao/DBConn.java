package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {

	   public static Connection getConn() throws SQLException {
	      Connection conn = null;
	      try {
	         Class.forName("org.mariadb.jdbc.Driver");

	         String url = "jdbc:mysql://127.0.0.1:3306/bookmall?charset=utf8";
	         conn = DriverManager.getConnection(url, "bookmall", "bookmall");
	      } catch (ClassNotFoundException e) {
	    	  e.printStackTrace();
	      }

	      return conn;
	   }

	   public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
	      try {
	         if (rs != null)
	            rs.close();
	         if (ps != null)
	            ps.close();
	         if (conn != null)
	            conn.close();
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      }
	   }

	   public static void close(Connection conn, PreparedStatement ps) {
	      try {
	         if (ps != null)
	            ps.close();
	         if (conn != null)
	            conn.close();
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      }
	   }
	}