package com.nsd.encryptions.services.aes_service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

/**
 * @author Nilesh Dhawale
 * @Date 20-06-2024
 * @Version 1.0
 */

public interface AesService {

	public ResponseEntity<Map<String, Object>> generateSecreateKey();

	public ResponseEntity<Map<String, Object>> encryptData(String data, String base64SecreteKey);

	public ResponseEntity<Map<String, Object>> decryptData(String encryptrdData, String base64SecreteKey);
}
