package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.dto.OrderDto;
import bookmall.vo.CartVo;

public class OrderDao {

	public static List<OrderDto> findAll() {
		List<OrderDto> result = new ArrayList<OrderDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConn.getConn();
			
			String sql = "select a.no,"
					+ "          a.order_number,"
					+ "          a.price,"
					+ "          a.address,"
					+ "          b.name,"
					+ "          b.tel,"
					+ "          b.email"
					+ "   from   bookmall.order a"
					+ "   inner  join member b on a.member_no = b.no";

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
				
				OrderDto dto = new OrderDto();
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
		
		for(OrderDto dto : result) {
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