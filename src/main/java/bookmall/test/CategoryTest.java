package bookmall.test;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;

public class CategoryTest {
	
	public static void main(String[] args) {
		// select test
		CategoryDao.findAll();
		
		// insert test
		CategoryVo vo = new CategoryVo("¼öÇÊ");
		CategoryDao.insert(vo);
		
		// select test(insert)
		CategoryDao.findAll();
		
		CategoryDao.deleteAll();
		
		// select test(delete)
		CategoryDao.findAll();
	}
}
