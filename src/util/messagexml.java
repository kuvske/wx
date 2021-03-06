package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.*;

import pojo.News;
import pojo.NewsMessage;
import pojo.textnaessage;
import com.thoughtworks.xstream.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

public class messagexml {

	//读取xml转换为MAP
	  public static Map<String,String> xmltomap(HttpServletRequest request) throws IOException {
		  
		  Map<String,String> map = new HashMap<String,String>();
		  ServletInputStream ins;
		  Document doc;
		try {
		
			 ins = request.getInputStream();
		
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
	  //将文本消息转换为XML
	  public static String textmessageTOxml(textnaessage str){
		XStream xr = new XStream();
		xr.alias("xml", str.getClass());
		return xr.toXML(str);
	  }
	  
	  /**	图文消息转换为XML                                              */
	  public static String newsmessageTOxml(NewsMessage newsmessage){
			XStream xr = new XStream();
			xr.alias("xml", newsmessage.getClass());
			xr.alias("item", new News().getClass());
			return xr.toXML(newsmessage);
		  }
	  
}
