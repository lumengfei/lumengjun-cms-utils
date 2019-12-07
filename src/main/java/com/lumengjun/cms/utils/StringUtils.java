package com.lumengjun.cms.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	
	static char charArray[]=new char[36];
	
	static {
		for (int j = 0; j < 10; j++) {
			charArray[j]=(char)('0'+j);	
		}
		for (int j = 0; j < 26; j++) {
			charArray[j+10]=(char)('A'+j);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 判断一个字符串是否为空，空字符串也为空
	 * @param srt
	 * @return 为空返回true 否则返回false
	 */
	public static boolean isBlank(String str){
		
		return null==str||"".equals(str.trim());
	}
	
	
	/**
	 * 判断一个字符串是否有值
	 * @param str 
	 * @return 非空返回true 空字符串或空返回false
	 */
	public static boolean havaValue(String str){
		return null!=str&&!"".equals(str.trim());
	}
	
	
	public static boolean isMobile(String str){
		String regex = "^(135|136|138)\\d{8}$";
		Pattern compile = Pattern.compile(regex);
		Matcher matcher = compile.matcher(str);
		return matcher.matches();
	}
	
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	public static String getRandonStr(int n){
		Random random = new Random();
		/**
		 * StringBuilder 线程不安全  但是执行效率高
		 * StringBuffer 线程安全  但是执行效率低
		 */
		StringBuilder sb =new StringBuilder();
		for (int i = 0; i < n; i++) {
			char randomChar= (char) ('A'+random.nextInt(26));
			sb.append(randomChar);
		}
		return sb.toString();
	}
	
	
	
	
	
	public static String getrandomStrNum(int i){
		//char charArray[]={'0','1'..}
		
		StringBuilder sb =new StringBuilder();
		for (int j = 0; j < i; j++) {
			Random rr =new Random();
			int nextInt = rr.nextInt(36);
			sb.append(charArray[nextInt]);
		}
		return sb.toString();
	}
	
	
	
	
	
	private static String getGb2312() throws UnsupportedEncodingException{
		byte word[] = new byte[2];
		Random random = new Random();
		word[0] =(byte)(0xB0+ random.nextInt(39));
		word[1] =(byte)(0xA1 + random.nextInt(93));
		 
		return new String(word,"gb2312");
	}
	
	public static String getGb2312N(int n) throws UnsupportedEncodingException{
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(getGb2312());
		}
		return sb.toString();
	}
	
}
