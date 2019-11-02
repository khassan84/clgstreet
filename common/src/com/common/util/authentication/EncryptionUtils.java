package com.common.util.authentication;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.codec.binary.Base64;

public class EncryptionUtils {
	
	public static String generateSalt() {
		 return appendZero(new SecureRandom().nextInt(10000));
	}
	
	public static String generateSHA1Password(String password, String salt) throws UnsupportedEncodingException, NoSuchAlgorithmException  {
		byte[] bytesOfMessage = (password + salt).getBytes("UTF-8");
		MessageDigest md = MessageDigest.getInstance("SHA1");
		
		byte[] thedigest = md.digest(bytesOfMessage);
		return bytesToHex(thedigest);
	}

	public static boolean validatePassword(String hashedPassword,String password, String salt) {
		try {
			return generateSHA1Password(password,salt).equalsIgnoreCase(hashedPassword);
		} catch (UnsupportedEncodingException e) {
			return false;
		} catch (NoSuchAlgorithmException e) {
			return false;
		}
	}
	
	private static String appendZero(int randomNumber) {
		String number = randomNumber + "";
		StringBuilder sb = new StringBuilder(); 
		for(int i = number.length(); i < 4; i++) {
			sb.append("0");
		}
		return sb.toString()+number; 
	}
	
	public static byte[] hexToBytes(String string) {
	      ByteArrayOutputStream bas = new ByteArrayOutputStream();
	      for(int i = 0; i<string.length(); i+=2) {
	    	bas.write(Integer.parseInt(string.substring(i, i+2), 16));
	      }
	      return bas.toByteArray();
	}

	
	public static String bytesToHex(byte[] b) {
	      char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7',
	                         '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	      StringBuffer buf = new StringBuffer();
	      for (int j=0; j<b.length; j++) {
	         buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
	         System.out.println("--> "+hexDigit[(b[j] >> 4) & 0x0f]);
	         buf.append(hexDigit[b[j] & 0x0f]);
	      }
	      return buf.toString();
	}


    public static void main(String[] a) throws Exception{
    	String password = "ABC";
    	//if (a != null && a.length == 1) {
    		//String password = a[0];
	
		System.out.println("Password input: " + password);
		
		String salt = generateSalt();
		System.out.println("Password salt: " + salt);
		System.out.println("Password generated: " + generateSHA1Password(password, salt));
		System.out.println("Password encryptet: " + EncryptionUtils.base64Encode(password));
    	System.out.println("Password decrypted: " + EncryptionUtils.base64Decode(password));
    	//}
    }
    
    /**
     * Encode using BASE64
     */
    public static String base64Encode(String text) throws Exception{
    	// Encode the string into bytes using utf-8
        byte[] utf8 = text.getBytes("UTF8");
        // Encrypt
        byte[] enc = getCipher(Cipher.ENCRYPT_MODE).doFinal(utf8);
        // Encode bytes to base64 to get a string
        return new String(Base64.encodeBase64(enc, false),"UTF-8");
    }

    public static String base64EncodeByte(byte[] b) throws Exception{
    	 // Encrypt
        byte[] enc = getCipher(Cipher.ENCRYPT_MODE).doFinal(b);
        // Encode bytes to base64 to get a string
        return new String(Base64.encodeBase64(enc, false),"UTF-8");
    }
    
    
    public static byte[] base64DecodeByte(String data) throws Exception{
        // Decode base64 to get bytes
        byte[] dec = Base64.decodeBase64(data.getBytes("UTF-8"));
        // Decrypt
        byte[] utf8 = getCipher(Cipher.DECRYPT_MODE).doFinal(dec);
        // Decode using utf-8
        return utf8;
   }
    
    
    /**
     * Decode using BASE64
     */
    public static String base64Decode(String text) {
       return base64Decode(text, true);
    }
    
    
    public static String base64Decode(String text, boolean log) {
        try {
            // Decode base64 to get bytes
            byte[] dec = Base64.decodeBase64(text.getBytes("UTF8"));
            // Decrypt
            byte[] utf8 = getCipher(Cipher.DECRYPT_MODE).doFinal(dec);
            // Decode using utf-8
            return new String(utf8, "UTF8");
        } catch (Exception ex) {
        	if(log) {
        	}
        }
        return null;
    }
    
    private static Cipher getCipher(int mode) {
        try {
            PBEKeySpec pbeKeySpec;
            PBEParameterSpec pbeParamSpec;
            SecretKeyFactory keyFac;

            // Salt
            byte[] salt = {
                (byte) 0xc7, (byte) 0x22, (byte) 0x21, (byte) 0x8c, (byte) 0x7e, (byte) 0xc8, (byte) 0xee, (byte) 0x99
            };

            // Iteration count
            int count = 6;

            // Create PBE parameter set
            pbeParamSpec = new PBEParameterSpec(salt, count);
            pbeKeySpec = new PBEKeySpec("http://skvader.com/rolf_operations_fm".toCharArray());
            keyFac = SecretKeyFactory.getInstance("PBEWithMD5AndDES");

            SecretKey pbeKey = keyFac.generateSecret(pbeKeySpec);

            // Create PBE Cipher
            Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");

            // Initialize PBE Cipher with key and parameters
            pbeCipher.init(mode, pbeKey, pbeParamSpec);

            return pbeCipher;
        } catch (Exception e) {
        }

        return null;
    }
    
    public static String getMD5(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(text.getBytes("8859_1"), 0, text.length());
        byte[] md5hash = md.digest();

        return convertToHex(md5hash);
    }
    
    public static String getMD5(byte[] md5hash)  {
        return convertToHex(md5hash);
    }
	
    private static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;

            do {
                if ((0 <= halfbyte) && (halfbyte <= 9)) {
                    buf.append((char) ('0' + halfbyte));
                } else {
                    buf.append((char) ('a' + (halfbyte - 10)));
                }

                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }

        return buf.toString();
    }
    
}	
