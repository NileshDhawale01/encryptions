package com.nsd.encryptions.utils.aes_util;

import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.nsd.encryptions.store.aes_store.AesKeyStrore;

/**
 * @author Nilesh Dhawale
 * @Date 20-06-2024
 * @Version 1.0
 */

public class AESSecreteKeyGenerator {

	private AESSecreteKeyGenerator() {
	}

	public static String generateSecreteKey() throws Exception {

		// get key generator
		KeyGenerator generator = KeyGenerator.getInstance("AES");
		// set key size
		generator.init(256);
		// get key and set to key store
		String base64String = Base64.getEncoder().encodeToString(generator.generateKey().getEncoded());
		AesKeyStrore.setBase64SecreteKey(base64String);
		return base64String;
	}

	public static SecretKey getSecreteKeyFromBase64SecreteKey(String base64Key) {

		byte[] byteKey = Base64.getDecoder().decode(base64Key);
		// get secrete key
//		SecretKey secretKey = new javax.crypto.spec.SecretKeySpec(byteKey, 0, base64Key.length(), "AES");
		SecretKey secretKey = new SecretKeySpec(byteKey, "AES");
		return secretKey;
	}

}
