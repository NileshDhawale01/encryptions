package com.nsd.encryptions.utils.aes_util;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/**
 * @author Nilesh Dhawale
 * @Date 20-06-2024
 * @Version 1.0
 */
public class AesUtil {

	private AesUtil() {
	}

	// encrypt
	public static String aseEncrypt(String data, SecretKey secretKey) throws Exception {

		// get cipher
		Cipher cipher = Cipher.getInstance("AES");
		// encrypt mode on
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		// encrypt
		byte[] encryptedData = cipher.doFinal(data.getBytes());
		return Base64.getEncoder().encodeToString(encryptedData);
	}

	// decrypt
	public static String aseDecrypt(String base64EncodedData, SecretKey secretKey) throws Exception {

		// base64 decode
		byte[] encodedData = Base64.getDecoder().decode(base64EncodedData);
		// get cipher
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		// decrypt mode
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		// decrypt data
		byte[] decryptedByte = cipher.doFinal(encodedData);
		return new String(decryptedByte);
	}
}
