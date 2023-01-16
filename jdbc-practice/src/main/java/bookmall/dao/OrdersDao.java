package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.OrderBookVo;
import bookmall.vo.OrdersVo;

public class OrdersDao {
	public void insert(OrdersVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();

			String sql = "insert into orders values(null,concat(date_format(now(),'%Y%m%d-'),no+1),?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, vo.getPayment());
			pstmt.setString(2, vo.getAddress());
			pstmt.setLong(3, vo.getUserNo());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<OrdersVo> findAll() {
		List<OrdersVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();

			String sql = "select u.no, o.order_no, u.name, u.email, o.payment, o.address from user u join orders o on  u.no = o.user_no";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrdersVo vo = new OrdersVo();
				vo.setNo(rs.getLong(1));
				vo.setOrderNo(rs.getString(2));
				vo.setUserName(rs.getString(3));
				vo.setUserEmail(rs.getString(4));
				vo.setPayment(rs.getLong(5));
				vo.setAddress(rs.getString(6));

				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
	public void setOrderBooK() {
		List<OrderBookVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			ArrayList<Long> count = new ArrayList<Long>();
			ArrayList<Long> bookNo = new ArrayList<Long>();
			ArrayList<Long> ordersNo = new ArrayList<Long>();		
			
			String sql = "select c.book_no,c.count, o.no from user u "
					+ "join orders o on  u.no = o.user_no "
					+ "join cart c on o.user_no = c.user_no";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
	
			while (rs.next()) {
				count.add(rs.getLong(1));
				bookNo.add(rs.getLong(2));
				ordersNo.add(rs.getLong(3));

			}
			
			if (rs != null) {
				rs.close();
			}
			OrderBookVo vo = new OrderBookVo();
			String sql2 =""; 
			for(int i = 0; i<count.size();i++) {
				sql2="insert into order_book values(null,"+count.get(i)+","
						+bookNo.get(i)+","+ordersNo.get(i)+")";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setLong(1, count.get(i));
				pstmt.setLong(2, bookNo.get(i));
				pstmt.setLong(3, ordersNo.get(i));
				pstmt.executeUpdate();
			}


		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void printOrderBooK() {
		List<OrderBookVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();

			String sql = "select * from order_book";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderBookVo vo = new OrderBookVo();
				vo.setNo(rs.getLong(1));
				vo.setBookNo(rs.getLong(2));
				vo.setCount(rs.getLong(3));
				vo.setOrderNo(rs.getLong(4));
				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
		for(OrderBookVo vo : result) {
			System.out.println(vo);
		}
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.10.111:3307/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}

		return conn;
	}
}