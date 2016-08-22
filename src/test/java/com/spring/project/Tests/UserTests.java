package com.spring.project.Tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
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
@ContextConfiguration(locations = { "classpath:*/dao-context.xml", "classpath:*/security-context.xml",
		"classpath:*/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTests {
	
	/**
	 * @author giorgos chatziefstratiou
	 * @throws RuntimeException
	 * This is a test for json using HttpClient from Apache
	 * You have to deploy the app and then run then test 
	 * change the HttpGet(""http://localhost:8080/projectClient/")with the server location you have
	 * then just add /webservice/user/Json
	 */	
	@SuppressWarnings("deprecation")
	@Test
	public void getUserTestJson() throws IOException { // ok
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet("http://localhost:8080/projectClient/webservice/user/Json");
		CloseableHttpResponse response = httpclient.execute(httpget);
		try {
			//HttpEntity entity = response.getEntity();
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
				String output;
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output + "\n");
				}
				//httpclient.getConnectionManager().shutdown();
			} else {
				throw new RuntimeException("Failed : http error code :" + response.getStatusLine().getStatusCode());
			}
		} finally {
			response.close();
		}
	}

	
	/**
	 * @author giorgos chatziefstratiou
	 * @throws RuntimeException
	 * 
	 * This is a test for Xml using HttpClient from Apache
	 * You have to deploy the app and then run then test 
	 * change the HttpGet(""http://localhost:8080/projectClient/")with the server location you have
	 * then just add /webservice/user/Xml
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void getUserTestXml() throws IOException { // ok
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet("http://localhost:8080/projectClient/webservice/user/Xml");
		CloseableHttpResponse response = httpclient.execute(httpget);
		try {
			//HttpEntity entity = response.getEntity();
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
				String output;
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output + "\n");
				}
				httpclient.getConnectionManager().shutdown();
			} else {
				throw new RuntimeException("Failed : http error code :" + response.getStatusLine().getStatusCode());
			}
		} finally {
			response.close();
		}
	}

	/**
	 * @author giorgos chatziefstratiou
	 * @throws RuntimeException
	 * 
	 * This is a test for Xml using HttpClient from Apache 
	 * this runs for every userid from 1 to 4
	 * You have to deploy the app and then run then test 
	 * change the HttpGet(""http://localhost:8080/projectClient/")with the server location you have
	 * then just add /webservice/user/Xml
	 */
	@Test
	public void getUserTestXmlEach() throws IOException { // ok
		HttpClient httpclient = HttpClients.createDefault();
		int[] userId = new int[4];
		userId[0] = 1;
		userId[1] = 2;
		userId[2] = 3;
		userId[3] = 4;
		for (int i = 0; i < userId.length; i++) {
			HttpGet httpget = new HttpGet("http://localhost:8080/projectClient/webservice/user/Xml/" + userId[i]);
			HttpResponse response = httpclient.execute(httpget);
			try {
				// HttpEntity entity = response.getEntity();
				if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
					BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
					String output;
					System.out.println("Output from Server ....to  Xml \n");
					while ((output = br.readLine()) != null) {
						System.out.println(output + "\n");
					}
					// httpclient.getConnectionManager().shutdown();
					// response.close();
				} else {
					throw new RuntimeException("Failed : http error code :" + response.getStatusLine().getStatusCode());
				}
			} finally {

			}
		}
	}

	/**
	 * @author giorgos chatziefstratiou
	 * @throws RuntimeException
	 * 
	 * This is a test for Json using HttpClient from Apache 
	 * this runs for every userid from 1 to 4
	 * You have to deploy the app and then run then test 
	 * change the HttpGet(""http://localhost:8080/projectClient/")with the server location you have
	 * then just add /webservice/user/Xml
	 */
	@Test
	public void getUserTestJsonEach() throws IOException { // ok
		int[] userId = new int[4];
		userId[0] = 1;
		userId[1] = 2;
		userId[2] = 3;
		userId[3] = 4;
		for (int i = 0; i < userId.length; i++) {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet("http://localhost:8080/projectClient/webservice/user/Json/"+userId[i]);
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				//HttpEntity entity = response.getEntity();
				if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
					BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
					String output;
					System.out.println("Output from Server .... to Json \n");
					while ((output = br.readLine()) != null) {
						System.out.println(output + "\n");
					}
					// httpclient.getConnectionManager().shutdown();
				} else {
					throw new RuntimeException("Failed : http error code :" + response.getStatusLine().getStatusCode());
				}
			} finally {
				// response.close();
			}
		}
	}
}
