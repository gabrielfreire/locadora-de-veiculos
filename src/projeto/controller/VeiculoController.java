package projeto.controller;

import projeto.model.Grupo;
import projeto.model.Veiculo;
import projeto.view.VeiculoView;

public class VeiculoController {

	public VeiculoController() {
		
	}
	
	public void executar() {
		
		VeiculoView view = new VeiculoView();
		view.exibirFrame("pt-BR", Veiculo.getArrEstados(), Veiculo.getArrAnos(), Grupo.getArrObjects());
	}
	
	public boolean inserir(String chassi, String placa,  String cidade, 
						   String estado, String modelo, String fabricante, 
						   int ano,       String marca,  String cor, 
						   String tarifa, String km,     int grupo_id) {
		
		Veiculo veiculo = new Veiculo(chassi, placa, cidade, estado, modelo, 
				                      fabricante, ano, marca, cor, tarifa, km, grupo_id);
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
