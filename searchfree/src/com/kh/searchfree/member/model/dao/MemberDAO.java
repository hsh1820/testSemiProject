package com.kh.searchfree.member.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.kh.searchfree.common.JDBCTemplate.*;

import com.kh.searchfree.admin.model.vo.Category1;
import com.kh.searchfree.admin.model.vo.Category2;
import com.kh.searchfree.member.model.vo.Member;

import oracle.sql.LobPlsqlUtil;

public class MemberDAO { 
	
	private Properties prop = null;
	
	// 유지보수를 위해 properties 파일을 새로 읽도록
	public MemberDAO() throws Exception {
		// member 관련 sql 파일을 관리할  properties 파일 생성
		String fileName = MemberDAO.class.getResource("/com/kh/searchfree/sql/member/member-query.properties")
				.getPath();
		prop = new Properties();
		prop.load(new FileReader(fileName));
	}
	/** 로그인용 Dao
	 * @param conn
	 * @param member
	 * @return loginMember
	 * @throws Exception
	 */
	public Member loginMember(Connection conn, Member member) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Member loginMember = null;
		
		String query = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			System.out.println("dao에서 받은 id, pwd : "+member.getMemberId()+ member.getMemberPwd());
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				int memberNo = rset.getInt("MEMBER_NO");
				String memberId = rset.getString("MEMBER_ID");
				String memberPwd = rset.getString("MEMBER_PWD");
				String memberNick = rset.getString("MEMBER_NICK");
				String memberName = rset.getString("MEMBER_NM");
				String memberPhone = rset.getString("MEMBER_PHONE");
				String memberEmail = rset.getString("MEMBER_EMAIL");
				String memberAddress = rset.getString("MEMBER_ADDRESS");
				String memberGrade = rset.getString("MEMBER_GRADE");
				String memberStatus = rset.getString("MEMBER_STATUS");
				String memberAccount = rset.getString("MEMBER_ACCOUNT");
				String memberInterest = rset.getString("MEMBER_INTEREST");
				String memberIntro = rset.getString("MEMBER_INTRO");
				Date memberEnrollDt = rset.getDate("MEMBER_ENROLL_DT");
				
				
				loginMember = new Member();
				
				loginMember.setMemberNo(memberNo);
				loginMember.setMemberId(memberId);
				loginMember.setMemberPwd(memberPwd);
				loginMember.setMemerNick(memberNick);
				loginMember.setMemberNm(memberName);
				loginMember.setMemberPhone(memberPhone);
				loginMember.setMemberEmail(memberEmail);
				loginMember.setMemberAddr(memberAddress);
				loginMember.setMemberGrade(memberGrade.charAt(0));
				loginMember.setMemberStatus(memberStatus.charAt(0));
				loginMember.setMemberAccount(memberAccount);
				loginMember.setMemberInterest(memberInterest);
				loginMember.setMemberIntro(memberIntro);
				loginMember.setMemberEnrollDate(memberEnrollDt);
				System.out.println("select결과 :" + loginMember);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		return loginMember;
	}
	
	/** 회원 정보 조회용 DAO
	 * @param conn
	 * @param memberId
	 * @return selectMember
	 */
	public Member selectMember(Connection conn, String memberId) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member selectMember = null;
		
		String query = prop.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				selectMember = new Member();
				
				selectMember.setMemberNo(rset.getInt("MEMBER_NO"));
				selectMember.setMemberId(rset.getString("MEMBER_ID"));
				selectMember.setMemberNm(rset.getString("MEMBER_NM"));
				selectMember.setMemberPhone(rset.getString("MEMBER_PHONE"));
				selectMember.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				selectMember.setMemberAddr(rset.getString("MEMBER_ADDR"));
				selectMember.setMemberInterest(rset.getString("MEMBER_INTEREST"));
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		return selectMember;
	}
	
	
	/** 현재 비밀번호 일치 여부 확인용 DAO
	 * @param conn
	 * @param loginMember
	 * @return result
	 * @throws Exception
	 */
	public int checkPwd(Connection conn, Member loginMember) throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("checkPwd");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, loginMember.getMemberId());
			pstmt.setString(2, loginMember.getMemberPwd());
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
	
}
