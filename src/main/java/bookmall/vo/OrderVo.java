package bookmall.vo;

public class OrderVo {

	private int no;
	private String order_number;
	private int price;
	private String address;
	private int member_no;

	public OrderVo() {
		super();
	}

	public OrderVo(String order_number, int price, String address, int member_no) {
		super();
		this.order_number = order_number;
		this.price = price;
		this.address = address;
		this.member_no = member_no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getOrder_number() {
		return order_number;
	}

	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	@Override
	public String toString() {
		return "Order [no=" + no + ", order_number=" + order_number + ", price=" + price + ", address=" + address
				+ ", member_no=" + member_no + "]";
	}

}
