package labfour;

import java.util.Scanner;

public class EncryptorTest {
    
    public static void main(String[] args) {
    	Encryptor user = new Encryptor();
    	System.out.println("Beginning Encryption!");
    	System.out.println("Enter the method of Encryption:");
    	Scanner in = new Scanner(System.in);
    	String a = in.next();
    	user.set_algo(a);
    	System.out.println("Enter the text you want to encrypt:");
    	String b = in.next();
    	user.encryptData(b);
    	
    	
    }
	
	}
