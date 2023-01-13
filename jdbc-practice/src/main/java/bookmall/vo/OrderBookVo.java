package bookmall.vo;

public class OrderBookVo {
	private Long no;
	private Long bookNo;
	private Long count;
	private Long orderNo;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public Long getBookNo() {
		return bookNo;
	}

	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	@Override
	public String toString() {
		return "OrderBookVo [no=" + no + ", bookNo=" + bookNo + ", count=" + count + ", orderNo=" + orderNo + "]";
	}



}
