package com.kh.searchfree.member.model.service;
import static com.kh.searchfree.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.searchfree.admin.model.vo.Category2;
import com.kh.searchfree.member.model.dao.MemberDAO;
import com.kh.searchfree.member.model.vo.Member;

public class MemberService {

	/** 로그인용 Service
	 * @param member
	 * @return loginMember
	 * @throws Exception
	 */
	public Member loginMember(Member member) throws Exception{
		
		Connection conn = getConnection();
		
		Member loginMember = new MemberDAO().loginMember(conn, member);
		
		return loginMember;
	}

	
	/** 회원 정보 조회용 Service
	 * @param memberId
	 * @return selectMember
	 * @throws Exception
	 */
	public Member selectMember(String memberId) throws Exception{
		
		Connection conn = getConnection();
		return new MemberDAO().selectMember(conn,memberId);
	}


	public List<Category2> getCategory2List() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
