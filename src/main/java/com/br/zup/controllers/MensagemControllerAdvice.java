package com.br.zup.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.br.zup.exceptions.MensagemNaoEncontradaException;
import com.br.zup.helpers.DetalhesErro;

@RestController
@ControllerAdvice
public class MensagemControllerAdvice {
	
	@ExceptionHandler(MensagemNaoEncontradaException.class)
	public ResponseEntity<DetalhesErro> handleMensagemNaoEncontradaException(
										MensagemNaoEncontradaException e,
										WebRequest requisicao) {
		DetalhesErro detalhesErro = new DetalhesErro(e.getMessage(),
													requisicao.getDescription(false),
													HttpStatus.NOT_FOUND);
		return ResponseEntity.status(detalhesErro.getStatus()).body(detalhesErro);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<DetalhesErro> handleMethodArgumentNotValidException(
										MethodArgumentNotValidException e,
										WebRequest requisicao) {
		DetalhesErro detalhesErro = new DetalhesErro(e.getMessage(),
													 requisicao.getDescription(false),
													 HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(detalhesErro.getStatus()).body(detalhesErro);
	}
}
