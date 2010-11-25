/**
 * 
 */
package com.xmhuanyu.eport.third.Util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



/**
 * @category Properties操作类
 * @author
 * 
 */
public class PropertieUtil {
	private static Properties prop=new Properties();
	
	public InputStream getInputStream(String fileName){
		return this.getClass().getResourceAsStream(fileName); 
	}

	public static Properties getPropertie(String fileName) {
			
		try {			
			//FileInputStream propFile = new FileInputStream(propURL.getFile());	
			InputStream in=PropertieUtil.class.getClassLoader().getResourceAsStream(fileName);
			prop.load(in);
			in.close();
			//propFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		} 
		return prop;
	}
	
	
}
