package com.aditi.timesheet.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import android.os.AsyncTask;

public class WebRequest {
	// Web Request
	public String request(String url, String data) {

		HttpClient httpClient = new DefaultHttpClient();
		HttpContext localContext = new BasicHttpContext();
		HttpPost httpPost = new HttpPost(url);
		StringBuilder total = new StringBuilder();

		try {
			httpPost.setHeader("content-type", "application/json");
			httpPost.setHeader("Accept", "application/json");
			httpPost.setEntity(new StringEntity(data));

			InputStream inputStream = httpClient
					.execute(httpPost, localContext).getEntity().getContent();

			BufferedReader r = new BufferedReader(new InputStreamReader(
					inputStream));
			
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

class AsyncWebRequest extends AsyncTask<String, Void, String>{

	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		return null;
	}		
}
