package test;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import pojo.AccessToken;
import util.InitMenu;
import util.weixinutil;

public class tokentest {

	public static void main(String[] args) { 
		// TODO Auto-generated method stub
//           weixinutil wx = new weixinutil();
//          AccessToken  token =  wx.getAccessToken();
//          System.out.println(token.getToken());
//          System.out.println(token.getExpiresin());
      weixinutil wx = new weixinutil();
     AccessToken  token =  wx.getAccessToken();
     String menu = new JSONObject(InitMenu.initmenu()).toString();
    int i = wx.getmenu(token.getToken(), menu);
    if(i==0)   {   
    System.out.println("创建成功");
	}else{
		System.out.println("错误码是："+i);
	}
    
    
    
	}
	

}

	
//	public static void doget(String url){
//		HttpClient httpclient = new DefaultHttpClient();
//		HttpGet httpget = new HttpGet(url);
//		HttpResponse response;
//		try {
//			response = httpclient.execute(httpget);
//			HttpEntity httpentity = response.getEntity();
//			if(httpentity !=null){
//				String st = EntityUtils.toString(httpentity);
//			}
//		} catch (ClientProtocolException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			
//		}
	
	

