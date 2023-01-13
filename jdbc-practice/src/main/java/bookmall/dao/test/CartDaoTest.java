package bookmall.dao.test;

import java.util.List;

import bookmall.dao.CartDao;
import bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
//		testInsert();
		testFindAll();
	}

	public static void testFindAll() {
		List<CartVo> list = new CartDao().findAll();
		for (CartVo vo : list) {
			System.out.println(vo);
		}
	}

	private static void testInsert() {
		CartVo vo = null;
		CartDao dao = new CartDao();
		
		vo = new CartVo();
		vo.setTitle("Java의 정석");
		vo.setCount(2L);
		vo.setTotalPrice(60000L);
		vo.setBookNo(2L);
		vo.setUserNo(1L);
		dao.insert(vo);

		vo = new CartVo();
		vo.setTitle("여행의 이유");
		vo.setCount(1L);
		vo.setTotalPrice(13500L);
		vo.setBookNo(4L);
		vo.setUserNo(1L);
		dao.insert(vo);
	}
}
