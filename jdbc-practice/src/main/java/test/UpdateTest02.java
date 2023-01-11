package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTest02 {
	public static void main(String[] args) {
		// ValueObject
		DeptVo vo = new DeptVo();
		vo.setNo(1L);
		vo.setName("경영");
		
		Boolean result = update(vo);
		System.out.println(result ? "성공":"실패");
		
	}

	private static Boolean update(DeptVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1. JDBC Driver Class 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.10.111:3307/webdb?charset=utf-8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			String sql = "update dept set name = ? where no = ?";
			
			// 3. Statement 생성
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setLong(2,vo.getNo());
			
			// 4. SQL 실행
			int count = pstmt.executeUpdate();

			// 5. 결과처리
			result = count == 1;
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error : " + e);
			}
		}
		return result;
	}
}
