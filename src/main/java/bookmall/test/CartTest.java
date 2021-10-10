package bookmall.test;

import bookmall.dao.CartDao;
import bookmall.vo.CartVo;

public class CartTest {

	public static void main(String[] args) {
		// select test
		CartDao.findAll();
		
		// insert test (Ã¥no, ¸É¹öno, ¼ö·®)
		CartVo vo = new CartVo(3, 1, 1);
		CartDao.insert(vo);
		
		// select test(insert)
		CartDao.findAll();
		
		CartDao.deleteAll();
		
		// select test(delete)
		CartDao.findAll();
	}
}
