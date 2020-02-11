package com.ruoyi.common.EncryptionProcessing;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.AES.AESUtil;
import com.ruoyi.common.utils.SM.SM4Utils;

public class Encryption {
	
	//控制时候加密 解密处理
	private static boolean flag = true;
	private static String tKey ="1234567899876543";
	private static String tiv ="0000000000000000";
	
	private static String KEY = "1234567899876543";
    private static String IV = "0000000000000000";
	//加密
	public static String encryptRSA(String result) throws BusinessException{
        System.out.println("aes模式加密");  
        System.out.println(result);  
        String cipherText;
		try {
			cipherText = AESUtil.encrypt(result, tKey, tiv);
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
		System.out.println("aes模式解密");  
//		String cipherText = sm4.encryptData_ECB(result);  
//		System.out.println("密文: " + cipherText);  
		System.out.println(result);  
        String plainText;
		try {
			plainText = AESUtil.desEncrypt(result, tKey, tiv);
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
