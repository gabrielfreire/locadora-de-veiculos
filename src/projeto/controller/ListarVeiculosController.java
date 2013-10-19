package projeto.controller;

import projeto.model.Veiculo;
import projeto.view.ListarVeiculosView;

public class ListarVeiculosController {

	private String idioma;
	
	public ListarVeiculosController(String idioma) {
		this.idioma = idioma;
	}
	
	public void executar() {	
		ListarVeiculosView view = new ListarVeiculosView(idioma);
		view.exibirFrame();
	}
	
	public static boolean buscar(String busca) {
		
		
		return true;
	}
}
