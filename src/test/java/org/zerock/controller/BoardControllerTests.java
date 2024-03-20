package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

/* 톰캣을 실행하지 않고 스프링과 URL 테스트를 가능하게 하는 환경 */
@RunWith(SpringJUnit4ClassRunner.class)
/* ServletContext를 스프링 WebApplicationContext에서 이용하기 위한 어노테이션 */
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class BoardControllerTests {
	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx;
	// 테스트용 가짜 MVC 프로젝트 = 가짜로 URL과 파라미터등을 브라우저에서 사용하는 것처럼 만들어서 Contrller 실행가능.
	private MockMvc mockMvc;
	// 모든 테스트 전에 매번 실행되는 매서드 설정하는 어노테이션
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	// 전체목록
	@Test
	public void testList() throws Exception{
      log.info(
// MockMvcRequestBuilders.get("/board/list")를 호출 -> BoardController getList()에서 반환된 결과를 이용
// -> Model에 담긴 데이터들 확인하는 테스트 ==> 화면 구성후 브라우저에 확인할 예정이고, 여기서는 단지 기존 테스트와 동일하게 실행
            mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap());
	}
	
	//등록 처리
	@Test
	public void testRegister() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title", "테스트 새글 제목")
				.param("content","테스트 새글 내용")
				.param("writer","ironman")
			).andReturn().getModelAndView().getViewName();
	}
	
	// 조회
	@Test
	public void testGet() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders
				.get("/board/get")
				.param("bno", "64")) // DB에 실제 있는 bno 값 사용하여 테스트
				.andReturn()
				.getModelAndView()
				.getViewName());
	}
	
	// 수정
	@Test
	public void testModify() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders
				.post("/board/modify")
				.param("bno", "64") // DB에 실제 있는 bno 값 사용하여 테스트
				.param("title", "수정 테스트 제목")
				.param("content", "수정 테스트 내용")
				.param("writer", "mcssam"))
				.andReturn()
				.getModelAndView()
				.getViewName();
		log.info(resultPage);
	}
	
	// 삭제
	@Test
	public void testRemove() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders
				.post("/board/remove")
				.param("bno", "64")) // DB에 실제 있는 bno 값 사용하여 테스트
				.andReturn()
				.getModelAndView()
				.getViewName();
		log.info(resultPage);	
	}
	
	
} // EOC
