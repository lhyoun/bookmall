package bookmall;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

public class Test {

	public static void main(String[] args) {
		BookVo bookvo1 = new BookVo("≈∏¿Ã∆≤", 10000, 111);
		BookDao.insert(bookvo1);
		BookDao.findAll();
	}
}
