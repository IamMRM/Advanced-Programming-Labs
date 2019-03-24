package Client;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.SecretKey;
public class Cli {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		SecretKey number = null;
		String algoname;
		byte[] encrypted = null;

		Socket s = new Socket("localhost",9999);
		Scanner sc1 = new Scanner(s.getInputStream());
		
		System.out.println("Enter the method of encryption");
		algoname = in.nextLine();
		System.out.println("Enter the String you want to encrypt");
		String plaintext = in.nextLine();
		if (algoname.equals("Aes")){
			AesEncryption a = new AesEncryption();
			encrypted = a.encryptData(plaintext);
			number = a.keyy;
		}
		
		String stringKey = Base64.getEncoder().encodeToString(number.getEncoded());
	
		System.out.println("Now sending data to server ......");
		
		PrintStream p = new PrintStream(s.getOutputStream());//can also use OutputStreamWriter
		p.println(algoname);// ye teeno server pe data bhaj rhe hein
		p.println(stringKey);
		p.println(hash(plaintext));
		
		DataOutputStream dOut = new DataOutputStream(s.getOutputStream());

		dOut.writeInt(encrypted.length); // write length of the message
		dOut.write(encrypted);
		
		System.out.println(sc1.nextLine());
		s.close();
		sc1.close();
	}
	
	
	
	public static long hash(String s) {
		int p = 31;
		int m = (int) (1e9 +9);
		long hash_value=0;
		long p_pow = 1;
		for(char c: s.toCharArray()) {
			hash_value = (hash_value + (c- 'a' +1)* p_pow)%m;
			p_pow=(p_pow *p)%m;
		}
		return hash_value;
	}
	
}