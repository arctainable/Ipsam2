package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DB.DBManager;
import DTO.RewardVO;

public class RewardDAO {

	private RewardDAO() {};
	private static RewardDAO instance = new RewardDAO();
	public static RewardDAO getInstance() {
		return instance;
	}
	// 리워드 넣는거 프로젝트 업로드할때 작동함
	public void setRewardInsert(RewardVO rvo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = " insert into reward (pno, rno, rcontent, rmoney) "+ 
					" values (?, ?, ?, ?) ";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rvo.getPno());
			pstmt.setInt(2, rvo.getRno());
			pstmt.setString(3, rvo.getRcontent());
			pstmt.setInt(4, rvo.getRmoney());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	// 리워드리스트 출력
	public List<RewardVO> getRewardList(int pno){
		List<RewardVO> list = new ArrayList<RewardVO>();
		RewardVO rvo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select pno, rno, rcontent, rmoney, rcount from reward where pno = ? order by rno asc";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				rvo = new RewardVO();
				rvo.setPno(rs.getInt("pno"));
				rvo.setRno(rs.getInt("rno"));
				rvo.setRcontent(rs.getString("rcontent"));
				rvo.setRmoney(rs.getInt("rmoney"));
				rvo.setRcount(rs.getInt("rcount"));
				
				list.add(rvo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	//프로젝트 번호랑 리워드 번호로 리워드 객체 뽑기
	public RewardVO getRewardSelect(int pno, int rno) {
		RewardVO rvo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select rno, pno, rcontent, rmoney, rcount from reward where rno = ? and pno = ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
			pstmt.setInt(2, pno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				rvo = new RewardVO();
				rvo.setRno(rs.getInt("rno"));
				rvo.setRcontent(rs.getString("rcontent"));
				rvo.setRmoney(rs.getInt("rmoney"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return rvo;
	}
	// 프로젝트 후원해서 리워드 카운트 증가함
	public void setRewardCountUp(int pno, int rno) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update reward set rcount = rcount +1 where rno = ? and pno = ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
			pstmt.setInt(2, pno);
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}

}
