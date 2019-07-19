package com.qihoo.dmp.southernAirlines.utils;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 日期工具类 DateUtils
 * 
 */
public class DateUtils extends org.apache.commons.lang.time.DateUtils {
	/**
	 * yyyyMMdd
	 */
	public static final String DateFormat1 = "yyyyMMdd";
	/**
	 * yyyy-MM-dd
	 */
	public static final String DateFormat2 = "yyyy-MM-dd";
	/**
	 * yyyyMMdd hh:mm:ss
	 */
	public static final String DateFormat3 = "yyyyMMdd HH:mm:ss";
	/**
	 * yyyy-MM-dd hh:mm:ss
	 */
	public static final String DateFormat4 = "yyyy-MM-dd HH:mm:ss";
	/**
	 * yyMMdd
	 */
	public static final String DateFormat5 = "yyMMdd";
	
	/**
	 * yyyyMMddhhmmss
	 */
	public static final String DateFormat6 = "yyyyMMddHHmmss";
	/**
	 * EEE MMM dd HH:mm:ss zzz yyyy
	 */
	public static final String DateFormat7 = "EEE MMM dd HH:mm:ss zzz yyyy";
	/**
	 * HH:mm:ss
	 */
	public static final String DateFormat8 = "HH:mm:ss";
	
	public static final String DateFormat9 = "yyyy-MM-dd HH:mm";

	public final static int MONDAY = 1;

	public final static int TUESDAY = 2;

	public final static int WEDNESDAY = 3;

	public final static int THURSDAY = 4;

	public final static int FRIDAY = 5;

	public final static int SATURDAY = 6;

	public final static int SUNDAY = 7;

	public static long getTimestampFromStr(String timestr) {
		try {
			Date date = new SimpleDateFormat(DateFormat2).parse(timestr);
			return date.getTime()/1000;
		} catch (ParseException e) {
			try {
				if(timestr.length() == 8){
					Date date = new SimpleDateFormat(DateFormat1).parse(timestr);
					return date.getTime()/1000; 
				} else if (timestr.length() == 13) {
					try{
						return Long.parseLong(timestr) / 1000;
					}catch(Exception e2){
						return 0;
					}
				} else{ 
					try{
						return Long.parseLong(timestr);
					}catch(Exception e2){
						return 0;
					}
				}
			} catch (ParseException e1) {
				return 0;
			}
		}
	}
	
