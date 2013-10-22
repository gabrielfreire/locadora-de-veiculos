package projeto.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import projeto.controller.LocacaoController;
import projeto.model.Reserva;
import tableModel.ReservaTableModel;
import locale.start.StartLocale;

public class ReservaView extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8617045944801765155L;
	private JLabel lblTitulo = null;
			
	private JButton btnNovaReserva = null;
	private JButton btnCancelar    = null;
	private JTable table = null;
	private ArrayList<Reserva> reservas = null;
	
	
	// Internacionalização
	private ResourceBundle bundle = null;
	private String idioma = null;
	
	
    public ReservaView(String idioma) {
    	StartLocale locale = new StartLocale(idioma);    	
        this.bundle = locale.getLocale();
        this.idioma = idioma;
    }
    
	
	public void exibirFrame() {
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
						
		// Declara panels
		JPanel panel = new JPanel();
		
						
		        
        lblTitulo      = new JLabel(bundle.getString("LABEL_TITULO_RESERVA"));
    	btnNovaReserva = new JButton(bundle.getString("BTN_NOVA_RESERVA"));
    	btnCancelar    = new JButton(bundle.getString("BTN_CANCELAR"));

    	btnNovaReserva.addActionListener(this);
    	btnCancelar.addActionListener(this);
    	    	        
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));

        /***********tabela***********/        

        reservas = Reserva.getArrObjects();
        ReservaTableModel model = new ReservaTableModel(reservas);
                
        table = new JTable(model);        
        table.setPreferredScrollableViewportSize(new Dimension(730, 170));
        table.setFillsViewportHeight(true);
        
        JScrollPane scroll = new JScrollPane(table);
        scroll.setAutoscrolls(true);  
        
        table.addMouseListener(this);
        /*****fim da tabela***********/

        

        panel.add(lblTitulo);
        panel.add(scroll);
        panel.add(btnNovaReserva);
        panel.add(btnCancelar);
                
        c.add(panel);
        
		setResizable(false);
		setSize(750, 300);
		setLocation(200, 150);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnCancelar) {
			setVisible(false);
		}
		else if (e.getSource() == btnNovaReserva) {
			setVisible(false);
			LocacaoController ctlLocacao = new LocacaoController(idioma);
			ctlLocacao.executar();
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Stub de método gerado automaticamente
		
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
