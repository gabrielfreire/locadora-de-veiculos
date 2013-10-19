package projeto.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
//import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import projeto.controller.ClienteController;
import projeto.model.ClientePF;
import projeto.model.ClientePJ;
import tableModel.ClientePFTableModel;
import tableModel.ClientePJTableModel;
//import locale.start.StartLocale;

public class ListarClientesView extends JFrame implements ActionListener, MouseListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5974609381578763063L;
	
	JTable table = null;
	JRadioButton radioPF = null;
	JRadioButton radioPJ = null;
	
    // Internacionalização
//    private ResourceBundle bundle = null;
    private String idioma = null;
    
    private ArrayList<ClientePF> clientesPF = null;
    private ArrayList<ClientePJ> clientesPJ = null;
    
    public ListarClientesView(String idioma) {
    	// Vou deixar comentado pois essa tela não precisa ser internacionalizada
//    	StartLocale locale = new StartLocale(idioma);
//      this.bundle = locale.getLocale();
        this.idioma = idioma;
    }
	
    
	public void exibirFrame() {
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel panelRadios = new JPanel();
		JPanel panelTabela = new JPanel();
		
		
		
		/****Tabela***/		
		radioPF = new JRadioButton("Pessoa física", true);
		radioPJ = new JRadioButton("Pessoa jurídica");
		
		clientesPF = ClientePF.getArrayObjects();
		clientesPJ = ClientePJ.getArrayObjects();
		
		ClientePFTableModel model = new ClientePFTableModel(clientesPF);		
		table = new JTable(model);
		

		
		ButtonGroup group = new ButtonGroup();
		
		group.add(radioPF);
		group.add(radioPJ);
		
		table.addMouseListener(this);
		radioPF.addMouseListener(this);
		radioPJ.addMouseListener(this);
		
		
		table.setPreferredScrollableViewportSize(new Dimension(430, 200));
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
	public void mouseClicked(MouseEvent e) {
		
		if (e.getSource() == radioPF) {
			ClientePFTableModel novaModel = new ClientePFTableModel(ClientePF.getArrayObjects());
			table.setModel(novaModel);
		}
		else if (e.getSource() == radioPJ) {
			ClientePJTableModel novaModel = new ClientePJTableModel(ClientePJ.getArrayObjects());
			table.setModel(novaModel);
		}
		else if (e.getClickCount() == 2 && e.getSource() == table) {
			
			if (radioPF.isSelected()) {
				ClientePF cliente = clientesPF.get(table.getSelectedRow());
				
				ClienteController ctlController = new ClienteController(idioma);
				ctlController.setObject(cliente);
				ctlController.executarPF();
			}
			else {
				ClientePJ cliente = clientesPJ.get(table.getSelectedRow());
				
				ClienteController ctlController = new ClienteController(idioma);
				ctlController.setObject(cliente);
				ctlController.executarPJ();
			}
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Stub de método gerado automaticamente
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Stub de método gerado automaticamente
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Stub de método gerado automaticamente
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Stub de método gerado automaticamente
		
	}
}
