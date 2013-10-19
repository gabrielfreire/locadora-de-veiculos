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
import auxiliar.Genero;
import projeto.controller.ClienteController;
import projeto.model.ClientePF;
import locale.start.StartLocale;

public class ClientePFView extends JFrame implements ActionListener {


	private static final long serialVersionUID = 3842888543755265416L;
	
	private JLabel lblTitulo         = null;
	private JLabel lblCpf            = null;
	private JLabel lblNome           = null;
	private JLabel lblTelefone       = null;
	private JLabel lblEmail          = null;	
	private JLabel lblRg             = null;
	private JLabel lblPassaporte     = null;
	private JLabel lblDataNascimento = null;
	private JLabel lblGenero         = null;
	private JLabel lblHabilitacao    = null;
	private JLabel lblRegistro       = null;
	private JLabel lblEstadoEmissor  = null;
	private JLabel lblValidade       = null;
	private JLabel lblEndereco       = null;
	private JLabel lblCidade         = null;
	private JLabel lblEstado         = null;
	private JLabel lblCep            = null;

	private JTextField textCpf            = null;
	private JTextField textNome           = null;
	private JTextField textTelefone       = null;
	private JTextField textEmail          = null;
	private JTextField textRg             = null;
	private JTextField textPassaporte     = null;
	private JTextField textDataNascimento = null;
	private JComboBox<String> comboGenero = null;
	private JTextField textHabilitacao    = null;
	private JTextField textRegistro       = null;
	private JTextField textEstadoEmissor  = null;
	private JTextField textValidade       = null;	
	private JTextField textEndereco       = null;
	private JTextField textCidade         = null;
	private JComboBox<String> comboEstado = null;
	private JTextField textCep            = null;
	
	private JButton btnCancelar  = null;
	private JButton btnSalvar    = null;
	private JButton btnCadastrar = null;
	
	
	private ClientePF cliente = null;
	
	// Internacionalização
    private ResourceBundle bundle = null;
    private String idioma  = null;
	
	public ClientePFView(String idioma) {
		StartLocale locale = new StartLocale(idioma);    	
        this.bundle = locale.getLocale();
        this.idioma = idioma;
	}

