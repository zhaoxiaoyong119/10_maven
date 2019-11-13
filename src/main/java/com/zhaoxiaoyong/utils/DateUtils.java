package com.zhaoxiaoyong.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期相关工具类
 * @author wanghd
 *
 */
public class DateUtils {
		// date 日期  Calendar 日历
		/*public static int getAge(Calendar birth) {
			//当前日期的年份
			Calendar now = formateDateToCalendar(new Date());
			int j = now.get(Calendar.YEAR);
			//生日年份
			int i = birth.get(Calendar.YEAR);
			return j - i;
		}
		*/
	
		/**
		 * 根据 Date    求年龄
		 * @param birth
		 * @return
		 */
		public static int getAge(Date birth) {
			//当前的年份
			Calendar now = formateDateToCalendar(new Date());
			int j = now.get(Calendar.YEAR);
			//生日年份
			Calendar calendar = formateDateToCalendar(birth);
			int i = calendar.get(Calendar.YEAR);
			return j - i;
		}
		
		/**
		 * 根据 日期字符串     求年龄
		 * @param birth
		 * @return
		 */
		public static int getAge(String birth) {
			//当前的年份
			Calendar now = formateDateToCalendar(new Date());
			int j = now.get(Calendar.YEAR);
			//生日年份
			Date date = formateStringToDate(birth);
			Calendar calendar = formateDateToCalendar(date);
			int i = calendar.get(Calendar.YEAR);
			return j - i;
		}
		
		/**
		 * 将Date 转换成Calender
		 * @param date
		 * @return
		 */
		public static Calendar formateDateToCalendar(Date date) {
			Calendar instance = Calendar.getInstance();
			instance.setTime(date);
			return instance;
		}
		
		/**
		 * 将String类型的日期转换成Date类型
		 * @param str
		 * @return
		 */
		public static Date formateStringToDate(String str) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try {
				 date = dateFormat.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return date;
		}
		
		/**
		 * 求当前时间到未来的天数
		 * @param future	未来日期  string类型  例如 :"2020-01-14"
		 * @return
		 */
		public static int getFutureDays(String future) {
			
			Date date = new Date();
			long time = date.getTime();
			
			Date formateStringToDate = formateStringToDate(future);
			long time2 = formateStringToDate.getTime();
			
			long dt = time2 - time ;
			
			int day = (int) (dt/1000/60/60/24);
			return day;
		}
		
		/**
		 * 求过去到今天天数
		 * @param future	未来日期  string类型  例如 :"2020-01-14"
		 * @return
		 */
		public static int getFutureDay(String future) {
			
			Date date = new Date();
			long time = date.getTime();
			
			Date formateStringToDate = formateStringToDate(future);
			long time2 = formateStringToDate.getTime();
			
			long dt = time - time2 ;
			
			int day = (int) (dt/1000/60/60/24);
			return day;
		}
		/**
		 * 判断给定日期是否是当天
		 * @param str
		 * @return
		 */
		public static boolean isToday(String str) {
			/*
			 * 获取日期的年 月 日
			 * Calendar instance = Calendar.getInstance();
			instance.setTime(new Date());
			instance.get(Calendar.YEAR);
			instance.get(Calendar.MONTH);
			instance.get(Calendar.DAY_OF_MONTH);*/
			
			int futureDays = getFutureDays(str);
			if(futureDays==0) {
				return true;
			}
			return false;
		}
		/**
		 * 判断当前给定的日期是否在本周之内
		 * @return
		 */
		public static boolean isDayInWeek(String date) {
			
			Calendar instance = Calendar.getInstance();
			instance.setTime(new Date());
			int year = instance.get(Calendar.YEAR);
			int month = instance.get(Calendar.MONTH);
			int dayOfWeek = instance.get(Calendar.DAY_OF_WEEK_IN_MONTH);
			
			Date stringToDate = formateStringToDate(date);
			Calendar dateToCalendar = formateDateToCalendar(stringToDate);
			int year1 = dateToCalendar.get(Calendar.YEAR);
			int month1 = dateToCalendar.get(Calendar.MONTH);
			int dayOfWeek1 = dateToCalendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
			
			if(year==year1&&month==month1&&dayOfWeek==dayOfWeek1) {
				return true;
			}
			return false;
		}
		
