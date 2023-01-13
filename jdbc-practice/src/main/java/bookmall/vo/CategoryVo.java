package bookmall.vo;

public class CategoryVo {
	private Long no;
	private String cateName;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", cateName=" + cateName + "]";
	}
}
