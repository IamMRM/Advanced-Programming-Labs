package labfour;

public class Encryptor {
	private String algorithmName;
    private String plainText;
    
public void encryptData(String plainText) {
		
		if (algorithmName.equals("Aes")){
            System.out.println("Encrypting data using AES algorithm");
            EncryptionStrategy aesStrategy=new AesEncryptionStrategy();
            aesStrategy.encryptData(plainText);
        }
       else if (algorithmName.equals("Blowfish")){
            System.out.println("Encrypting data using Blowfish algorithm");
            EncryptionStrategy blowfishStrategy=new BlowfishEncryptionStrategy();
            blowfishStrategy.encryptData(plainText);
        }
       else if (algorithmName.equals("TripleDES")){
           System.out.println("Encrypting data using Triple DES encryption algorithm");
           EncryptionStrategy TDES = new TripleDESEncryptionStrategy();
           TDES.encryptData(plainText);
       }
       else{
    	   System.out.println("You entered wrong name.");}
       }
public String get_algoname() {
	return this.plainText;
}
public String get_text() {
	return this.plainText;
}
public void set_algo(String algo) {
	this.algorithmName=algo;
}
public void set_text(String text) {
	this.plainText=text;
}
}
