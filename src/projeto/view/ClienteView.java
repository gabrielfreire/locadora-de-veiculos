package projeto.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JFrame;

import locale.start.StartLocale;

public class ClienteView extends JFrame implements ActionListener {


	private static final long serialVersionUID = 3842888543755265416L;
	
	
	
	// Internacionalização
    private ResourceBundle bundle = null;
    
	
	public ClienteView(String idioma) {
		StartLocale locale = new StartLocale(idioma);    	
        this.bundle = locale.getLocale();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
