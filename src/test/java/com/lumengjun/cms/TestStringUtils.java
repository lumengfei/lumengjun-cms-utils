package com.lumengjun.cms;

import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.lumengjun.cms.utils.StringUtils;

/**
 * 
 * @author ASUS
 *
 */
public class TestStringUtils {

	
	
	
	
	
	@Test
	public void ssss(){
		int i=0xB0;
		System.out.println(i);
	}
	
	
	
	
	
	@Test
	public void testStringUtils(){
		boolean blank = StringUtils.isBlank("11");
		//验证是否为假
		Assert.assertTrue(blank==false);
		
	}
	
	@Test
	public void testStringUtils2(){
		boolean blank1 = StringUtils.isBlank("    ");
		//验证是否为真
		Assert.assertTrue(blank1==true);
	}
	
	@Test
	public void testisMobile(){
		String str="13512345678";
		boolean mobile = StringUtils.isMobile(str);
		Assert.assertTrue(mobile==true);
	}
	
	@Test
	public void testisMobile1(){
		String str="11512345678";
		boolean mobile = StringUtils.isMobile(str);
		Assert.assertTrue(mobile==false);
	}
	
	
	@Test 
	public  void testRandonStr(){
		String randonStr = StringUtils.getRandomStr(20);
		System.out.println(randonStr);
	}
	
	@Test 
	public  void testRandonStrNum(){
		String randonStr = StringUtils.getRandomStrNum(20);
		System.out.println(randonStr);
	}
	
	@Test
	public void testgetGb2312N() throws UnsupportedEncodingException{
		String gb2312n = StringUtils.getGb2312(20);
		System.out.println(gb2312n);
	}
	
	@Test
	public void testisEmail(){
		boolean email = StringUtils.isEmail("1232342@qqcom");
		System.out.println(email);
	}
	
}
