package util;

import java.util.*;
public class CheckUtil {
	private static final String token="zsweix";
	
	  public static boolean checkSignature(String signature,String timestamp,String nonce){
		 String [] arr =new String[]{token,timestamp,nonce};

		 Arrays.sort(arr);

		 StringBuffer content = new StringBuffer();
		 for(int i =0;i<arr.length;i++){
			 content.append(arr[i]);
		 }

		 
		String mm = jiami.SHA1(content.toString());
		//return false;
		  return mm.equals(signature);
	  }
}
