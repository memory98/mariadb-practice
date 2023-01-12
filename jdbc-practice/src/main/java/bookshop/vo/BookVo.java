package bookshop.vo;

public class BookVo {
	private int no;
	private String title;
	private String rent;
	private int AuthorNo;
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
	public String getRent() {
		return rent;
	}
	public void setRent(String rent) {
		this.rent = rent;
	}
	public int getAuthorNo() {
		return AuthorNo;
	}
	public void setAuthorNo(int authorNo) {
		this.AuthorNo = authorNo;
	}
	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", rent=" + rent + ", authorNo=" + AuthorNo + "]";
	}
	
	
}
