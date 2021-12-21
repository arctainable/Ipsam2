package Util;

import java.security.MessageDigest;

public class Utility {
	
	//단방향 암호 알고리즘 (MD5, SHA-1, SHA-256, SHA-512) 사용
	
	public static String encoding(String userpw) {
		String encodeString="";
		try {
			//암호화 알고리즘 선택하여 객체 생성
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(userpw.getBytes());
			byte[] encodeData = md.digest();
			for(int i = 0; i < encodeData.length; i++) {
				encodeString += Integer.toHexString(encodeData[i]&0xFF);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return encodeString;
	}
	
}
