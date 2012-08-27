/**
 * 
 */
package com.aditi.timesheet.serializer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Administrator
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Serialize {
	String name();

	boolean ignore() default false;
}
