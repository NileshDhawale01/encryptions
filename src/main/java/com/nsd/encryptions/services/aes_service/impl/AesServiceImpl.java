package com.nsd.encryptions.services.aes_service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nsd.encryptions.services.aes_service.AesService;
import com.nsd.encryptions.utils.aes_util.AESSecreteKeyGenerator;
import com.nsd.encryptions.utils.aes_util.AesUtil;

/**
 * @author Nilesh Dhawale
 * @Date 20-06-2024
 * @Version 1.0
 */

@Service
public class AesServiceImpl implements AesService {

	@Override
	public ResponseEntity<Map<String, Object>> generateSecreateKey() {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String message = AESSecreteKeyGenerator.generateSecreteKey();
			map.put("data", "key generated");
			map.put("secreteKey", message);
			map.put("success", true);

		} catch (Exception e) {
			map.put("data", e.getMessage());
			map.put("success", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Map<String, Object>> encryptData(String data, String base64SecreteKey) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {

			String encryptrdData = AesUtil.aseEncrypt(data,
					AESSecreteKeyGenerator.getSecreteKeyFromBase64SecreteKey(base64SecreteKey));
			map.put("data", encryptrdData);
			map.put("success", true);

		} catch (Exception e) {
			map.put("data", e.getMessage());
			map.put("success", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Map<String, Object>> decryptData(String encryptrdData, String base64SecreteKey) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String decodedData = AesUtil.aseDecrypt(encryptrdData,
					AESSecreteKeyGenerator.getSecreteKeyFromBase64SecreteKey(base64SecreteKey));
			map.put("data", decodedData);
			map.put("success", true);
		} catch (Exception e) {
			map.put("data", e.getMessage());
			map.put("success", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

}
