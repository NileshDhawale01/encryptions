package com.nsd.encryptions.utils.ecc_util;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import com.nsd.encryptions.store.ecc_store.EccKeyStrore;

/**
 * @author Nilesh Dhawale
 * @Date 20-06-2024
 * @Version 1.0
 */

public class ECCKeyPairGenerator {

	private ECCKeyPairGenerator() {
	}

	public static String eccKeyPairGenerator() throws Exception {

		// get key generator
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
		// get secure random
		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
		// set key size
		keyPairGenerator.initialize(256, secureRandom);
		// generate key pair
		KeyPair keyPair = keyPairGenerator.generateKeyPair();

		// set keys in ecc key store
		String base64PublicKey = Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
		String base64PrivateKey = Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());
		EccKeyStrore.setEccBase64PublicKey(base64PublicKey);
		EccKeyStrore.setEccBase64PrivateKey(base64PrivateKey);
		
		return base64PublicKey;
	}

	public static PublicKey generatePublicKeyFromBase64PublicKeyString(String base64PublicKeyString) throws Exception {

		byte[] publicKey = Base64.getDecoder().decode(base64PublicKeyString);
		KeyFactory keyFactory = KeyFactory.getInstance("EC");
		X509EncodedKeySpec encodedKeySpec = new X509EncodedKeySpec(publicKey);
		return keyFactory.generatePublic(encodedKeySpec);
	}

	public static PrivateKey generatePrivateKeyFromBase64PrivateKeyString(String base64PrivateKey) throws Exception {

		byte[] privateKey = Base64.getDecoder().decode(base64PrivateKey);
		KeyFactory keyFactory = KeyFactory.getInstance("EC");
		PKCS8EncodedKeySpec encodedKeySpec = new PKCS8EncodedKeySpec(privateKey);
		return keyFactory.generatePrivate(encodedKeySpec);
	}
}
