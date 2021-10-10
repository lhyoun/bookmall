package bookmall.vo;

public class CartVo {

	private int book_no;
	private int member_no;
	private int count;

	public CartVo() {
		super();
	}

	public CartVo(int book_no, int member_no, int count) {
		super();
		this.book_no = book_no;
		this.member_no = member_no;
		this.count = count;
	}

	public int getBook_no() {
		return book_no;
	}

	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Cart [book_no=" + book_no + ", member_no=" + member_no + ", count=" + count + "]";
	}

}
