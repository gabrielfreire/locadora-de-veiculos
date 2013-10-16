package projeto.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import projeto.model.Cliente;
import projeto.model.ClientePF;
import tableModel.ClientePFTableModel;
import locale.start.StartLocale;

public class ListarClientesView extends JFrame implements ActionListener {

    // Internacionalização
    private ResourceBundle bundle = null;
    private String idioma = null;
    
    
    public ListarClientesView(String idioma) {
    	StartLocale locale = new StartLocale(idioma);
    	
        this.bundle = locale.getLocale();
        this.idioma = idioma;
    }
	
	
	public void exibirFrame() {
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel panelRadios = new JPanel(new GridBagLayout());
		JPanel panelTabela = new JPanel(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		
		ButtonGroup group = new ButtonGroup();
		
		JRadioButton radioPF = new JRadioButton("Pessoa física");
		JRadioButton radioPJ = new JRadioButton("Pessoa jurídica");
		
//		radioPF.setPreferredSize(new Dimension(200, 5));
//		radioPJ.setPreferredSize(new Dimension(200, 5));
		
		group.add(radioPF);
		group.add(radioPJ);
				
		
		/****Tabela***/
		ClientePFTableModel model = new ClientePFTableModel(ClientePF.getArrayObjects());		
		
		JTable table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(430, 210));
        table.setFillsViewportHeight(true);
        
        JScrollPane scroll = new JScrollPane(table);
        scroll.setAutoscrolls(true);  
        
		/******Fim da tabela****/
		
        
        panelRadios.add(radioPF);
        panelRadios.add(radioPJ);
		panelTabela.add(scroll);
		
		c.add(panelRadios, BorderLayout.NORTH);
		c.add(panelTabela, BorderLayout.CENTER);
		
    	setResizable(false);
    	setSize(450, 300);
    	setLocation(375, 175);
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
