package com.team.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.team.domain.Criteria;
import com.team.domain.DiaryVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.team.config.RootConfig.class})
@Log4j
@WebAppConfiguration
public class DiaryServiceImplTest {
	
	@Setter(onMethod_ = @Autowired)
	private DiaryServiceImpl service;
	
//	@Test
	public void testGet() {
		Criteria c1 = new Criteria();
		service.getListWithPaging(c1).forEach(diary -> log.info(diary));
	
	}
	
//	@Test
	public void testRead() {
		Long no = 1L;
		log.info(service.read(no));
		
	}
	
//	@Test
	public void testDelete() {
		Long no = 7L;
		if(service.delete(no)) {
			log.info("deleted " + no);
		}
		
	}
	
//	@Test
	public void testUpdate() {
		DiaryVO vo = new DiaryVO();
		vo.setUser_id("bbb@bbb.com");
		vo.setTitle("title and title");
		vo.setContent("content and content");
		vo.setNo(1L);
		if(service.update(vo)) {
			log.info("updated " + vo.getNo());
		}
	}
	
//	@Test
	public void testInsert() {
		DiaryVO vo = new DiaryVO();
		vo.setUser_id("aaa@aaa.com");
		vo.setTitle("11111");
		vo.setContent("1111111111111");
		if(service.insert(vo)) {
			log.info("inserted " + vo.getNo());
		}
	}
	
	@Test
	public void testCount() {
		String userId = "aaa@aaa.com";
		log.info(userId + " : " + service.countList(userId)); 
	}
}
