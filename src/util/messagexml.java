package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.*;
import pojo.textnaessage;
import com.thoughtworks.xstream.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

public class messagexml {

	  public static Map<String,String> xmltomap(HttpServletRequest request) throws IOException {
		  System.out.println("00000000000000000000000");
		  Map<String,String> map = new HashMap<String,String>();
		  ServletInputStream ins;
		  Document doc;
		try {
			System.out.println("1=================================1");
			 ins = request.getInputStream();
			 System.out.println("2=================================2");
			 SAXReader reader = new SAXReader();
			 doc= reader.read(ins);
			  Element root = doc.getRootElement();
			  List<Element> list=  root.elements();
			  for(Element e:list){
				  map.put(e.getName(), e.getText());
			  }
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
			System.out.println("=================================");
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			System.out.println("+++++++++++++++++++++++++++++++++++");
			e1.printStackTrace();
			System.out.println("+++++++++++++++++++++++++++++++++++++++");
		}finally{
			
			ins = null;
		}
		  return map;
		 
	  }
	  
	  public static String textmessageTOxml(textnaessage str){
		XStream xr = new XStream();
		return xr.toXML(str);
	  }
	  
}
