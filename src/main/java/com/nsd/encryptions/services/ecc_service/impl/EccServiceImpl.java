package com.nsd.encryptions.services.ecc_service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nsd.encryptions.services.ecc_service.EccService;
import com.nsd.encryptions.utils.ecc_util.ECCKeyPairGenerator;
import com.nsd.encryptions.utils.ecc_util.EccUtil;

/**
 * @author Nilesh Dhawale
 * @Date 20-06-2024
 * @Version 1.0
 */
@Service
public class EccServiceImpl implements EccService {

	@Override
	public ResponseEntity<Map<String, Object>> generateKeyPair() {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String base64PublicKey = ECCKeyPairGenerator.eccKeyPairGenerator();
			map.put("data", "ECC keys genereted");
			map.put("base64PublicKey", base64PublicKey);
			map.put("success", true);
		} catch (Exception e) {
			map.put("data", e.getMessage());
			map.put("success", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Map<String, Object>> encryptData(String data, String base64PublicKey) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String encryptedData = EccUtil.eccEncrypt(data, base64PublicKey);
			map.put("data", "ECC Encryption Done");
			map.put("encryptedData", encryptedData);
			map.put("success", true);
		} catch (Exception e) {
			map.put("data", e.getMessage());
			map.put("success", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Map<String, Object>> decryptData(String data) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String decryptedData = EccUtil.eccDecrypt(data);
			map.put("data", "ECC Decryption Done");
			map.put("base64PublicKey", decryptedData);
			map.put("success", true);
		} catch (Exception e) {
			map.put("data", e.getMessage());
			map.put("success", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

}
