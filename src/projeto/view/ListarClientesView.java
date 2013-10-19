package projeto.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import projeto.model.ClientePF;
import tableModel.ClientePFTableModel;
import locale.start.StartLocale;

public class ListarClientesView extends JFrame implements ActionListener, MouseListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5974609381578763063L;
	JRadioButton radioPF = null;
	JRadioButton radioPJ = null;
	
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
		
		JPanel panelRadios = new JPanel();
		JPanel panelTabela = new JPanel();
		
		
		
		ButtonGroup group = new ButtonGroup();
		
		radioPF = new JRadioButton("Pessoa física", true);
		radioPJ = new JRadioButton("Pessoa jurídica");
		
		
		group.add(radioPF);
		group.add(radioPJ);
		
		radioPF.addMouseListener(this);
		radioPJ.addMouseListener(this);
		
		
		/****Tabela***/
		ClientePFTableModel model = new ClientePFTableModel(ClientePF.getArrayObjects());		
		
		JTable table = new JTable(model);
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
	public void actionPerformed(ActionEvent e) {
		
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Stub de método gerado automaticamente
		
		if (e.getSource() == radioPF) {
			System.out.println("Selecionei PF");
		}
		else if (e.getSource() == radioPJ) {
			System.out.println("Selecionei PJ");
		}
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
