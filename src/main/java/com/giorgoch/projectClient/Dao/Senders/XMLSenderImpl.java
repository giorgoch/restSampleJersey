package com.giorgoch.projectClient.Dao.Senders;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class XMLSenderImpl {
	
    String sendXmlToUrl="http://localhost:8080/projectClient";
	CloseableHttpClient httpclient = HttpClients.createDefault();
	HttpGet httpget = new HttpGet("");
	CloseableHttpResponse response = httpclient.execute(httpget);

}
