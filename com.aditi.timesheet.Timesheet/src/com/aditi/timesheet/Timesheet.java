package com.aditi.timesheet;

import org.json.JSONException;

import com.aditi.timesheet.network.WebRequest;
import com.aditi.timesheet.serializable.Login;
import com.aditi.timesheet.serializable.Result;
import com.aditi.timesheet.serializer.JsonSerializer;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Timesheet extends Activity {
	EditText userName;
	EditText password;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timesheet);

		userName = (EditText) findViewById(R.id.userName);
		password = (EditText) findViewById(R.id.password);
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

		//Create a builder
		AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
		builder.setTitle("Alert Window");
		//add buttons and listener
		
		EmptyListener pl = new EmptyListener();
		builder.setPositiveButton("OK", pl);
		//Create the dialog
		AlertDialog ad = builder.create();
		//show
		ad.show();

		Toast toast = Toast.makeText(getApplicationContext(), "Testing",
				Toast.LENGTH_LONG);
		toast.show();

		WebRequest request = new WebRequest();
		String response = request.request(
				"http://10.0.2.2/Json/Timesheet.svc/Login",
				String.format("{\"loginInfo\":%s}",
						JsonSerializer.serialize(login)));

		try {
			Result result = JsonSerializer.deSerialize(Result.class, response);

			if (result != null && result.success) {

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

		// String serializedString;
		// try {
		// serializedString = JsonSerializer.serialize(login);
		// serializedString = serializedString.intern();
		// } catch (ClassNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}
	
	public class EmptyListener
	implements android.content.DialogInterface.OnClickListener {
	public void onClick(DialogInterface v, int buttonId)
	{
	}
	}
}

