package bookmall.vo;

public class Order_bookVo {

	private int order_no;
	private int book_no;
	private int count;
	private int price;

	public Order_bookVo() {
		super();
	}

	public Order_bookVo(int order_no, int book_no, int count, int price) {
		super();
		this.order_no = order_no;
		this.book_no = book_no;
		this.count = count;
		this.price = price;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public int getBook_no() {
		return book_no;
	}

	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order_book [order_no=" + order_no + ", book_no=" + book_no + ", count=" + count + ", price=" + price
				+ "]";
	}

}
