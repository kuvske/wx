package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import pojo.*;
import pojo.textnaessage;

public class InitMessage {
       public static String gethelpmessage(Map<String ,String> mp){
    	   String fromusername = mp.get("FromUserName");
   		String tousername = mp.get("ToUserName");
   		String msgtype ="text";
   		String content = "1、查看图文消息\\n    2、说什么是什么";
   		textnaessage tx = new textnaessage();
		messagexml mx = new messagexml();
		tx.setContent(content);
		tx.setCreateTime(new Date().toString());
		tx.setFromUserName(tousername);
		tx.setToUserName(fromusername);
		tx.setMsgType(msgtype);
		return   mx.textmessageTOxml(tx);		  
       }
	   public static String gettextmessage(Map<String ,String> mp){
		String fromusername = mp.get("FromUserName");
		String tousername = mp.get("ToUserName");
		String msgtype = mp.get("MsgType");
		String content = mp.get("Content");
		textnaessage tx = new textnaessage();
		messagexml mx = new messagexml();
		tx.setContent("你说的是:"+content);
		tx.setCreateTime(new Date().toString());
		tx.setFromUserName(tousername);
		tx.setToUserName(fromusername);
		tx.setMsgType(msgtype);
		return   mx.textmessageTOxml(tx);		  
	   }
	   
	   public static String getnewsmessage (Map<String ,String> mp){
		   String fromusername = mp.get("FromUserName");
			String tousername = mp.get("ToUserName");
			List<News> newslist=new ArrayList<News>();
			
			News news=new News();
			news.setTitle("这里是简介抬头");
			news.setDescription("这里是描述");
			news.setPicUrl("http://www.ljbbj.com/xx.jpg");
			news.setUrl("http://www.ljbbj.com");
			
			News news1=new News();
			news1.setTitle("这里是简介抬头1");
			news1.setDescription("这里是描述1");
			news1.setPicUrl("http://www.ljbbj.com/xx.jpg");
			news1.setUrl("http://www.163.com");
			
			newslist.add(news);
			newslist.add(news1);
			
			NewsMessage nm = new NewsMessage();
			nm.setFromUserName(tousername);
			nm.setToUserName(fromusername);
			nm.setArticles(newslist);
			nm.setArticleCount(newslist.size());
			nm.setCreateTime(new Date().toString());
			nm.setMsgType("news");
			
		   return messagexml.newsmessageTOxml(nm);
		   
	   }
	   
	   
}
