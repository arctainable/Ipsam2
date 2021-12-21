package Util;

public class CriteriaMy {
	
	// 페이지 처리를 하기위한 파라미터 : 페이지번호, 한 페이지당 보여줄 레코드 개수
	
	private int pageNum; // 페이지번호
	private int amount; // 한 페이지당 보여줄 레코드 개수
	
	private String type; // 검색조건
	private String keyword; // 검색단어
	
	public CriteriaMy() {
		this(1,3);
	}
	
	public CriteriaMy(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
	
}// end class
