package bookmall;

import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.MemberDao;
import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.CategoryVo;
import bookmall.vo.MemberVo;

public class BookMall {

	public static void main(String[] args) {
		MemberDao.deleteAll();
		BookDao.deleteAll();
		CategoryDao.deleteAll();
		System.out.println();
		
		// 1. 회원 리스트 – 2명
		MemberDao.findAll();
		MemberVo memberVo1 = new MemberVo("이하윤", "lhyoundev@gmail.com", "qwe123", "010-5023-9050");
		MemberVo memberVo2 = new MemberVo("장은주", "lsaoundev@gmail.com", "asd321", "010-5123-9510");
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