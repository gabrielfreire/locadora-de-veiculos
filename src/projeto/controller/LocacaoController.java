package projeto.controller;

import projeto.model.Locacao;
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
	
	public static boolean inserir(Locacao l) {
		l.inserir();
		return true;
	}
	
	public static boolean editarStatus(Locacao l) {
		l.editarStatus();
		return true;
	}
}
