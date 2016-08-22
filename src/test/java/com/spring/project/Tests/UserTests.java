package com.spring.project.Tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mongodb.DBObject;

import com.mongodb.util.JSON;

@ActiveProfiles("dev")
@ContextConfiguration(locations = { "classpath:*/dao-context.xml",
		"classpath:*/security-context.xml", "classpath:*/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTests {
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void getUserTest() throws IOException { // ok
		
		CloseableHttpClient httpclient = HttpClients.createDefault();		
		HttpGet httpget = new HttpGet("http://localhost:8080/projectClient/webservice/user/Json");	

		CloseableHttpResponse response = httpclient.execute(httpget);		
		
		try {
			HttpEntity entity = response.getEntity();	
			
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {			
				BufferedReader br = new BufferedReader( new InputStreamReader((response.getEntity().getContent())));
				String output;
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					
					System.out.println(output+"\n");
				}

				httpclient.getConnectionManager().shutdown();
			} else {
				throw new RuntimeException("Failed : http error code :"+response.getStatusLine().getStatusCode());
			}
		} finally {
			response.close();
			
		}
		
		
	

	
	
		
	}

}
