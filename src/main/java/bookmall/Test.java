package bookmall;

import bookmall.dao.BookDao;
import bookmall.dao.CategoryDao;
import bookmall.vo.BookVo;
import bookmall.vo.CategoryVo;

public class Test {

	public static void main(String[] args) {
		BookDao.deleteAll();
		CategoryDao.deleteAll();
		System.out.println();
		
		CategoryDao.findAll();
		CategoryVo categoryVo1 = new CategoryVo("인문학");
		CategoryDao.insert(categoryVo1);
		CategoryDao.findAll();
		System.out.println();
		
		BookDao.findAll();
		BookVo bookVo1 = new BookVo("타이틀", 10000, 1);
		BookDao.insert(bookVo1);
		BookDao.findAll();
	}
}
