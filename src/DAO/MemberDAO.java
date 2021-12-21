package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DB.DBManager;
import DTO.MemberVO;
import DTO.ProjectVO;

public class MemberDAO {

	private MemberDAO() {};
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	//회원가입
	public int setMemberInsert(MemberVO mvo) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = " insert into member (bno, id, pw, name, email) " +
					" values ( member_seq.nextval, ?, ?, ? ,?) ";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mvo.getId());
			pstmt.setString(2, mvo.getPw());
			pstmt.setString(3, mvo.getName());
			pstmt.setString(4, mvo.getEmail());
			
			result = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	//로그인 할때 쓰는거
	public MemberVO getMemberLogin(String id) {
		MemberVO mvo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select bno, id, pw, name, email, profile, grade " + 
					" from member where id= ? ";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mvo = new MemberVO();
				mvo.setBno(rs.getInt("bno"));
				mvo.setId(id);
				mvo.setPw(rs.getString("pw"));
				mvo.setName(rs.getString("name"));
				mvo.setEmail(rs.getString("email"));
				mvo.setProfile(rs.getString("profile"));
				mvo.setGrade(rs.getInt("grade"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mvo;
	} 
	
	public static void setMemberUpdate(MemberVO mvo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		

		String sql ="update member set id=?, pw=?, name=?, email=?, profile=? where bno=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mvo.getId());
			pstmt.setString(2, mvo.getPw());
			pstmt.setString(3, mvo.getName());
			pstmt.setString(4, mvo.getEmail());
			pstmt.setString(5, mvo.getProfile());
			pstmt.setInt(6, mvo.getBno());
			
			pstmt.executeUpdate();
			
			System.out.println("id는 "+mvo.getId());
			System.out.println("pw는 "+mvo.getPw());
			System.out.println("name은 "+mvo.getName());
			System.out.println("email은 "+mvo.getEmail());
			System.out.println("파일명은 "+mvo.getProfile());
			System.out.println("번호는 "+mvo.getBno());
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public List<ProjectVO> getMemberProjectList(MemberVO mvo){
		List<ProjectVO> list = new ArrayList<ProjectVO>();
		ProjectVO pvo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql =" select "
				+ "a.pno, a.pname1, a.pname2, a.pcontent1, a.id, a.pgrade, " + 
				" a.adate, a.odate, a.gdate, a.pmoney, a.categoryno,a.nowmoney, " + 
				" b.name, b.id" + 
				" from project a,member b" + 
				" where (a.id = b.id)and b.id='sample3' ";
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
				pvo.setAdate(rs.getString("adate"));
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
	
	//카테고리 번호를 이름으로 바꿔준다
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
				if(rs.next()) {
					categoryname = rs.getString("categoryname");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt, rs);
			}
			return categoryname;
		}
	
	
}
