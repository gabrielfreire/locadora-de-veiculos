package projeto.controller;

import projeto.view.ReservaView;




public class ReservaController {

	// Internacionalização
	private String idioma = null;
	
	public ReservaController (String idioma) {
		this.idioma = idioma;
	}
	
	public void executar() {
		ReservaView view = new ReservaView(idioma);
		view.exibirFrame();
	}
}
