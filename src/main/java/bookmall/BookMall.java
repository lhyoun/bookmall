package bookmall;

import java.util.ArrayList;
import java.util.List;

import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.MemberDao;
import bookmall.dao.OrderDao;
import bookmall.dao.Order_bookDao;
import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.CategoryVo;
import bookmall.vo.MemberVo;
import bookmall.vo.OrderVo;
import bookmall.vo.Order_bookVo;

public class BookMall {

	public static void main(String[] args) {
		//MemberDao.deleteAll();
		//BookDao.deleteAll();
		//CategoryDao.deleteAll();
		//System.out.println();
		
		// 1. 회원 리스트 – 2명
		MemberDao.findAll();
		MemberVo memberVo1 = new MemberVo("유저이름1", "dlgkdbs@gmail.com", "gkdbs", "010-1234-4321");
		MemberVo memberVo2 = new MemberVo("유저이름2", "wkddmswn@gmail.com", "dmswn", "010-4321-1234");
		MemberDao.insert(memberVo1);
		MemberDao.insert(memberVo2);
		MemberDao.findAll();
		System.out.println();
		
		// 2. 카테고리 리스트 – 3개
		CategoryDao.findAll();
		CategoryVo categoryVo1 = new CategoryVo("소설");
		CategoryVo categoryVo2 = new CategoryVo("수필");
		CategoryVo categoryVo3 = new CategoryVo("컴퓨터/IT");
		CategoryDao.insert(categoryVo1);
		CategoryDao.insert(categoryVo2);
		CategoryDao.insert(categoryVo3);
		CategoryDao.findAll();
		System.out.println();
		
		// 3. 상품리스트 – 3개
		BookDao.findAll();
		BookVo bookVo1 = new BookVo("novelBook", 18000, 1);
		BookVo bookVo2 = new BookVo("essayBook", 15000, 2);
		BookVo bookVo3 = new BookVo("javaBook", 25000, 3);
		BookDao.insert(bookVo1);
		BookDao.insert(bookVo2);
		BookDao.insert(bookVo3);
		BookDao.findAll();
		System.out.println();
		
		// 4. 카트 리스트 – 2개
		CartDao.findAll();
		CartVo cartVo1 = new CartVo(1, 1, 1);
		CartVo cartVo2 = new CartVo(2, 2, 2);
		CartDao.insert(cartVo1);
		CartDao.insert(cartVo2);
		CartDao.findAll();
		System.out.println();
		
		// 5. 주문 리스트 – 1개 & 6. 주문 도서 리스트 – 2개
		OrderDao.findAll();
		Order_bookDao.findAll();
		
		OrderVo vo = new OrderVo("2021-book-01", 60000, "부산광역시 해운대구", 1);
		
		List<Order_bookVo> orderList = new ArrayList<Order_bookVo>();
		orderList.add(new Order_bookVo(1, 1, 1, 25000));
		orderList.add(new Order_bookVo(1, 2, 1, 35000));
		
		OrderDao.insert(vo, orderList);
		System.out.println("&&&&&&&&&& 책 2권 주문 완료 &&&&&&&&&");
		OrderDao.findAll();
		Order_bookDao.findAll();
	}
}

/*
    1. 회원 리스트 – 2명
    2. 카테고리 리스트 – 3개
    3. 상품리스트 – 3개
    4. 카트 리스트 – 2개
    5. 주문 리스트 – 1개
    6. 주문 도서 리스트 – 2개
*/