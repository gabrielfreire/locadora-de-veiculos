package projeto.controller;

import projeto.model.Menu;
import projeto.view.MenuView;


public class MenuController {

	
    public void executar() {        
        

        // Faço conexão com a model para retornar as combos pela base de dados
        Menu menu = new Menu();
        
    	MenuView view = new MenuView();    	       
        view.exibirFrame(menu.getArrIdiomas(), menu.getArrAgencias());
    }
}