		/***
		 * 给定时间对象，初始化到该年初的1月1日0时0分0秒0毫秒
		 */
		public static void  setInitDate(String str) {
			Date stringToDate = formateStringToDate(str);
			Calendar dateToCalendar = formateDateToCalendar(stringToDate);
			dateToCalendar.set(Calendar.MONTH, 1);
			dateToCalendar.set(Calendar.DAY_OF_YEAR, 1);
			dateToCalendar.set(Calendar.HOUR, 0);
			dateToCalendar.set(Calendar.MINUTE, 0);
			dateToCalendar.set(Calendar.SECOND, 0);
			dateToCalendar.set(Calendar.MILLISECOND, 0);
			
			System.out.println(dateToCalendar.getTime());
			
		}
		
		
		/*public static void main(String[] args) {
			int futureDays = getFutureDays("2020-01-14");
			System.out.println(futureDays);
		}*/
		
		
		
		/***
		 * 获取本月的第一天
		 * 给定时间对象，初始化到该年初的1月1日0时0分0秒0毫秒
		 */
		public static String getMonthBegin(String specifiedDay) {
		    Date data = null;
		    try {
		        data = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		    Calendar c = Calendar.getInstance();
		    c.setTime(data);
		    //设置为1号,当前日期既为本月第一天
		    c.set(Calendar.DAY_OF_MONTH, 1);
		    //将小时至0
		    c.set(Calendar.HOUR_OF_DAY, 0);
		    //将分钟至0
		    c.set(Calendar.MINUTE, 0);
		    //将秒至0
		    c.set(Calendar.SECOND,0);
		    //将毫秒至0
		    c.set(Calendar.MILLISECOND, 0);
		    // 本月第一天的时间戳转换为字符串
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    Date date;
		    try {
		        date = sdf.parse(sdf.format(new Date(new Long(c.getTimeInMillis()))));
		        //Date date = sdf.parse(sdf.format(new Long(s)));// 等价于
		        return sdf.format(date);
		    } catch (NumberFormatException e) {
		        // TODO 自动生成的 catch 块
		        e.printStackTrace();
		    } catch (ParseException e) {
		        // TODO 自动生成的 catch 块
		        e.printStackTrace();
		    }
		    return null;
		}
		
		/***
		 * 获取本月的最后一天
		 * 给定时间对象，初始化到该年初的1月1日0时0分0秒0毫秒
		 */
		@SuppressWarnings("deprecation")
		public static String getMonthLastBegin(String specifiedDay) {
		    Date data = null;
		    try {
		        data = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		    Calendar c = Calendar.getInstance();
		    c.setTime(data);
		   
		    //设置为1号,当前日期既为本月第一天
		    c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		    //将小时至0
		    c.set(Calendar.HOUR_OF_DAY, 23);
		    //将分钟至0
		    c.set(Calendar.MINUTE, 59);
		    //将秒至0
		    c.set(Calendar.SECOND,59);
		    //将毫秒至0
		    c.set(Calendar.MILLISECOND, 59);
		    // 本月第一天的时间戳转换为字符串
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    Date date;
		    try {
		        date = sdf.parse(sdf.format(new Date(new Long(c.getTimeInMillis()))));
		        //Date date = sdf.parse(sdf.format(new Long(s)));// 等价于
		        return sdf.format(date);
		    } catch (NumberFormatException e) {
		        // TODO 自动生成的 catch 块
		        e.printStackTrace();
		    } catch (ParseException e) {
		        // TODO 自动生成的 catch 块
		        e.printStackTrace();
		    }
		    return null;
		}

		
		
		
		
		
		
		
		
		
		
		
		
}
