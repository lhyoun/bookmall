package bookmall.test;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

public class BookTest {
	public static void main(String[] args) {
		// select test
		BookDao.findAll();
		
		// insert test 
		BookVo vo = new BookVo("novelBook", 18000, 1);

		BookDao.insert(vo);
		
		// select test(insert)
		BookDao.findAll();
		
		BookDao.deleteAll();
		
		// select test(delete)
		BookDao.findAll();
	}
}
