package projeto.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import projeto.model.Cliente;
import locale.start.StartLocale;

public class ClientePFView extends JFrame implements ActionListener {


	private static final long serialVersionUID = 3842888543755265416L;
	
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
	private JTextField textGenero         = null;
	private JTextField textHabilitacao    = null;
	private JTextField textRegistro       = null;
	private JTextField textEstadoEmissor  = null;
	private JTextField textValidade       = null;	
	private JTextField textEndereco       = null;
	private JTextField textCidade         = null;
	private JTextField textEstado         = null;
	private JTextField textCep            = null;
	
	private JButton btnCancelar  = null;
	private JButton btnExcluir   = null;
	private JButton btnSalvar    = null;
	private JButton btnCadastrar = null;
	
	
	private Cliente cliente = null;
	
	// Internacionalização
    private ResourceBundle bundle = null;
    
	
	public ClientePFView(String idioma) {
		StartLocale locale = new StartLocale(idioma);    	
        this.bundle = locale.getLocale();
	}

    public void setObject(Cliente cliente) {
    	this.cliente = cliente;
    }
	
    
    
    public void exibirFrame() {    	
    	this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    	
    	Container c = getContentPane();
    	c.setLayout(new BorderLayout());
    	
    	JPanel panelDadosPessoais = new JPanel(new GridBagLayout());
    	JPanel panelDadosEndereco = new JPanel(new GridBagLayout());
    	JPanel panelBotoes        = new JPanel(new GridBagLayout());
    	
    	GridBagConstraints gbc = new GridBagConstraints();
    	
    	// Iniciar elementos
//    	instanciarElementos();
    	JLabel lblCpf            = new JLabel(bundle.getString("LABEL_CPF"));
    	JLabel lblNome           = new JLabel(bundle.getString("LABEL_NOME"));
    	JLabel lblTelefone       = new JLabel(bundle.getString("LABEL_TELEFONE"));
    	JLabel lblEmail          = new JLabel(bundle.getString("LABEL_EMAIL"));
    	JLabel lblRg             = new JLabel(bundle.getString("LABEL_RG"));
    	JLabel lblPassaporte     = new JLabel(bundle.getString("LABEL_PASSAPORTE"));
    	JLabel lblDataNascimento = new JLabel(bundle.getString("LABEL_DATA_NASCIMENTO"));
    	JLabel lblGenero         = new JLabel(bundle.getString("LABEL_GENERO"));
    	JLabel lblHabilitacao    = new JLabel(bundle.getString("LABEL_HABILITACAO"));
    	JLabel lblRegistro       = new JLabel(bundle.getString("LABEL_REGISTRO"));
    	JLabel lblEstadoEmissor  = new JLabel(bundle.getString("LABEL_ESTADO_EMISSOR"));
    	JLabel lblValidade       = new JLabel(bundle.getString("LABEL_VALIDADE"));
    	JLabel lblEndereco       = new JLabel(bundle.getString("LABEL_ENDERECO"));
    	JLabel lblCidade         = new JLabel(bundle.getString("LABEL_CIDADE"));
    	JLabel lblEstado         = new JLabel(bundle.getString("LABEL_ESTADO"));
    	JLabel lblCep            = new JLabel(bundle.getString("LABEL_CEP"));

    	JTextField textCpf            = new JTextField();
    	JTextField textNome           = new JTextField();
    	JTextField textTelefone       = new JTextField();
    	JTextField textEmail          = new JTextField();
    	JTextField textRg             = new JTextField();
    	JTextField textPassaporte     = new JTextField();
    	JTextField textDataNascimento = new JTextField();
    	JTextField textGenero         = new JTextField();
    	JTextField textHabilitacao    = new JTextField();
    	JTextField textRegistro       = new JTextField();
    	JTextField textEstadoEmissor  = new JTextField();
    	JTextField textValidade       = new JTextField();
    	JTextField textEndereco       = new JTextField();
    	JTextField textCidade         = new JTextField();
    	JTextField textEstado         = new JTextField();
    	JTextField textCep            = new JTextField();
    	
    	JButton btnCancelar  = new JButton(bundle.getString("BTN_CANCELAR"));
    	JButton btnExcluir   = new JButton(bundle.getString("BTN_EXCLUIR"));
    	JButton btnSalvar    = new JButton(bundle.getString("BTN_EDITAR"));
    	JButton btnCadastrar = new JButton(bundle.getString("BTN_CADASTRAR"));
//    	addActionListener();
    	

    	
    	textCpf.setPreferredSize(new Dimension(150, 25));
    	textNome.setPreferredSize(new Dimension(150, 25));
    	textTelefone.setPreferredSize(new Dimension(150, 25));
    	textEmail.setPreferredSize(new Dimension(150, 25));
    	textRg.setPreferredSize(new Dimension(150, 25));
    	textPassaporte.setPreferredSize(new Dimension(150, 25));
    	textDataNascimento.setPreferredSize(new Dimension(150, 25));
    	textGenero.setPreferredSize(new Dimension(150, 25));
    	textHabilitacao.setPreferredSize(new Dimension(150, 25));
    	textRegistro.setPreferredSize(new Dimension(150, 25));
    	textEstadoEmissor.setPreferredSize(new Dimension(150, 25));
    	textValidade.setPreferredSize(new Dimension(150, 25));
    	
    	
    	
    	gbc.anchor = GridBagConstraints.LINE_END;
    	gbc.insets = new Insets(0, 0, 2, 5);
    	
    	gbc.gridx = 0;
    	gbc.gridy = 0;
    	panelDadosPessoais.add(lblCpf, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 0;
    	panelDadosPessoais.add(textCpf, gbc);
    	
    	gbc.gridx = 0;
    	gbc.gridy = 1;
    	panelDadosPessoais.add(lblNome, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 1;
    	panelDadosPessoais.add(textNome, gbc);
    	
    	gbc.gridx = 0;
    	gbc.gridy = 2;
    	panelDadosPessoais.add(lblTelefone, gbc);
    	
    	gbc.gridx = 1;
    	gbc.gridy = 2;
    	panelDadosPessoais.add(textTelefone, gbc);
    	
    	/*******************/
    	gbc.gridx = 2;
    	gbc.gridy = 0;
    	panelDadosPessoais.add(lblEmail, gbc);
    	
    	gbc.gridx = 3;
    	gbc.gridy = 0;
    	panelDadosPessoais.add(textEmail, gbc);
    	
    	gbc.gridx = 2;
    	gbc.gridy = 1;
    	panelDadosPessoais.add(lblRg, gbc);
    	
    	gbc.gridx = 3;
    	gbc.gridy = 1;
    	panelDadosPessoais.add(textRg, gbc);
    	
    	gbc.gridx = 2;
    	gbc.gridy = 2;
    	panelDadosPessoais.add(lblPassaporte, gbc);
    	
    	gbc.gridx = 3;
    	gbc.gridy = 2;
    	panelDadosPessoais.add(textPassaporte, gbc);
    	
    	/*******************/    	
    	gbc.gridx = 4;
    	gbc.gridy = 0;
    	panelDadosPessoais.add(lblDataNascimento, gbc);
    	
    	gbc.gridx = 5;
    	gbc.gridy = 0;
    	panelDadosPessoais.add(textDataNascimento, gbc);
    	
    	gbc.gridx = 4;
    	gbc.gridy = 1;
    	panelDadosPessoais.add(lblGenero, gbc);
    	
    	gbc.gridx = 5;
    	gbc.gridy = 1;
    	panelDadosPessoais.add(textGenero, gbc);
    	
    	gbc.gridx = 4;
    	gbc.gridy = 2;
    	panelDadosPessoais.add(lblHabilitacao, gbc);
    	
    	gbc.gridx = 5;
    	gbc.gridy = 2;
    	panelDadosPessoais.add(textHabilitacao, gbc);
    	
    	/*******************/
    	
    	gbc.gridx = 6;
    	gbc.gridy = 0;
    	panelDadosPessoais.add(lblRegistro, gbc);
    	
    	gbc.gridx = 7;
    	gbc.gridy = 0;
    	panelDadosPessoais.add(textRegistro, gbc);
    	
    	gbc.gridx = 6;
    	gbc.gridy = 1;
    	panelDadosPessoais.add(lblEstadoEmissor, gbc);
    	
    	gbc.gridx = 7;
    	gbc.gridy = 1;
    	panelDadosPessoais.add(textEstadoEmissor, gbc);
    	
    	gbc.gridx = 6;
    	gbc.gridy = 2;
		panelDadosPessoais.add(lblValidade, gbc);
		
    	gbc.gridx = 7;
    	gbc.gridy = 2;
		panelDadosPessoais.add(textValidade, gbc);
		
		
		
//		panelDadosEndereco.add(lblEndereco, gbc);
//		panelDadosEndereco.add(textEndereco, gbc);
//		
//		panelDadosEndereco.add(lblCidade, gbc);
//		panelDadosEndereco.add(textCidade, gbc);
//		
//		panelDadosEndereco.add(lblEstado, gbc);
//		panelDadosEndereco.add(textEstado, gbc);
//		
//		panelDadosEndereco.add(lblCep, gbc);
//		panelDadosEndereco.add(textCep, gbc);
//		
//		
//		panelBotoes.add(btnCancelar, gbc);
//		panelBotoes.add(btnExcluir, gbc);
//		panelBotoes.add(btnSalvar, gbc);
//		panelBotoes.add(btnCadastrar, gbc);
    	
    	
		Border margin = BorderFactory.createEmptyBorder(25, 10, 5, 10);
    	Border title = BorderFactory.createTitledBorder("Dados Pessoais");
    	
    	Border compound = BorderFactory.createCompoundBorder(title, margin);    	
    	panelDadosPessoais.setBorder(compound);
    	
    	// Add panels na tela
    	c.add(panelDadosPessoais, BorderLayout.NORTH);
//    	c.add(panelDadosEndereco, BorderLayout.NORTH);
//    	c.add(panelBotoes,        BorderLayout.SOUTH);    	
    	
    	// Define frame
    	setResizable(false);
    	setSize(1100, 300);
    	setLocation(150, 150);
    	setVisible(true);
    }
    
	
    private void instanciarElementos() {
    	
    	JLabel lblCpf            = new JLabel(bundle.getString("LABEL_CPF"));
    	JLabel lblNome           = new JLabel(bundle.getString("LABEL_NOME"));
    	JLabel lblTelefone       = new JLabel(bundle.getString("LABEL_TELEFONE"));
    	JLabel lblEmail          = new JLabel(bundle.getString("LABEL_EMAIL"));
    	JLabel lblRg             = new JLabel(bundle.getString("LABEL_RG"));
    	JLabel lblPassaporte     = new JLabel(bundle.getString("LABEL_PASSAPORTE"));
    	JLabel lblDataNascimento = new JLabel(bundle.getString("LABEL_DATA_NASCIMENTO"));
    	JLabel lblGenero         = new JLabel(bundle.getString("LABEL_GENERO"));
    	JLabel lblHabilitacao    = new JLabel(bundle.getString("LABEL_HABILITACAO"));
    	JLabel lblRegistro       = new JLabel(bundle.getString("LABEL_REGISTRO"));
    	JLabel lblEstadoEmissor  = new JLabel(bundle.getString("LABEL_ESTADO_EMISSOR"));
    	JLabel lblValidade       = new JLabel(bundle.getString("LABEL_VALIDADE"));
    	JLabel lblEndereco       = new JLabel(bundle.getString("LABEL_ENDERECO"));
    	JLabel lblCidade         = new JLabel(bundle.getString("LABEL_CIDADE"));
    	JLabel lblEstado         = new JLabel(bundle.getString("LABEL_ESTADO"));
    	JLabel lblCep            = new JLabel(bundle.getString("LABEL_CEP"));

    	JTextField textCpf            = new JTextField();
    	JTextField textNome           = new JTextField();
    	JTextField textTelefone       = new JTextField();
    	JTextField textEmail          = new JTextField();
    	JTextField textRg             = new JTextField();
    	JTextField textPassaporte     = new JTextField();
    	JTextField textDataNascimento = new JTextField();
    	JTextField textGenero         = new JTextField();
    	JTextField textHabilitacao    = new JTextField();
    	JTextField textRegistro       = new JTextField();
    	JTextField textEstadoEmissor  = new JTextField();
    	JTextField textValidade       = new JTextField();
    	JTextField textEndereco       = new JTextField();
    	JTextField textCidade         = new JTextField();
    	JTextField textEstado         = new JTextField();
    	JTextField textCep            = new JTextField();
    	
    	JButton btnCancelar  = new JButton(bundle.getString("BTN_CANCELAR"));
    	JButton btnExcluir   = new JButton(bundle.getString("BTN_EXCLUIR"));
    	JButton btnSalvar    = new JButton(bundle.getString("BTN_EDITAR"));
    	JButton btnCadastrar = new JButton(bundle.getString("BTN_CADASTRAR"));
    }
    
    public void addElementosNoJPanel(JPanel panelDadosPessoais, JPanel panelDadosEndereco, JPanel panelBotoes) {
    
    }
    
    
    public void addActionListener() {
    	btnCancelar.addActionListener(this);
    	btnExcluir.addActionListener(this);
    	btnSalvar.addActionListener(this);
    	btnCadastrar.addActionListener(this);
    }
    
    
    public void ordenarLayout(GridBagConstraints gbc) {
    	
    }
    
    
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
