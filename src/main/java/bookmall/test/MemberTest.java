package bookmall.test;

import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;

public class MemberTest {

	public static void main(String[] args) {
		// select test
		MemberDao.findAll();
		
		// insert test
		MemberVo vo = new MemberVo("이하윤", "lhyoundev@gmail.com", "qwe123", "010-5023-1234");
		MemberDao.insert(vo);
		
		// select test(insert)
		MemberDao.findAll();
		
		MemberDao.deleteAll();
		
		// select test(delete)
		MemberDao.findAll();
		
	}
}
