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
	
	public static boolean inserir(String chassi, String placa,  String cidade, 
						   String estado, String modelo, String fabricante, 
						   int ano,       String tarifa, double km, 
						   int grupo_id,  int marca_id,  int cor_id) {
		
		Veiculo v = new Veiculo();
		v.setChassi(chassi);
		v.setPlaca(placa);
		v.setCidade(cidade);
		v.setEstado(estado);
		v.setModelo(modelo);
		v.setFabricante(fabricante);
		v.setAno(ano);
		v.setTarifaAluguel(tarifa);
		v.setKmRodado(km);
		v.setIdGrupo(grupo_id);
		v.setIdMarca(marca_id);
		v.setIdCor(cor_id);
		v.inserir();
		
		return true;
	}
	
	public boolean editar() {
		
		return true;
	}
	
	public boolean excluir() {
		
		return true;
	}

}
