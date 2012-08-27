package com.aditi.timesheet.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import com.aditi.timesheet.serializer.JsonSerializer;

public class WebRequest {
	public String request(String url, Object data) {

		HttpClient httpClient = new DefaultHttpClient();
		HttpContext localContext = new BasicHttpContext();
		HttpPost httpPost = new HttpPost(url);
		StringBuilder total = new StringBuilder();

		try {
			httpPost.addHeader("content-type", "application/json");
			
			ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		    nameValuePairs.add(new BasicNameValuePair("loginInfo", JsonSerializer.serialize(data))); 
					    
		    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		    
			InputStream inputStream = httpClient
										.execute(httpPost, localContext)
										.getEntity()
										.getContent();

			BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));

			String line;
			while ((line = r.readLine()) != null) {
				total.append(line);
			}

			return total.toString();

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
