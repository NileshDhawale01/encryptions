package com.nsd.encryptions.apis.rsa;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsd.encryptions.services.rsa_service.RsaService;

/**
 * @author Nilesh Dhawale
 * @Date 20-06-2024
 * @Version 1.0
 */

@RestController
@RequestMapping("/rsa")
public class RsaApis {

	@Autowired
	RsaService rsaService;

	@GetMapping("generate_Keys")
	public ResponseEntity<Map<String, Object>> generateKeyPair() {

		return rsaService.generateKeyPair();
	}

	// just test
	@PostMapping("/encrypt")
	public ResponseEntity<Map<String, Object>> encryptData(@RequestBody Map<String, String> map) {

		String sampleData = map.get("dataString");
		String base64PublicKey = map.get("base64PublicKey");
		return rsaService.encryptData(sampleData, base64PublicKey);
	}

	@PostMapping("/decrypt")
	public ResponseEntity<Map<String, Object>> decryptData(@RequestBody Map<String, String> map) {
		String encryptedData = map.get("encrytedData");
		System.out.println("API :: " + encryptedData);
		return rsaService.decryptData(encryptedData);
	}

}
