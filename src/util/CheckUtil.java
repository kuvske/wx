package util;

import java.util.*;
public class CheckUtil {
	private static final String token="112233";
	
	  public static boolean checkSignature(String signature,String timestamp,String nonce){
		 String [] arr =new String[]{token,timestamp,nonce};
        //进行字典排序
		 Arrays.sort(arr);
		 StringBuffer content = new StringBuffer();
		//进行拼接字符串
		 for(int i =0;i<arr.length;i++){
			 content.append(arr[i]);
		 }
		String mm = jiami.SHA1(content.toString());
		//return false;
		System.out.println("加密得到的是:"+mm +"传递过来的是"+signature);
		  return mm.equals(signature);
	  }
}
