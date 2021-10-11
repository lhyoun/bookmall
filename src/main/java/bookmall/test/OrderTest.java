package bookmall.test;

import bookmall.dao.BookDao;
import bookmall.dao.OrderDao;
import bookmall.vo.BookVo;
import bookmall.vo.OrderVo;

public class OrderTest {
	public static void main(String[] args) {
		// select test
		OrderDao.findAll();
		
		// insert test (åno, �ɹ�no, ����)
		OrderVo vo = new OrderVo("book-001", 15000, "�λ걤����", 1);

		OrderDao.insert(vo);
		
		// select test(insert)
		OrderDao.findAll();
		
		//OrderDao.deleteAll();
		
		// select test(delete)
		OrderDao.findAll();
	}
}
