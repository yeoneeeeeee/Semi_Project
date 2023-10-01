package com.semi.member.model.dao;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.semi.common.model.vo.PageInfo;
import com.semi.member.model.vo.Grade;
import com.semi.member.model.vo.Member;

public class MemberDao {

	private Properties prop = new Properties();
	
	public MemberDao() {
		
		String fileName = MemberDao.class.getResource("/sql/member/member-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 로그인
	 * @param conn
	 * @param userId
	 * @param userPwd
	 * @return m
	 */
	public Member loginMember(Connection conn, String userId, String userPwd) {
	
		Member m = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member(
							rset.getString("USER_NO"),
							rset.getString("USER_ID"),
							rset.getString("USER_PWD"),
							rset.getString("USER_NAME"),
							rset.getString("PHONE"),
							rset.getString("EMAIL"),
							rset.getString("ADDRESS"),
							rset.getDate("ENROLL_DATE"),
							rset.getString("GRADE_NO"),
							rset.getString("STATUS")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return m;
	}
	
	
	/**
	 * 로그인 시 회원등급 조회
	 * @param conn
	 * @param userId
	 * @param userPwd
	 * @return m
	 */
	public Grade loginMember(Connection conn, String userId) {
	
		Grade g = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("memberGrade");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				g = new Grade(
							rset.getString("GRADE_NO"),
							rset.getString("GRADE_NAME"),
							rset.getInt("MIN_DONA"),
							rset.getInt("MAX_DONA")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return g;
	}
	
	/**
	 * 회원가입
	 * @param conn
	 * @param m
	 * @return result
	 */
	public int insertMember(Connection conn, Member m) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getAddress());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	/**
	 * 회원가입 시 아이디 중복체크
	 * @param conn
	 * @param userId
	 * @return
	 */
	public Member idCheck(Connection conn, String userId) {
		
		Member m = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("idCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member(
							rset.getString("USER_NO"), 
							rset.getString("USER_ID"), 
							rset.getString("USER_PWD"),
							rset.getString("USER_NAME"), 
							rset.getString("PHONE"), 
							rset.getString("EMAIL"),
							rset.getString("ADDRESS"), 
							rset.getDate("ENROLL_DATE"),
							rset.getString("GRADE_NO"), 
							rset.getString("STATUS")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return m;
	}
	
	/**
	 * 회원 정보 수정
	 * @param conn
	 * @param m
	 * @return result
	 */
	public int updateMember(Connection conn, Member m) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserName());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	/**
	 * 회원 비밀번호 변경
	 * @param conn
	 * @param userId
	 * @param userPwd
	 * @return result
	 */
	public int updatePwdMember(Connection conn,String userId, String userPwd) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updatePwdMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userPwd);
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 회원 조회
	 * @param conn
	 * @param userId
	 * @return m
	 */
	public Member selectMember(Connection conn, String userId) {

		Member m = null;

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectMember");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userId);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				m = new Member(
						rset.getString("USER_NO"), 
						rset.getString("USER_ID"), 
						rset.getString("USER_PWD"),
						rset.getString("USER_NAME"), 
						rset.getString("PHONE"), 
						rset.getString("EMAIL"),
						rset.getString("ADDRESS"), 
						rset.getDate("ENROLL_DATE"),
						rset.getString("GRADE_NO"), 
						rset.getString("STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return m;
	}

	/**
	 * 회원 탈퇴
	 * @param conn
	 * @param userId
	 * @param userPwd
	 * @return result
	 */
	public int deleteMember(Connection conn, String userId, String userPwd) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userPwd);
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	/**
	 * 관리자 회원 삭제
	 * @param conn
	 * @param userId
	 * @param userPwd
	 * @return result
	 */
	public int deleteMember(Connection conn, String userNo) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteMemberAd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	/**
	 * 회원 리스트 조회(전체 정보)
	 * @param conn
	 * @return
	 */
	public ArrayList<Member> memberList(Connection conn, PageInfo pi) {
		
		ArrayList<Member> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("memberListPi");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Member(
							rset.getString("USER_NO"),
							rset.getString("USER_ID"),
							rset.getString("USER_PWD"),
							rset.getString("USER_NAME"),
							rset.getString("PHONE"),
							rset.getString("EMAIL"),
							rset.getString("ADDRESS"),
							rset.getDate("ENROLL_DATE"),
							rset.getString("GRADE_NO"),
							rset.getString("STATUS")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	
	/**
	 * 회원 리스트 조회(전체 정보)
	 * @param conn
	 * @return
	 */
	public ArrayList<Member> memberList(Connection conn) {
		
		ArrayList<Member> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("memberList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Member(
							rset.getString("USER_NO"),
							rset.getString("USER_ID"),
							rset.getString("USER_PWD"),
							rset.getString("USER_NAME"),
							rset.getString("PHONE"),
							rset.getString("EMAIL"),
							rset.getString("ADDRESS"),
							rset.getDate("ENROLL_DATE"),
							rset.getString("GRADE_NO"),
							rset.getString("STATUS")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	
	/**
	 * 회원 수 조회
	 * @param conn
	 * @param memberNo
	 * @return
	 */
	public int selectMemberCount(Connection conn) {
		
		int listCount = 0;

		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMemberCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	
	
	
	
	/**
	 * 페이징 : 조건 검색
	 * @param conn
	 * @param memberNo
	 * @return
	 */
	public int selectMemberCount(Connection conn, String keyword) {
		
		int listCount = 0;

		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectKeywordMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + keyword + "%");
			pstmt.setString(4, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	
	
	
	
	/**
	 * 회원 리스트 조회(전체 정보)
	 * @param conn
	 * @return
	 */
	public ArrayList<Member> selectMemberList(Connection conn, PageInfo pi, String keyword, String category) {
		
		ArrayList<Member> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = "";
		
		switch(category) {
		
		case "날짜순" :
			sql = prop.getProperty("selectEnrollDate");
			break;
		case "멤버쉽순" :
			sql = prop.getProperty("selectMemberGrade");
			break;
		default :
			sql = prop.getProperty("selectMemberNo");
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
		
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + keyword + "%");
			pstmt.setString(4, "%" + keyword + "%");
			pstmt.setInt(5, startRow);
			pstmt.setInt(6, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Member(
							rset.getString("USER_NO"),
							rset.getString("USER_ID"),
							rset.getString("USER_PWD"),
							rset.getString("USER_NAME"),
							rset.getString("PHONE"),
							rset.getString("EMAIL"),
							rset.getString("ADDRESS"),
							rset.getDate("ENROLL_DATE"),
							rset.getString("GRADE_NO"),
							rset.getString("STATUS")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	public Member memberDetail(Connection conn, String mno) {
		
		Member m = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("memberDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member(
							rset.getString("USER_NO"), 
							rset.getString("USER_ID"), 
							rset.getString("USER_PWD"),
							rset.getString("USER_NAME"), 
							rset.getString("PHONE"), 
							rset.getString("EMAIL"),
							rset.getString("ADDRESS"), 
							rset.getDate("ENROLL_DATE"),
							rset.getString("GRADE_NO"), 
							rset.getString("STATUS")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return m;
	}
	
	public String userNo(Connection conn, String receiver) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("userNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, receiver);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				receiver = rset.getString("USER_NO");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return receiver;
	}
	
	
	
}
