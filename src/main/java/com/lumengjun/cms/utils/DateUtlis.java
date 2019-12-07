package com.lumengjun.cms.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//关于日期
public class DateUtlis {

	/**
	 * 一天有多少毫秒
	 */
	static final int millsecondsPerDay=1000*60*60*24;
	
	/**
	 * 计算年龄
	 * @param birthday
	 * @return 返回年龄
	 */
	public static int getAge(Date birthday){
		Calendar calendar = Calendar.getInstance();
		//计算出生的年月日
		calendar.setTime(birthday);
		int i = calendar.get(Calendar.YEAR);//年
		int e = calendar.get(Calendar.MONTH);//月
		int c = calendar.get(Calendar.DATE);//日
		
		calendar.setTime(new Date());
		int i2 = calendar.get(Calendar.YEAR);//年
		int e2 = calendar.get(Calendar.MONTH);//月
		int c2 = calendar.get(Calendar.DATE);//日
		int age =i2-i;
		if(e2<e){
			age--;
		}else if(e2==e&&c2<c){
			age--;
		}
		return age;
	}
	
	
	
	
	
	
	/**
	 * 
	 * @param future
	 * @return
	 */
	public static int getRemainDays(Date future){
	 int age =(int) ((future.getTime() - new Date().getTime())/millsecondsPerDay);
		return age;
		
	}
	/**
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String format2 = format.format(date);
		String format3 = format.format(new Date());
		
		return format2.equals(format3);
		
	}
	/**
	 * 
	 * @return
	 */
	public static Date isBeginOfMonth(){
		//获取日历
		Calendar instance = Calendar.getInstance();
		//设置当前时间
		instance.setTime(new Date());
		instance.set(Calendar.SECOND, 0);
		instance.set(Calendar.MINUTE, 0);
		instance.set(Calendar.HOUR, 0);
		instance.set(Calendar.DATE, 1);
		instance.set(Calendar.AM_PM,Calendar.AM);
		return instance.getTime();
	}
	
	
	/**
	 * 获取当前月末
	 * @return
	 */
	public  static Date getEndOfMonth(){
		//获取日历
		Calendar instance = Calendar.getInstance();
		//设置当前时间
		instance.setTime(new Date());
		instance.add(Calendar.MONTH, 1);//月份加一
		
		
		instance.set(Calendar.SECOND, 0);
		instance.set(Calendar.MINUTE, 0);
		instance.set(Calendar.HOUR, 0);
		instance.set(Calendar.DATE, 1);
		instance.set(Calendar.AM_PM,Calendar.AM);
		//减去一秒
		instance.add(Calendar.SECOND, -1);//秒减一
		return instance.getTime();
	}
	
}
