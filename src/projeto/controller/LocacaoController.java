package projeto.controller;

import projeto.view.LocacaoView;



public class LocacaoController {

	// Internacionalização
	private String idioma = null;
	
	public LocacaoController (String idioma) {
		this.idioma = idioma;
	}
	
	public void executar() {
		LocacaoView view = new LocacaoView(idioma);
		view.exibirFrame();
	}
}
