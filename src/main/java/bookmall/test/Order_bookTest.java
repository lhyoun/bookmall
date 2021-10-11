package bookmall.test;

import bookmall.dao.Order_bookDao;
import bookmall.vo.Order_bookVo;

public class Order_bookTest {
	public static void main(String[] args) {
		Order_bookDao.findAll();
		
		Order_bookVo vo = new Order_bookVo(1, 1, 10, 25000);
		Order_bookDao.insert(vo);
		
		Order_bookDao.findAll();
	}
}
