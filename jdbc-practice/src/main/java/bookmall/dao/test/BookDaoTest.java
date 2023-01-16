package bookmall.dao.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
//		testInsert();
		testFindAll();
	}

	public static void testFindAll() {
		List<BookVo> list = new BookDao().findAll();
		for(BookVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void testInsert() {
		BookVo vo = null;
		BookDao dao = new BookDao();
		
		vo = new BookVo();
		vo.setTitle("이것이 자바다");
		vo.setAuthor("신용권, 임경균");
		vo.setPrice(30000L);
		vo.setCategoryNo(1L);
		dao.insert(vo);

		vo = new BookVo();
		vo.setTitle("Java의 정석");
		vo.setAuthor("남궁성");
		vo.setPrice(30000L);
		vo.setCategoryNo(1L);
		dao.insert(vo);

		vo = new BookVo();
		vo.setTitle("셜록홈즈 베스트 단편선");
		vo.setAuthor("아서 코난 도일");
		vo.setPrice(13000L);
		vo.setCategoryNo(2L);
		dao.insert(vo);

		vo = new BookVo();
		vo.setTitle("여행의 이유");
		vo.setAuthor("김영하");
		vo.setPrice(13500L);
		vo.setCategoryNo(3L);
		dao.insert(vo);

	}
}
