package com.ruoyi.common.utils.SM;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class SM4Utils
{
    private String secretKey = "";
    private String iv = "";
    private boolean hexString = false; 
    
    public SM4Utils()
    {
    }
    
    public String encryptData_ECB(String plainText)
    {
        try 
        {
            SM4_Context ctx = new SM4_Context();
            ctx.isPadding = true;
            ctx.mode = SM4.SM4_ENCRYPT;
            
            byte[] keyBytes;
            keyBytes = getSecretKey().getBytes();
            SM4 sm4 = new SM4();
            sm4.sm4_setkey_enc(ctx, keyBytes);
            byte[] encrypted = sm4.sm4_crypt_ecb(ctx, plainText.getBytes("UTF-8"));
            String cipherText = new BASE64Encoder().encode(encrypted);
            if (cipherText != null && cipherText.trim().length() > 0)
            {
                Pattern p = Pattern.compile("\\s*|\t|\r|\n");
                Matcher m = p.matcher(cipherText);
                cipherText = m.replaceAll("");
            }
            return cipherText;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public String decryptData_ECB(String cipherText)
    {
        try 
        {
            SM4_Context ctx = new SM4_Context();
            ctx.isPadding = true;
            ctx.mode = SM4.SM4_DECRYPT;
            
            byte[] keyBytes;
            keyBytes = getSecretKey().getBytes();
            SM4 sm4 = new SM4();
            sm4.sm4_setkey_dec(ctx, keyBytes);
            byte[] decrypted = sm4.sm4_crypt_ecb(ctx, new BASE64Decoder().decodeBuffer(cipherText));
            return new String(decrypted, "UTF-8");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public String encryptData_CBC(String plainText){  
         try{  
                SM4_Context ctx = new SM4_Context();  
                ctx.isPadding = true;  
                ctx.mode = SM4.SM4_ENCRYPT;  
                  
                byte[] keyBytes;  
                byte[] ivBytes;  
               
                keyBytes = getSecretKey().getBytes();  
                ivBytes = iv.getBytes();  
                  
                SM4 sm4 = new SM4();  
                sm4.sm4_setkey_enc(ctx, keyBytes);  
                byte[] encrypted = sm4.sm4_crypt_cbc(ctx, ivBytes, plainText.getBytes("UTF-8"));  
                String cipherText = new BASE64Encoder().encode(encrypted);  
                if (cipherText != null && cipherText.trim().length() > 0)  
                {  
                    Pattern p = Pattern.compile("\\s*|\t|\r|\n");  
                    Matcher m = p.matcher(cipherText);  
                    cipherText = m.replaceAll("");  
                }  
                return cipherText;  
            }   
            catch (Exception e)   
            {  
                e.printStackTrace();  
                return null;  
            }  
        }  
          
        public String decryptData_CBC(String cipherText)  
        {  
            try   
            {  
                SM4_Context ctx = new SM4_Context();  
                ctx.isPadding = true;  
                ctx.mode = SM4.SM4_DECRYPT;  
                  
                byte[] keyBytes;  
                byte[] ivBytes;  
                if (isHexString())  
                {  
                    keyBytes = Util.hexStringToBytes(getSecretKey());  
                    ivBytes = Util.hexStringToBytes(iv);  
                }  
                else  
                {  
                    keyBytes = getSecretKey().getBytes();  
                    ivBytes = iv.getBytes();  
                }  
                  
                SM4 sm4 = new SM4();  
                sm4.sm4_setkey_dec(ctx, keyBytes);  
                byte[] decrypted = sm4.sm4_crypt_cbc(ctx, ivBytes, new BASE64Decoder().decodeBuffer(cipherText));  
                return new String(decrypted, "UTF-8");  
            }   
            catch (Exception e)  
            {  
                e.printStackTrace();
                return null;  
            }  
        }  
          
    
	/*
	 * public static void main(String[] args) throws IOException { String plainText
	 * ="{\"username\":\"usertest0561\",\"password\":\"1234qwer\",\"rememberMe\":\"true\"}";
	 * SM4Utils sm4 = new SM4Utils(); sm4.setSecretKey("JeF8U9wHFOMfs2Y8");
	 * plainText.getBytes("UTF-8"); System.out.println("ECB模式"); String cipherText =
	 * sm4.encryptData_ECB(plainText); System.out.println("密文: " + cipherText);
	 * System.out.println("");
	 * 
	 * plainText = sm4.decryptData_ECB("v5oJ+QH8358MGxG0GuZoBQ==");
	 * System.out.println("明文: " + plainText); System.out.println("");
	 * 
	 * System.out.println("CBC模式"); sm4.iv = "UISwD9fW6cFh9SNS"; cipherText =
	 * sm4.encryptData_CBC(plainText); System.out.println("密文: " + cipherText);
	 * System.out.println("");
	 * 
	 * plainText = sm4.decryptData_CBC(cipherText); System.out.println("明文: " +
	 * plainText); //PI4ke7HMoUMD/LOSHWX5/g==
	 * 
	 * }
	 */

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public boolean isHexString() {
		return hexString;
	}

	public void setHexString(boolean hexString) {
		this.hexString = hexString;
	}
}