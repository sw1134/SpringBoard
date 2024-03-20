package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Setter(onMethod_ = { @Autowired })
	private BoardMapper mapper;
	
	// select
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	// insert
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 제목");
		board.setContent("새로 작성하는 내용");
		board.setWriter("작성자");
		mapper.insert(board);
		log.info(board);
	}
	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("Select Key 새로 작성하는 제목");
		board.setContent("Select Key 새로 작성하는 내용");
		board.setWriter("Select Key 작성자");
		mapper.insertSelectKey(board);
		log.info(board);
	}
	
	// read
	@Test
	public void testRead() {
		BoardVO board = mapper.read(68L);
		log.info(board);
	}
	
	// delete
	@Test
	public void testDelete() {
		log.info("Delete Count : " + mapper.delete(67L));
	}
		
	// update
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(72L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("작성자");
		
		int count = mapper.update(board);
		log.info("Update Count : " + count);
	}
	
	
	
} //EOC
