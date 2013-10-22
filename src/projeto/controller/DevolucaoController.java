package projeto.controller;

import projeto.view.DevolucaoView;




public class DevolucaoController {

	// Internacionalização
	private String idioma = null;
	
	public DevolucaoController (String idioma) {
		this.idioma = idioma;
	}
	
	public void executar() {
		DevolucaoView view = new DevolucaoView(idioma);
		view.exibirFrame();
	}
}
