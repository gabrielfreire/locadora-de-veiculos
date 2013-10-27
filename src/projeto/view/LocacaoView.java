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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import locale.start.StartLocale;
import projeto.controller.LocacaoController;
import projeto.controller.PagamentoController;
import projeto.model.Agencia;
import projeto.model.Cliente;
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
	private JLabel lblVeiculo1       = null;
	private JLabel lblVeiculo2       = null;
	private JLabel lblVeiculo3       = null;
	private JLabel lblVeiculo4       = null;

	private JTextField textDataRetirada           = null;
	private JTextField textDataDevolucao          = null;
	private JTextField textCpf                    = null;
	private JComboBox<String> comboAgencia        = null;
	private JComboBox<String> comboVeiculo1       = null;
	private JComboBox<String> comboVeiculo2       = null;
	private JComboBox<String> comboVeiculo3       = null;
	private JComboBox<String> comboVeiculo4       = null;
	private JCheckBox checkReservar1              = null;
	private JCheckBox checkReservar2              = null;
	private JCheckBox checkReservar3              = null;
	private JCheckBox checkReservar4              = null;
	
	
	private JButton btnCancelar  = null;
	private JButton btnSalvar    = null;
	private JButton btnFinalizar = null;
	
	
	private JTable table = null;
	private ArrayList<Locacao> locacoes = null;
	private ArrayList<Agencia> agencias = null;
	
	
	// Internacionalização
	private ResourceBundle bundle = null;
	private String idioma = null;
	
	
    public LocacaoView(String idioma) {
    	StartLocale locale = new StartLocale(idioma);    	
        this.bundle = locale.getLocale();
        this.idioma = idioma;
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
		
        
        MaskFormatter mascaraData = null;
		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}  
        
        
        lblTitulo         = new JLabel(bundle.getString("LABEL_TITULO_LOCACAO"));
        lblDataRetirada   = new JLabel(bundle.getString("LABEL_DATA_RETIRADA"));
        lblDataDevolucao  = new JLabel(bundle.getString("LABEL_DATA_DEVOLUCAO"));
        lblCpf            = new JLabel(bundle.getString("LABEL_CPF"));
        lblAgencia        = new JLabel(bundle.getString("LABEL_AGENCIA"));
        lblVeiculo1       = new JLabel(bundle.getString("LABEL_VEICULO1"));
        lblVeiculo2       = new JLabel(bundle.getString("LABEL_VEICULO2"));
        lblVeiculo3       = new JLabel(bundle.getString("LABEL_VEICULO3"));
        lblVeiculo4       = new JLabel(bundle.getString("LABEL_VEICULO4"));
        
        textDataRetirada    = new JFormattedTextField(mascaraData);
        textDataDevolucao   = new JFormattedTextField(mascaraData);
        textCpf             = new JTextField();
        comboAgencia        = new JComboBox<String>();
        comboVeiculo1       = new JComboBox<String>();
        comboVeiculo2       = new JComboBox<String>();
        comboVeiculo3       = new JComboBox<String>();
        comboVeiculo4       = new JComboBox<String>();
        checkReservar1      = new JCheckBox(bundle.getString("CHECKBOX_RESERVAR"));
        checkReservar2      = new JCheckBox(bundle.getString("CHECKBOX_RESERVAR"));
        checkReservar3      = new JCheckBox(bundle.getString("CHECKBOX_RESERVAR"));
        checkReservar4      = new JCheckBox(bundle.getString("CHECKBOX_RESERVAR"));
        
        
    	btnCancelar  = new JButton(bundle.getString("BTN_CANCELAR"));
    	btnSalvar    = new JButton(bundle.getString("BTN_EDITAR"));
    	btnFinalizar = new JButton(bundle.getString("BTN_FINALIZAR"));

    	btnCancelar.addActionListener(this);
    	btnSalvar.addActionListener(this);
    	btnFinalizar.addActionListener(this);
        
    	
    	
        textDataRetirada.setPreferredSize(new Dimension(200, 22));
        textDataDevolucao.setPreferredSize(new Dimension(200, 22));
        textCpf.setPreferredSize(new Dimension(200, 22));
        comboAgencia.setPreferredSize(new Dimension(200, 22));
        comboVeiculo1.setPreferredSize(new Dimension(100, 22));
        comboVeiculo2.setPreferredSize(new Dimension(100, 22));
        comboVeiculo3.setPreferredSize(new Dimension(100, 22));
        comboVeiculo4.setPreferredSize(new Dimension(100, 22));
        
        
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        
        
        checkReservar1.setFont(new Font("Arial", Font.BOLD, 11));
        checkReservar2.setFont(new Font("Arial", Font.BOLD, 11));
        checkReservar3.setFont(new Font("Arial", Font.BOLD, 11));
        checkReservar4.setFont(new Font("Arial", Font.BOLD, 11));

        

        ArrayList<Veiculo> veiculos = Veiculo.getArrayObjects();
        
        Iterator<Veiculo> itVeiculo = veiculos.iterator();
        while (itVeiculo.hasNext()) {
        	Veiculo v = itVeiculo.next();
        	comboVeiculo1.addItem(String.valueOf(v.getIdVeiculo()));
        	comboVeiculo2.addItem(String.valueOf(v.getIdVeiculo()));
        	comboVeiculo3.addItem(String.valueOf(v.getIdVeiculo()));
        	comboVeiculo4.addItem(String.valueOf(v.getIdVeiculo()));
        }
        
        agencias = Agencia.getArrayObjects();
        
        Iterator<Agencia> itAgencia = agencias.iterator();
        while (itAgencia.hasNext()) {
        	Agencia a = itAgencia.next(); 
        	comboAgencia.addItem(String.valueOf(a.getNome()));
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
        
        
        
        
        gbc.gridx = 4;
        gbc.gridy = 0;
        panelFormulario.add(checkReservar1, gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 1;
        panelFormulario.add(checkReservar2, gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 2;
        panelFormulario.add(checkReservar3, gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 3;
        panelFormulario.add(checkReservar4, gbc);
        
        
        
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
        panelBotoes.add(btnFinalizar, gbc);
        

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
		setSize(750, 420);
		setLocation(200, 150);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnFinalizar) {
			
			
			if (textCpf.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "CPF é obrigatório", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			long cpf = Long.parseLong(textCpf.getText());			
			
			if (Cliente.consultar(cpf) == false) {
				JOptionPane.showMessageDialog(null, "Este cliente não se encontra na base de dados!", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (Locacao.checar(cpf)) {
				JOptionPane.showMessageDialog(null, "Este cliente possui uma locação em andamento.\n"
						+ "Por favor aguarde a devolução para efetuar um novo empréstimo!", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			int idAgenciaSelecionada = agencias.get(comboAgencia.getSelectedIndex()).getCodigo();						
			 
			
			Locacao l = new Locacao();
			l.setData_retirada(textDataRetirada.getText());
			l.setData_devolucao(textDataDevolucao.getText());
			l.setCpf(cpf);
			l.setAgencia_id(idAgenciaSelecionada);
			l.setPagamento_id(0); // será inserido na próxima etapa
			LocacaoController.inserir(l);
			
			
						
			int idVeiculo1 = Integer.parseInt((String) comboVeiculo1.getSelectedItem());
			int idVeiculo2 = Integer.parseInt((String) comboVeiculo2.getSelectedItem());
			int idVeiculo3 = Integer.parseInt((String) comboVeiculo3.getSelectedItem());
			int idVeiculo4 = Integer.parseInt((String) comboVeiculo4.getSelectedItem());
			
			l.inserirItem(idVeiculo1);
			l.inserirItem(idVeiculo2);
			l.inserirItem(idVeiculo3);
			l.inserirItem(idVeiculo4);
			
			// Abre tela de pagamento
			setVisible(false);
			PagamentoController ctlPagamento = new PagamentoController(idioma);
			ctlPagamento.setObjectLocacao(l);
			ctlPagamento.executar();
		}
		else if (e.getSource() == btnCancelar) {
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
