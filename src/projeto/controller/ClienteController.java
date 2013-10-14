package projeto.controller;

import projeto.model.Cliente;
import projeto.view.ClientePFView;

public class ClienteController {

	private String idioma   = null;
	private Cliente cliente = null; 
	
	
	public ClienteController(String idioma) {
		this.idioma = idioma;
	}

	public void setObject(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void executarPF() {
		ClientePFView cliente = new ClientePFView(idioma);
		cliente.exibirFrame();
	}
}
