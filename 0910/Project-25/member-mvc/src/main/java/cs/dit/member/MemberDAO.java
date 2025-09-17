package cs.dit.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 패키지명 : cs.dit.member
 * 파일명 : MemberDAO.java
 * 작성일 : 2025. 4. 16.
 * 작성자 : 김진숙
 * 변경이력 :
 * 프로그램 설명 : 데이터베이스와 연동하고 CRUD가 가능한 메소드 구현
 *
 */
public class MemberDAO {
	
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
	
	//데이터베이스에 데이터 저장
	public void insert(MemberDTO dto) {
		String sql = "INSERT INTO member(id,name,pwd) VALUES(?,?,?)";
		try(
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);	
		) {
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPwd());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//DB에서 레코드 조회
	public ArrayList<MemberDTO> list(int p, int numOfRecords){
		String sql = "SELECT id, name, pwd FROM MEMBER limit ?, ?";

		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		try(Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
							
		) 
		{	pstmt.setInt(1, (p-1)*numOfRecords);
			pstmt.setInt(2, numOfRecords);
			ResultSet rs = pstmt.executeQuery();	
			
			//ResultSet에 들어있는 레코드를 추출하여 ArrayList에 추가
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String pwd = rs.getString("pwd");
				MemberDTO dto = new MemberDTO(id, name, pwd);
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtos;
	}
	
	//전체 레코드의 갯수를 알아오는 메소드 작성
	public int countRecords() {
		String sql = "SELECT COUNT(id) FROM MEMBER;";
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
	
	//updateForm에 출력할 데이터 가져오기
	public MemberDTO get(String id) {
		String sql = "select * from member where id = ?";
		MemberDTO dto=null;
		try (
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
		){
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			String name = rs.getString("name");
			String pwd = rs.getString("pwd");
			
			dto = new MemberDTO(id, name, pwd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	//update
	public void update(MemberDTO dto) {
		String sql = "UPDATE member SET NAME=?, PWD=? WHERE ID=?";
		
		try(
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);	
		) {
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getId());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void delete(String id) {
		String sql = "DELETE FROM MEMBER WHERE ID=?";
		
		try(
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);	
		) {
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}