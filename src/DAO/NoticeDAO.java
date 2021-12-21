package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DB.DBManager;
import DTO.NoticeVO;

public class NoticeDAO {
	
	private NoticeDAO() {};
	private static NoticeDAO instance = new NoticeDAO();
	public static NoticeDAO getInstance() {
		return instance;
	}
	
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public int insertNotice(NoticeVO nvo) {
		int result = 0;
		
		String sql = "insert into notice(bno, title, content, regdate,viewcount,writer) "
				+ "values(notice_seq.nextval,?,?,sysdate,0,?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nvo.getTitle());
			pstmt.setString(2, nvo.getContent());
			pstmt.setString(3, nvo.getWriter());
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		} return result;
		
	}
	
	
	public List<NoticeVO> selectNoticeList(){
		
		 List<NoticeVO> nlist = new  ArrayList<NoticeVO>();
		 
		 String sql = "select bno, title, content,regdate, viewcount, writer from notice order by bno desc";
		 NoticeVO nvo = null;
		 
		 try {
			 conn = DBManager.getConnection();
			 pstmt = conn.prepareStatement(sql);
			 rs = pstmt.executeQuery();
			 
			 while(rs.next()) {
				nvo = new NoticeVO();
				nvo.setBno(rs.getInt("bno"));
				nvo.setTitle(rs.getString("title"));
				nvo.setContent(rs.getString("content"));
				nvo.setRegdate(rs.getDate("regdate"));
				nvo.setViewcount(rs.getInt("viewcount"));
				nvo.setWriter(rs.getString("writer"));
				nlist.add(nvo);
			 }
			 
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 DBManager.close(conn, pstmt, rs);
		 }return nlist;
		
	}


	public NoticeVO selectNoticeView(int bno) {
		NoticeVO nvo = null;
		
		String sql = "select bno, title, content, regdate, viewcount,writer from notice where bno = ?";
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				nvo = new NoticeVO();
				nvo.setBno(rs.getInt("bno"));
				nvo.setTitle(rs.getString("title"));
				nvo.setContent(rs.getString("content"));
				nvo.setRegdate(rs.getDate("regdate"));
				nvo.setViewcount(rs.getInt("viewcount"));
				nvo.setWriter(rs.getString("writer"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return nvo;
	}


	public void deletenotice(int bno) {
		String sql = "delete from notice where bno="+bno;
		
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
	
	
	public void updatenotice(NoticeVO nvo) {
		String sql = "update notice set title=?, content=?, regdate=sysdate where bno=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nvo.getTitle());
			pstmt.setString(2, nvo.getContent());
			pstmt.setInt(3, nvo.getBno());
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	
	public void noticeViewcount(int bno) {
		String sql = "update notice set viewcount = viewcount+1 where bno="+bno;
		
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