    public void setObject(ClientePF cliente) {
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
    	lblTitulo         = new JLabel(bundle.getString("LABEL_TITULO_CLIENTE_PF"));
    	lblCpf            = new JLabel(bundle.getString("LABEL_CPF"));
    	lblNome           = new JLabel(bundle.getString("LABEL_NOME"));
    	lblTelefone       = new JLabel(bundle.getString("LABEL_TELEFONE"));
    	lblEmail          = new JLabel(bundle.getString("LABEL_EMAIL"));
    	lblRg             = new JLabel(bundle.getString("LABEL_RG"));
    	lblPassaporte     = new JLabel(bundle.getString("LABEL_PASSAPORTE"));
    	lblDataNascimento = new JLabel(bundle.getString("LABEL_DATA_NASCIMENTO"));
    	lblGenero         = new JLabel(bundle.getString("LABEL_GENERO"));
    	lblHabilitacao    = new JLabel(bundle.getString("LABEL_HABILITACAO"));
    	lblRegistro       = new JLabel(bundle.getString("LABEL_REGISTRO"));
    	lblEstadoEmissor  = new JLabel(bundle.getString("LABEL_ESTADO_EMISSOR"));
    	lblValidade       = new JLabel(bundle.getString("LABEL_VALIDADE"));
    	lblEndereco       = new JLabel(bundle.getString("LABEL_ENDERECO"));
    	lblCidade         = new JLabel(bundle.getString("LABEL_CIDADE"));
    	lblEstado         = new JLabel(bundle.getString("LABEL_ESTADO"));
    	lblCep            = new JLabel(bundle.getString("LABEL_CEP"));

    	textCpf            = new JTextField();
    	textNome           = new JTextField();
    	textTelefone       = new JTextField();
    	textEmail          = new JTextField();
    	textRg             = new JTextField();
    	textPassaporte     = new JTextField();
    	textDataNascimento = new JTextField();
    	comboGenero        = new JComboBox<String>();
    	textHabilitacao    = new JTextField();
    	textRegistro       = new JTextField();
    	textEstadoEmissor  = new JTextField();
    	textValidade       = new JTextField();
    	textEndereco       = new JTextField();
    	textCidade         = new JTextField();
    	comboEstado        = new JComboBox<String>();
    	textCep            = new JTextField();
    	
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
    	textRg.setPreferredSize(new Dimension(175, 22));
    	textPassaporte.setPreferredSize(new Dimension(175, 22));
    	textDataNascimento.setPreferredSize(new Dimension(175, 22));
    	comboGenero.setPreferredSize(new Dimension(100, 22));
    	textHabilitacao.setPreferredSize(new Dimension(175, 22));
    	textRegistro.setPreferredSize(new Dimension(175, 22));
    	textEstadoEmissor.setPreferredSize(new Dimension(175, 22));
    	textValidade.setPreferredSize(new Dimension(175, 22));
    	
    	textEndereco.setPreferredSize(new Dimension(175, 22));
    	textCidade.setPreferredSize(new Dimension(175, 22));
    	comboEstado.setPreferredSize(new Dimension(125, 22));
    	textCep.setPreferredSize(new Dimension(175, 22));
    	
    	String[] generos = Genero.getArrGenero();
    	for(int i=0; i<generos.length; i++) {
    		comboGenero.addItem(generos[i]);
    	}
    	
    	String[] estados = Estado.getArrEstados();    	
    	for(int i=0; i<estados.length; i++) {
    		comboEstado.addItem(estados[i]);
    	}
    	
    	
    	
    	// Trazer dados de Cliente PF
    	if (cliente != null) {
    		textCpf.setText(String.valueOf(cliente.getCpf()));
    		textNome.setText(cliente.getNome());
    		textTelefone.setText(cliente.getTelefone());
    		textEmail.setText(cliente.getEmail());
    		textRg.setText(cliente.getRg());
    		textPassaporte.setText(cliente.getPassaporte());
    		textDataNascimento.setText(cliente.getData_nascimento()); 
    		comboGenero.setSelectedItem(cliente.getGenero());
    		textHabilitacao.setText(cliente.getHabilitacao());
    		textRegistro.setText(cliente.getRegistro());       
    		textEstadoEmissor.setText(cliente.getEstado_emissor()); 
    		textValidade.setText(cliente.getValidade());
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
    	panelDados.add(lblRg, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 4;
    	gbc.anchor = GridBagConstraints.LINE_START;
    	panelDados.add(textRg, gbc);
    	
    	gbc.gridx = 0;
    	gbc.gridy = 5;
    	gbc.anchor = GridBagConstraints.LINE_END;
    	panelDados.add(lblPassaporte, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 5;
    	gbc.anchor = GridBagConstraints.LINE_START;
    	panelDados.add(textPassaporte, gbc);
    	
    	/*******************/    	
    	gbc.gridx = 2;
    	gbc.gridy = 0;
    	gbc.anchor = GridBagConstraints.LINE_END;
    	panelDados.add(lblDataNascimento, gbc);
    	
    	gbc.gridx = 3;
    	gbc.gridy = 0;
    	gbc.anchor = GridBagConstraints.LINE_START;
    	panelDados.add(textDataNascimento, gbc);
    	
    	gbc.gridx = 2;
    	gbc.gridy = 1;
    	gbc.anchor = GridBagConstraints.LINE_END;
    	panelDados.add(lblGenero, gbc);
    	
    	gbc.gridx = 3;
    	gbc.gridy = 1;
    	gbc.anchor = GridBagConstraints.LINE_START;
    	panelDados.add(comboGenero, gbc);
    	
    	gbc.gridx = 2;
    	gbc.gridy = 2;
    	gbc.anchor = GridBagConstraints.LINE_END;
    	panelDados.add(lblHabilitacao, gbc);
    	
    	gbc.gridx = 3;
    	gbc.gridy = 2;
    	gbc.anchor = GridBagConstraints.LINE_START;
    	panelDados.add(textHabilitacao, gbc);
    	
    	/*******************/
    	
    	gbc.gridx = 2;
    	gbc.gridy = 3;
    	gbc.anchor = GridBagConstraints.LINE_END;
    	panelDados.add(lblRegistro, gbc);
    	
    	gbc.gridx = 3;
    	gbc.gridy = 3;
    	gbc.anchor = GridBagConstraints.LINE_START;
    	panelDados.add(textRegistro, gbc);
    	
    	gbc.gridx = 2;
    	gbc.gridy = 4;
    	gbc.anchor = GridBagConstraints.LINE_END;
    	panelDados.add(lblEstadoEmissor, gbc);
    	
    	gbc.gridx = 3;
    	gbc.gridy = 4;
    	gbc.anchor = GridBagConstraints.LINE_START;
    	panelDados.add(textEstadoEmissor, gbc);
    	
    	gbc.gridx = 2;
    	gbc.gridy = 5;
    	gbc.anchor = GridBagConstraints.LINE_END;
		panelDados.add(lblValidade, gbc);
		
    	gbc.gridx = 3;
    	gbc.gridy = 5;
    	gbc.anchor = GridBagConstraints.LINE_START;
		panelDados.add(textValidade, gbc);
		
		
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
    	title = BorderFactory.createTitledBorder(bundle.getString("LABEL_SUBTITULO_CLIENTE_PF"));
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
    		
    		
			cliente = new ClientePF();
								
        	cliente.setCpf(Long.parseLong(textCpf.getText()));
        	cliente.setNome(textNome.getText());
        	cliente.setTelefone(textTelefone.getText());
        	cliente.setEmail(textEmail.getText());
        	cliente.setEndereco(textEndereco.getText());
        	cliente.setCidade(textCidade.getText());
        	cliente.setEstado((String)comboEstado.getSelectedItem());
        	cliente.setCep(textCep.getText());
    		            	
        	cliente.setRg(textRg.getText());
        	cliente.setPassaporte(textPassaporte.getText());
        	cliente.setData_nascimento(textDataNascimento.getText());
        	cliente.setGenero((String)comboGenero.getSelectedItem());
        	cliente.setHabilitacao(textHabilitacao.getText());
        	cliente.setRegistro(textRegistro.getText());
        	cliente.setEstado_emissor(textEstadoEmissor.getText());
        	cliente.setValidade(textValidade.getText());
        	cliente.setTipo("PF");
			
    	
        	if (e.getSource() == btnCadastrar) {
        		ClienteController.inserirPF(cliente);
        		JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");        		
        		setVisible(false);
	        	
            	ListarClientesView ctlListarClientes = new ListarClientesView(idioma);
            	ctlListarClientes.exibirFrame();
        	}
        	else {
				ClienteController.editarPF(cliente);
				JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");				
				setVisible(false);
        	}
        	

		}
		else if (e.getSource() == btnCancelar) {
			setVisible(false);
		}
	}

}
