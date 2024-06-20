package com.nsd.encryptions.apis.ase;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsd.encryptions.services.aes_service.AesService;

/**
 * @author Nilesh Dhawale
 * @Date 20-06-2024
 * @Version 1.0
 */

@RestController
@RequestMapping("/ase")
public class AseApis {

	@Autowired
	AesService aesService;

	@GetMapping("/generate")
	public ResponseEntity<Map<String, Object>> generateSecreateKey() {
		return aesService.generateSecreateKey();
	}

	@PostMapping("/encrypt")
	public ResponseEntity<Map<String, Object>> encryptData(@RequestBody Map<String, String> map) {

		String data = map.get("data");
		String base64SecreteKey = map.get("base64SecreteKey");
		return aesService.encryptData(data, base64SecreteKey);
	}

	@PostMapping("/decrypt")
	public ResponseEntity<Map<String, Object>> decryptData(@RequestBody Map<String, String> map) {

		String encryptrdData = map.get("encryptedData");
		String base64SecreteKey = map.get("base64SecreteKey");
		return aesService.decryptData(encryptrdData, base64SecreteKey);
	}

}
