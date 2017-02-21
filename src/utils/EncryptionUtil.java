package utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionUtil {

	static public final String HASH_TYPE_MD5 = "MD5";
	static public final String HASH_TYPE_SHA256 = "SHA-256";
	
	static public String SaltedEncrypt(String password, String salt) {
		// sha(md5(salt + pw))
		return hash(HASH_TYPE_SHA256, hash(HASH_TYPE_MD5, salt + password));
	}
	
	private static String hash(String hashType, String base) {
		MessageDigest digest;
		byte[] hash = null;
		final String BYTE_ENCODING = "UTF-8";
		
		try {
			digest = MessageDigest.getInstance(hashType);
			hash = digest.digest(base.getBytes(BYTE_ENCODING));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		} catch (NoSuchAlgorithmException e1) {
			throw new RuntimeException(e1);
		}
		
		return byteToHex(hash); 
	}

	private static String byteToHex(byte[] hash) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if(hex.length() == 1) hexString.append('0');
			hexString.append(hex);
		}
		
		return hexString.toString();
	}
}
