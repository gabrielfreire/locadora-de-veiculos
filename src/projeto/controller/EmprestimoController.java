package projeto.controller;

import java.util.ResourceBundle;

import projeto.view.EmprestimoView;

public class EmprestimoController {

	// Internacionalização
	private ResourceBundle bundle = null;
	private String idioma = null;
	
	public EmprestimoController (String idioma) {
		this.idioma = idioma;
	}
	
	public void executar() {
		EmprestimoView view = new EmprestimoView();
		view.exibirFrame();
	}
}
