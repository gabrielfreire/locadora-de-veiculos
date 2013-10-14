package projeto.controller;

import projeto.model.Menu;
import projeto.view.MenuView;


public class MenuController {
	
    public void executar() { 
    	MenuView view = new MenuView();    	       
        view.exibirFrame(Menu.getArrIdiomas(), Menu.getArrAgencias());
    }
}