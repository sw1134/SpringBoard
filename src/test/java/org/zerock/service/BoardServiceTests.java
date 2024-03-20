package org.zerock.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assume.assumeNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	// 주입 테스트
	@Test
	public void testExist() {
		log.info(service);
		// 주어진 값이 null인지 아닌지 확인하는 제공 메서드 = 테스트 프레임워크에서 제공됨
		assertNotNull(service);
	}
	
	// 회원가입
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("서비스 제목");
		board.setContent("서비스 내용");
		board.setWriter("gimssam");
		// 비지니스 BoardService 이용
		service.register(board);
		// 로그 출력 = pk만 출력
		log.info("서비스 사용 PK bno => " + board.getBno());
	}
	// 전체 목록
	@Test
	public void testGetList() {
		service.getList().forEach(board -> log.info(board));
	}
	// 읽기
	@Test
	public void testGet() {
		log.info("서비스 게시물 읽기 => " + service.get(62L));
	}
	// 삭제
	@Test
	public void testDelete() {
		log.info("서비스 게시물 삭제 => " + service.remove(62L));
	}
	// 수정 = 특정 게시물 조회후에 글제목 수정
	@Test
	public void testUpdate() {
		BoardVO board = service.get(62L);
		if(board == null) {
			return;
		}
		board.setTitle("서비스 제목수정");
		log.info("서비스 게시물 수정 => " + service.modify(board));
	}
	
}
