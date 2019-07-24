package com.br.zup.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MensagemNaoEncontradaException extends RuntimeException {
	public MensagemNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
}
