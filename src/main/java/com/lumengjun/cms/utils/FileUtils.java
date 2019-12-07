package com.lumengjun.cms.utils;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class FileUtils {

	
	public void ss(){
		new HashMap();
	}
	
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getSuffixName(String fileName){
		int indexOf = fileName.lastIndexOf(".");
		if(indexOf<0){
			return "";
		}
		String suffixName = fileName.substring(indexOf);
		
		return suffixName;
	}
	/**
	 * 
	 * @param fileName
	 */
	public static void delFile(String fileName){
		File file =new File(fileName);
		if(!file.exists()){
			return ;
		}
		if(file.isDirectory()){
			String[] list = file.list();
			for (int i = 0; i < list.length; i++) {
				String childFileName = fileName+"\\"+list[i];
				delFile(childFileName);
			}
		}
		file.delete();
		
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public static String getProperty(String key){
		Properties properties = System.getProperties();
//		ArrayList arrayList = new ArrayList();
//		arrayList.forEach(x->{System.out.println(x);});
//		Set<Object> keySet = properties.keySet();
//		for (Object hkey : keySet) {
//			System.out.println("hkey is "+hkey);
//			System.out.println("hValue is "+properties.getProperty((String)hkey));
//		}
		
		return properties.getProperty(key);
		
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public static String getEnv(String key){
		Map<String, String> getenv = System.getenv();
//		getenv.forEach((hkey,hvalue)->{System.out.println("key is"+hkey);
//			System.out.println("hvalue is "+hvalue);
//		});
		return getenv.get(key);
	}
	
	/**
	 * 获取文件的大小
	 * @param fileName
	 * @return
	 */
	public static long getSize(String fileName){
		File file = new File(fileName);
		long last = file.lastModified();
		if(!file.exists()||!file.isFile()){
			return 0;
		}
		return file.length();
	}
	/**
	 * 
	 * @param src
	 * @param dst
	 * @return
	 */
	public static void comparePath(String src,String dst){
		File file1 = new File(src);
		File file2 = new File(dst);
		if(!file1.exists()){
			System.err.println("  源文件 不存在 "+src);
			return ;
		}
		if(!file2.exists()){
			System.err.println("  目标文件 不存在 "+dst);
			return ;
		}
		if(file1.isFile()&&file2.isFile()){
			if(file1.length() !=file2.length()){
			System.err.println("文件不一致"+src);
			}else{
				
			}
			return;
		}
		if(file1.isDirectory()){
			//递归，便历
			String[] list = file1.list();
			for (int i = 0; i < list.length; i++) {
				String childfile1 =src+"\\"+list[i];
				String childfile2 =dst+"\\"+list[i];
				comparePath(childfile1,childfile2);
			}
		}
	}
	
	
	
	/**
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static List<String> getListString(String fileName) throws IOException{
//		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<String>();
		
		FileInputStream file = new FileInputStream(fileName);
		InputStreamReader fr = new InputStreamReader(file,"GBK");
		BufferedReader br = new BufferedReader(fr);
		String ln =null;
		while((ln=br.readLine())!=null){
			list.add(ln);
		}
		br.close();
		fr.close();
		return list;
		
	}
	
	
	
	public static void copy(String srcFileName,String dstFileName) throws IOException{
		File srcfile = new File(srcFileName);
		File dstfile = new File(dstFileName);
		FileInputStream fis = new FileInputStream(srcfile);
		FileOutputStream fos = new FileOutputStream(dstfile);
		byte[] by=new  byte[1024];
		while(fis.read(by)!=-1){
			fos.write(by);
		}
		fos.close();
		fis.close();
	}
	
}
