package com.br.zup.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {
	@GetMapping
	public ResponseEntity getOlaMundo() {
		return ResponseEntity.ok("Olá mundo!");
	}
}
