package Server;
import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class first {

	public static void main(String[] args) throws Exception {

		ServerSocket s1 = new ServerSocket(9999);
		Socket ss = s1.accept();
		
		Scanner sc = new Scanner(ss.getInputStream());
		String test = sc.nextLine();
		String key = sc.nextLine();
		String hashi = sc.nextLine();
		System.out.println("The method of encryption used is "+test);
		System.out.println("The secret key in string is "+key);
		
		DataInputStream dIn = new DataInputStream(ss.getInputStream());
		byte[] abc = null;
		int length = dIn.readInt();                    // read length of incoming message
		if(length>0) {
		    byte[] message = new byte[length];
		    dIn.readFully(message, 0, message.length); // read the message
		    abc = message;
		}

		byte[] decodedKey = Base64.getDecoder().decode(key);
		SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
		System.out.println("The original key used is "+originalKey);
	
		System.out.println("........Now Decrypting.........");
		AesDecryption bbbb = new AesDecryption();
		byte[] decryptedCipherText = bbbb.decrypt(abc,originalKey,test.toUpperCase());
		System.out.println(new String(decryptedCipherText));
		System.out.println("The given hash was "+hashi);
		long hashi2 = hash(new String(decryptedCipherText));
		System.out.println("The Hash we calculated is "+ hashi2);
		PrintStream p = new PrintStream(ss.getOutputStream());
		if(hashi2 == Long.parseLong(hashi)){
			p.println("Everything works fine as hash values are same!");
		}else {
			p.println("The hash values do not match so send the data again please.");
		}
		s1.close();
		sc.close();
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
