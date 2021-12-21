package DTO;

public class ProjectVO {
	
	private int pno;
	private String pname1; //프로젝트 썸네일
	private String pname2; //프로젝트 제목
	private String pcontent1; //프로젝트 소개글
	private String pcontent2; //프로젝트 내용
	private String pcontent3; //창작자 소개
	private String adate; //신청날짜
	private String odate; // 공개날짜
	private String gdate; //목표 날짜
	private int pgrade;	//프로젝트 상태
	private int pmoney; //목표금액
	private String id; //창작자 아이디
	private int categoryno; //카테고리 번호
	private String categoryname; // 카테고리 이름
	private String paccount; //받을 계좌번호
	private int likecount; //좋아요 수
	private int sponsor; //참여한 사람 수
	private String pname3; //창작자 이름
	private int nowmoney; //펀딩 모인 금액
	private String name; //창작자 닉네임
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNowmoney() {
		return nowmoney;
	}
	public void setNowmoney(int nowmoney) {
		this.nowmoney = nowmoney;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPname1() {
		return pname1;
	}
	public void setPname1(String pname1) {
		this.pname1 = pname1;
	}
	public String getPname2() {
		return pname2;
	}
	public void setPname2(String pname2) {
		this.pname2 = pname2;
	}
	public String getPcontent1() {
		return pcontent1;
	}
	public void setPcontent1(String pcontent1) {
		this.pcontent1 = pcontent1;
	}
	public String getPcontent2() {
		return pcontent2;
	}
	public void setPcontent2(String pcontent2) {
		this.pcontent2 = pcontent2;
	}
	public String getPcontent3() {
		return pcontent3;
	}
	public void setPcontent3(String pcontent3) {
		this.pcontent3 = pcontent3;
	}
	public String getAdate() {
		return adate;
	}
	public void setAdate(String adate) {
		this.adate = adate;
	}
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	public String getGdate() {
		return gdate;
	}
	public void setGdate(String gdate) {
		this.gdate = gdate;
	}
	public int getPgrade() {
		return pgrade;
	}
	public void setPgrade(int pgrade) {
		this.pgrade = pgrade;
	}
	public int getPmoney() {
		return pmoney;
	}
	public void setPmoney(int pmoney) {
		this.pmoney = pmoney;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCategoryno() {
		return categoryno;
	}
	public void setCategoryno(int categoryno) {
		this.categoryno = categoryno;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getPaccount() {
		return paccount;
	}
	public void setPaccount(String paccount) {
		this.paccount = paccount;
	}
	public int getLikecount() {
		return likecount;
	}
	public void setLikecount(int likecount) {
		System.out.println(likecount);
		this.likecount = likecount;
	}
	public int getSponsor() {
		return sponsor;
	}
	public void setSponsor(int sponsor) {
		this.sponsor = sponsor;
	}
	public String getPname3() {
		return pname3;
	}
	public void setPname3(String pname3) {
		this.pname3 = pname3;
	}
	
	
}
