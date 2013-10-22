package projeto.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import locale.start.StartLocale;
import projeto.model.Locacao;
import projeto.model.Veiculo;
import tableModel.LocacaoTableModel;

public class DevolucaoView extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8617045944801765155L;
	private JLabel lblTitulo     = null;
	private JLabel lblNumLocacao = null;
	private JLabel lblCpf        = null;
	private JLabel lblData       = null;
	private JLabel lblMulta      = null;

	private JTextField textCpf        = null;
	private JTextField textNumLocacao = null;
	private JTextField textData       = null;
	private JTextField textMulta      = null;
		
	private JButton btnLocalizar          = null;
	private JButton btnConfirmarDevolucao = null;
	private JButton btnCancelar           = null;
	
	
	// Internacionalização
	private ResourceBundle bundle = null;
//	private String idioma = null;
	
	
    public DevolucaoView(String idioma) {
    	StartLocale locale = new StartLocale(idioma);    	
        this.bundle = locale.getLocale();
    }
    
	
	public void exibirFrame() {
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
						
		// Declara panels
		JPanel panelTitulo     = new JPanel(new GridBagLayout());
		JPanel panelFormulario = new JPanel(new GridBagLayout());
		JPanel panelBotoes     = new JPanel(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
						
		        
        lblTitulo      = new JLabel(bundle.getString("LABEL_TITULO_DEVOLUCAO"));
        lblCpf         = new JLabel(bundle.getString("LABEL_CPF"));
        lblNumLocacao  = new JLabel(bundle.getString("LABEL_NUM_LOCACAO"));
        lblData        = new JLabel(bundle.getString("LABEL_DATA_DEVOLUCAO"));
        lblMulta       = new JLabel(bundle.getString("LABEL_MULTA"));
        
        textCpf        = new JTextField();
        textNumLocacao = new JTextField();
        textData       = new JTextField();
        textMulta      = new JTextField();
        
        btnLocalizar          = new JButton(bundle.getString("BTN_LOCALIZAR"));
    	btnConfirmarDevolucao = new JButton(bundle.getString("BTN_CONFIRMAR_DEVOLUCAO"));
    	btnCancelar           = new JButton(bundle.getString("BTN_CANCELAR"));

    	btnConfirmarDevolucao.addActionListener(this);
    	btnCancelar.addActionListener(this);
    	    	
    	textCpf.setPreferredSize(new Dimension(200, 22));
        textNumLocacao.setPreferredSize(new Dimension(200, 22));
        textData.setPreferredSize(new Dimension(200, 22));
        textMulta.setPreferredSize(new Dimension(200, 22));
                
        
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));


        

        panelTitulo.add(lblTitulo);
        
        
        gbc.insets = new Insets(0, 0, 5, 0);
        
        gbc.gridx = 0;
        gbc.gridy = 0;        
        panelFormulario.add(lblNumLocacao, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelFormulario.add(textNumLocacao, gbc);
        

        gbc.gridx = 0;
        gbc.gridy = 2;
        panelFormulario.add(btnLocalizar, gbc);
        
        
        gbc.insets = new Insets(20, 0, 5, 0);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelFormulario.add(lblCpf, gbc);
        
        
        gbc.insets = new Insets(0, 0, 5, 0);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        panelFormulario.add(textCpf, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        panelFormulario.add(lblData, gbc);
        
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        panelFormulario.add(textData, gbc);
        
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        panelFormulario.add(lblMulta, gbc);
                
        gbc.gridx = 0;
        gbc.gridy = 8;
        panelFormulario.add(textMulta, gbc);
        
        
        gbc.insets = new Insets(20, 5, 15, 0);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelBotoes.add(btnConfirmarDevolucao, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        panelBotoes.add(btnCancelar, gbc);
        
        
        
        
        c.add(panelTitulo, BorderLayout.NORTH);
        c.add(panelFormulario, BorderLayout.CENTER);
        c.add(panelBotoes, BorderLayout.SOUTH);
		
		setResizable(false);
		setSize(380, 400);
		setLocation(200, 150);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnCancelar) {
			setVisible(false);
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
