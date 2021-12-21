package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DB.DBManager;
import DTO.EventVO;

public class EventDAO {
	
	private EventDAO() {};
	private static EventDAO instance = new EventDAO();
	public static EventDAO getInstance() {
		return instance;
	}
	
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public void insertNotice(EventVO evo) {
		
		String sql = "insert into event(bno, title, content, regdate,viewcount,writer,thumbnail) "
				+ "values(event_seq.nextval,?,?,sysdate,0,?,?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, evo.getTitle());
			pstmt.setString(2, evo.getContent());
			pstmt.setString(3, evo.getWriter());
			pstmt.setString(4, evo.getThumbnail());
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		} 
		
	}
	
	
	public List<EventVO> selectEventList(){
		List<EventVO> elist = new ArrayList<EventVO>();
		
		String sql = "select * from event";
		
		EventVO evo = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				evo = new EventVO();
				evo.setBno(rs.getInt("bno"));
				evo.setTitle(rs.getString("title"));
				evo.setContent(rs.getString("content"));
				evo.setRegdate(rs.getDate("regdate"));
				evo.setViewcount(rs.getInt("viewcount"));
				evo.setWriter(rs.getString("writer"));
				evo.setThumbnail(rs.getString("thumbnail"));
				
				elist.add(evo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return elist;
	}
	
	public EventVO selectEventList(int bno){
		
		String sql = "select * from event where bno="+bno;
		
		EventVO evo = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				evo = new EventVO();
				evo.setBno(rs.getInt("bno"));
				evo.setTitle(rs.getString("title"));
				evo.setContent(rs.getString("content"));
				evo.setRegdate(rs.getDate("regdate"));
				evo.setViewcount(rs.getInt("viewcount"));
				evo.setWriter(rs.getString("writer"));
				evo.setThumbnail(rs.getString("thumbnail"));
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return evo;
	}
	
	
	public void deleteEvent(int bno) {
		String sql = "delete from event where bno="+bno;
		
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
	public List<EventVO> indexlist() {
		List<EventVO> elist = new ArrayList<EventVO>();
		
		String sql="select bno, title, content, regdate, viewcount, writer, thumbnail from event where rownum < 4 order by bno desc";

		EventVO evo = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				evo = new EventVO();
				evo.setBno(rs.getInt("bno"));
				evo.setTitle(rs.getString("title"));
				evo.setContent(rs.getString("content"));
				evo.setRegdate(rs.getDate("regdate"));
				evo.setViewcount(rs.getInt("viewcount"));
				evo.setWriter(rs.getString("writer"));
				evo.setThumbnail(rs.getString("thumbnail"));

				elist.add(evo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		return elist;
	}

}
