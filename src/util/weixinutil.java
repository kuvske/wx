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
	 //��httpȥʵ��
	  DefaultHttpClient  httpClient = new DefaultHttpClient();
	 //��post��ʽȥ
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
	  //����httpȥʵ��
	  DefaultHttpClient  httpClient = new DefaultHttpClient();
	//��get��ʽȥ�ύ��ͬʱ��URL���ݽ�ȥ�ύ
	  HttpGet httpGet = new HttpGet(url);
	  //�����������ܽ��
	 JSONObject jsonObject =null;
	 
	 try {
		 //�������ս��
		HttpResponse response=httpClient.execute(httpGet);
		//�õ����յĽ��
		HttpEntity entity = response.getEntity();
	    if(entity != null){
	    	//�õ����ս������
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
