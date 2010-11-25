package com.xmhuanyu.eport.third.Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	/**
	 * 获取当前时间日期的字符串
	 */
	public static String getCurrentDateStr(DateFormatType dateFormatType) {
		Date date = getCurrentDate();
		return (String) OpearationDate(date, dateFormatType.getValue());
	}

	/**
	 * 时间、日期格式化成字符串
	 */
	public static String formatDate(Date date, DateFormatType dateFormatType) {
		return (String) OpearationDate(date, dateFormatType.getValue());
	}

	/**
	 * 从字符串解析成时间、日期
	 */
	public static Date parseDate(String dateStr, DateFormatType dateFormatType) {
		return (Date) OpearationDate(dateStr, dateFormatType.getValue());
	}

	/**
	 * 获取当前系统时间(原始格式)
	 */
	public static Date getCurrentDate() {
		Date date = new Date(System.currentTimeMillis());
		return date;
	}

	/**
	 * 获取当前日期的年、月、日、时、分、秒
	 */
	public static int getCurrentTime(TimeFormatType timeFormatType) {
		return getTime(getCurrentDate(), timeFormatType);
	}

	/**
	 * 获取指定日期的年、月、日、时、分、秒
	 */
	public static int getTime(Date date, TimeFormatType timeFormatType) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			int type = timeFormatType.getValue();
			int i = c.get(type);
			return type == 2 ? i + 1 : i;
		} catch (Exception e) {
			throw new RuntimeException("获取失败", e);
		}
	}

	/**
	 * 获取指定日期的毫秒数
	 */
	public static long getMillis(Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	/**
	 * 日期相加、减操作
	 * 
	 * 所返回结果单位为:天数
	 */
	public static int operationDate(Date date, Date diffDate,
			DateOperationType dateOperationType) {
		long add = getMillis(date) + getMillis(diffDate);
		long diff = getMillis(date) - getMillis(diffDate);
		return (int) ((dateOperationType.getValue() ? add : diff) / (24 * 3600 * 1000));
	}

	/**
	 * 日期月份相加、减操作
	 */
	public static Date operationDateOfMonth(Date date, int month,
			DateOperationType dateOperationType) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, dateOperationType.getValue() ? month : month
				- (month * 2));
		return c.getTime();
	}

	/**
	 * 日期天数相加、减操作
	 */
	public static Date operationDateOfDay(Date date, int day,
			DateOperationType dateOperationType) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		long millis = c.getTimeInMillis();
		long millisOfday = day * 24 * 3600 * 1000;
		long sumMillis = dateOperationType.getValue() ? (millis + millisOfday)
				: (millis - millisOfday);
		c.setTimeInMillis(sumMillis);
		return c.getTime();
	}

	private static Object OpearationDate(Object object, String formatStr) {
		if (object == null || null == formatStr || "".equals(formatStr)) {
			throw new RuntimeException("参数不能为空");
		}
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		try {
			if (object instanceof Date)
				return format.format(object);
			else
				return format.parse(object.toString());
		} catch (Exception e) {
			throw new RuntimeException("操作失败", e);
		}

	}

	public enum DateOperationType {

		/**
		 * 加操作
		 */
		ADD(true),

		/**
		 * 减操作
		 */
		DIFF(false);

		private final boolean value;

		DateOperationType(boolean operation) {
			this.value = operation;
		}

		public boolean getValue() {
			return value;
		}
	}

	public enum TimeFormatType {

		YEAR(1), MONTH(2), DAY(5), HOUR(11), MINUTE(12), SECOND(13);
		private final int value;

		TimeFormatType(int formatStr) {
			this.value = formatStr;
		}

		public int getValue() {
			return value;
		}
	}

	public enum DateFormatType {
		/**
		 * 格式为：yyyy-MM-dd HH:mm:ss
		 */
		DATE_FORMAT_STR("yyyy-MM-dd HH:mm:ss"),
		/**
		 * 格式为：yyyyMMddHHmmss
		 */
		SIMPLE_DATE_TIME_FORMAT_STR("yyyyMMddHHmmss"),

		/**
		 * 格式为：yyyy-MM-dd
		 */
		SIMPLE_DATE_FORMAT_STR("yyyy-MM-dd"),

		/**
		 * 格式为：yyyy/MM/dd
		 */
		SIMPLE_DATE_FORMAT_VIRGULE_STR("yyyy/MM/dd"),

		/**
		 * 格式为：HH:mm:ss
		 */
		HOUR_MINUTE_SECOND("HH:mm:ss"),

		/**
		 * 格式为：HH:mm
		 */
		HOUR_MINUTE("HH:mm");

		private final String value;

		DateFormatType(String formatStr) {
			this.value = formatStr;
		}

		public String getValue() {
			return value;
		}
	}
}
