package com.spring.project.Tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.giorgoch.projectClient.wsService.UserService;

@ActiveProfiles("dev")
@ContextConfiguration(locations = { "classpath:*/dao-context.xml", "classpath:*/security-context.xml",
		"classpath:*/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class aopTests {
	
	
	@Test
	public void aopTest(){
		// Create Spring application context that configured by xml.
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/aop.xml");
        
        //IOC with spring
        UserService userService=(UserService)ctx.getBean("userAop");
        
 
        
        ctx.close();
    }
	}

 
