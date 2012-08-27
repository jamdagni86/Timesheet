package com.aditi.timesheet.serializer;

import java.lang.reflect.Field;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonSerializer {
	public static <T> String serialize(T object) {

		StringBuilder builder = new StringBuilder("{");

		Class<? extends Object> classObject = object.getClass();
		// Serialize classAttribute = Class.forName(classObject.getName())
		// .getAnnotation(Serialize.class);
		//
		// if (classAttribute != null) {
		//
		// builder.append(String.format("\"%s\": {", classAttribute.name()));

		Field[] fields = classObject.getFields();

		if (fields != null && fields.length > 0) {
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];

				Serialize serialize = field.getAnnotation(Serialize.class);
				if (serialize != null) {
					try {
						builder.append(String.format("\"%s\": \"%s\"%s",
								serialize.name(), field.get(object).toString(),
								i == fields.length - 1 ? "" : ","));
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			builder.append("}");
		}
		// builder.append("}");
		return builder.toString();
		// } else {
		// return "";
		// }
	}

	public static <T> T deSerialize(Class<T> type, String object)
			throws JSONException, InstantiationException,
			IllegalAccessException {
		JSONObject jsonObject = new JSONObject(object);

		T variable = type.newInstance();
		Field[] fields = type.getFields();

		for (Field field : fields) {
			Serialize serialize = field.getAnnotation(Serialize.class);
			String fieldName = null;
			try {

				if (serialize == null) {
					// No annotations added for this field. try to get the value
					// from JSON by field name
					fieldName = field.getName();
				} else {
					// Get the annotation
					fieldName = serialize.name();
				}

				field.set(variable, jsonObject.get(fieldName));

			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		return variable;
	}
}
