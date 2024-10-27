package com.SpringProject.member.vo;

import com.SpringProject.cmm.DefaultVO;


public class MemberVO extends DefaultVO{
	// 회원 고유 번호
    private String memberIdx=""; // MEMBER_IDX
    // 회원 이메일(아이디)
    private String memberEmail=""; // MEMBER_EMAIL
    // 회원 비밀번호
    private String memberPwd=""; // MEMBER_PWD
    // 회원명
    private String memberName=""; // MEMBER_NAME
    
	public String getMemberIdx() {
		return memberIdx;
	}
	public void setMemberIdx(String memberIdx) {
		this.memberIdx = memberIdx;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	@Override
	public String toString() {
		return "MemberVO [memberIdx=" + memberIdx + ", memberEmail=" + memberEmail + ", memberPwd=" + memberPwd
				+ ", memberName=" + memberName + "]";
	}
    
    
}
