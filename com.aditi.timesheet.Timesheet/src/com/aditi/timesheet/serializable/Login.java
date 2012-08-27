package com.aditi.timesheet.serializable;

import com.aditi.timesheet.serializer.Serialize;

@Serialize(name = "login")
public class Login {
	@Serialize(name = "userName")
	public String userName;

	@Serialize(name = "password")
	public String password;
}
