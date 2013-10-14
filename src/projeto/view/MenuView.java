package projeto.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import projeto.controller.ListarVeiculosController;

public class MenuView extends JFrame implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private JLabel lblTitulo;
    private JLabel lblIdioma;
    private JLabel lblAgencia;

    private JComboBox<String> comboIdioma;
    private JComboBox<String> comboAgencia;

    private JButton btnSair;
    private JButton btnOK;

    
    public void exibirFrame(ArrayList<String> arrayIdiomas, ArrayList<String> arrayAgencias) {
    	
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JPanel panelTitulo = new JPanel();
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        lblTitulo = new JLabel("Selecione as opções para continuar...");
        lblIdioma = new JLabel("Idioma:");
        lblAgencia = new JLabel("Agência:");

        comboIdioma = new JComboBox<String>();
        comboAgencia = new JComboBox<String>();

        btnSair = new JButton("Sair");
        btnOK = new JButton("OK");

        lblTitulo.setForeground(new Color(137, 104, 205));
        panelTitulo.setBackground(new Color(232, 232, 232));
        
        /**
         * Listar combos
         */
    	for (int i=0; i < arrayIdiomas.size(); i++) {
    		comboIdioma.addItem(arrayIdiomas.get(i));
    	}    	
    	
    	for (int i=0; i < arrayAgencias.size(); i++) {
    		comboAgencia.addItem(arrayAgencias.get(i));
    	}
    	arrayIdiomas.clear();
    	arrayAgencias.clear();
    	
        btnSair.addActionListener(this);
        btnOK.addActionListener(this);
        
        
        /**
         * 
         */
        panelTitulo.add(lblTitulo);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 5, 5);
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(lblIdioma, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(comboIdioma, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 10, 5);
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(lblAgencia, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(comboAgencia, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 0, 60);
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.ipady = 7;
        panel.add(btnSair, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.ipady = 7;
        panel.add(btnOK, gbc);

        c.add(panelTitulo, BorderLayout.NORTH);
        c.add(panel, BorderLayout.CENTER);

        setTitle("BEM VINDO A LOCADORA");
        setSize(550, 220);
        setLocation(420, 275);
        setVisible(true);
    }
    

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnSair) {
        	System.exit(0);
        }
        else if (e.getSource() == btnOK) {
            
            setVisible(false);            
            String idiomaEscolhido = (String)comboIdioma.getSelectedItem();
//            String agenciaEscolhida = (String)this.comboAgencia.getSelectedItem(); //ainda não sei como usarei isso
            
            ListarVeiculosController ctrListarVeiculos = new ListarVeiculosController(idiomaEscolhido);
            ctrListarVeiculos.executar();
        }
    }
}