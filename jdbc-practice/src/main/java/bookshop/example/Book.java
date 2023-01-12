package bookshop.example;

public class Book {
	private int bookNo;
	private String title;
	private String author;
	private int stateCode;
	
	public Book(int bookNo,String title, String author) {
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		this.stateCode=1;
	}
	
	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getStateCode() {
		return stateCode;
	}

	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}

	public void rent() {
		this.stateCode =0;
		System.out.println(title+"이(가) 대여 됐습니다.");
	}
	
	public void print() {
		System.out.print("No : "+bookNo+
						", 책 제목 : "+this.title+
						", 작가 : "+this.author+
						", 대여 유무 : ");
		if(this.stateCode==1) System.out.println("재고있음");
		else System.out.println("대여중");
	}
}
