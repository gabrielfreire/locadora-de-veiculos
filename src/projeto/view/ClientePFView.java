package projeto.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import projeto.model.Cliente;
import locale.start.StartLocale;

public class ClientePFView extends JFrame implements ActionListener {


	private static final long serialVersionUID = 3842888543755265416L;
	
	private int    lblCpf            = 0;
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
    	
    	
    	setSize(600, 500);
    	setLocation(375, 150);
    	setVisible(true);
    }
    
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
