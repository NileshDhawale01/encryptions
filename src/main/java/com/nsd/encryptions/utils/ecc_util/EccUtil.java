package com.nsd.encryptions.utils.ecc_util;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.util.Base64;

import javax.crypto.Cipher;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.nsd.encryptions.store.ecc_store.EccKeyStrore;

/**
 * @author Nilesh Dhawale
 * @Date 20-06-2024
 * @Version 1.0
 */
public class EccUtil {

	private EccUtil() {
	}

	static {
		Security.addProvider(new BouncyCastleProvider());
	}

	// encrypt
	public static String eccEncrypt(String data, String base64EccPublicKey) throws Exception {

		PublicKey publicKey = ECCKeyPairGenerator.generatePublicKeyFromBase64PublicKeyString(base64EccPublicKey);

		Cipher cipher = Cipher.getInstance("ECIES", "BC");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] encryptedData = cipher.doFinal(data.getBytes("UTF-8"));
		return Base64.getEncoder().encodeToString(encryptedData);
	}

	// decrypt
	public static String eccDecrypt(String encryptedBase64Data) throws Exception {

		byte[] encryptedData = Base64.getDecoder().decode(encryptedBase64Data);
		String base64PrivateKeyString = EccKeyStrore.getEccBase64PrivateKey();

		PrivateKey privateKey = ECCKeyPairGenerator
				.generatePrivateKeyFromBase64PrivateKeyString(base64PrivateKeyString);

		Cipher cipher = Cipher.getInstance("ECIES", "BC");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] decryptedData = cipher.doFinal(encryptedData);
		return new String(decryptedData);
	}
}
