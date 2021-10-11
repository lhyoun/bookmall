package bookmall.dto;

public class Order_bookDto {
	// private int order_no;
	private String order_number;
	// private int price;
	private String address;
	private String name;
	private String email;
	private String tel;

	// private int book_no;
	private String title;
	// private int price;
	private String category_name;

	private int count;
	private int price;
	
	public String getOrder_number() {
		return order_number;
	}

	public void setOrder_number(String order_number) {
		this.order_number = order_number;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
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
		return "Order_bookDto [order_number=" + order_number + ", address=" + address + ", name=" + name + ", email="
				+ email + ", tel=" + tel + ", title=" + title + ", category_name=" + category_name + ", count=" + count
				+ ", price=" + price + "]";
	}

}
