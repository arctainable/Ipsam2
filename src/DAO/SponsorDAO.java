package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DB.DBManager;
import DTO.SponsorVO;
import Util.CriteriaMy;

public class SponsorDAO {

	private SponsorDAO() {};
	private static SponsorDAO instance = new SponsorDAO();
	public static SponsorDAO getInstance() {
		return instance;
	}
	
	//후원자가 후원 하면~
	public int setSponsor(SponsorVO svo) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = " insert into sponsor (pno, rno, id, smoney, address) "
				+ " values (?, ?, ?, ?, ?) ";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, svo.getPno());
			pstmt.setInt(2, svo.getRno());
			pstmt.setString(3, svo.getId());
			pstmt.setInt(4, svo.getSmoney());
			pstmt.setString(5, svo.getAddress());
			
			result = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

}
