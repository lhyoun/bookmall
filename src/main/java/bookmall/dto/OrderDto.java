package bookmall.dto;

public class OrderDto {

	private int no;
	private String order_number;
	private int price;
	private String address;
	private String name;
	private String email;
	private String tel;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "OrderDto [no=" + no + ", order_number=" + order_number + ", price=" + price + ", address=" + address
				+ ", name=" + name + ", email=" + email + ", tel=" + tel + "]";
	}

}
