package labfour;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class TripleDESEncryptionStrategy implements EncryptionStrategy{

	
	@Override
	public void encryptData(String plainText) {
		System.out.println("\n-------Encrypting data using TripleDes algorithm-------");
	    try {
	        KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
	        keyGenerator.init(168);
	        SecretKey secretKey = keyGenerator.generateKey();
	        byte[] plaintTextByteArray = plainText.getBytes("UTF8");
	        Cipher cipher = Cipher.getInstance("DESede");
	        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	        byte[] cipherText = cipher.doFinal(plaintTextByteArray);
	        System.out.println("Original data: " + plainText);
	        System.out.println("Encrypted data:");
	        for (int i = 0; i < cipherText.length; i++) {
	            System.out.print(cipherText[i] + " ");

	        }
	    }
	    catch(Exception ex){
	        ex.printStackTrace();
	    }
		
	}

}
