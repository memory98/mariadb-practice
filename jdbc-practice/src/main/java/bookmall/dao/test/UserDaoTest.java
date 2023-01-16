package bookmall.dao.test;

import java.util.List;

import bookmall.dao.UserDao;
import bookmall.vo.UserVo;

public class UserDaoTest {

	public static void main(String[] args) {
//		testInsert();
		testFindAll();
	}

	public static void testFindAll() {
		List<UserVo> list = new UserDao().findAll();
		for (UserVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void testInsert() {
		UserVo vo = null;
		UserDao dao = new UserDao();

		vo = new UserVo();
		vo.setName("정은성");
		vo.setPhone("010-1111-1111");
		vo.setEmail("wjddmstjd@gmail.com");
		vo.setPassword("dmstjd123");
		dao.insert(vo);

		vo = new UserVo();
		vo.setName("홍길동");
		vo.setPhone("010-2222-2222");
		vo.setEmail("ghdrlfehd@gmail.com");
		vo.setPassword("rlfehd123");
		dao.insert(vo);


	}
}
