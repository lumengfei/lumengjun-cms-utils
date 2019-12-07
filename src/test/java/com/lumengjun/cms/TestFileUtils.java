package com.lumengjun.cms;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.lumengjun.cms.utils.FileUtils;
/**
 * 测试文件的工具类
 * @author ASUS
 *
 */
public class TestFileUtils {

	@Test
	public void ssss(){
		int i =2&150;
		System.out.println(i);
	}
	
	
	@Test
	public void testGteSuffixName(){
		String suffixName = FileUtils.getSuffixName("sfgegwd.jop");
		System.out.println(suffixName);
	}
	
	@Test
	public void testDelFile(){
		FileUtils.delFile("C:\\Users\\ASUS\\Desktop/ssm_yuekao_img");
	}
	@Test
	public void testGetProperty(){
		FileUtils.getProperty("");
	}
	
	@Test
	public void testGetEnv(){
		String env = FileUtils.getEnv("java_home");
		System.out.println(env);
	}
	
	
	@Test
	public void testGetFileName() throws IOException{
		List<String> listString = FileUtils.getListString("C:\\Users\\ASUS\\Desktop/hj.txt.txt");
		for (String string : listString) {
			System.out.println(string);
		}
	}
	
	
	@Test
	public void testcopy(){
		
	}
	
	
}
