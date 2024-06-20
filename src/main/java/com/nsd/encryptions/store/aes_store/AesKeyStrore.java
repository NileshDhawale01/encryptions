package com.nsd.encryptions.store.aes_store;

/**
 * @author Nilesh Dhawale
 * @Date 20-06-2024
 * @Version 1.0
 */
public class AesKeyStrore {

	private AesKeyStrore() {
	}

	private static String base64SecreteKey = null;

	public static String getBase64SecreteKey() {
		return base64SecreteKey;
	}

	public static void setBase64SecreteKey(String base64SecreteKey) {
		AesKeyStrore.base64SecreteKey = base64SecreteKey;
	}
}
