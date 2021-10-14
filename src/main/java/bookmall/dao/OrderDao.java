package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.dto.OrderDto;
import bookmall.vo.OrderVo;
import bookmall.vo.Order_bookVo;

public class OrderDao {

	public static List<OrderDto> findAll() {
		List<OrderDto> result = new ArrayList<OrderDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConn.getConn();

			String sql = "select a.no," + "          a.order_number," + "          a.price," + "          a.address,"
					+ "          b.name," + "          b.tel," + "          b.email" + "   from   bookmall.order a"
					+ "   inner  join member b on a.member_no = b.no";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt(1);
				String order_number = rs.getString(2);
				int price = rs.getInt(3);
				String address = rs.getString(4);
				String name = rs.getString(5);
				String email = rs.getString(6);
				String tel = rs.getString(7);

				OrderDto dto = new OrderDto();
				dto.setNo(no);
				dto.setOrder_number(order_number);
				dto.setPrice(price);
				dto.setAddress(address);
				dto.setName(name);
				dto.setEmail(email);
				dto.setTel(tel);

				result.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			DBConn.close(conn, pstmt, rs);
		}

		System.out.println("***** Order List *****");

		for (OrderDto dto : result) {
			System.out.println(dto);
		}

		System.out.println("*** Order List END ***");

		return result;
	}

	public static boolean insert(OrderVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConn.getConn();

			String sql = "insert into bookmall.order values(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, vo.getNo());
			pstmt.setString(2, vo.getOrder_number());
			pstmt.setInt(3, vo.getPrice());
			pstmt.setString(4, vo.getAddress());
			pstmt.setInt(5, vo.getMember_no());

			int count = pstmt.executeUpdate();

			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			DBConn.close(conn, pstmt);
		}

		if (result)
			System.out.println("*** Insert order[o] ***");
		else
			System.out.println("*** Insert order[x] ***");

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

		if (result)
			System.out.println("** Delete book table[o] **");
		else
			System.out.println("** Delete book table[x] **");

		return result;
	}

	public static void insert(OrderVo vo, List<Order_bookVo> order_list) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConn.getConn();
			conn.setAutoCommit(false); // AutoCommit => false

			String sql = "insert into bookmall.order values(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, vo.getNo());
			pstmt.setString(2, vo.getOrder_number());
			pstmt.setInt(3, vo.getPrice());
			pstmt.setString(4, vo.getAddress());
			pstmt.setInt(5, vo.getMember_no());

			int count = pstmt.executeUpdate();

			result = count == 1;
			insertCheck(result);
			
			for (Order_bookVo forVo : order_list) {
				String sql2 = "insert into order_book values(?, ?, ?, ?)";

				pstmt = conn.prepareStatement(sql2);

				pstmt.setInt(1, forVo.getOrder_no());
				pstmt.setInt(2, forVo.getBook_no());
				pstmt.setInt(3, forVo.getCount());
				pstmt.setInt(4, forVo.getPrice());

				int count2 = pstmt.executeUpdate();
				
				result = count2 == 1;
				insertCheck(result);
			}

		} catch (Throwable e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			DBConn.close(conn, pstmt);
		}

		if (result)
			System.out.println("*** Insert order[o] ***");
		else
			System.out.println("*** Insert order[x] ***");

	}

	private static void insertCheck(boolean result) throws Exception {
		if (!result) throw new Exception("Insert[x]");
	}
}