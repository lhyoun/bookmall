package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.dto.Order_bookDto;
import bookmall.vo.Order_bookVo;

public class Order_bookDao {
	public static List<Order_bookDto> findAll() {
		List<Order_bookDto> result = new ArrayList<Order_bookDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConn.getConn();
			
			String sql = "select b.order_number, b.address, d.name, d.email, d.tel, c.title, e.name, a.count, a.price"
					+ "   from   order_book a "
					+ "   inner  join bookmall.order b on a.order_no = b.no"
					+ "   inner  join book c on a.book_no = c.no"
					+ "   inner  join member d on b.member_no = d.no"
					+ "   inner  join category e on c.category_no = e.no";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String order_number = rs.getString(1);
				String address = rs.getString(2);
				String name = rs.getString(3);
				String email = rs.getString(4);
				String tel = rs.getString(5);

				String title = rs.getString(6);
				String category_name = rs.getString(7);
				
				int count = rs.getInt(8);
				int price = rs.getInt(9);
				
				Order_bookDto dto = new Order_bookDto();
				dto.setOrder_number(order_number);
				dto.setAddress(address);
				dto.setName(name);
				dto.setEmail(email);
				dto.setTel(tel);
				
				dto.setTitle(title);
				dto.setCategory_name(category_name);
				
				dto.setCount(count);
				dto.setPrice(price);
				
				result.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		
		System.out.println("***** Order_book List *****");
		
		for(Order_bookDto dto : result) {
			System.out.println(dto);
		}
		
		System.out.println("*** Order_book List END ***");
		
		return result;
	}
	
	public static boolean insert(Order_bookVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConn.getConn();
			
			String sql = "insert into order_book values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getOrder_no());
			pstmt.setInt(2, vo.getBook_no());
			pstmt.setInt(3, vo.getCount());
			pstmt.setInt(4, vo.getPrice());
			
			int count = pstmt.executeUpdate();
			
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			DBConn.close(conn, pstmt);
		}
		
		if(result) System.out.println("*** Insert Order_book[o] ***");
		else System.out.println("*** Insert Order_book[x] ***");
		
		return result;
	}
	
	public static boolean deleteAll() {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConn.getConn();
			
			String sql = "delete from book where no > '0'";

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
