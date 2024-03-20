/*
	커넥션 풀 설정 = HikariCP 사용
	: 자바의 DataSource 인터페이스를 통해 커넥션 풀을 사용
	  => DataSource를 통해 미리 연결을 맺어주고 반환하는 구조를 이용.
	  
	a. pom.xml = 라이브러리 추가
	b. root-context.xml = HikariCP 빈 설정
*/
package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {
	@Setter(onMethod_ = { @Autowired } )
	private DataSource dataSource;
	
	@Test
	public void testConnection() {
		try(Connection con = dataSource.getConnection()) {
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
/*
	(작동방식)
	a. 스프링이 시작되면 스프링 컨텍스트가 메모리에 만들어지고, -> root-context.xml을 읽음
	   -> 문서내 id가 dataSource 객체
	b. HikariCP 관련 빈을 찾아 DataSource에 주입됨
	
	(테스트 코드)
	 : 스프링에 빈으로 등록된 DataSource를 이용, Connection을 제대로 처리할 수 있는지 확인해 보는 용도
	   => 단지, 해당 테스트 메서드를 이용 내부적으로 HikariCP의 시작과 종료 로그만 확인하면 됨
	   => 현 단계에서는 설정 문제 유무만 확인하는 수준으로 , 아직 브라우저에서 최종 결과 확인 안됨 
	   => 추후 여러 설정을 추가한 후에 가능
*/
