package org.zerock.persistence;
/* JDBC 테스트 코드 = JDBC 드라이버 이상 유무 테스트 */

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		try(Connection con = 
				DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:XE", 
						"book_ex",
						"book_ex")) {
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
/* (테스트결과) Java와 JDBC 드라이버만으로 테스트 함 
	= 해당 DB접속 정보로 DB접속이 가능하다면 DB가 연결된 Connection객체 생성됨. (다음작업) 커넥션풀 설정*/
