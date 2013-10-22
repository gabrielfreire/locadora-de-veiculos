package projeto.view;

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

public class LocacaoView extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8617045944801765155L;
	private JLabel lblTitulo         = null;
	private JLabel lblDataRetirada   = null;
	private JLabel lblDataDevolucao  = null;
	private JLabel lblCpf            = null;
	private JLabel lblAgencia        = null;
	private JLabel lblFormaPagamento = null;
	private JLabel lblVeiculo1       = null;
	private JLabel lblVeiculo2       = null;
	private JLabel lblVeiculo3       = null;
	private JLabel lblVeiculo4       = null;
	private JLabel lblVeiculo5       = null;

	private JTextField textDataRetirada           = null;
	private JTextField textDataDevolucao          = null;
	private JTextField textCpf                    = null;
	private JComboBox<String> comboAgencia        = null;
	private JComboBox<String> comboFormaPagamento = null;
	private JComboBox<String> comboVeiculo1       = null;
	private JComboBox<String> comboVeiculo2       = null;
	private JComboBox<String> comboVeiculo3       = null;
	private JComboBox<String> comboVeiculo4       = null;
	private JComboBox<String> comboVeiculo5       = null;
	
	private JButton btnCancelar  = null;
	private JButton btnSalvar    = null;
	private JButton btnCadastrar = null;
	
	
	private JTable table = null;
	private ArrayList<Locacao> locacoes = null;
	
	// Internacionalização
	private ResourceBundle bundle = null;
