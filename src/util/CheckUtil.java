package util;

import java.util.*;
public class CheckUtil {
	private static final String token="112233";
	
	  public static boolean checkSignature(String signature,String timestamp,String nonce){
		 String [] arr =new String[]{token,timestamp,nonce};
        //�����ֵ�����
		 Arrays.sort(arr);
		 StringBuffer content = new StringBuffer();
		//����ƴ���ַ���
		 for(int i =0;i<arr.length;i++){
			 content.append(arr[i]);
		 }
		String mm = jiami.SHA1(content.toString());
		//return false;
		System.out.println("���ܵõ�����:"+mm +"���ݹ�������"+signature);
		  return mm.equals(signature);
	  }
}
