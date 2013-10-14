package projeto.controller;

import projeto.model.Cliente;

public class ClienteController {

	private String idioma   = null;
	private Cliente cliente = null; 
	
	
	public ClienteController(String idioma) {
		this.idioma = idioma;
	}

	public void setObject(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void executar() {
		
	}
}
