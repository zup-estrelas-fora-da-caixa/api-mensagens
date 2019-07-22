package com.br.zup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.zup.models.Mensagem;
import com.br.zup.services.MensagemService;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {
	@Autowired
	private MensagemService mensagemService;
	
	@GetMapping("/olaMundo")
	public ResponseEntity getOlaMundo() {
		return ResponseEntity.ok("Olá mundo!");
	}

	@GetMapping
	public ResponseEntity pegarMensagens() {
		if(mensagemService.quantidadeDeMensagens() > 0) {
			return ResponseEntity.ok(mensagemService.pegarMensagens());
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Mensagem> criarMensagem(@RequestBody Mensagem mensagem) {
		mensagemService.salvarMensagem(mensagem);
		return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);
	}
}
