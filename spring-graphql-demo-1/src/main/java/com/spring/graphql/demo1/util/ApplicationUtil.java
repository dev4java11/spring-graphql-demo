package com.spring.graphql.demo1.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.spring.graphql.demo1.model.MDate;

public class ApplicationUtil {
	
	public static final String FORMAT_DATE = "dd/MM/yyyy";
	public static final String FORMAT_TIME = "HH:mm:ss";
	public static final String FORMAT_DATE_TIME = FORMAT_DATE + " " + FORMAT_TIME;
	
	public static final DateTimeFormatter formatter_date = DateTimeFormat.forPattern(FORMAT_DATE);
	public static final DateTimeFormatter formatter_time = DateTimeFormat.forPattern(FORMAT_TIME);
	public static final DateTimeFormatter formatter_date_time = DateTimeFormat.forPattern(FORMAT_DATE_TIME);
	
	public static String generateRandomUUID(){
		return UUID.randomUUID().toString();
	}

	public static <T> List<T> getNewArrayList(){
		return new ArrayList<T>();
	}
	
	public static DateTime transformToDateTime(Date date){
		DateTime dt = new DateTime(date);
		return dt;
	}
	
	public static MDate buildMDate(Date date, String format){
		DateTimeFormatter formatter = DateTimeFormat.forPattern(format);
		DateTime dt = transformToDateTime(date);
		MDate model = new MDate();
		model.setValue(formatter.print(dt));
		model.setFormat(format);
		return model;
	}
	
	public static MDate buildMDateWithFormatDate(Date date){
		DateTime dt = transformToDateTime(date);
		MDate model = new MDate();
		model.setValue(formatter_date.print(dt));
		model.setFormat(FORMAT_DATE);
		return model;
	}
	
	public static MDate buildMDateWithFormatTime(Date date){
		DateTime dt = transformToDateTime(date);
		MDate model = new MDate();
		model.setValue(formatter_time.print(dt));
		model.setFormat(FORMAT_TIME);
		return model;
	}
	
	public static MDate buildMDateWithFormatDateTime(Date date){
		DateTime dt = transformToDateTime(date);
		MDate model = new MDate();
		model.setValue(formatter_date_time.print(dt));
		model.setFormat(FORMAT_DATE_TIME);
		return model;
	}
	
	public static Date buildDateFromMDate(MDate model){
		DateTimeFormatter formatter = DateTimeFormat.forPattern(model.getFormat());
		DateTime dt = formatter.parseDateTime(model.getFormat());
		Date date = dt.toDate();
		return date;
	}
}
