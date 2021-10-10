package bookmall.dto;

public class BookDto {

	private int no;
	private String title;
	private int price;
	private String category_name;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	@Override
	public String toString() {
		return "BookDto [no=" + no + ", 제목=" + title + ", 가격=" + price + ", 카테고리=" + category_name + "]";
	}

}
