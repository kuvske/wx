package util;

import java.io.IOException;

import org.apache.http.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.google.gson.Gson;

import pojo.AccessToken;

public class weixinutil {
  private static final String APPID="wxbdd6cd5754a3a493";
  private static final String APPSECRET="f1a701bff9abda6661e81c7be12b781b";
 
  public static AccessToken getAccessToken(){
	  AccessToken token = new AccessToken();
	  String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+APPID+"&secret="+APPSECRET;
	  JSONObject json = doGetStr(url);
	  if(json != null){
		  token.setToken(json.getString("access_token"));
		  token.setExpiresin(json.getInt("expires_in"));
	  }
	  return token;
  }
  
  
  public static JSONObject dopostStr(String url,String outStr){
	 //用http去实现
	  DefaultHttpClient  httpClient = new DefaultHttpClient();
	 //用post方式去
	  HttpPost httppost = new HttpPost(url);
	  JSONObject jsonObject =null;
	 // 
	  try {
		  StringEntity stringentity = new StringEntity(outStr,"utf-8");
		  httppost.setEntity(stringentity);
		HttpResponse response=httpClient.execute(httppost);
	    HttpEntity entity = response.getEntity();
		String result = EntityUtils.toString(entity,"utf-8");
		jsonObject =new JSONObject(result);
		
	  } catch (ClientProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return jsonObject;
	  
	  
  }
  public static JSONObject doGetStr(String url){
	  //用于http去实现
	  DefaultHttpClient  httpClient = new DefaultHttpClient();
	//用get方式去提交，同时把URL传递进去提交
	  HttpGet httpGet = new HttpGet(url);
	  //创建变量接受结果
	 JSONObject jsonObject =null;
	 
	 try {
		 //用来接收结果
		HttpResponse response=httpClient.execute(httpGet);
		//得到接收的结果
		HttpEntity entity = response.getEntity();
	    if(entity != null){
	    	//得到接收结果内容
	    	String result = EntityUtils.toString(entity);
	    	
	    	jsonObject =new JSONObject(result);

	    }
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally{
		httpClient.close();
	}
	 
	
	  return jsonObject;
	  
  }
}
