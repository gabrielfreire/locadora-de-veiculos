package projeto.controller;

import projeto.model.Cliente;
import projeto.model.ClientePF;
import projeto.model.ClientePJ;
import projeto.view.ClientePFView;
import projeto.view.ClientePJView;

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
	
	public void executarPJ() {
		ClientePJView cliente = new ClientePJView(idioma);
		cliente.exibirFrame();
	}
	
	
	public static boolean inserirPF(ClientePF cliente) {
		cliente.inserir();		
		return true;
	}
		
	public static boolean inserirPJ(ClientePJ cliente) {
		cliente.inserir();		
		return true;
	}
	
	public static boolean editarPF(ClientePF cliente) {
		cliente.editar();		
		return true;
	}
		
	public static boolean editarPJ(ClientePJ cliente) {
		cliente.editar();		
		return true;
	}
	
	
}
