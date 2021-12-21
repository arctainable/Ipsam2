package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DB.DBManager;
import DTO.ProjectVO;

public class ProjectDAO {

	private ProjectDAO() {
	};

	private static ProjectDAO instance = new ProjectDAO();

	public static ProjectDAO getInstance() {
		return instance;
	}

	// 프로젝트 올리기
	public int setProjectInsert(ProjectVO pvo) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = " insert into project "
				+ "(pno, pname1, pname2, pcontent1, pcontent2, pcontent3, id, categoryno, odate, gdate, pmoney, paccount)"
				+ " values (project_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pvo.getPname1());
			pstmt.setString(2, pvo.getPname2());
			pstmt.setString(3, pvo.getPcontent1());
			pstmt.setString(4, pvo.getPcontent2());
			pstmt.setString(5, pvo.getPcontent3());
			pstmt.setString(6, pvo.getId());
			pstmt.setInt(7, pvo.getCategoryno());
			pstmt.setString(8, pvo.getOdate());
			pstmt.setString(9, pvo.getGdate());
			pstmt.setInt(10, pvo.getPmoney());
			pstmt.setString(11, pvo.getPaccount());

			result = pstmt.executeUpdate();
			if (result != 0) {
				result = getPno();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return result;
	}

	// pno숫자 불러오기
	public int getPno() {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select max(pno) as pno from project";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("pno");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	// 프로젝트 카테고리 불러오기
	public List<ProjectVO> getCategoryList() {
		List<ProjectVO> list = new ArrayList<ProjectVO>();
		ProjectVO pvo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select categoryno, categoryname from category ";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				pvo = new ProjectVO();
				pvo.setCategoryno(rs.getInt("categoryno"));
				pvo.setCategoryname(rs.getString("categoryname"));

				list.add(pvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}

	// 카테고리 번호를 이름으로 바꿔준다
	public String getCategoryName(int categoryno) {
		String categoryname = "카테고리 무엇?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select categoryno, categoryname from category where categoryno = ? ";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, categoryno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				categoryname = rs.getString("categoryname");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return categoryname;
	}

	// 프로젝트 리스트 페이지
	public List<ProjectVO> getProjectList() {
		List<ProjectVO> list = new ArrayList<ProjectVO>();
		ProjectVO pvo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select " + "a.pno, a.pname1, a.pname2, a.pcontent1, a.id, a.pgrade, "
				+ " a.odate, a.gdate, a.pmoney, a.categoryno,a.nowmoney, " + " b.name " + " from project a,member b"
				+ " where (a.id = b.id)and a.pgrade >= 2 order by a.gdate asc";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				pvo = new ProjectVO();
				pvo.setPno(rs.getInt("pno"));
				pvo.setPname1(rs.getString("pname1"));
				pvo.setPname2(rs.getString("pname2"));
				pvo.setPcontent1(rs.getString("pcontent1"));
				pvo.setId(rs.getString("id"));
				pvo.setPgrade(rs.getInt("pgrade"));
				pvo.setOdate(rs.getString("odate"));
				pvo.setGdate(rs.getString("gdate"));
				pvo.setNowmoney(rs.getInt("nowmoney"));
				pvo.setPmoney(rs.getInt("pmoney"));
				pvo.setCategoryname(getCategoryName(rs.getInt("categoryno")));
				pvo.setName(rs.getString("name"));

				list.add(pvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 프로젝트 객체 불러오기
	public ProjectVO getProjectView(int bno) {
		ProjectVO pvo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select " + "a.pno, a.pname1, a.pname2, a.pcontent1, a.pcontent2, a.pcontent3, "
				+ "a.id, a.pgrade, a.pmoney, a.nowmoney, a.categoryno, " + "a.odate, a.gdate, a.paccount,  "
				+ "b.name, b.bno " + "from project a, member b "
				+ "where (a.id = b.id) and a.pgrade >= 1 and a.pno = ? ";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				pvo = new ProjectVO();
				pvo.setPno(rs.getInt("pno"));
				pvo.setPname1(rs.getString("pname1"));
				pvo.setPname2(rs.getString("pname2"));
				pvo.setPcontent1(rs.getString("pcontent1"));
				pvo.setPcontent2(rs.getString("pcontent2"));
				pvo.setPcontent3(rs.getString("pcontent3"));
				pvo.setId(rs.getString("id"));
				pvo.setPgrade(rs.getInt("pgrade"));
				pvo.setPmoney(rs.getInt("pmoney"));
				pvo.setNowmoney(rs.getInt("nowmoney"));
				pvo.setOdate(rs.getString("odate"));
				pvo.setGdate(rs.getString("gdate"));
				pvo.setPaccount(rs.getString("paccount"));
				pvo.setName(rs.getString("name"));
				pvo.setCategoryname(getCategoryName(rs.getInt("categoryno")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return pvo;
	}

	// 프로젝트 총 후원자수 불러오기
	public int getProjectSponCount(int pno) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select count(*) as count from project a, sponsor b where (a.pno = b.pno) and a.pno = ? ";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pno);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	// 프로젝트 총 후원 금액
	public int getProjectAllMoney(int pno) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select sum(smoney) as money from sponsor where pno = ?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pno);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt("money");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	// 프로젝트 후원금 추가하기
	public void setProjectSponMoney(int pno, int money) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = " update project set nowmoney = nowmoney + ? where pno = ? ";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, money);
			pstmt.setInt(2, pno);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 프로젝트 좋아요 갯수 불러오기
	public int getProjectLikeCount(int pno) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select count(*) as count from likes where pno= ? ";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pno);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	// 좋아요
	public int getProjectLikeUpdate(int pno, String id) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		int check = LikeCheck(pno, id);
		String sql = "";
		if (check == 1) {
			sql = "delete likes where pno = ? and id = ? ";
		} else {
			sql = " insert into likes(pno, id) values(?, ?) ";
		}
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pno);
			pstmt.setString(2, id);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	// 좋아요 했는지 안 했는지
	public int LikeCheck(int postbno, String userid) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from likes where pno = ? and id = ?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postbno);
			pstmt.setString(2, userid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	// 프로젝트 리스트 검색
	public List<ProjectVO> getProjectListSerch(String query) {
		List<ProjectVO> list = new ArrayList<ProjectVO>();
		ProjectVO pvo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "";
		if (query != "") {
			sql = " select " + "a.pno, a.pname1, a.pname2, a.pcontent1, a.id, a.pgrade, "
					+ " a.odate, a.gdate, a.pmoney, a.categoryno,a.nowmoney, " + " b.name " + " from project a,member b"
					+ " where (a.id = b.id)and a.pgrade >= 2 " + query + " order by a.gdate asc";
		} else {
			sql = " select " + "a.pno, a.pname1, a.pname2, a.pcontent1, a.id, a.pgrade, "
					+ " a.odate, a.gdate, a.pmoney, a.categoryno,a.nowmoney, " + " b.name " + " from project a,member b"
					+ " where (a.id = b.id)and a.pgrade >= 2 order by a.gdate asc";
		}

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				pvo = new ProjectVO();
				pvo.setPno(rs.getInt("pno"));
				pvo.setPname1(rs.getString("pname1"));
				pvo.setPname2(rs.getString("pname2"));
				pvo.setPcontent1(rs.getString("pcontent1"));
				pvo.setId(rs.getString("id"));
				pvo.setPgrade(rs.getInt("pgrade"));
				pvo.setOdate(rs.getString("odate"));
				pvo.setGdate(rs.getString("gdate"));
				pvo.setNowmoney(rs.getInt("nowmoney"));
				pvo.setPmoney(rs.getInt("pmoney"));
				pvo.setCategoryname(getCategoryName(rs.getInt("categoryno")));
				pvo.setName(rs.getString("name"));

				list.add(pvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	//메인 페이지 공개예정 4개
	public List<ProjectVO> getWaitProjectList(){
		List<ProjectVO> list = new ArrayList<ProjectVO>();
		ProjectVO pvo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from " + 
				" (select a.pno, a.pname1, a.pname2, a.pcontent1, a.id, a.pgrade, " + 
				" a.odate, a.gdate, a.pmoney, a.categoryno,a.nowmoney, " + 
				" b.name " + 
				" from project a, member b " + 
				" where (a.id = b.id)and (a.pgrade = 3) order by a.odate asc) where rownum < 5" ;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				pvo = new ProjectVO();
				pvo.setPno(rs.getInt("pno"));
				pvo.setPname1(rs.getString("pname1"));
				pvo.setPname2(rs.getString("pname2"));
				pvo.setPcontent1(rs.getString("pcontent1"));
				pvo.setId(rs.getString("id"));
				pvo.setPgrade(rs.getInt("pgrade"));
				pvo.setOdate(rs.getString("odate"));
				pvo.setGdate(rs.getString("gdate"));
				pvo.setNowmoney(rs.getInt("nowmoney"));
				pvo.setPmoney(rs.getInt("pmoney"));
				pvo.setCategoryname(getCategoryName(rs.getInt("categoryno")));
				pvo.setName(rs.getString("name"));
				
				list.add(pvo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	//메인 페이지 공개 6개
	public List<ProjectVO> getMainProjectList(){
		List<ProjectVO> list = new ArrayList<ProjectVO>();
		ProjectVO pvo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from " + 
				"( select a.pno, a.pname1, a.pname2, a.pcontent1, a.id, a.pgrade,  " + 
				"a.odate, a.gdate, a.pmoney, a.categoryno,a.nowmoney,  " + 
				"b.name " + 
				"from project a, member b " + 
				"where (a.id = b.id)and (a.pgrade = 2) order by a.odate desc) where rownum < 7" ;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				pvo = new ProjectVO();
				pvo.setPno(rs.getInt("pno"));
				pvo.setPname1(rs.getString("pname1"));
				pvo.setPname2(rs.getString("pname2"));
				pvo.setPcontent1(rs.getString("pcontent1"));
				pvo.setId(rs.getString("id"));
				pvo.setPgrade(rs.getInt("pgrade"));
				pvo.setOdate(rs.getString("odate"));
				pvo.setGdate(rs.getString("gdate"));
				pvo.setNowmoney(rs.getInt("nowmoney"));
				pvo.setPmoney(rs.getInt("pmoney"));
				pvo.setCategoryname(getCategoryName(rs.getInt("categoryno")));
				pvo.setName(rs.getString("name"));
				
				list.add(pvo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	//메인 페이지 순위
	public List<ProjectVO> getMainRanking(){
		List<ProjectVO> list = new ArrayList<ProjectVO>();
		ProjectVO pvo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from "
				+ "( select rownum rn, pno, pname1,pname2,"
				+ "(select count(*) from likes where project.pno = pno) as lcount, " 
				+ "adate, odate,gdate,pgrade, pmoney, nowmoney from project)"
				+ " order by lcount desc";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				for(int i = 0; i<5; rs.next(), i++) {
				pvo = new ProjectVO();
				pvo.setPno(rs.getInt("pno"));
				pvo.setPname1(rs.getString("pname1"));
				pvo.setPname2(rs.getString("pname2"));
				pvo.setPgrade(rs.getInt("pgrade"));
				pvo.setOdate(rs.getString("odate"));
				pvo.setGdate(rs.getString("gdate"));
				pvo.setNowmoney(rs.getInt("nowmoney"));
				pvo.setPmoney(rs.getInt("pmoney"));
				
				list.add(pvo);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	//프로젝트 삭제
	public void setProjectDelete(int pno) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = " delete project where pno = ? ";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pno);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	//위에 삭제할때 리워드도 같이 삭제
	public void setRewardDelete(int pno) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = " delete reward where pno = ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pno);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
}
