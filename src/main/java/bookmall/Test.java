package bookmall;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

public class Test {

	public static void main(String[] args) {
		BookVo bookvo1 = new BookVo("≈∏¿Ã∆≤", 10000, 111);
		BookDao.insert(bookvo1);
		List<BookVo> booklist = BookDao.findAll();
		System.out.println(booklist.get(0));
	}
}
