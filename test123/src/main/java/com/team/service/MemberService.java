package com.team.service;

import com.team.domain.MemberVO;

public interface MemberService {
	
	//회원가입
	public void memberJoin(MemberVO member) throws Exception;
	
	// 아이디 중복 검사
	public int idCheck(String userId) throws Exception;
	
	/* 로그인 */
    public MemberVO memberLogin(MemberVO member) throws Exception;
    
    //회원 수정
    public void updateMember(MemberVO member) throws Exception;
    
    //회원 탈퇴
    public void deleteMember(MemberVO member) throws Exception;
}
