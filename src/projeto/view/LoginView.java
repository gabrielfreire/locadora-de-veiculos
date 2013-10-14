package projeto.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import projeto.controller.LoginController;
import projeto.controller.MenuController;

public class LoginView extends JFrame implements ActionListener {


    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private JMenuBar barra;
    private JMenu menuArquivo;
    private JMenuItem itemArquivoSobre;
    private JMenuItem itemArquivoFechar;    
    
    private JLabel lblTitulo;
    private JLabel lblLogin;
    private JLabel lblSenha;

    private JTextField textLogin;
    private JPasswordField textSenha;

    private JButton btnEntrar;
    private JButton btnSair;
    
    
    public void exibirFrame() {
        
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
        Container c = getContentPane();
        c.setLayout(new BorderLayout());	
        
        
        JPanel panel = new JPanel(new GridBagLayout());        
        GridBagConstraints gbc = new GridBagConstraints();  
        
        /**
         * Monta o menu
         */
        barra = new JMenuBar();
        setJMenuBar(barra);
        
        menuArquivo = new JMenu("Arquivo");
        
        
        itemArquivoSobre = new JMenuItem("Sobre");
        itemArquivoFechar = new JMenuItem("Sair");
        
        // Extendendo a largura do primeiro
        itemArquivoSobre.setPreferredSize(new Dimension(120, 20));
        
        menuArquivo.add(itemArquivoSobre);
        menuArquivo.add(itemArquivoFechar);
        
        barra.add(menuArquivo);
        
        itemArquivoSobre.addActionListener(this);
        itemArquivoFechar.addActionListener(this);
        
        
        /**
         * Componentes
         */
        lblTitulo = new JLabel("Fazer login");
        lblLogin  = new JLabel("Email:");
        lblSenha  = new JLabel("Senha:");

        textLogin = new JTextField();
        textSenha = new JPasswordField();

        btnEntrar = new JButton("Entrar");
        btnSair   = new JButton("Sair");

        /**
         * Acionar evento dos botões
         */
        btnEntrar.addActionListener(this);
        btnSair.addActionListener(this);
        
        /**
         * Propriedades dos campos
         */
        textLogin.setFocusable(true);
        
        Dimension dTextBox = new Dimension(200, 22);
        textLogin.setPreferredSize(dTextBox);
        textSenha.setPreferredSize(dTextBox);

//        panel.setBorder(BorderFactory.createTitledBorder("Title"));
        
        
        
      
        /**
         * Add layout
         */
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(0, 0, 5, 0);
        gbc.anchor = GridBagConstraints.SOUTH;
        panel.add(lblTitulo, gbc);
         
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(lblLogin, gbc);
                   
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 0, 0, 0);
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(textLogin, gbc);
          
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(2, 0, 0, 5);
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(lblSenha, gbc);
          
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(2, 0, 0, 0);
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(textSenha, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 55, 0, 0);
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        gbc.ipady = 7;
        panel.add(btnSair, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 0, 0, 0);
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        gbc.ipady = 7;
        panel.add(btnEntrar, gbc);
        
        /**
         * Mostrar view
         */
        
        c.add(panel, BorderLayout.CENTER);
        
        setTitle("Locadora de automóveis");
        setResizable(false);        
        setSize(400, 200);
        setLocation(470, 280);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnSair) {
            System.exit(0);
        }
        else if (e.getSource() == btnEntrar) {
            
            String email = textLogin.getText();
            String senha = String.valueOf(textSenha.getPassword());
            
            LoginController ctrlLogin = new LoginController();
            boolean logado = ctrlLogin.validar(email, senha);
            
            if (logado) {            
            	setVisible(false);            	
            	MenuController ctlMenu = new MenuController();
            	ctlMenu.executar();
            }
            else {
            	JOptionPane.showMessageDialog(null, "Dados inválidos, tente novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
        }        
        else if (e.getSource() == itemArquivoSobre) {
			JOptionPane.showMessageDialog(null, "Sistema para locadora de veículos\n\n"
					+ "Gabriel Freire RA 201210027\n"
					+ "Vanessa Souza Pinto RA 201204604\n\n"
					+ "Universidade São Judas Tadeu - Butantã\n"
					+ "2 MSIN", "Sobre a locadora", JOptionPane.INFORMATION_MESSAGE
					);
		}
        else if (e.getSource() == itemArquivoFechar) {
        	System.exit(0);
        }
    }
}