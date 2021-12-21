package DTO;

import Util.CriteriaMy;

public class PageMyVO {

	private int startPage; // 시작 페이지 멤버변수
	private int endPage; // 끝
	private boolean prev, next; // 이전, 다음페이지
	private int total; // 총 레코드 갯수 // 현재 페이지
	private CriteriaMy cri; // pagenum, amount, type, keyword 가 저장된 곳 저 안에 있는 get과 set을 이용하여 호출한다

	public PageMyVO(CriteriaMy cri, int total) {
		this.cri = cri;
		this.total = total;
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10; // math.ceil() 괄호안의 값을 올림처리한다. 0.5는 1로 등등
		this.startPage = this.endPage - 9;
		int realEnd = (int) (Math.ceil(total * 1.0 / cri.getAmount()));
		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public CriteriaMy getCri() {
		return cri;
	}

	public void setCri(CriteriaMy cri) {
		this.cri = cri;
	}

}
