package Client;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import Client.EncryptionStrategy;

public class AesEncryption implements EncryptionStrategy {
	SecretKey keyy;
	String a = "";
	public byte[] encryptData(String plainText) {
		System.out.println("-------Encrypting data using AES algorithm-------");
	     try {
	         KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
	         keyGenerator.init(128);
	         SecretKey secretKey = keyGenerator.generateKey();
	         this.keyy=secretKey;
	         byte[] plaintTextByteArray = plainText.getBytes("UTF8");
	         Cipher cipher = Cipher.getInstance("AES");
	         cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	         byte[] cipherText = cipher.doFinal(plaintTextByteArray);
	         System.out.println("The original key used is "+secretKey);
	         System.out.println("Original data: " + plainText);
	         /*for (int i = 0; i < cipherText.length; i++) {
	             a += cipherText[i] + " ";
	         }*/
	         return cipherText;
	     }
	         catch(Exception ex){
	             ex.printStackTrace();
	         }
		return null;
	    
	}
}
