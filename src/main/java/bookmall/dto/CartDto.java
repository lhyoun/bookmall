package bookmall.dto;

public class CartDto {

	private int count;
	private String book_title;
	private int book_price;
	private String book_category_name;
	private String member_name;
	private String member_tel;
	private String member_email;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public int getBook_price() {
		return book_price;
	}

	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}

	public String getBook_category_name() {
		return book_category_name;
	}

	public void setBook_category_name(String book_category_name) {
		this.book_category_name = book_category_name;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_tel() {
		return member_tel;
	}

	public void setMember_tel(String member_tel) {
		this.member_tel = member_tel;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	@Override
	public String toString() {
		return "CartDto [count=" + count + ", book_title=" + book_title + ", book_price=" + book_price
				+ ", book_category_name=" + book_category_name + ", member_name=" + member_name + ", member_tel="
				+ member_tel + ", member_email=" + member_email + "]";
	}

}
