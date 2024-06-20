package com.nsd.encryptions.services.rsa_service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

/**
 * @author Nilesh Dhawale
 * @Date 20-06-2024
 * @Version 1.0
 */

public interface RsaService {

	ResponseEntity<Map<String, Object>> generateKeyPair();

	ResponseEntity<Map<String, Object>> encryptData(String data,String base64PublicKey);

	ResponseEntity<Map<String, Object>> decryptData(String data);
}
