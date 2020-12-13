package com.gxf.test;

import com.gxf.user.UserMain8006;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;


@RunWith(SpringRunner.class)  //底层用junit  SpringJUnit4ClassRunner
@SpringBootTest(classes={UserMain8006.class})//启动整个springboot工程
public class SpringBootTestDemo {

	
	
	@Test
	public void testOne(){
		System.out.println("test hello 1");
		TestCase.assertEquals(1, 1);
		
	}
	
	@Test
	public void testTwo(){
		Duration between = Duration.between(LocalDate.parse("2020-09-04"), LocalDate.parse("2017-09-18"));
		System.out.println(between.toDays());
	}
	
	
	
	
	@Before
	public void testBefore(){
		System.out.println("before");
	}
	
	
	
	@After
	public void testAfter(){
		System.out.println("after");
	}

}
