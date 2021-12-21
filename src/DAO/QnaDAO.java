package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DB.DBManager;
import DTO.QnaVO;

public class QnaDAO {
	
	private static QnaDAO Instance = new QnaDAO();
	
	public static QnaDAO getInstance() {
		return Instance;
	}
	
	public void QnaWrite(QnaVO qvo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into qna values(qna_seq.nextval,?,?,?,?,?,sysdate,0)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qvo.getQuestion());
			pstmt.setString(2, qvo.getReply());
			pstmt.setString(3, qvo.getPno());
			pstmt.setString(4, qvo.getId());
			pstmt.setString(5, qvo.getPid());
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public List<QnaVO> getQnaListAll(int pno){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<QnaVO> list = new ArrayList<QnaVO>();
		QnaVO qvo = null;
		
		String sql = " select  " + 
				" a.bno , a.question, a.reply, a.pno, a.id, a.pid, a.regdate, a.replied, " + 
				" b.name " + 
				" from qna a, member b " + 
				" where (a.id = b.id) and pno = ?"
				+ " order by bno desc";
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				qvo = new QnaVO();
				qvo.setBno(rs.getInt("bno"));
				qvo.setQuestion(rs.getString("question"));
				qvo.setReply(rs.getString("reply"));
				qvo.setPno(rs.getString("pno"));
				qvo.setId(rs.getString("id"));
				qvo.setPid(rs.getString("pid"));
				qvo.setRegdate(rs.getString("regdate"));
				qvo.setReplied(rs.getInt("replied"));
				qvo.setName(rs.getString("name"));
				
				list.add(qvo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
		return list;
	}
	
public List<QnaVO> getQnaListById(String id, int pno){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<QnaVO> list = new ArrayList<QnaVO>();
		QnaVO qvo = null;
		
		String sql = "select  " + 
				"a.bno , a.question, a.reply, a.pno, a.id, a.pid, a.regdate, a.replied, " + 
				"b.name " + 
				"from qna a, member b " + 
				"where (a.id = b.id) and a.id=? and pno=?  " + 
				"order by bno desc";
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setInt(2, pno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				qvo = new QnaVO();
				qvo.setBno(rs.getInt("bno"));
				qvo.setQuestion(rs.getNString("question"));
				qvo.setReply(rs.getString("reply"));
				qvo.setPno(rs.getString("pno"));
				qvo.setId(rs.getString("id"));
				qvo.setPid(rs.getString("pid"));
				qvo.setRegdate(rs.getString("regdate"));
				qvo.setReplied(rs.getInt("replied"));
				qvo.setName(rs.getString("name"));
				
				list.add(qvo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
		return list;
	}

public void replywrite(QnaVO qvo) {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String sql = "update qna set reply=? where bno=?";
	
	try {
		
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, qvo.getReply());
		pstmt.setInt(2, qvo.getBno());
		
		pstmt.executeUpdate();
		
	}catch(Exception e) {
		
	}finally {
		DBManager.close(conn, pstmt);
	}
}

}
