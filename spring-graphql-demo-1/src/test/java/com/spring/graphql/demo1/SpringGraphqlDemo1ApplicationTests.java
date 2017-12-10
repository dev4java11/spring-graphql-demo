package com.spring.graphql.demo1;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringGraphqlDemo1ApplicationTests {
	
	@Before
	public void before(){
		System.out.println("***************************************** EJECUTANDO PRUEBAS *****************************************");
	}
	
	@After
	public void after(){
		System.out.println("***************************************** EJECUTANDO PRUEBAS *****************************************");
	}

	@Test
	@Ignore
	public void contextLoads() {
	}

}
