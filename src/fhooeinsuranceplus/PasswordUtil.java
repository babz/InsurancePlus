package fhooeinsuranceplus;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Die Klasse PasswordUtil beinhaltet Methoden zum Bearbeiten des Passwortes.
 *
 */
public class PasswordUtil {

	/**
	 * Diese Methode hashed das Uebergebene Password mit SHA-2 und uebergibt das gehashte Passwort als Hex String zurueck
	 * 
	 * @param password das zu hashende Passwort
	 * @return das gehashte Passwort
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 *  author: stefanie
	 */
	public String savePassword(char[] password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest messagedigest = MessageDigest.getInstance("SHA-256");
		messagedigest.reset();
		
		ByteBuffer passwordToByte = Charset.forName("UTF-8").encode(CharBuffer.wrap(password));
		
		byte[] passwordByte = new byte[passwordToByte.remaining()];
		passwordToByte.get(passwordByte);
		
		byte[] hashed = messagedigest.digest(passwordByte);
	
		String PasswordHashed = new BigInteger(1, hashed).toString(16); 
		
		return PasswordHashed;
	}

}
