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
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import auxiliar.Estado;
import projeto.controller.ClienteController;
import projeto.model.ClientePJ;
import locale.start.StartLocale;

public class ClientePJView extends JFrame implements ActionListener {


	private static final long serialVersionUID = 3842888543755265416L;
	
	private JLabel lblTitulo             = null;
	private JLabel lblCpf                = null;
	private JLabel lblNome               = null;
	private JLabel lblTelefone           = null;
	private JLabel lblEmail              = null;	
	private JLabel lblRazaoSocial        = null;
	private JLabel lblNomeComercial      = null;
	private JLabel lblCnpj               = null;
	private JLabel lblInscricaoEstadual  = null;
	private JLabel lblDataFundacao       = null;
	private JLabel lblNumeroFuncionarios = null;
	
	private JLabel lblEndereco = null;
	private JLabel lblCidade   = null;
	private JLabel lblEstado   = null;
	private JLabel lblCep      = null;

	private JTextField textCpf                = null;
	private JTextField textNome               = null;
	private JTextField textTelefone           = null;
	private JTextField textEmail              = null;
	private JTextField textRazaoSocial        = null;
	private JTextField textNomeComercial      = null;
	private JTextField textCnpj               = null;
	private JTextField textInscricaoEstadual  = null;
	private JTextField textDataFundacao       = null;
	private JTextField textNumeroFuncionarios = null;
	private JTextField textEndereco           = null;
	private JTextField textCidade             = null;
	private JComboBox<String> comboEstado     = null;
	private JTextField textCep                = null;
	
	private JButton btnCancelar  = null;
	private JButton btnSalvar    = null;
	private JButton btnCadastrar = null;
		
	private ClientePJ cliente = null;
	private String idioma  = null;
	
	// Internacionalização
    private ResourceBundle bundle = null;    
	
	public ClientePJView(String idioma) {
		StartLocale locale = new StartLocale(idioma);		
        this.bundle = locale.getLocale();
        this.idioma = idioma;
	}

    public void setObject(ClientePJ cliente) {
    	this.cliente = cliente;
    }
	
    
    
