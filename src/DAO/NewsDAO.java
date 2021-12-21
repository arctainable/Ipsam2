package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DB.DBManager;
import DTO.NewsVO;
import DTO.News_CommentVO;

public class NewsDAO {

	private NewsDAO() {};
	private static NewsDAO instance = new NewsDAO();
	public static NewsDAO getInstance() {
		return instance;
	}
	
	//프로젝트 커뮤니티 글 갯수
	public int getNewsCount(int pno) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select count(*) as count from news where pno = ? ";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pno);
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
	//프로젝트 커뮤니티 글쓰기
	public void setNewsWrite(NewsVO nvo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = " insert into news (nno, pno, id, ncontent) "
				+ " values (news_seq.nextval, ?, ?, ? ) ";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nvo.getPno());
			pstmt.setString(2, nvo.getId());
			pstmt.setString(3, nvo.getNcontent());
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	//글목록 불러오기
	public List<NewsVO> getNewsList(int pno){
		List<NewsVO> list = new ArrayList<NewsVO>();
		NewsVO nvo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select "+ 
				"a.nno, a.pno, a.id, a.ncontent, a.regdate, b.name ,b.profile " + 
				"from news a, member b " + 
				"where (a.id = b.id) and a.pno = ? ";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				nvo = new NewsVO();
				nvo.setNno(rs.getInt("nno"));
				nvo.setPno(rs.getInt("pno"));
				nvo.setId(rs.getString("id"));
				nvo.setNcontent(rs.getString("ncontent"));
				nvo.setRegdate(rs.getString("regdate"));
				nvo.setName(rs.getString("name"));
				nvo.setProfile(rs.getString("profile"));
				
				list.add(nvo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	//댓글 갯수 가져오기
	public int getNewsCommentCount(int nno) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select count(*) as count from news_comment  where nno=? ";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
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
	//커뮤니티 글 객체 한개 가져오기
	public NewsVO getNewsView(int nno){
		NewsVO nvo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select "+ 
				"a.nno, a.pno, a.id, a.ncontent, a.regdate, b.name ,b.profile " + 
				"from news a, member b " + 
				"where (a.id = b.id) and a.nno = ? ";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				nvo = new NewsVO();
				nvo.setNno(rs.getInt("nno"));
				nvo.setPno(rs.getInt("pno"));
				nvo.setId(rs.getString("id"));
				nvo.setNcontent(rs.getString("ncontent"));
				nvo.setRegdate(rs.getString("regdate"));
				nvo.setName(rs.getString("name"));
				nvo.setProfile(rs.getString("profile"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return nvo;
	}
	//커뮤니티 글 수정하기
	public void setNewsModify(NewsVO nvo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update news set ncontent = ? where nno=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nvo.getNcontent());
			pstmt.setInt(2, nvo.getNno());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}DBManager.close(conn, pstmt);
	}
	//커뮤니티 글 삭제하기
	public void setNewsDelete(int nno) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = " delete news where nno = ? ";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	//댓글 작성
	public int setCommentInsert(News_CommentVO ncvo) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = " insert into news_comment(cno, nno, id, ncomment) "+
					" values (news_comment_seq.nextval,?,?,?) ";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ncvo.getNno());
			pstmt.setString(2, ncvo.getId());
			pstmt.setString(3, ncvo.getNcomment());
			
			pstmt.executeUpdate();
			
			result = getCommentNo();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	//
	public int getCommentNo() {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select max(cno) as cno from news_comment ";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("cno");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
	//댓글 번호로 댓글 하나 불러오기
	public News_CommentVO getCommentVO(int cno) {
		News_CommentVO ncvo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select cno, nno, id, ncomment, regdate from news_comment where cno = ? ";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				ncvo = new News_CommentVO();
				ncvo.setCno(rs.getInt("cno"));
				ncvo.setId(rs.getString("id"));
				ncvo.setNcomment(rs.getString("ncomment"));
				ncvo.setRegdate(rs.getString("regdate"));
				ncvo.setNno(rs.getInt("nno"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return ncvo;
	}
	//댓글 목록 불러오기
	public List<News_CommentVO> getCommentList(int nno) {
		List<News_CommentVO> list = new ArrayList<News_CommentVO>();
		News_CommentVO ncvo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select a.cno, a.nno, a.id, a.ncomment, a.regdate, b.name, b.profile " + 
					" from news_comment a, member b where (a.id = b.id) and a.nno = ? order by regdate desc";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				ncvo = new News_CommentVO();
				ncvo.setCno(rs.getInt("cno"));
				ncvo.setId(rs.getString("id"));
				ncvo.setNcomment(rs.getString("ncomment"));
				ncvo.setRegdate(rs.getString("regdate"));
				ncvo.setNno(rs.getInt("nno"));
				ncvo.setName(rs.getString("name"));
				ncvo.setProfile(rs.getString("profile"));
				list.add(ncvo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	//댓글삭제
	public void setCommentDelete(String id, int cno) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete news_comment where id = ? and cno = ? ";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, cno);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
}
