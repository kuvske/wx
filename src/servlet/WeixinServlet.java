package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import pojo.textnaessage;
import util.CheckUtil;
import util.messagexml;

/**
 * Servlet implementation class WeixinServlet
 */

public class WeixinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeixinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		//request.setCharacterEncoding("gbk");
		//response.setCharacterEncoding("gbk");
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		PrintWriter out = response.getWriter();
		CheckUtil ck = new CheckUtil();
		
		if(ck.checkSignature(signature, timestamp, nonce)){
			out.print(echostr);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
       PrintWriter out = response.getWriter();
	   messagexml mp = new messagexml();   	  
		Map<String, String> map =mp.xmltomap(request);
		//Map<String, String> map =new HashMap<String,String>();		
		String fromusername = map.get("FromUserName");
		String tousername = map.get("ToUserName");
		String msgtype = map.get("MsgType");
		String conntent = map.get("Content");
		
		String message=null;
		textnaessage tx = new textnaessage();
		if("text".equals(msgtype)){		
			tx.setFromUserName(tousername);
			tx.setToUserName(fromusername);
			tx.setMsgType(msgtype);
			tx.setCreateTime(new Date().toString());
			tx.setContent("你说的是："+conntent);
		}else{
			tx.setContent("对不起，我还不能回答除文字以外的问题");
		}
		message = messagexml.textmessageTOxml(tx);
		System.out.println(message);
		out.print(message);
       
       
      
       
	}

}
