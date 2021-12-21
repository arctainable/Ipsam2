package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DB.DBManager;
import DTO.MemberVO;
import DTO.ProjectVO;
import DTO.RewardVO;
import DTO.SponserDetailVO;
import Util.Criteria;

public class AdminDAO {

	private AdminDAO() {
	};

	private static AdminDAO instance = new AdminDAO();

	public static AdminDAO getInstance() {
		return instance;
	}

	public int AllprojectCount() { // 총 프로젝트 개수

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int count = 0;

		try {
			String sql = "select count(*) as cnt from project";

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}

	public int NcheckprojectCount() { // 검토중인 프로젝트 개수

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int count = 0;

		try {
			String sql = "select count(*) as cnt from project where pgrade = 1";

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}

	public int TodayEndProject() { // 오늘 마감 프로젝트

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int count = 0;

		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
		Date time = new Date();

		String time1 = format1.format(time);
		// System.out.println(time1);

		try {
			String sql = "select count(*) as cnt from project where to_char(gdate, 'YYYYMMDD') = '" + time1 + "'";

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}

	public int TodayJoincount() { // 오늘 가입 회원

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int count = 0;

		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
		Date time = new Date();

		String time1 = format1.format(time);
		// System.out.println(time1);

		try {
			String sql = "select count(*) as cnt from member where to_char(regdate, 'YYYYMMDD') = '" + time1 + "'";

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}

	public List<MemberVO> memberSelect() { // 회원목록(후원수 포함)

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO mvo = null;

		try {
			String sql = " select bno,id,pw,name,email,profile,grade,regdate, (select count(*) from sponsor where member.id = id) count from member";

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				mvo = new MemberVO();
				mvo.setBno(rs.getInt("bno"));
				mvo.setId(rs.getString("id"));
				mvo.setPw(rs.getString("pw"));
				mvo.setName(rs.getString("name"));
				mvo.setEmail(rs.getString("email"));
				mvo.setProfile(rs.getString("profile"));
				mvo.setGrade(rs.getInt("grade"));
				mvo.setRegdate(rs.getString("regdate"));
				mvo.setSponsercount(rs.getInt("count"));
				list.add(mvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;

	}

	public int MemberCount(String query) { // 회원 수

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int count = 0;

		try {
			String sql = "";
			if (query != "") {
				sql = "select count(*) as cnt from member where " + query;
			} else {
				sql = "select count(*) as cnt from member";
			}

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}

	public MemberVO memberDetail(String id) { // 회원상세조회(회원)

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		MemberVO mvo = null;

		try {
			String sql = "select bno,id,pw,name,email,profile,grade,regdate, (select count(*) from sponsor where member.id = id) count from member where id like '%"
					+ id + "%'";

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				mvo = new MemberVO();
				mvo.setBno(rs.getInt("bno"));
				mvo.setId(rs.getString("id"));
				mvo.setPw(rs.getString("pw"));
				mvo.setName(rs.getString("name"));
				mvo.setEmail(rs.getString("email"));
				mvo.setProfile(rs.getString("profile"));
				mvo.setGrade(rs.getInt("grade"));
				mvo.setRegdate(rs.getString("regdate"));
				mvo.setSponsercount(rs.getInt("count"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mvo;

	}

	public List<SponserDetailVO> memberSponserDetail(String id) { // 회원상세조회(프로젝트)

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<SponserDetailVO> list = new ArrayList<SponserDetailVO>();
		SponserDetailVO pvo = null;

		try {
			String sql = "select p.pno, p.pname1, p.pname2, p.pcontent1, p.odate, s.smoney, s.id, s.sdate"
					+ " from project p, sponsor s" + " where p.pno = s.pno" + " and s.id like '%" + id + "%'"
					+ " order by p.pno desc";

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				pvo = new SponserDetailVO();
				pvo.setPno(rs.getInt("pno"));
				pvo.setPname1(rs.getString("pname1"));
				pvo.setPname2(rs.getString("pname2"));
				pvo.setPcontent1(rs.getString("pcontent1"));
				pvo.setOdate(rs.getString("odate"));
				pvo.setSmoney(rs.getInt("smoney"));
				pvo.setId(rs.getString("id"));
				pvo.setSdate(rs.getString("sdate"));
				list.add(pvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;

	}

	public void grademodify(String id, int grade) { // 회원등급 변경

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			String sql = "update member set grade = " + grade + " where id like '%" + id + "%'";

			// System.out.println(sql);
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public List<MemberVO> getListWithPaging(Criteria cri, String query) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO mvo = null;

		String sql = "";
		try {

			if (query != "") {
				sql = "select * from (" + "select /*+ index_desc (member member_pk) */"
						+ "rownum rn, bno,id,pw,name,email,profile,grade,regdate, (select count(*) from sponsor where member.id = id) count from member"
						+ " where (" + query + ") and rownum <= ? * ?" + ") where rn > (?-1) * ?";
			} else {
				sql = "select * from (" + "select /*+ index_desc (member member_pk) */"
						+ "rownum rn,bno,id,pw,name,email,profile,grade,regdate, (select count(*) from sponsor where member.id = id) count from member"
						+ " where rownum <= ? * ?" + ") where rn > (?-1) * ?";
			}

			// System.out.println(sql);
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());// 1
			pstmt.setInt(2, cri.getAmount());// 10
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				mvo = new MemberVO();
				mvo.setBno(rs.getInt("bno"));
				mvo.setId(rs.getString("id"));
				mvo.setPw(rs.getString("pw"));
				mvo.setName(rs.getString("name"));
				mvo.setEmail(rs.getString("email"));
				mvo.setProfile(rs.getString("profile"));
				mvo.setGrade(rs.getInt("grade"));
				mvo.setRegdate(rs.getString("regdate"));
				mvo.setSponsercount(rs.getInt("count"));
				list.add(mvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 프로젝트 뷰 출력
	public ProjectVO selectProjectView(int pno) {
		ProjectVO pvo = new ProjectVO();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select a.pno, a.pname1,a.pname2,(select count(*) from sponsor a , project b where (a.pno = b.pno)and a.pno = ? ) as scount, " + 
				"a.pcontent1, a.pcontent2, a.pcontent3, " + 
				"a.adate, a.odate,a.gdate,a.pgrade, a.pmoney, a.nowmoney, " + 
				"(select categoryname from category b where a.categoryno = b.categoryno) as category , " + 
				"a.paccount, (select name from member m where a.id=m.id) as name, a.id " + 
				"from project a where a.pno=" + pno;
		// System.out.println(sql);
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pno);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				pvo = new ProjectVO();
				pvo.setPno(rs.getInt("pno"));
				pvo.setPname1(rs.getString("pname1"));
				pvo.setPname2(rs.getString("pname2"));
				pvo.setSponsor(rs.getInt("scount"));
				pvo.setPcontent1(rs.getString("pcontent1"));
				pvo.setPcontent2(rs.getString("pcontent2"));
				pvo.setPcontent3(rs.getString("pcontent3"));
				pvo.setAdate(rs.getString("adate"));
				pvo.setOdate(rs.getString("odate"));
				pvo.setGdate(rs.getString("gdate"));
				pvo.setPgrade(rs.getInt("pgrade"));
				pvo.setPmoney(rs.getInt("pmoney"));
				pvo.setNowmoney(rs.getInt("nowmoney"));
				pvo.setCategoryname(rs.getString("category"));
				pvo.setPaccount(rs.getString("paccount"));
				pvo.setName(rs.getString("name"));
				pvo.setId(rs.getString("id"));

				// System.out.println(rs.getString("pname1"));
				// System.out.println(rs.getString("category"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return pvo;
	}

	// 프로젝트 뷰 안의 리워드 출력
	public List<RewardVO> rewardList(int pno) {
		List<RewardVO> rlist = new ArrayList<RewardVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select rno, rcontent, rmoney, rcount " + "from reward where pno =" + pno;

		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			RewardVO rvo = null;

			while (rs.next()) {
				rvo = new RewardVO();

				rvo.setRno(rs.getInt("rno"));
				rvo.setRcontent(rs.getString("rcontent"));
				rvo.setRmoney(rs.getInt("rmoney"));
				rvo.setRcount(rs.getInt("rcount"));

				rlist.add(rvo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return rlist;

	}

	// 검토 완료로 프로젝트 상태변경
	public void changeOK(String pno) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update project set pgrade = 3 where pno=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pno);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 반려로 프로젝트 상태변경
	public void changeNotOK(String pno) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update project set pgrade = 0 where pno=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pno);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	
	public void changeProjectStart() {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = " update project set pgrade = 2 where pgrade = 3 and odate like sysdate";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 관리자 페이지 프로젝트 리스트 페이지네이션 포함
	public ArrayList<ProjectVO> selectProjectListWithPaging(Criteria cri, String query) {
		ArrayList<ProjectVO> plist = new ArrayList<ProjectVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "";

		try {

			if (query != "") {
				sql = "select * from "
						+ "( select rownum rn, pno, pname1,pname2,(select count(*) from sponsor where project.pno = pno) as scount,  "
						+ "adate, odate,gdate,pgrade, pmoney, nowmoney from project " + "where ( pname2 " + query
						+ ") and rownum <= ? * ? " + ") where rn > (?-1) * ? order by pno desc";
			} else {
				sql = "select * from "
						+ "( select rownum rn, pno, pname1,pname2,(select count(*) from sponsor where project.pno = pno) as scount,  "
						+ "adate, odate,gdate,pgrade, pmoney, nowmoney from project " + "where rownum <= ? * ? "
						+ ") where rn > (?-1) * ? order by pno desc";

				// System.out.println(sql);

			}

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());

			// System.out.println(sql);

			rs = pstmt.executeQuery();

			ProjectVO pvo = null;

			while (rs.next()) {
				pvo = new ProjectVO();
				pvo.setPno(rs.getInt("pno"));
				pvo.setPname1(rs.getString("pname1"));
				pvo.setPname2(rs.getString("pname2"));
				pvo.setSponsor(rs.getInt("scount"));
				pvo.setAdate(rs.getString("adate"));
				pvo.setOdate(rs.getString("odate"));
				pvo.setGdate(rs.getString("gdate"));
				pvo.setPgrade(rs.getInt("pgrade"));
				pvo.setPmoney(rs.getInt("pmoney"));
				pvo.setNowmoney(rs.getInt("nowmoney"));

				plist.add(pvo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return plist;
	}

	// 관리자 페이지 프로젝트 리스트 페이지네이션 포함, 프로젝트 상태 검토중
	public ArrayList<ProjectVO> selectProjectListWithPagingP1(Criteria cri, String query) {
		ArrayList<ProjectVO> plist = new ArrayList<ProjectVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "";

		try {

			if (query != "") {
				sql = "select * from ("
						+ "select rownum rn, pno, pname1,pname2,(select count(*) from sponsor where project.pno = pno) as scount, "
						+ "adate, odate,gdate,pgrade, pmoney, nowmoney from project " + "where ( pname2 " + query
						+ ") and rownum <= ? * ? " + "and pgrade = 1) where rn > (?-1) * ? ";
			} else {
				sql = "select * from ("
						+ "select rownum rn, pno, pname1,pname2,(select count(*) from sponsor where project.pno = pno) as scount, "
						+ "adate, odate,gdate,pgrade, pmoney, nowmoney from project " + "where rownum <= ? * ? "
						+ " and pgrade = 1) where rn > (?-1) * ?";

				// System.out.println(sql);

			}

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());

			// System.out.println(sql);

			rs = pstmt.executeQuery();

			ProjectVO pvo = null;

			while (rs.next()) {
				pvo = new ProjectVO();
				pvo.setPno(rs.getInt("pno"));
				pvo.setPname1(rs.getString("pname1"));
				pvo.setPname2(rs.getString("pname2"));
				pvo.setSponsor(rs.getInt("scount"));
				pvo.setAdate(rs.getString("adate"));
				pvo.setOdate(rs.getString("odate"));
				pvo.setGdate(rs.getString("gdate"));
				pvo.setPgrade(rs.getInt("pgrade"));
				pvo.setPmoney(rs.getInt("pmoney"));
				pvo.setNowmoney(rs.getInt("nowmoney"));

				plist.add(pvo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return plist;
	}

	// 관리자 페이지 프로젝트 리스트 페이지네이션 포함, 프로젝트 상태 진행중
	public ArrayList<ProjectVO> selectProjectListWithPagingP2(Criteria cri, String query) {
		ArrayList<ProjectVO> plist = new ArrayList<ProjectVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "";

		try {

			if (query != "") {
				sql = "select * from ("
						+ "select rownum rn, pno, pname1,pname2,(select count(*) from sponsor where project.pno = pno) as scount, "
						+ "adate, odate,gdate,pgrade, pmoney, nowmoney from project " + "where ( pname2 " + query
						+ ") and rownum <= ? * ? " + ") where rn > (?-1) * ? and pgrade = 2";
			} else {
				sql = "select * from ("
						+ "select rownum rn, pno, pname1,pname2,(select count(*) from sponsor where project.pno = pno) as scount, "
						+ "adate, odate,gdate,pgrade, pmoney, nowmoney from project " + "where rownum <= ? * ? "
						+ ") where rn > (?-1) * ? and pgrade = 2";

				// System.out.println(sql);

			}

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());

			// System.out.println(sql);

			rs = pstmt.executeQuery();

			ProjectVO pvo = null;

			while (rs.next()) {
				pvo = new ProjectVO();
				pvo.setPno(rs.getInt("pno"));
				pvo.setPname1(rs.getString("pname1"));
				pvo.setPname2(rs.getString("pname2"));
				pvo.setSponsor(rs.getInt("scount"));
				pvo.setAdate(rs.getString("adate"));
				pvo.setOdate(rs.getString("odate"));
				pvo.setGdate(rs.getString("gdate"));
				pvo.setPgrade(rs.getInt("pgrade"));
				pvo.setPmoney(rs.getInt("pmoney"));
				pvo.setNowmoney(rs.getInt("nowmoney"));

				plist.add(pvo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return plist;
	}

	// 관리자 페이지 프로젝트 리스트 페이지네이션 포함, 프로젝트 상태 공개 예정
	public ArrayList<ProjectVO> selectProjectListWithPagingP3(Criteria cri, String query) {
		ArrayList<ProjectVO> plist = new ArrayList<ProjectVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "";

		try {

			if (query != "") {
				sql = "select * from ("
						+ "select rownum rn, pno, pname1,pname2,(select count(*) from sponsor where project.pno = pno) as scount, "
						+ "adate, odate,gdate,pgrade, pmoney, nowmoney from project " + "where ( pname2 " + query
						+ ") and rownum <= ? * ? " + ") where rn > (?-1) * ? and pgrade = 3";
			} else {
				sql = "select * from ("
						+ "select rownum rn, pno, pname1,pname2,(select count(*) from sponsor where project.pno = pno) as scount, "
						+ "adate, odate,gdate,pgrade, pmoney, nowmoney from project " + "where rownum <= ? * ? "
						+ ") where rn > (?-1) * ? and pgrade = 3";

				// System.out.println(sql);

			}

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());

			// System.out.println(sql);

			rs = pstmt.executeQuery();

			ProjectVO pvo = null;

			while (rs.next()) {
				pvo = new ProjectVO();
				pvo.setPno(rs.getInt("pno"));
				pvo.setPname1(rs.getString("pname1"));
				pvo.setPname2(rs.getString("pname2"));
				pvo.setSponsor(rs.getInt("scount"));
				pvo.setAdate(rs.getString("adate"));
				pvo.setOdate(rs.getString("odate"));
				pvo.setGdate(rs.getString("gdate"));
				pvo.setPgrade(rs.getInt("pgrade"));
				pvo.setPmoney(rs.getInt("pmoney"));
				pvo.setNowmoney(rs.getInt("nowmoney"));

				plist.add(pvo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return plist;
	}

	// 관리자 페이지 프로젝트 리스트 페이지네이션 포함, 프로젝트 상태 완료
	public ArrayList<ProjectVO> selectProjectListWithPagingP4(Criteria cri, String query) {
		ArrayList<ProjectVO> plist = new ArrayList<ProjectVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "";

		try {

			if (query != "") {
				sql = "select * from ("
						+ "select rownum rn, pno, pname1,pname2,(select count(*) from sponsor where project.pno = pno) as scount, "
						+ "adate, odate,gdate,pgrade, pmoney, nowmoney from project " + "where ( pname2 " + query
						+ " and pgrade = 4 ) and rownum <= ? * ? " + ") where rn > (?-1) * ? ";
			} else {
				sql = "select * from ("
						+ "select rownum rn, pno, pname1,pname2,(select count(*) from sponsor where project.pno = pno) as scount, "
						+ "adate, odate,gdate,pgrade, pmoney, nowmoney from project " + "where rownum <= ? * ? and pgrade = 4 "
						+ ") where rn > (?-1) * ? ";

				// System.out.println(sql);

			}

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());

			// System.out.println(sql);

			rs = pstmt.executeQuery();

			ProjectVO pvo = null;

			while (rs.next()) {
				pvo = new ProjectVO();
				pvo.setPno(rs.getInt("pno"));
				pvo.setPname1(rs.getString("pname1"));
				pvo.setPname2(rs.getString("pname2"));
				pvo.setSponsor(rs.getInt("scount"));
				pvo.setAdate(rs.getString("adate"));
				pvo.setOdate(rs.getString("odate"));
				pvo.setGdate(rs.getString("gdate"));
				pvo.setPgrade(rs.getInt("pgrade"));
				pvo.setPmoney(rs.getInt("pmoney"));
				pvo.setNowmoney(rs.getInt("nowmoney"));

				plist.add(pvo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return plist;
	}

	//프로젝트 검토중 수 출력
	public int ProjectListCount(String query) {

		int count = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = null;
		try {

			if (query != "") {
				sql = "select count(*) as cnt from project where pname2 " + query;

			} else {
				sql = "select count(*) as cnt from project";
			}

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt("cnt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}
	
	
	// 프로젝트 검토중 수 출력
	public int ProjectListCountGrade1(String query) {

		int count = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = null;
		try {

			if (query != "") {
				sql = "select count(*) as cnt from project where pgrade = 1 and pname2 " + query;

			} else {
				sql = "select count(*) as cnt from project where pgrade = 1";
			}

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt("cnt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}
	
	// 프로젝트 진행중 수 출력
		public int ProjectListCountGrade2(String query) {

			int count = 0;

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = null;
			try {

				if (query != "") {
					sql = "select count(*) as cnt from project where pgrade = 2 and pname2 " + query;

				} else {
					sql = "select count(*) as cnt from project where pgrade = 2";
				}

				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					count = rs.getInt("cnt");
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return count;
		}
	
	
	// 프로젝트 공개예정 수 출력
		public int ProjectListCountGrade3(String query) {

			int count = 0;

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = null;
			try {

				if (query != "") {
					sql = "select count(*) as cnt from project where pgrade = 3 and pname2 " + query;

				} else {
					sql = "select count(*) as cnt from project where pgrade = 3";
				}

				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					count = rs.getInt("cnt");
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return count;
		}
		
		// 프로젝트 완료 수 출력
				public int ProjectListCountGrade4(String query) {

					int count = 0;

					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					String sql = null;
					try {

						if (query != "") {
							sql = "select count(*) as cnt from project where pgrade = 4 and pname2 " + query;

						} else {
							sql = "select count(*) as cnt from project where pgrade = 4";
						}

						conn = DBManager.getConnection();
						pstmt = conn.prepareStatement(sql);
						rs = pstmt.executeQuery();

						while (rs.next()) {
							count = rs.getInt("cnt");
						}

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						DBManager.close(conn, pstmt, rs);
					}
					return count;
				}

				public void updateProjectGrade(int grade, int pno) {

					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;

					String sql = "update project set pgrade = "+grade+" where pno = "+pno;
					
					try {
						
						conn = DBManager.getConnection();
						pstmt = conn.prepareStatement(sql);
						pstmt.executeUpdate();
						
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						DBManager.close(conn, pstmt);
					}
					
				}
	
}
