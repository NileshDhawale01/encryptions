package com.nsd.encryptions.store.rsa_store;

/**
 * @author Nilesh Dhawale
 * @Date 20-06-2024
 * @Version 1.0
 */
public class RsaKeyStore {

	private RsaKeyStore() {
	}

	private static String base64PublicKey = null;
	private static String base64PrivateKey = null;

	public static String getBase64PublicKey() {
		return base64PublicKey;
	}

	public static void setBase64PublicKey(String base64PublicKey) {
		RsaKeyStore.base64PublicKey = base64PublicKey;
	}

	public static String getBase64PrivateKey() {
		return base64PrivateKey;
	}

	public static void setBase64PrivateKey(String base64PrivateKey) {
		RsaKeyStore.base64PrivateKey = base64PrivateKey;
	}
}
