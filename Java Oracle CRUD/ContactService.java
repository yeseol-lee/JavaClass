package j20240826.contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactService {
	
	// 모든 연락처 조회
	public List<ContactVO> contactList() {
		String query = "SELECT * FROM contactTBL";
		
		List<ContactVO> list = new ArrayList<>();
		
		Connection conn = OracleDBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("contact_no");
				String name = rs.getString("contact_name");
				String phoneNumber = rs.getString("phoneNumber");
				String email = rs.getString("email");
				
				ContactVO contactVO = new ContactVO(no, name, phoneNumber, email);
				list.add(contactVO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			OracleDBConnection.closeConnection(conn);
		}
		
		
		return list;
	}
	
	
	// 이름(유일)으로 연락처 검색
	public ContactVO getContactByName(String searchName) {
		String query = "SELECT * FROM contactTBL WHERE contact_name = ?";

		ContactVO vo = null;
		
		Connection conn = OracleDBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {      
			pstmt = conn.prepareStatement(query);
			// ?와 변수 바인딩하기
			pstmt.setString(1, searchName);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int no = rs.getInt("contact_no");
				String name = rs.getString("contact_name");
				String phoneNumber = rs.getString("phoneNumber");
				String email = rs.getString("email");
				
				vo = new ContactVO(no, name, phoneNumber, email);
				
			} else {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			OracleDBConnection.closeConnection(conn);
		}
		return vo;
	}
	
	// 연락처 등록
	public void contactRegister(ContactVO vo) {
		String query = "INSERT INTO contactTBL VALUES (?, ?, ?, ?)";
		
		Connection conn = OracleDBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, vo.getNo());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPhoneNumber());
			pstmt.setString(4, vo.getEmail());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			OracleDBConnection.closeConnection(conn);
		}
	}
	
	
	// 연락처 삭제
	public void contactRemove(String name) {
		String query = "DELETE FROM contactTBL WHERE contact_name = ?";
		Connection conn = OracleDBConnection.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			OracleDBConnection.closeConnection(conn);
		}
	}
	
	// 연락처 수정
	public void contactModify(ContactVO param) {
		
		String query = "UPDATE contactTBL SET phoneNumber = ?, email = ? WHERE contact_name = ?";
		
		Connection conn = OracleDBConnection.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, param.getPhoneNumber());
			pstmt.setString(2, param.getEmail());
			pstmt.setString(3, param.getName());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			OracleDBConnection.closeConnection(conn);
		}
	}
	
	
}
