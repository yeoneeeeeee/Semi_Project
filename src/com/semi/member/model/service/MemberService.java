package com.semi.member.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.semi.common.model.vo.PageInfo;
import com.semi.member.model.dao.MemberDao;
import com.semi.member.model.vo.Grade;
import com.semi.member.model.vo.Member;

public class MemberService {

	
	/**
	 * 사용자 로그인
	 * @param userId
	 * @param userPwd
	 * @return
	 */
	public Member loginMember(String userId, String userPwd) {
		
		Connection conn = getConnection();
		
		Member m = new MemberDao().loginMember(conn, userId, userPwd);
		
		close(conn);
		
		return m;
	}
	
	/**
	 * 사용자 회원등급 조회
	 * @param userId
	 * @param userPwd
	 * @return
	 */
	public Grade loginMember(String userId) {
		
		Connection conn = getConnection();
		
		Grade g = new MemberDao().loginMember(conn, userId);
		
		close(conn);
		
		return g;
	}
	
	
	
	/**
	 * 회원가입
	 * @param m
	 * @return
	 */
	public int insertMember(Member m) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().insertMember(conn, m);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	/**
	 * 회원가입 시 아이디 중복 체크
	 * @param userId
	 * @return m
	 */
	public Member idCheck(String userId) {
		
		Connection conn = getConnection();
		
		Member m = new MemberDao().idCheck(conn, userId);
		
		close(conn);
		
		return m;
	}
	
	/**
	 * 회원정보 변경
	 * @param m
	 * @return
	 */
	public Member updateMember(Member m) {
			
		Connection conn = getConnection();
		
		int result = new MemberDao().updateMember(conn, m);
		
		Member updateMember = null;
		
		if(result > 0) {
			commit(conn);
			updateMember = new MemberDao().selectMember(conn, m.getUserId());
		} else {
			rollback(conn);
		}
		close(conn);
		
		return updateMember;
	}
	
	/**
	 * 회원 비밀번호 변경
	 * @param userId
	 * @param userPwd
	 * @return result
	 */
	public int updatePwdMember(String userId, String userPwd) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().updatePwdMember(conn, userId, userPwd);
		
		Member updateMember = null;
		
		if(result > 0) {
			commit(conn);
			updateMember = new MemberDao().selectMember(conn, userId);
			
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	/**
	 * 계정 탈퇴
	 * @param userId
	 * @param userPwd
	 * @return
	 */
	public int deleteMember(String userId, String userPwd) {
	
		Connection conn = getConnection();
		
		int result = new MemberDao().deleteMember(conn, userId, userPwd);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	
	/**
	 * 관리자 회원 계정 삭제
	 * @param userId
	 * @param userPwd
	 * @return
	 */
	public int deleteMember(String userNo) {
	
		Connection conn = getConnection();
		
		int result = new MemberDao().deleteMember(conn,userNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	/**
	 * 회원 전체 조회
	 * @param m
	 * @return ArrayList<Member>
	 */
	public ArrayList<Member> memberList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Member> list = new MemberDao().memberList(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 회원 전체 조회
	 * @param m
	 * @return ArrayList<Member>
	 */
	public ArrayList<Member> memberList() {
		
		Connection conn = getConnection();
		
		ArrayList<Member> list = new MemberDao().memberList(conn);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 페이징 : 멤버수
	 * @return
	 */
	public int selectMemberCount() {
		
		Connection conn = getConnection();
		
		int listCount = new MemberDao().selectMemberCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 페이징 : 조건 검색 
	 * @param keyword
	 * @param category
	 * @return
	 */
	public int selectMemberCount(String keyword) {
		
		Connection conn = getConnection();
		
		int listCount = new MemberDao().selectMemberCount(conn,keyword);
		
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 페이징 : 조건 검색 
	 * @param m
	 * @return ArrayList<Member>
	 */
	public ArrayList<Member> selectMemberList(PageInfo pi, String keyword, String category) {
		
		Connection conn = getConnection();
		
		ArrayList<Member> list = new MemberDao().selectMemberList(conn, pi, keyword, category);
		
		close(conn);
		
		return list;
	}
	
	
	/**
	 * 회원 상세 조회
	 * @param MemberNo
	 * @return
	 */
	public Member memberDetail(String mno) {
		
		Connection conn = getConnection();
		
		Member m = new MemberDao().memberDetail(conn, mno);
		
		close(conn);
		
		return m;
	}
	
	
	// 회원 등급 순 조회
	
	
	
	// 이름 순 조회
	
	
	
	// 회원 번호 순 조회
	
	
	
}
