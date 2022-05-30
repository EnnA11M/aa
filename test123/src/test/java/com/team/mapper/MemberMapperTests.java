package com.team.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team.domain.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.team.config.RootConfig.class})
@Log4j
public class MemberMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper membermapper;
	
//	@Test
	public void memberJoin() throws Exception {
		MemberVO member = new MemberVO();
		
		member.setUserId("test@test.com");
		member.setUserPassword("test123");
		member.setUserName("test");
		member.setUserTel("000-0000-0000");
		
		membermapper.memberJoin(member);
	}
	
	// 아이디 중복검사
//	@Test
	public void memberIdChk() throws Exception{
		String id = "asd@asd.com";	// 존재하는 아이디
		String id2 = "zzz@zzz.com";	// 존재하지 않는 아이디
		membermapper.idCheck(id);
		membermapper.idCheck(id2);
	}
	
	/* 로그인 쿼리 mapper 메서드 테스트 */
    @Test
    public void memberLogin() throws Exception{
        
        MemberVO member = new MemberVO();
        
        /* 올바른 아이디 비번 입력경우 */
        member.setUserId("asd@asd.com");
        member.setUserPassword("asd123");
        
        /* 올바른 않은 아이디 비번 입력경우 */
//        member.setUserId("asd1@asd.com");
//        member.setUserPassword("asd1234");
        
        membermapper.memberLogin(member);
        
    }
}
