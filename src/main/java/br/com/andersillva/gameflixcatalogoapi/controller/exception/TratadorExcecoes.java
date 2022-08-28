package br.com.andersillva.gameflixcatalogoapi.controller.exception;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.andersillva.gameflixcatalogoapi.domain.service.exception.RegistroNaoEncontradoException;

@ControllerAdvice
public class TratadorExcecoes {

	@ExceptionHandler(br.com.andersillva.gameflixcatalogoapi.domain.service.exception.RegistroNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public RespostaPadraoErro responderErro(RegistroNaoEncontradoException e, HttpServletRequest request){
		return new RespostaPadraoErro(HttpStatus.NOT_FOUND.value(), e.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public RespostaPadraoErro responderErro(MethodArgumentNotValidException e, HttpServletRequest request){
		return new RespostaPadraoErro(HttpStatus.BAD_REQUEST.value(), "Parâmetro(s) obrigatório(s) não informado(s).");
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<RespostaPadraoErro> responderErro(Exception e, HttpServletRequest request){
		Throwable resultCause = getResultCause(e);
	    if (resultCause instanceof SQLIntegrityConstraintViolationException) {
			RespostaPadraoErro resposta = new RespostaPadraoErro(HttpStatus.CONFLICT.value(), "Registro não pode ser excluído, pois possui dependências."); 
			return ResponseEntity.status(HttpStatus.CONFLICT).body(resposta);
	    } else {
	    	RespostaPadraoErro resposta = new RespostaPadraoErro(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ocorreu um erro interno no servidor. Por favor, tente novamente mais tarde.");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resposta);
	    }
	}

	private Throwable getResultCause(Exception e) {
		Throwable cause, resultCause = e;
	    while ((cause = resultCause.getCause()) != null && resultCause != cause) {
	        resultCause = cause;
	    }
	    return resultCause;
	}

}