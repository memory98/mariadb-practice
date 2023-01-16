package bookmall.dao.test;

import java.util.List;

import bookmall.dao.OrdersDao;
import bookmall.dao.UserDao;
import bookmall.vo.OrdersVo;
import bookmall.vo.UserVo;

public class OrdersDaoTest {

	public static void main(String[] args) {
//		testInsert();
		testFindAll();
	}

	public static void testFindAll() {
		List<OrdersVo> list = new OrdersDao().findAll();
		for(OrdersVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void testInsert() {
		OrdersVo vo = null;
		OrdersDao dao = new OrdersDao();

		UserDao userDao = new UserDao();
		UserVo userInfo = new UserVo();
		userInfo = userDao.find(1L);

		vo = new OrdersVo();
		vo.setPayment(73500L);
		vo.setAddress("김해");
		vo.setUserNo(1L);
		vo.setUserName(userInfo.getName());
		vo.setUserEmail(userInfo.getEmail());
		dao.insert(vo);
	}

}
