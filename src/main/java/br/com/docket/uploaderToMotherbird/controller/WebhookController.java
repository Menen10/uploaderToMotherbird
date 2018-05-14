package br.com.docket.uploaderToMotherbird.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

	@PostMapping
	public ResponseEntity<?> getleitura(@RequestBody String texto) {
		System.out.println(texto);
		return ResponseEntity.ok().body("");
	}
}
