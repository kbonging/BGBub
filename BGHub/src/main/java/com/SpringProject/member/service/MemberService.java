package com.SpringProject.member.service;

import java.util.Map;

public interface MemberService {

	/**
	 * 회원 목록을 조회한다.
	 *
	 * @param 
	 * @return Map<String, Object>
	 * @throws Exception
	 */
	public Map<String, Object>  selectMemberList() throws Exception;
}