	public static String today() {
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat(DateFormat2);
		return sf.format(date);
	}
	public static String now() {
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat(DateFormat6);
		return sf.format(date);
	}
	/**
	 * 时间差[by day] 1st 较早时间 2st 较晚时间
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static long calendarDayPlus(Date d1, Date d2) {
		long milis = calendarMilisPlus(d1, d2);
		milis = milis / 1000 / 60 / 60 / 24;
		return milis;
	}

	/**
	 * 时间差[by hour] 1st 较早时间 2st 较晚时间
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static long calendarHourPlus(Date d1, Date d2) {
		long milis = calendarMilisPlus(d1, d2);
		milis = milis / 1000 / 60 / 60;
		return milis;
	}

	/**
	 * 时间差[by minute] 1st 较早时间 2st 较晚时间
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static long calendarMinutePlus(Date d1, Date d2) {
		long milis = calendarMilisPlus(d1, d2);
		milis = milis / 1000 / 60;
		return milis;
	}

	/**
	 * 时间差[by second] 1st 较早时间 2st 较晚时间
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static long calendarSecondPlus(Date d1, Date d2) {
		long milis = calendarMilisPlus(d1, d2);
		milis = milis / 1000;
		return milis;
	}

	/**
	 * 1st 较早时间 2st 较晚时间
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static long calendarMilisPlus(Date d1, Date d2) {
		return d2.getTime() - d1.getTime();
	}

	/**
	 * 时间差[by day] 1st 较早时间 2st 较晚时间
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static long calendarDayPlus(Calendar d1, Calendar d2) {
		long milis = calendarMilisPlus(d1, d2);
		milis = milis / 1000 / 60 / 60 / 24;
		return milis;
	}

	/**
	 * 时间差[by hour] 1st 较早时间 2st 较晚时间
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static long calendarHourPlus(Calendar d1, Calendar d2) {
		long milis = calendarMilisPlus(d1, d2);
		milis = milis / 1000 / 60 / 60;
		return milis;
	}

	/**
	 * 时间差[by minute] 1st 较早时间 2st 较晚时间
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static long calendarMinutePlus(Calendar d1, Calendar d2) {
		long milis = calendarMilisPlus(d1, d2);
		milis = milis / 1000 / 60;
		return milis;
	}

	/**
	 * 时间差[by second] 1st 较早时间 2st 较晚时间
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static long calendarSecondPlus(Calendar d1, Calendar d2) {
		long milis = calendarMilisPlus(d1, d2);
		milis = milis / 1000;
		return milis;
	}

	public static long calendarMilisPlus(Calendar d1, Calendar d2) {
		return d2.getTime().getTime() - d1.getTime().getTime();
	}

	/**
	 * 把字符串格式转化为日期格式
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date convertStringToDate(String date, String format,
			Locale locale) {
		SimpleDateFormat sf = (locale == null) ? new SimpleDateFormat(format)
				: new SimpleDateFormat(format, locale);
		ParsePosition parsePosition = new ParsePosition(0);
		parsePosition.setIndex(0);
		return sf.parse(date, parsePosition);
	}

	public static Date convertStringToDate(String date, String format) {
		SimpleDateFormat sf = new SimpleDateFormat(format);
		ParsePosition parsePosition = new ParsePosition(0);
		parsePosition.setIndex(0);
		return sf.parse(date, parsePosition);
	}
	public static Date convertStringToDate(String date) {
		if(date == null || "".equals(date)) {
			return null;
		}
		SimpleDateFormat sf = new SimpleDateFormat(DateFormat4);
		ParsePosition parsePosition = new ParsePosition(0);
		parsePosition.setIndex(0);
		return sf.parse(date, parsePosition);
	}
	public static Date convertStringToDate1(String date) {
		if(date == null || "".equals(date)) {
			return null;
		}
		SimpleDateFormat sf = new SimpleDateFormat(DateFormat2);
		ParsePosition parsePosition = new ParsePosition(0);
		parsePosition.setIndex(0);
		return sf.parse(date, parsePosition);
	}

	/**
	 * 将日期格式转化成字符串格式
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String convertDateToString(Date date, String format) {
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.format(date);
	}
	public static String convertDateToString(Date date) {
		SimpleDateFormat sf = new SimpleDateFormat(DateFormat4);
		if(date != null){
			return sf.format(date);
		}else{
			return null;
		}
	}
	/**
	 * 将日期格式转化成字符串格式
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String convertDateToString(Date date, String format,
			Locale locale) {
		SimpleDateFormat sf = (locale == null) ? new SimpleDateFormat(format)
				: new SimpleDateFormat(format, locale);
		ParsePosition parsePosition = new ParsePosition(0);
		parsePosition.setIndex(0);
		return sf.format(date);
	}

	/**
	 * 以天为单位+/-日期
	 * 
	 * @param date
	 * @param cnt
	 * @return
	 */
	public static Date addDay(Date date, int cnt) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.add(GregorianCalendar.DAY_OF_YEAR, cnt);
		return gc.getTime();
	}

	/**
	 * 以月为单位+/-日期
	 * 
	 * @param date
	 * @param cnt
	 * @return
	 */
	public static Date addMonth(Date date, int cnt) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.add(GregorianCalendar.MONTH, cnt);
		return gc.getTime();
	}

	/**
	 * 以年为单位+/-日期
	 * 
	 * @param date
	 * @param cnt
	 * @return
	 */
	public static Date addYear(Date date, int cnt) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.add(GregorianCalendar.YEAR, cnt);
		return gc.getTime();
	}

	/**
	 * 算出传入的日期是周几
	 * 
	 * @param date
	 * @return
	 */
	public static int getWeek(Date date) {
		GregorianCalendar gc = new GregorianCalendar(Locale.CHINESE);
		gc.setTime(date);
		return gc.get(GregorianCalendar.DAY_OF_WEEK) - 1;
	}

	public static String convertformatStr(String date, String format,
			String target) {
		Date d = convertStringToDate(date, format);
		return convertDateToString(d, target);
	}

	/**
	 * 判断传入的日期是不是周末
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isWeekEnd(Date date) {
		if (getWeek(date) == SATURDAY || getWeek(date) == SUNDAY) {
			return true;
		}
		return false;
	}

	/**
	 * 获得每月第1天
	 * 
	 * @param date
	 * @return
	 */

	public static Date getFirstDayofMonth(Date date) {
		GregorianCalendar gc = new GregorianCalendar(Locale.CHINESE);
		gc.setTime(date);
		int day = gc.get(GregorianCalendar.DATE);
		gc.add(GregorianCalendar.DAY_OF_YEAR, -day + 1);
		return gc.getTime();
	}

	/**
	 * 获得每月最后一天
	 * 
	 * @param date
	 * @return
	 */

	public static Date getEndDayofMonth(int month) {
		String str = "";   
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");       
		Calendar lastDate = Calendar.getInstance();   
		lastDate.add(Calendar.MONTH, month);
		lastDate.set(Calendar.DATE,1);//设为当前月的1号   
		lastDate.add(Calendar.DATE,-1);//设为当前月的1号   
		lastDate.set(Calendar.HOUR_OF_DAY, 23);
		lastDate.set(Calendar.MINUTE, 59);
		lastDate.set(Calendar.SECOND, 59);
		str = sdf.format(lastDate.getTime());   
		return convertStringToDate(str);    
	}
	/**
	 * 取得0点时间
	 * getZeroTime(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param date
	 * @return   
	 * Date  
	 * @exception   
	 * @since  1.0.0
	 */
	public static Date getZeroTime(Date date) {
		return DateUtils.setSeconds(setMinutes(setHours(date, 0), 0), 0);
	}
	/**
	 * 后一个月的第一天
	* @Title: getFirstDayOfMonth   
	* @Description: 
	* @return
	* @return String 
	* @see DateUtils.java
	 */
	public static Date getFirstDayOfMonth(int month, int minute, int second){     
		String str = "";   
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");       
		Calendar lastDate = Calendar.getInstance();   
		lastDate.set(Calendar.DATE,1);//设为当前月的1号   
		lastDate.add(Calendar.MONTH, month);
		lastDate.set(Calendar.HOUR_OF_DAY, 0);
		lastDate.set(Calendar.MINUTE, minute);
		lastDate.set(Calendar.SECOND, second);
		str = sdf.format(lastDate.getTime());   
		return convertStringToDate(str);     
	} 
	/**
	 * 保护日期
	* @Title: getProtectionTime   
	* @Description: 
	* @return
	* @return Date 
	* @see DateUtils.java
	 */
	public static Date getProtectionTime() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 20);  // 设为当前月的1号
		lastDate.set(Calendar.HOUR_OF_DAY, 23);
		lastDate.set(Calendar.MINUTE, 59);
		lastDate.set(Calendar.SECOND, 59);
		str = sdf.format(lastDate.getTime());
		return convertStringToDate(str);
	}
	
	public static Date getServerTime(int cycle) {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.YEAR,lastDate.get(Calendar.YEAR) + cycle);
		lastDate.set(Calendar.DATE, lastDate.get(Calendar.DATE) - 1);
		lastDate.set(Calendar.HOUR_OF_DAY, 23);
		lastDate.set(Calendar.MINUTE, 59);
		lastDate.set(Calendar.SECOND, 59);
		str = sdf.format(lastDate.getTime());
		return convertStringToDate(str);
	}
	/**
	 * 获取第二天的时间
	* @Title: getFirstDayOfDay   
	* @Description: 
	* @param date
	* @return
	* @return String 
	* @see DateUtils.java
	 */
	public static String getFirstDayOfDay(Date date) {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		GregorianCalendar gc = new GregorianCalendar(Locale.CHINESE);
		Calendar lastDate = Calendar.getInstance();
		gc.setTime(date);
		lastDate.set(Calendar.DATE, gc.get(GregorianCalendar.DATE)+1);  // 设为当前月的1号
		lastDate.set(Calendar.HOUR_OF_DAY, 0);
		lastDate.set(Calendar.MINUTE, 0);
		lastDate.set(Calendar.SECOND, 1);
		str = sdf.format(lastDate.getTime());
		return str;
	}
	
	/**
	* @Title: getBetweenDate   
	* @Description: 获取一个时间段中的所有日期列表
	* @param startTime
	* @param endTime
	* @return List<String> 
	* @see DateUtils.java
	 */
	public static List<String>  getBetweenDate(String startTime,String endTime) {
		List<String> list = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar gc1 = new GregorianCalendar(), gc2 = new GregorianCalendar();
        try {
			gc1.setTime(sdf.parse(startTime));
			gc2.setTime(sdf.parse(endTime));  
		} catch (ParseException e) {
			e.printStackTrace();
		}
        while(!gc1.after(gc2)){
        	GregorianCalendar gc3=(GregorianCalendar)gc1.clone();  
        	list.add(convertDateToString(gc3.getTime(),DateFormat2));  
        	gc1.add(Calendar.DAY_OF_MONTH, 1);   
        }
        return list;
		
	}
	/**
	* @Title: getGMTdate   
	* @Description: 时区转换
	* @param dateTime 日期 20130744 00:00:00
	* @param gmt 设置当前时区  "GMT-5" 
	* @return String  默认转换为GTM+8
	* @see DateUtils.java
	 */
	public static  String getGMTdate(String dateTime,String gmt){
		 //String startDateStr = "20130722 00:00:00";
		  Calendar gmtlocal = new GregorianCalendar(TimeZone.getTimeZone(gmt));
		  gmtlocal.set(Calendar.YEAR, Integer.valueOf(dateTime.split(" ")[0].substring(0,4)));
		  gmtlocal.set(Calendar.MONTH,Integer.valueOf(dateTime.split(" ")[0].substring(4,6))-1);
		  gmtlocal.set(Calendar.DAY_OF_MONTH, Integer.valueOf(dateTime.split(" ")[0].substring(6,8)));
		  gmtlocal.set(Calendar.HOUR_OF_DAY, Integer.valueOf(dateTime.split(" ")[1].split(":")[0]));
		  gmtlocal.set(Calendar.MINUTE, Integer.valueOf(dateTime.split(" ")[1].split(":")[1]));
		  gmtlocal.set(Calendar.SECOND, Integer.valueOf(dateTime.split(" ")[1].split(":")[2]));
		  SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  sf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		  return sf.format(gmtlocal.getTime());
	}
	public static void main(String[] args) {
		// 获取Calendar
//		Calendar calendar = Calendar.getInstance();
//		// 设置Calendar月份数为下一个月
//		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
//		// 设置Calendar日期为下一个月一号
//		calendar.set(Calendar.DATE, 1);
//		// 设置Calendar日期减一,为本月末
//		calendar.add(Calendar.DATE, -1);
//		// 打印
//		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");       
//		Calendar lastDate = Calendar.getInstance();   
//		lastDate.add(Calendar.MONTH, 1);
//		lastDate.set(Calendar.DATE,1);//设为当前月的1号   
//		lastDate.add(Calendar.DATE,-1);//设为当前月的1号   
//		lastDate.set(Calendar.HOUR_OF_DAY, 23);
//		lastDate.set(Calendar.MINUTE, 59);
//		lastDate.set(Calendar.SECOND, 59);
//		String str = sdf.format(lastDate.getTime());  
//		Date date = getServerTime(2);
		System.out.println(today());
		System.out.println(addDay(new Date(), -1));
		System.out.println(convertDateToString(addDay(new Date(), -1), DateUtils.DateFormat2));
		System.out.println(getWeek(DateUtils.convertStringToDate("20170820", "yyyyMMdd")));
		
		System.out.println(getTimestampFromStr("1234657980"));
	
	}
}
