package projeto.controller;

import projeto.model.Cor;
import projeto.model.Grupo;
import projeto.model.Marca;
import projeto.model.Veiculo;
import projeto.view.VeiculoView;

public class VeiculoController {

	private String idioma;
	
	public VeiculoController(String idioma) {
		this.idioma = idioma;
	}
	
	public void executar() {		
		VeiculoView view = new VeiculoView(idioma);
		
		view.exibirFrame(Veiculo.getArrEstados(), Veiculo.getArrAnos(), 
				         Grupo.getArrObjects(),   Marca.getArrObjects(), 
				         Cor.getArrObjects());
	}
	
	public static boolean inserir(String chassi, String placa,  String cidade, 
						   String estado, String modelo, String fabricante, 
						   int ano,       String marca,  String cor, 
						   String tarifa, double km,     int grupo_id,
						   int marca_id, int cor_id) {
		
		Veiculo veiculo = new Veiculo();
		veiculo.setChassi(chassi);
		veiculo.setPlaca(placa);
		veiculo.setCidade(cidade);
		veiculo.setEstado(estado);
		veiculo.setModelo(modelo);
		veiculo.setFabricante(fabricante);
		veiculo.setAno(ano);
		veiculo.setMarca(marca);
		veiculo.setCor(cor);
		veiculo.setTarifaAluguel(tarifa);
		veiculo.setKmRodado(km);
		veiculo.setIdGrupo(grupo_id);
		veiculo.setIdMarca(marca_id);
		veiculo.setIdCor(cor_id);
		veiculo.inserir();
		
		return true;
	}
	
	public boolean editar() {
		
		return true;
	}
	
	public boolean excluir() {
		
		return true;
	}

}
