package bookmall.main;

import bookmall.dao.OrdersDao;
import bookmall.dao.test.BookDaoTest;
import bookmall.dao.test.CartDaoTest;
import bookmall.dao.test.CategoryDaoTest;
import bookmall.dao.test.OrdersDaoTest;
import bookmall.dao.test.UserDaoTest;

public class BookMall {
	public static void main(String[] args) {
		UserDaoTest user = new UserDaoTest();
		CategoryDaoTest category = new CategoryDaoTest();
		BookDaoTest book = new BookDaoTest();
		CartDaoTest cart = new CartDaoTest();
		OrdersDaoTest order = new OrdersDaoTest();
		OrdersDao ordersDao = new OrdersDao();

//		user.testInsert();
//		category.testInsert();
//		book.testInsert();
//		cart.testInsert();
//		order.testInsert();
//		ordersDao.setOrderBooK();

		System.out.println("## 회원리스트");
		// 이름, 전화번호, 이메일, 비밀번호
		user.testFindAll();
		System.out.println("## 카테고리");
		// 카테고리 (예 - 소설, 수필, 컴퓨터/IT, 인문, 경제, 예술)
		category.testFindAll();		
		System.out.println("## 상품");
		// 제목, 가격.
		book.testFindAll();	
		System.out.println("## 카트");
		// 도서제목, 수량, 가격
		cart.testFindAll();	
		System.out.println("## 주문");
		// 주문번호(order_no), 주문자(이름/이메일), 결제금액, 배송지
		order.testFindAll();
		System.out.println("## 주문 도서 리스트");
		// 도서번호, 도서제목, 수량
		ordersDao.printOrderBooK();
	}
}