//	private String idioma = null;
	
	
    public LocacaoView(String idioma) {
    	StartLocale locale = new StartLocale(idioma);    	
        this.bundle = locale.getLocale();
    }
    
	
	public void exibirFrame() {
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                
		Container c = getContentPane();
		c.setLayout(new GridBagLayout());
		
				
		// Declara panels
		JPanel panelTitulo     = new JPanel(new GridBagLayout());				
		JPanel panelTabela     = new JPanel(new GridBagLayout());			
		JPanel panelFormulario = new JPanel(new GridBagLayout());
		JPanel panelBotoes     = new JPanel(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
						
		
        /***********tabela***********/        

        locacoes = Locacao.getArrObjects();
        LocacaoTableModel model = new LocacaoTableModel(locacoes);
                
        table = new JTable(model);        
        table.setPreferredScrollableViewportSize(new Dimension(730, 150));
        table.setFillsViewportHeight(true);
        
        JScrollPane scroll = new JScrollPane(table);
        scroll.setAutoscrolls(true);  
        
        table.addMouseListener(this);
        /*****fim da tabela***********/
		
        
        
        
        
        lblTitulo         = new JLabel(bundle.getString("LABEL_TITULO_LOCACAO"));
        lblDataRetirada   = new JLabel(bundle.getString("LABEL_DATA_RETIRADA"));
        lblDataDevolucao  = new JLabel(bundle.getString("LABEL_DATA_DEVOLUCAO"));
        lblCpf            = new JLabel(bundle.getString("LABEL_CPF"));
        lblAgencia        = new JLabel(bundle.getString("LABEL_AGENCIA"));
        lblFormaPagamento = new JLabel(bundle.getString("LABEL_FORMA_PAGAMENTO"));
        lblVeiculo1       = new JLabel(bundle.getString("LABEL_VEICULO1"));
        lblVeiculo2       = new JLabel(bundle.getString("LABEL_VEICULO2"));
        lblVeiculo3       = new JLabel(bundle.getString("LABEL_VEICULO3"));
        lblVeiculo4       = new JLabel(bundle.getString("LABEL_VEICULO4"));
        lblVeiculo5       = new JLabel(bundle.getString("LABEL_VEICULO5"));
        
        textDataRetirada    = new JTextField();
        textDataDevolucao   = new JTextField();
        textCpf             = new JTextField();
        comboAgencia        = new JComboBox<String>();
        comboFormaPagamento = new JComboBox<String>();
        comboVeiculo1       = new JComboBox<String>();
        comboVeiculo2       = new JComboBox<String>();
        comboVeiculo3       = new JComboBox<String>();
        comboVeiculo4       = new JComboBox<String>();
        comboVeiculo5       = new JComboBox<String>();
        
    	btnCancelar  = new JButton(bundle.getString("BTN_CANCELAR"));
    	btnSalvar    = new JButton(bundle.getString("BTN_EDITAR"));
    	btnCadastrar = new JButton(bundle.getString("BTN_CADASTRAR"));

    	btnCancelar.addActionListener(this);
    	btnSalvar.addActionListener(this);
    	btnCadastrar.addActionListener(this);
        
        textDataRetirada.setPreferredSize(new Dimension(200, 22));
        textDataDevolucao.setPreferredSize(new Dimension(200, 22));
        textCpf.setPreferredSize(new Dimension(200, 22));
        comboAgencia.setPreferredSize(new Dimension(100, 22));
        comboFormaPagamento.setPreferredSize(new Dimension(100, 22));
        comboVeiculo1.setPreferredSize(new Dimension(100, 22));
        comboVeiculo2.setPreferredSize(new Dimension(100, 22));
        comboVeiculo3.setPreferredSize(new Dimension(100, 22));
        comboVeiculo4.setPreferredSize(new Dimension(100, 22));
        comboVeiculo5.setPreferredSize(new Dimension(100, 22));
        
        
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));

        

        ArrayList<Veiculo> veiculos = Veiculo.getArrayObjects();
        
        Iterator<Veiculo> it = veiculos.iterator();
        while (it.hasNext()) {
        	Veiculo v = it.next();
        	comboVeiculo1.addItem(String.valueOf(v.getIdVeiculo()));
        	comboVeiculo2.addItem(String.valueOf(v.getIdVeiculo()));
        	comboVeiculo3.addItem(String.valueOf(v.getIdVeiculo()));
        	comboVeiculo4.addItem(String.valueOf(v.getIdVeiculo()));
        	comboVeiculo5.addItem(String.valueOf(v.getIdVeiculo()));
        }
        
        

        
        panelTitulo.add(lblTitulo);
        panelTabela.add(scroll);
        
        gbc.insets = new Insets(0, 5, 2, 0);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        panelFormulario.add(lblDataRetirada, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        panelFormulario.add(textDataRetirada, gbc);
        
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        panelFormulario.add(lblDataDevolucao, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        panelFormulario.add(textDataDevolucao, gbc);
        
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        panelFormulario.add(lblCpf, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        panelFormulario.add(textCpf, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        panelFormulario.add(lblAgencia, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        panelFormulario.add(comboAgencia, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_END;
        panelFormulario.add(lblFormaPagamento, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_START;
        panelFormulario.add(comboFormaPagamento, gbc);
        
        
        /***Veículos**/
        gbc.gridx = 2;
        gbc.gridy = 0;
        panelFormulario.add(lblVeiculo1, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 0;
        panelFormulario.add(comboVeiculo1, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        panelFormulario.add(lblVeiculo2, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 1;
        panelFormulario.add(comboVeiculo2, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 2;
        panelFormulario.add(lblVeiculo3, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 2;
        panelFormulario.add(comboVeiculo3, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 3;
        panelFormulario.add(lblVeiculo4, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 3;
        panelFormulario.add(comboVeiculo4, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 4;
        panelFormulario.add(lblVeiculo5, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 4;
        panelFormulario.add(comboVeiculo5, gbc);
        
        
        
        /***Botões****/
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(15, 15, 5, 0);
        panelBotoes.add(btnSalvar, gbc);
        

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(15, 7, 5, 0);
        panelBotoes.add(btnCadastrar, gbc);
        

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(15, 7, 5, 0);
        panelBotoes.add(btnCancelar, gbc);
        
        
        /*******Panels*******/

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(0, 0, 10, 0);
        c.add(panelTitulo, gbc);
        

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 0);
        c.add(panelTabela, gbc);


        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 0);
        c.add(panelFormulario, gbc);
        

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 0);
        c.add(panelBotoes, gbc);
        
		
		setResizable(false);
		setSize(750, 440);
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
