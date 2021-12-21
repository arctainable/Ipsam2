package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DB.DBManager;
import DTO.ProjectVO;
import DTO.SponsorVO;
import DTO.MypageVO;
import Util.CriteriaMy;

public class MypageDAO {
	

	private static MypageDAO instance = new MypageDAO();
	
	public static MypageDAO getInstance() {
		
		return instance;
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
		
//		public List<ProjectVO> getMemberProjectList1(String id) {
//		List<ProjectVO> list = new ArrayList<ProjectVO>();
//		ProjectVO pvo = null;
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		String sql = " select " + "a.pno, a.pname1, a.pname2, a.pcontent1, a.id, a.pgrade, "
//				+ " a.adate, a.odate, a.gdate, a.pmoney, a.categoryno,a.nowmoney, " + " b.name, b.id"
//				+ " from project a,member b" + " where (a.id = b.id) and (a.pgrade<2 or a.pgrade=3) and b.id=?";
//		try {
//			conn = DBManager.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				pvo = new ProjectVO();
//				pvo.setPno(rs.getInt("pno"));
//				pvo.setPname1(rs.getString("pname1"));
//				pvo.setPname2(rs.getString("pname2"));
//				pvo.setPcontent1(rs.getString("pcontent1"));
//				pvo.setId(rs.getString("id"));
//				pvo.setPgrade(rs.getInt("pgrade"));
//				pvo.setAdate(rs.getString("adate"));
//				pvo.setOdate(rs.getString("odate"));
//				pvo.setGdate(rs.getString("gdate"));
//				pvo.setNowmoney(rs.getInt("nowmoney"));
//				pvo.setPmoney(rs.getInt("pmoney"));
//				pvo.setCategoryname(getCategoryName(rs.getInt("categoryno")));
//				pvo.setName(rs.getString("name"));
//
//				list.add(pvo);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager.close(conn, pstmt, rs);
//		}
//		return list;
//	}

	public List<MypageVO> getMemberProjectListWithPaging1(CriteriaMy cri, String id) {
		List<MypageVO> list = new ArrayList<MypageVO>();
		MypageVO pvo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from (select rownum rn, a.pno, a.pname1, a.pname2, a.pcontent1, a.id as aid, a.pgrade, "
				+ " a.adate, a.odate, a.gdate, a.pmoney, a.categoryno, a.nowmoney, b.name, b.id"
				+ " from project a, member b"
				+ " where (a.id = b.id) and (a.pgrade<2 or a.pgrade=3) and b.id=?) where rn <= ? * ? and rn > (?-1) * ?";
		System.out.println(sql);
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, cri.getPageNum());
			pstmt.setInt(3, cri.getAmount());
			pstmt.setInt(4, cri.getPageNum());
			pstmt.setInt(5, cri.getAmount());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				pvo = new MypageVO();
				pvo.setPno(rs.getInt("pno"));
				pvo.setPname1(rs.getString("pname1"));
				pvo.setPname2(rs.getString("pname2"));
				pvo.setPcontent1(rs.getString("pcontent1"));
				pvo.setId(rs.getString("id"));
				pvo.setPgrade(rs.getInt("pgrade"));
				pvo.setAdate(rs.getString("adate"));
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

	public List<ProjectVO> getMemberProjectListWithPaging2(CriteriaMy cri, String id) {
		List<ProjectVO> list = new ArrayList<ProjectVO>();
		ProjectVO pvo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from (select rownum rn, a.pno, a.pname1, a.pname2, a.pcontent1, a.id as aid, a.pgrade, "
				+ " a.adate, a.odate, a.gdate, a.pmoney, a.categoryno, a.nowmoney, b.name, b.id "
				+ " from project a, member b "
				+ " where (a.id = b.id) and a.pgrade=2 and b.id=?) where rn <= ? * ? and rn > (?-1) * ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, cri.getPageNum());
			pstmt.setInt(3, cri.getAmount());
			pstmt.setInt(4, cri.getPageNum());
			pstmt.setInt(5, cri.getAmount());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				pvo = new ProjectVO();
				pvo.setPno(rs.getInt("pno"));
				pvo.setPname1(rs.getString("pname1"));
				pvo.setPname2(rs.getString("pname2"));
				pvo.setPcontent1(rs.getString("pcontent1"));
				pvo.setId(rs.getString("id"));
				pvo.setPgrade(rs.getInt("pgrade"));
				pvo.setAdate(rs.getString("adate"));
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

	public List<ProjectVO> getMemberProjectListWithPaging3(CriteriaMy cri, String id) {
		List<ProjectVO> list = new ArrayList<ProjectVO>();
		ProjectVO pvo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from (select rownum rn, a.pno, a.pname1, a.pname2, a.pcontent1, a.id as aid, a.pgrade, "
				+ " a.adate, a.odate, a.gdate, a.pmoney, a.categoryno, a.nowmoney, b.name, b.id "
				+ " from project a, member b "
				+ " where (a.id = b.id) and a.pgrade=4 and b.id=?) where rn <= ? * ? and rn > (?-1) * ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, cri.getPageNum());
			pstmt.setInt(3, cri.getAmount());
			pstmt.setInt(4, cri.getPageNum());
			pstmt.setInt(5, cri.getAmount());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				pvo = new ProjectVO();
				pvo.setPno(rs.getInt("pno"));
				pvo.setPname1(rs.getString("pname1"));
				pvo.setPname2(rs.getString("pname2"));
				pvo.setPcontent1(rs.getString("pcontent1"));
				pvo.setId(rs.getString("id"));
				pvo.setPgrade(rs.getInt("pgrade"));
				pvo.setAdate(rs.getString("adate"));
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

	public int getCount1(String id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select count(*) as cnt from project a,member b where (a.id = b.id) and b.id=? and (a.pgrade<2 or a.pgrade=3)";

		int count1 = 0;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count1 = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count1;
	}

	public int getCount2(String id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select count(*) as cnt from project a,member b where (a.id = b.id) and b.id=? and a.pgrade=2";

		int count2 = 0;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count2 = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count2;
	}

	public int getCount3(String id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select count(*) as cnt from project a,member b where (a.id = b.id) and b.id=? and a.pgrade=4";

		int count3 = 0;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count3 = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count3;
	}
			
		
		public List<MypageVO> getMemberProjectListWithPaging4(CriteriaMy cri, String id) {
			
			List<MypageVO> list = new ArrayList<MypageVO>();
			MypageVO svo = null;
			
//			System.out.println(id);
//			System.out.println(cri.getPageNum());
//			System.out.println(cri.getAmount());
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String sql = "select * from (select rownum rn, a.pno, a.pname1, a.pname2, a.pcontent1, a.id as aid, a.pgrade, "
					+ " a.adate, a.odate, a.gdate, a.pmoney, a.categoryno, a.nowmoney, b.name, b.id, "
					+ " c.pno as cpno, c.rno, c.id as cid, c.sgrade, c.smoney, c.sdate, c.address from project a, member b, sponsor c "
					+ " where (b.id = c.id) and (a.pno = c.pno) and c.sgrade=1 and c.id=?) where rn <= ? * ? and rn > (?-1) * ?";
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setInt(2, cri.getPageNum());
				pstmt.setInt(3, cri.getAmount());
				pstmt.setInt(4, cri.getPageNum());
				pstmt.setInt(5, cri.getAmount());
				rs = pstmt.executeQuery();

				while (rs.next()) {
					svo = new MypageVO();
					svo.setPno(rs.getInt("pno"));
					svo.setPname1(rs.getString("pname1"));
					svo.setPname2(rs.getString("pname2"));
					svo.setPcontent1(rs.getString("pcontent1"));
					svo.setId(rs.getString("id"));
					svo.setPgrade(rs.getInt("pgrade"));
					svo.setAdate(rs.getString("adate"));
					svo.setOdate(rs.getString("odate"));
					svo.setGdate(rs.getString("gdate"));
					svo.setNowmoney(rs.getInt("nowmoney"));
					svo.setPmoney(rs.getInt("pmoney"));
					svo.setCategoryname(getCategoryName(rs.getInt("categoryno")));
					svo.setName(rs.getString("name"));
					svo.setRno(rs.getInt("rno"));
					svo.setSgrade(rs.getInt("sgrade"));
					svo.setSmoney(rs.getInt("smoney"));
					svo.setSdate(rs.getDate("sdate"));
					svo.setAddress(rs.getString("address"));
				
					list.add(svo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return list;
		}
		
		public List<MypageVO> getMemberProjectListWithPaging5(CriteriaMy cri, String id) {
			
			List<MypageVO> list = new ArrayList<MypageVO>();
			MypageVO svo = null;
			
//			System.out.println(id);
//			System.out.println(cri.getPageNum());
//			System.out.println(cri.getAmount());
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String sql = "select * from (select rownum rn, a.pno, a.pname1, a.pname2, a.pcontent1, a.id as aid, a.pgrade, "
					+ " a.adate, a.odate, a.gdate, a.pmoney, a.categoryno, a.nowmoney, b.name, b.id, "
					+ " c.pno as cpno, c.rno, c.id as cid, c.sgrade, c.smoney, c.sdate, c.address from project a, member b, sponsor c "
					+ " where (b.id = c.id) and (a.pno = c.pno) and c.sgrade=2 and c.id=?) where rn <= ? * ? and rn > (?-1) * ?";
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setInt(2, cri.getPageNum());
				pstmt.setInt(3, cri.getAmount());
				pstmt.setInt(4, cri.getPageNum());
				pstmt.setInt(5, cri.getAmount());
				rs = pstmt.executeQuery();

				while (rs.next()) {
					svo = new MypageVO();
					svo.setPno(rs.getInt("pno"));
					svo.setPname1(rs.getString("pname1"));
					svo.setPname2(rs.getString("pname2"));
					svo.setPcontent1(rs.getString("pcontent1"));
					svo.setId(rs.getString("id"));
					svo.setPgrade(rs.getInt("pgrade"));
					svo.setAdate(rs.getString("adate"));
					svo.setOdate(rs.getString("odate"));
					svo.setGdate(rs.getString("gdate"));
					svo.setNowmoney(rs.getInt("nowmoney"));
					svo.setPmoney(rs.getInt("pmoney"));
					svo.setCategoryname(getCategoryName(rs.getInt("categoryno")));
					svo.setName(rs.getString("name"));
					svo.setRno(rs.getInt("rno"));
					svo.setSgrade(rs.getInt("sgrade"));
					svo.setSmoney(rs.getInt("smoney"));
					svo.setSdate(rs.getDate("sdate"));
					svo.setAddress(rs.getString("address"));
				
					list.add(svo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return list;
		}

		public int getCount4(String id) {

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String sql = "select count(*) as cnt from project a,member b, sponsor c where (b.id = c.id) and (a.pno = c.pno) and c.sgrade=1 and c.id=?";

			int count1 = 0;

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					count1 = rs.getInt("cnt");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return count1;
		}
		
		public int getCount5(String id) {

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String sql = "select count(*) as cnt from project a,member b, sponsor c where (b.id = c.id) and (a.pno = c.pno) and c.sgrade=2 and c.id=?";

			int count1 = 0;

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					count1 = rs.getInt("cnt");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return count1;
		}
		
		public List<MypageVO> getMemberProjectListWithPaging6(CriteriaMy cri, String id) {
			
			List<MypageVO> list = new ArrayList<MypageVO>();
			MypageVO svo = null;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String sql = " select * from (select rownum rn, b.id, b.ncontent, b.regdate, b.nno, c.pname1, c.pname2, c.pno from "
						+ " sponsor a, news b, project c where a.pno = b.pno and a.pno=c.pno and a.id=?) "
						+ " where rn <= ? * ? and rn > (?-1) * ? ";

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setInt(2, cri.getPageNum());
				pstmt.setInt(3, cri.getAmount());
				pstmt.setInt(4, cri.getPageNum());
				pstmt.setInt(5, cri.getAmount());
				rs = pstmt.executeQuery();

				while (rs.next()) {
					svo = new MypageVO();
					svo.setId(rs.getString("id"));
					svo.setNcontent(rs.getString("ncontent"));
					svo.setRegdate(rs.getString("regdate"));
					svo.setNno(rs.getInt("nno"));
					svo.setPname1(rs.getString("pname1"));
					svo.setPname2(rs.getString("pname2"));
					svo.setPno(rs.getInt("pno"));
					list.add(svo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
//			System.out.println("pno값은 "+svo.getPno());
			return list;
		}
		
		//프로젝트 커뮤니티 글 갯수
		public int getMypageNewsCount(String id) {
			int result = 0;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "select count(*) as count from sponsor a, news b where a.pno = b.pno and a.id=?";
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result = rs.getInt("count");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt, rs);
			}
			return result;
		}
		
		public List<MypageVO> getSponsorListWithPaging(CriteriaMy cri, int pno) {
			List<MypageVO> list = new ArrayList<MypageVO>();
			MypageVO pvo = null;

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "select * from (select rownum rn, a.pno, a.rno, a.sgrade, a.smoney, a.sdate, a.id, a.address ,b.name, b.email, c.rcontent, "
					+ " d.pname2 from sponsor a, member b, reward c, project d "
					+ " where (a.id = b.id) and (a.pno=c.pno) and a.rno=c.rno and (a.pno=d.pno) and a.pno= ?) "
					+ " where rn <= ? * ? and rn > (?-1) * ? ";

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, pno);
				pstmt.setInt(2, cri.getPageNum());
				pstmt.setInt(3, cri.getAmount());
				pstmt.setInt(4, cri.getPageNum());
				pstmt.setInt(5, cri.getAmount());
				rs = pstmt.executeQuery();

				while (rs.next()) {
					pvo = new MypageVO();
					pvo.setRownum(rs.getInt("rn"));
					pvo.setPno(rs.getInt("pno"));
					pvo.setRno(rs.getInt("rno"));
					pvo.setSgrade(rs.getInt("sgrade"));
					pvo.setSmoney(rs.getInt("smoney"));
					pvo.setSdate(rs.getDate("sdate"));
					pvo.setId(rs.getString("id"));
					pvo.setAddress(rs.getString("address"));
					pvo.setName(rs.getString("name"));
					pvo.setEmail(rs.getString("email"));
//					System.out.println(pvo.getEmail());
//					System.out.println(pvo.getId());
					pvo.setRcontent(rs.getString("rcontent"));
					pvo.setPname2(rs.getString("pname2"));
					list.add(pvo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return list;
		}
		
		public static void updatereward(String id, int rno) {
			String sql = "update sponsor set rno=?, sdate=sysdate where id='?' and rno=?;";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, rno);
				pstmt.setString(2, id);
				pstmt.setInt(2, rno);
				pstmt.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt);
			}
		}
		
		public int getsponsorcount(CriteriaMy cri, int pno) {

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String sql = "select count(*) as cnt from (select rownum rn, a.pno, a.rno, a.sgrade, a.smoney, a.sdate, a.id ,b.name, b.email, c.rcontent "
					+ " from sponsor a, member b, reward c "
					+ "where (a.id = b.id) and (a.pno=c.pno) and a.rno=c.rno and a.pno= ?) ";

			int scount = 0;

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, pno);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					scount = rs.getInt("cnt");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return scount;
		}

		public static void updatesponsorsdate(SponsorVO svo) {
				
				Connection conn = null;
				PreparedStatement pstmt = null;
				
				String sql = "update sponsor set sgrade=2 where id=? and pno=?";
				System.out.println(sql);
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, svo.getId());
				pstmt.setInt(2, svo.getPno());
				
				pstmt.executeUpdate();

				} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
			
		}

		
}
