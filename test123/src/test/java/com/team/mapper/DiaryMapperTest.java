package com.team.mapper;

import java.util.List;

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
public class DiaryMapperTest {
	
	@Setter(onMethod_ = @Autowired)
	private DiaryMapper mapper;
	
//	@Test
	public void getListWithPagingTest() {
		Criteria c1 = new Criteria();
		c1.setPageNum(1);
		c1.setAmount(5);
		c1.setUserId("aaa@aaa.com");
		List<DiaryVO> list = mapper.getListWithPaging(c1);
		list.forEach(diary -> log.info(diary));
	}
	
//	@Test
	public void readTest() {
		Long no = 8L;
		log.info(mapper.read(no));
		
	}
	
//	@Test
	public void deleteTest() {
		Long no = 8L;
		log.info(mapper.delete(no));
	}
	
//	@Test
	public void updateTest() {
		DiaryVO d1 = new DiaryVO();
		d1.setNo(6L);
		d1.setUser_id("bbb@bbb.com");
		d1.setTitle("test title");
		d1.setContent("test content");
		log.info(mapper.update(d1));
		
	}
	
//	@Test
	public void insertTest() {
		DiaryVO diary = new DiaryVO();
		diary.setUser_id("aaa@aaa.com");
		diary.setTitle("test insert title");
		diary.setContent("test insert content");
		log.info(mapper.insert(diary));
	}
	
	@Test
	public void countTest() {
		String userId = "aaa@aaa.com";
		log.info(mapper.countList(userId));
	}
}
