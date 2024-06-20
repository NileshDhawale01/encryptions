package com.nsd.encryptions.store.ecc_store;

/**
 * @author Nilesh Dhawale
 * @Date 20-06-2024
 * @Version 1.0
 */
public class EccKeyStrore {

	private EccKeyStrore() {
	}

	private static String eccBase64PublicKey = null;
	private static String eccBase64PrivateKey = null;

	public static String getEccBase64PublicKey() {
		return eccBase64PublicKey;
	}

	public static void setEccBase64PublicKey(String eccBase64PublicKey) {
		EccKeyStrore.eccBase64PublicKey = eccBase64PublicKey;
	}

	public static String getEccBase64PrivateKey() {
		return eccBase64PrivateKey;
	}

	public static void setEccBase64PrivateKey(String eccBase64PrivateKey) {
		EccKeyStrore.eccBase64PrivateKey = eccBase64PrivateKey;
	}

}
