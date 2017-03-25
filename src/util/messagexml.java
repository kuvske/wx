package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.*;
import pojo.textnaessage;
import com.thoughtworks.xstream.*;
import javax.servlet.http.HttpServletRequest;

public class messagexml {

	  public static Map<String,String> xmltomap(HttpServletRequest request) {
		  Map<String,String> map = new HashMap<String,String>();
		  SAXReader reader = new SAXReader();
		  InputStream ins;
		  Document doc;
		try {
			ins = request.getInputStream();
			  doc= reader.read(ins);
			  Element root = doc.getRootElement();
			  List<Element> list=  root.elements();
			  for(Element e:list){
				  map.put(e.getName(), e.getText());
			  }
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("=================================");
			e1.printStackTrace();
			System.out.println("=================================");
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			System.out.println("+++++++++++++++++++++++++++++++++++");
			e1.printStackTrace();
			System.out.println("+++++++++++++++++++++++++++++++++++++++");
		}
		  return map;
		 
	  }
	  
	  public static String textmessageTOxml(textnaessage str){
		XStream xr = new XStream();
		return xr.toXML(str);
	  }
	  
}
