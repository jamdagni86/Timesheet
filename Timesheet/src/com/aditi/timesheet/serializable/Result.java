package com.aditi.timesheet.serializable;

import com.aditi.timesheet.serializer.Serialize;

public class Result {
	@Serialize(name = "success")
	public boolean success;

	@Serialize(name = "data")
	public Object data;

	@Serialize(name = "errorMessage")
	public String errorMessage;
}