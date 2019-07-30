package org.zerock.persistence;
// *Bean으로 등록된 DataSource를 이용해서 Connection을 처리할 수 있는지를 확인한다.*
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

	@Setter(onMethod_ =  {@Autowired})
	private DataSource dataSource;
	
	@Test
	public void testConnection() {
		
		try(Connection con = dataSource.getConnection()){
			log.info(con);
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
}
