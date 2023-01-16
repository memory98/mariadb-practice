package bookmall.dao.test;

import java.util.List;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
//		testInsert();
		testFindAll();
	}

	public static void testFindAll() {
		List<CategoryVo> list = new CategoryDao().findAll();
		for (CategoryVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void testInsert() {
		CategoryVo vo = null;
		CategoryDao dao = new CategoryDao();

		vo = new CategoryVo();
		vo.setCateName("컴퓨터/IT");
		dao.insert(vo);

		vo = new CategoryVo();
		vo.setCateName("소설");
		dao.insert(vo);

		vo = new CategoryVo();
		vo.setCateName("여행");
		dao.insert(vo);

	}
}
