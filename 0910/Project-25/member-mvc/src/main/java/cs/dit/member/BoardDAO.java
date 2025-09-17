package cs.dit.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 패키지명 : cs.dit.member
 * 파일명 : BoardDAO.java
 * 작성일 : 2025. 9. 17.
 * 작성자 : jhkim
 * 변경이력 :
 * 프로그램 설명 : Board 테이블과 연동하고 CRUD가 가능한 메소드 구현
 *
 */
public class BoardDAO {
	
	//MariaDB 연동 커넥션 생성
	private Connection getConnection() throws Exception {
		
		// MariaDB 직접 연결
		String driver = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/backend";
		String username = "jhkim";
		String password = "1111";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		
		return con;
	}
	
	//게시글 저장
	public void insert(BoardDTO dto) {
		String sql = "INSERT INTO board(subject, content, writer, regdate) VALUES(?,?,?,SYSDATE())";
		try(
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);	
		) {
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getWriter());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//게시글 목록 조회 (페이지네이션)
	public ArrayList<BoardDTO> list(int p, int numOfRecords){
		String sql = "SELECT bcode, subject, content, writer, regdate FROM board ORDER BY bcode DESC LIMIT ?, ?";

		ArrayList<BoardDTO> dtos = new ArrayList<BoardDTO>();
		try(Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
							
		) 
		{	pstmt.setInt(1, (p-1)*numOfRecords);
			pstmt.setInt(2, numOfRecords);
			ResultSet rs = pstmt.executeQuery();	
			
			//ResultSet에 들어있는 레코드를 추출하여 ArrayList에 추가
			while(rs.next()) {
				int bcode = rs.getInt("bcode");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				java.sql.Date regdate = rs.getDate("regdate");
				BoardDTO dto = new BoardDTO(bcode, subject, content, writer, regdate);
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtos;
	}
	
	//전체 게시글 갯수
	public int countRecords() {
		String sql = "SELECT COUNT(bcode) FROM board";
		int count = 0;
		try(Connection con = getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
		)
		{
			rs.next();
			count = rs.getInt(1);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	//게시글 상세보기
	public BoardDTO get(int bcode) {
		String sql = "select * from board where bcode = ?";
		BoardDTO dto=null;
		try (
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
		){
			pstmt.setInt(1, bcode);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			String subject = rs.getString("subject");
			String content = rs.getString("content");
			String writer = rs.getString("writer");
			java.sql.Date regdate = rs.getDate("regdate");
			
			dto = new BoardDTO(bcode, subject, content, writer, regdate);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	//게시글 수정
	public void update(BoardDTO dto) {
		String sql = "UPDATE board SET subject=?, content=? WHERE bcode=?";
		
		try(
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);	
		) {
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getBcode());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//게시글 삭제
	public void delete(int bcode) {
		String sql = "DELETE FROM board WHERE bcode=?";
		
		try(
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);	
		) {
			pstmt.setInt(1, bcode);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}