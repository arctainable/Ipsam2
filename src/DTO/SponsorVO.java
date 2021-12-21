package DTO;

import java.sql.Date;

public class SponsorVO {
	
	private int pno;
	private int rno;
	private String id;
	private int sgrade;
	private int smoney;
	private Date sdate;
	private String address;
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSgrade() {
		return sgrade;
	}
	public void setSgrade(int sgrade) {
		this.sgrade = sgrade;
	}
	public int getSmoney() {
		return smoney;
	}
	public void setSmoney(int smoney) {
		this.smoney = smoney;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date date) {
		this.sdate = date;
	}
	
	private int apno;
	private String pname1;
	private String pname2;
	private String pcontent1;
	private String pcontent2;
	private String pcontent3;
	private String adate;
	private String odate;
	private String gdate;
	private int pgrade;	
	private int pmoney;
	private String aid;
	private int categoryno;
	private String categoryname; // 카테고리 이름
	private String paccount;
	private int likecount; //좋아요 수
	private int sponsor; //참여한 사람 수
	private String pname3; //창작자 이름
	private int nowmoney; //펀딩 모인 금액
	private String name; //창작자 닉네임


	public int getApno() {
		return apno;
	}
	public void setApno(int apno) {
		this.apno = apno;
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
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
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
	public int getNowmoney() {
		return nowmoney;
	}
	public void setNowmoney(int nowmoney) {
		this.nowmoney = nowmoney;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
