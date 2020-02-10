package com.ruoyi.common.EncryptionProcessing;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.SM.SM4Utils;

public class Encryption {
	
	//控制时候加密 解密处理
	private static boolean flag = true;
	private static String tKey ="JeF8U9wHFOMfs2Y8";
	//加密
	public static String encryptRSA(String result) throws BusinessException{
		SM4Utils sm4 = new SM4Utils();  
        sm4.setSecretKey(tKey);  
        sm4.setHexString(false);  
        System.out.println("ECB模式加密");  
        System.out.println(result);  
        String cipherText;
		try {
			cipherText = sm4.encryptData_ECB(result);
		} catch (Exception e) {
			throw new BusinessException("无法加密"+result);
		}  
        System.out.println("密文: " + cipherText);  
//        plainText = sm4.decryptData_ECB(cipherText);  
//        System.out.println("明文: " + plainText);
        if (flag) {
        	return cipherText;
		}else {
			return result;
		}
	}
//	解密
	public static String dncryptRSA(String result)  {
		SM4Utils sm4 = new SM4Utils();  
		sm4.setSecretKey(tKey);  
		sm4.setHexString(false);  
		System.out.println("ECB模式解密");  
//		String cipherText = sm4.encryptData_ECB(result);  
//		System.out.println("密文: " + cipherText);  
		System.out.println(result);  
        String plainText;
		try {
			plainText = sm4.decryptData_ECB(result);
		} catch (Exception e) {
			throw new BusinessException("无法解密"+result);
		}  
        System.out.println("明文: " + plainText);
        if (flag) {
        	return plainText;
		}else {
			return result;
		}
	}
}
