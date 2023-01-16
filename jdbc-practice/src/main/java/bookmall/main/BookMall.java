package bookmall.main;

import bookmall.dao.OrdersDao;
import bookmall.dao.test.BookDaoTest;
import bookmall.dao.test.CartDaoTest;
import bookmall.dao.test.CategoryDaoTest;
import bookmall.dao.test.OrdersDaoTest;
import bookmall.dao.test.UserDaoTest;

public class BookMall {
	public static void main(String[] args) {
		
		System.out.println("## 회원리스트");
		// 이름, 전화번호, 이메일, 비밀번호
		UserDaoTest user = new UserDaoTest();
		user.testFindAll();
		System.out.println("## 카테고리");
		// 카테고리 (예 - 소설, 수필, 컴퓨터/IT, 인문, 경제, 예술)
		CategoryDaoTest category = new CategoryDaoTest();
		category.testFindAll();		
		System.out.println("## 상품");
		// 제목, 가격.
		BookDaoTest book = new BookDaoTest();
		book.testFindAll();		
		System.out.println("## 카트");
		// 도서제목, 수량, 가격
		CartDaoTest cart = new CartDaoTest();
		cart.testFindAll();		
		System.out.println("## 주문");
		// 주문번호(order_no), 주문자(이름/이메일), 결제금액, 배송지
		OrdersDaoTest order = new OrdersDaoTest();
		order.testFindAll();		
		System.out.println("## 주문 도서 리스트");
		// 도서번호, 도서제목, 수량
		OrdersDao ordersDao = new OrdersDao();
//		ordersDao.setOrderBooK();
		ordersDao.printOrderBooK();
	}
}