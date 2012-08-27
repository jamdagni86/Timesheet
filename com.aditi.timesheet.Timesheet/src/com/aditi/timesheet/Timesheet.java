package com.aditi.timesheet;

import org.json.JSONException;

import com.aditi.timesheet.network.WebRequest;
import com.aditi.timesheet.serializable.Login;
import com.aditi.timesheet.serializable.Result;
import com.aditi.timesheet.serializer.JsonSerializer;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class Timesheet extends Activity {
	EditText userName;
	EditText password;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timesheet);	
		
		userName = (EditText)findViewById(R.id.userName);
		password = (EditText)findViewById(R.id.password);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_timesheet, menu);
		return true;
	}
	
	public void onLogin(View view) {
		final String userNameString = userName.getText().toString();
		final String passwordString = password.getText().toString();
		Login login = new Login() {
			{
				userName = userNameString;
				password = passwordString;
			}
		};	
		
		WebRequest request = new WebRequest(); 
		String response = request.request("http://10.0.2.2/Json/Timesheet.svc/Login", 
				String.format("{\"loginInfo\":%s}", JsonSerializer.serialize(login)));
		
	    try {
			Result result =	JsonSerializer.deSerialize(Result.class, response);
			
			if(result != null && result.success){
				
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		String serializedString;
//		try {
//			serializedString = JsonSerializer.serialize(login);
//			serializedString = serializedString.intern();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
	}

}