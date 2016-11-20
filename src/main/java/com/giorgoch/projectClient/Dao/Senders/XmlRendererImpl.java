package com.giorgoch.projectClient.Dao.Senders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.NameValuePair;

public class XmlRendererImpl {
	
    String sendXmlToUrl="http://localhost:8080/projectClient/sendXml";
    
    
    public void sendMethod(){
		HttpClient client = new DefaultHttpClient();
    	 HttpPost post = new HttpPost(sendXmlToUrl);
    	
    	try{//TODO post with httpclient
    	List<NameValuePair> namedValuePair = new ArrayList<NameValuePair>(1);	
    	}catch(IOException e){
    		
    	}
    }
	

}
