package projeto.controller;

import projeto.model.Cor;
import projeto.model.Grupo;
import projeto.model.Marca;
import projeto.model.Veiculo;
import projeto.view.VeiculoView;

public class VeiculoController {

	private String idioma   = null;
	private Veiculo veiculo = null; 
	
	public VeiculoController(String idioma) {
		this.idioma = idioma;
	}
	
    public void setObject(Veiculo veiculo) {
    	this.veiculo = veiculo;
    }
    
	public void executar() {		
		VeiculoView view = new VeiculoView(idioma);
		view.setObject(veiculo);
		
		view.exibirFrame(Veiculo.getArrEstados(), Veiculo.getArrAnos(), 
				         Grupo.getArrObjects(),   Marca.getArrObjects(), 
				         Cor.getArrObjects());
	}
	
	public static boolean inserir(Veiculo veiculo) {		
		veiculo.inserir();		
		
		return true;
	}
	
	public static boolean editar() {
		
		return true;
	}
	
	public static boolean excluir() {
		
		return true;
	}

}
