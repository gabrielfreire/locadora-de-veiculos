package projeto.controller;

import projeto.model.Login;
import projeto.view.LoginView;

public class LoginController {

	public static void main(String[] args) {		
		LoginView view = new LoginView();
		view.exibirFrame();
	}
	
	public boolean validar(String email, String senha) {		
		Login login = new Login();
		return login.validar(email, senha);	
	}
}
