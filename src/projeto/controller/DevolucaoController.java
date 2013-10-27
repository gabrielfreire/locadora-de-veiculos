package projeto.controller;

import projeto.model.Devolucao;
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
	
	public static boolean inserir(Devolucao d) {
		d.inserir();
		return true;
	}
}
