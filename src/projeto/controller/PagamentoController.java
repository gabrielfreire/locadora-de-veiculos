package projeto.controller;

import projeto.model.Locacao;
import projeto.model.Pagamento;
import projeto.view.PagamentoView;

public class PagamentoController {

	private Locacao locacao = null;
	private String idioma = null;
	
	
	public PagamentoController(String idioma) {
		this.idioma = idioma;
	}
	

	public void setObjectLocacao(Locacao locacao) {
		this.locacao = locacao;
	}	
	
	public void executar() {
		PagamentoView view = new PagamentoView(idioma);
		view.setObjectLocacao(locacao);
		view.exibirFrame();
	}	
	
	public static boolean inserirCheque(Pagamento p) {
		p.inserirCheque();
		return true;
	}
	public static boolean inserirCredito(Pagamento p) {
		p.inserirCredito();
		return true;
	}
}
