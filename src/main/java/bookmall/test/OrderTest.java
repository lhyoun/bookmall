package bookmall.test;

import java.util.ArrayList;
import java.util.List;

import bookmall.dao.BookDao;
import bookmall.dao.OrderDao;
import bookmall.vo.BookVo;
import bookmall.vo.OrderVo;
import bookmall.vo.Order_bookVo;

public class OrderTest {
	public static void main(String[] args) {
		// select test
		OrderDao.findAll();
		
		// insert test 
		OrderVo vo = new OrderVo("book-001", 15000, "ºÎ»ê±¤¿ª½Ã", 1);
		
		Order_bookVo OBVo1 = new Order_bookVo(15, 1, 10, 25000);
		Order_bookVo OBVo2 = new Order_bookVo(15, 2, 11, 35000);

		List<Order_bookVo> orderList = new ArrayList<Order_bookVo>();
		orderList.add(OBVo1);
		orderList.add(OBVo2);
		OrderDao.insert(vo, orderList);
		
		// select test(insert)
		OrderDao.findAll();
		
		//OrderDao.deleteAll();
		
		// select test(delete)
		//OrderDao.findAll();
	}
}
