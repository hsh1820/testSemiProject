package com.kh.searchfree.member.model.vo;

import oracle.sql.CLOB;

public class ProfileResource {
	private int memberNo;
	private String profileResourcePath;
	private char profileResourceDeleteYN;
	private CLOB profileResourceContent;
	
	public ProfileResource() {
	}

	public ProfileResource(int memberNo, String profileResourcePath, char profileResourceDeleteYN,
			CLOB profileResourceContent) {
		super();
		this.memberNo = memberNo;
		this.profileResourcePath = profileResourcePath;
		this.profileResourceDeleteYN = profileResourceDeleteYN;
		this.profileResourceContent = profileResourceContent;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getProfileResourcePath() {
		return profileResourcePath;
	}

	public void setProfileResourcePath(String profileResourcePath) {
		this.profileResourcePath = profileResourcePath;
	}

	public char getProfileResourceDeleteYN() {
		return profileResourceDeleteYN;
	}

	public void setProfileResourceDeleteYN(char profileResourceDeleteYN) {
		this.profileResourceDeleteYN = profileResourceDeleteYN;
	}

	public CLOB getProfileResourceContent() {
		return profileResourceContent;
	}

	public void setProfileResourceContent(CLOB profileResourceContent) {
		this.profileResourceContent = profileResourceContent;
	}

	@Override
	public String toString() {
		return "ProfileResource [memberNo=" + memberNo + ", profileResourcePath=" + profileResourcePath
				+ ", profileResourceDeleteYN=" + profileResourceDeleteYN + ", profileResourceContent="
				+ profileResourceContent + "]";
	}
	
	
}
