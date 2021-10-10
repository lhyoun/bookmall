package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.dto.CartDto;
import bookmall.vo.CartVo;

public class CartDao {
	public static List<CartDto> findAll() {
		List<CartDto> result = new ArrayList<CartDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConn.getConn();
			
			String sql = "SELECT a.count    AS 수량,"
					+ "          b.title    AS 책제목,"
					+ "          b.price    AS 책가격,"
					+ "          c.name     AS 책카테고리,"
					+ "          d.name     AS 주문자이름,"
					+ "          d.tel      AS 주문자연락처,"
					+ "          d.email    AS 주문자이메일"
					+ "   FROM   cart a"
					+ "   INNER  JOIN book     b ON a.book_no     = b.no"
					+ "   INNER  JOIN category c ON b.category_no = c.no"
					+ "   INNER  JOIN member   d ON a.member_no   = d.no";

			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int count = rs.getInt(1);
				String book_title = rs.getString(2);
				int book_price = rs.getInt(3);
				String book_category_name = rs.getString(4);
				String member_name = rs.getString(5);
				String member_tel = rs.getString(6);
				String member_email = rs.getString(7);
				
				CartDto dto = new CartDto();
				dto.setCount(count);
				dto.setBook_title(book_title);
				dto.setBook_price(book_price);
				dto.setBook_category_name(book_category_name);
				dto.setMember_name(member_name);
				dto.setMember_tel(member_tel);
				dto.setMember_email(member_email);
				
				result.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		
		System.out.println("***** Cart List *****");
		
		for(CartDto dto : result) {
			System.out.println(dto);
		}
		
		System.out.println("*** Book Cart END ***");
		
		return result;
	}
	
	public static boolean insert(CartVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConn.getConn();
			
			String sql = "insert into cart values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getBook_no());
			pstmt.setInt(2, vo.getMember_no());
			pstmt.setInt(3, vo.getCount());
			
			int count = pstmt.executeUpdate();
			
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			DBConn.close(conn, pstmt);
		}
		
		if(result) System.out.println("*** Insert book[o] ***");
		else System.out.println("*** Insert book[x] ***");
		
		return result;
	}
	
	public static boolean deleteAll() {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConn.getConn();
			
			String sql = "delete from cart";

			pstmt = conn.prepareStatement(sql);
			
			int count = pstmt.executeUpdate();

			result = count >= 1;
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			DBConn.close(conn, pstmt);
		}
		
		if(result) System.out.println("** Delete book table[o] **");
		else System.out.println("** Delete book table[x] **");
		
		return result;
	}
}