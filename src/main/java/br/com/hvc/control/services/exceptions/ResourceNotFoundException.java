package br.com.hvc.control.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Recurso Não Encontrado. Id: " + id);
	}

}
