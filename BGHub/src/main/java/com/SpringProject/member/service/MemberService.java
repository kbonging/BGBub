package com.SpringProject.member.service;

import java.util.Map;

import com.SpringProject.member.vo.MemberVO;

public interface MemberService {

	/**
	 * 회원 목록을 조회한다.
	 *
	 * @param 
	 * @return Map<String, Object>
	 * @throws Exception
	 */
	public Map<String, Object>  selectMemberList() throws Exception;
	
	 
    /**
     * 이메일로 회원 정보를 조회한다.
     *
     * @param memberEmail
     * @return MemberVO
     */
    public MemberVO findByEmail(String memberEmail) throws Exception;
    
    /*회원 등록처리 */
    public int insertMember(MemberVO memberVO) throws Exception;
}