    public void exibirFrame() {    	
    	this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    	
    	Container c = getContentPane();
    	c.setLayout(new BorderLayout());

    	
    	JPanel panelTitulo  = new JPanel(new GridBagLayout());
    	JPanel panelDados   = new JPanel(new GridBagLayout());
    	JPanel panelBotoes  = new JPanel(new GridBagLayout());
    	
    	GridBagConstraints gbc = new GridBagConstraints();
    	
    	// Iniciar elementos
    	lblTitulo         = new JLabel(bundle.getString("LABEL_TITULO_CLIENTE_PJ"));
    	lblCpf            = new JLabel(bundle.getString("LABEL_CPF"));
    	lblNome           = new JLabel(bundle.getString("LABEL_NOME"));
    	lblTelefone       = new JLabel(bundle.getString("LABEL_TELEFONE"));
    	lblEmail          = new JLabel(bundle.getString("LABEL_EMAIL"));
    	
    	lblRazaoSocial        = new JLabel(bundle.getString("LABEL_RAZAO_SOCIAL"));
    	lblNomeComercial      = new JLabel(bundle.getString("LABEL_NOME_COMERCIAL"));
    	lblCnpj               = new JLabel(bundle.getString("LABEL_CNPJ"));
    	lblInscricaoEstadual  = new JLabel(bundle.getString("LABEL_INSC_ESTADUAL"));
    	lblDataFundacao       = new JLabel(bundle.getString("LABEL_DATA_FUNDACAO"));
    	lblNumeroFuncionarios = new JLabel(bundle.getString("LABEL_NUM_FUNCIONARIOS"));
    	
    	lblEndereco       = new JLabel(bundle.getString("LABEL_ENDERECO"));
    	lblCidade         = new JLabel(bundle.getString("LABEL_CIDADE"));
    	lblEstado         = new JLabel(bundle.getString("LABEL_ESTADO"));
    	lblCep            = new JLabel(bundle.getString("LABEL_CEP"));

    	textCpf                = new JTextField();
    	textNome               = new JTextField();
    	textTelefone           = new JTextField();
    	textEmail              = new JTextField();
    	textRazaoSocial        = new JTextField();
    	textNomeComercial      = new JTextField();
    	textCnpj               = new JTextField();
    	textInscricaoEstadual  = new JTextField();
    	textDataFundacao       = new JTextField();
    	textNumeroFuncionarios = new JTextField();
       	textEndereco           = new JTextField();
    	textCidade             = new JTextField();
    	comboEstado            = new JComboBox<String>();
    	textCep                = new JTextField();
    	
    	btnCancelar  = new JButton(bundle.getString("BTN_CANCELAR"));
    	btnSalvar    = new JButton(bundle.getString("BTN_EDITAR"));
    	btnCadastrar = new JButton(bundle.getString("BTN_CADASTRAR"));

    	btnCancelar.addActionListener(this);
    	btnSalvar.addActionListener(this);
    	btnCadastrar.addActionListener(this);
    	
    	
    	lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
    	
    	textCpf.setPreferredSize(new Dimension(175, 22));
    	textNome.setPreferredSize(new Dimension(175, 22));
    	textTelefone.setPreferredSize(new Dimension(175, 22));
    	textEmail.setPreferredSize(new Dimension(175, 22));
    	textRazaoSocial.setPreferredSize(new Dimension(175, 22));
    	textNomeComercial.setPreferredSize(new Dimension(175, 22));
    	textCnpj.setPreferredSize(new Dimension(175, 22));
    	textInscricaoEstadual.setPreferredSize(new Dimension(175, 22));
    	textDataFundacao.setPreferredSize(new Dimension(175, 22));
    	textNumeroFuncionarios.setPreferredSize(new Dimension(175, 22));
    	
    	textEndereco.setPreferredSize(new Dimension(175, 22));
    	textCidade.setPreferredSize(new Dimension(175, 22));
    	comboEstado.setPreferredSize(new Dimension(125, 22));
    	textCep.setPreferredSize(new Dimension(175, 22));
    	
    	String[] estados = Estado.getArrEstados();    	
    	for(int i=0; i<estados.length; i++) {
    		comboEstado.addItem(estados[i]);
    	}
    	
    	
    	
    	// Cliente PF
    	if (cliente != null) {
    		textCpf.setText(String.valueOf(cliente.getCpf()));
    		textNome.setText(cliente.getNome());
    		textTelefone.setText(cliente.getTelefone());
    		textEmail.setText(cliente.getEmail());
    		textRazaoSocial.setText(cliente.getRazao_social());
    		textNomeComercial.setText(cliente.getNome_comercial());
    		textCnpj.setText(String.valueOf(cliente.getCnpj())); 
    		textInscricaoEstadual.setText(cliente.getInscricao_estadual());
    		textDataFundacao.setText(cliente.getData_fundacao());
    		textNumeroFuncionarios.setText(String.valueOf(cliente.getNumero_funcionarios()));
    		textEndereco.setText(cliente.getEndereco());       
    		textCidade.setText(cliente.getCidade());         
    		comboEstado.setSelectedItem(cliente.getEstado());
    		textCep.setText(cliente.getCep());
    	}
    	
    	
    	
    	gbc.gridx = 0;
    	gbc.gridy = 0;
    	gbc.insets = new Insets(10, 0, 60, 0);
    	panelTitulo.add(lblTitulo);
    	
    	gbc.insets = new Insets(0, 0, 4, 5);
    	
    	gbc.gridx = 0;
    	gbc.gridy = 0;
    	gbc.anchor = GridBagConstraints.LINE_END;
    	panelDados.add(lblCpf, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 0;
    	gbc.anchor = GridBagConstraints.LINE_START;
    	panelDados.add(textCpf, gbc);
    	
    	gbc.gridx = 0;
    	gbc.gridy = 1;
    	gbc.anchor = GridBagConstraints.LINE_END;
    	panelDados.add(lblNome, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 1;
    	gbc.anchor = GridBagConstraints.LINE_START;
    	panelDados.add(textNome, gbc);
    	
    	gbc.gridx = 0;
    	gbc.gridy = 2;
    	gbc.anchor = GridBagConstraints.LINE_END;
    	panelDados.add(lblTelefone, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 2;
    	gbc.anchor = GridBagConstraints.LINE_START;
    	panelDados.add(textTelefone, gbc);
    	
    	/*******************/
    	gbc.gridx = 0;
    	gbc.gridy = 3;
    	gbc.anchor = GridBagConstraints.LINE_END;
    	panelDados.add(lblEmail, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 3;
    	gbc.anchor = GridBagConstraints.LINE_START;
    	panelDados.add(textEmail, gbc);
    	
    	
    	
    	gbc.gridx = 0;
    	gbc.gridy = 4;
    	gbc.anchor = GridBagConstraints.LINE_END;
    	panelDados.add(lblRazaoSocial, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 4;
    	gbc.anchor = GridBagConstraints.LINE_START;
    	panelDados.add(textRazaoSocial, gbc);
    	
    	gbc.gridx = 2;
    	gbc.gridy = 0;
    	gbc.anchor = GridBagConstraints.LINE_END;
    	panelDados.add(lblNomeComercial, gbc);
    	
    	gbc.gridx = 3;
    	gbc.gridy = 0;
    	gbc.anchor = GridBagConstraints.LINE_START;
    	panelDados.add(textNomeComercial, gbc);
    	
    	/*******************/    	
    	gbc.gridx = 2;
    	gbc.gridy = 1;
    	gbc.anchor = GridBagConstraints.LINE_END;
    	panelDados.add(lblCnpj, gbc);
    	
    	gbc.gridx = 3;
    	gbc.gridy = 1;
    	gbc.anchor = GridBagConstraints.LINE_START;
    	panelDados.add(textCnpj, gbc);
    	
    	gbc.gridx = 2;
    	gbc.gridy = 2;
    	gbc.anchor = GridBagConstraints.LINE_END;
    	panelDados.add(lblInscricaoEstadual, gbc);
    	
    	gbc.gridx = 3;
    	gbc.gridy = 2;
    	gbc.anchor = GridBagConstraints.LINE_START;
    	panelDados.add(textInscricaoEstadual, gbc);
    	
    	gbc.gridx = 2;
    	gbc.gridy = 3;
    	gbc.anchor = GridBagConstraints.LINE_END;
    	panelDados.add(lblDataFundacao, gbc);
    	
    	gbc.gridx = 3;
    	gbc.gridy = 3;
    	gbc.anchor = GridBagConstraints.LINE_START;
    	panelDados.add(textDataFundacao, gbc);
    	
    	/*******************/
    	
    	gbc.gridx = 2;
    	gbc.gridy = 4;
    	gbc.anchor = GridBagConstraints.LINE_END;
    	panelDados.add(lblNumeroFuncionarios, gbc);
    	
    	gbc.gridx = 3;
    	gbc.gridy = 4;
    	gbc.anchor = GridBagConstraints.LINE_START;
    	panelDados.add(textNumeroFuncionarios, gbc);
    	
		/********Endereço********/
    	gbc.insets = new Insets(15, 0, 4, 5);    	
    	gbc.gridx = 0;
    	gbc.gridy = 6;
    	gbc.anchor = GridBagConstraints.LINE_END;
		panelDados.add(lblEndereco, gbc);
		
    	gbc.gridx = 1;
    	gbc.gridy = 6;
    	gbc.anchor = GridBagConstraints.LINE_START;
		panelDados.add(textEndereco, gbc);
		
		gbc.insets = new Insets(0, 0, 4, 5);
    	gbc.gridx = 0;
    	gbc.gridy = 7;
    	gbc.anchor = GridBagConstraints.LINE_END;
		panelDados.add(lblCidade, gbc);
		
    	gbc.gridx = 1;
    	gbc.gridy = 7;
    	gbc.anchor = GridBagConstraints.LINE_START;
		panelDados.add(textCidade, gbc);
		
		/***********/
		gbc.insets = new Insets(15, 0, 4, 5);		
    	gbc.gridx = 2;
    	gbc.gridy = 6;
    	gbc.anchor = GridBagConstraints.LINE_END;
		panelDados.add(lblEstado, gbc);
		
    	gbc.gridx = 3;
    	gbc.gridy = 6;
    	gbc.anchor = GridBagConstraints.LINE_START;
		panelDados.add(comboEstado, gbc);
		
		gbc.insets = new Insets(0, 0, 4, 5);
    	gbc.gridx = 2;
    	gbc.gridy = 7;
    	gbc.anchor = GridBagConstraints.LINE_END;
		panelDados.add(lblCep, gbc);
		
    	gbc.gridx = 3;
    	gbc.gridy = 7;
    	gbc.anchor = GridBagConstraints.LINE_START;
		panelDados.add(textCep, gbc);

	
		/******Panel de botões******/
		
		gbc.insets = new Insets(2, 5, 20, 0);
		gbc.ipady = 7;
		
    	gbc.gridx = 0;
    	gbc.gridy = 0;    	
		panelBotoes.add(btnCancelar, gbc);
		
    	gbc.gridx = 1;
    	gbc.gridy = 0;
		panelBotoes.add(btnSalvar, gbc);
		
    	gbc.gridx = 2;
    	gbc.gridy = 0;
		panelBotoes.add(btnCadastrar, gbc);
    	
    	
		
		Border empty, compound;
		TitledBorder title;		
		
		empty = BorderFactory.createEmptyBorder(40, 0, 0, 0);
    	title = BorderFactory.createTitledBorder(bundle.getString("LABEL_SUBTITULO_CLIENTE_PJ"));
    	title.setTitleJustification(TitledBorder.CENTER);
    	
    	compound = BorderFactory.createCompoundBorder(empty, title);    	
    	panelDados.setBorder(compound);
    	
    	
    	// Add panels na tela
    	c.add(panelTitulo, BorderLayout.PAGE_START);
    	c.add(panelDados,  BorderLayout.CENTER);
    	c.add(panelBotoes, BorderLayout.PAGE_END);    	
    	
    	// Define frame
    	setResizable(false);
    	setSize(700, 450);
    	setLocation(375, 175);
    	setVisible(true);
    }
    
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnCadastrar || e.getSource() == btnSalvar) {
			
			if (textCpf.getText().isEmpty()) {
        		JOptionPane.showMessageDialog(null, "Campo CPF é obrigatório!");
        		return;
        	}
			
    		boolean cpf_valido = ClienteController.validarCPF(Long.parseLong(textCpf.getText()));    		
    		if (cpf_valido != true)
    			return;
    		
        		
			cliente = new ClientePJ();
	
			String cnpj = textCnpj.getText().isEmpty() ? "0" : textCnpj.getText(); 
			String numFunc = textNumeroFuncionarios.getText().isEmpty() ? "0" : textNumeroFuncionarios.getText();
						
        	cliente.setCpf(Long.parseLong(textCpf.getText()));
        	cliente.setNome(textNome.getText());
        	cliente.setTelefone(textTelefone.getText());
        	cliente.setEmail(textEmail.getText());
        	cliente.setEndereco(textEndereco.getText());
        	cliente.setCidade(textCidade.getText());
        	cliente.setEstado((String)comboEstado.getSelectedItem());
        	cliente.setCep(textCep.getText());
    		            	
        	cliente.setRazao_social(textRazaoSocial.getText());
        	cliente.setNome_comercial(textNomeComercial.getText());
        	cliente.setCnpj(Long.parseLong(cnpj));
        	cliente.setInscricao_estadual(textInscricaoEstadual.getText());
        	cliente.setData_fundacao(textDataFundacao.getText());
        	cliente.setNumero_funcionarios(Integer.parseInt(numFunc));
        	cliente.setTipo("PJ");
			
        	
        	if (e.getSource() == btnCadastrar) {
        		ClienteController.inserirPJ(cliente);
        		JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        		setVisible(false);
	        	
            	ListarClientesView ctlListarClientes = new ListarClientesView(idioma);
            	ctlListarClientes.exibirFrame();
        	}
        	else {
				ClienteController.editarPJ(cliente);
				JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
				setVisible(false);
        	}
        	

		}
		else if (e.getSource() == btnCancelar) {
			setVisible(false);
		}
	}
}
