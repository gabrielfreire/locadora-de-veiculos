package projeto.controller;

import projeto.view.ListarClientesView;

public class ListarClientesController {

	private String idioma;
	
	public ListarClientesController(String idioma) {
		this.idioma = idioma;
	}
	
	public void executar() {
		ListarClientesView view = new ListarClientesView(idioma);
		view.exibirFrame();
	}
}
