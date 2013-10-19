package projeto.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import projeto.controller.ClienteController;
import projeto.controller.ListarClientesController;
import projeto.controller.VeiculoController;
import projeto.model.Veiculo;
import tableModel.VeiculoTableModel;
import locale.start.StartLocale;

public class ListarVeiculosView extends JFrame implements ActionListener, MouseListener {

	
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private JMenuBar barra;
    
    private JMenu menuArquivo;
    private JMenuItem itemArquivoSair;    
    private JMenu menuEmprestimos;
    private JMenuItem itemEmprestimosCadastro;    
    private JMenu menuReservas;
    private JMenuItem itemReservasCadastro;    
    private JMenu menuDevolucoes;
    private JMenuItem itemDevolucoesRegistrar;    
    private JMenu menuClientes;
    private JMenuItem itemClientePFCadastro; 
    private JMenuItem itemClientePJCadastro;
    private JMenuItem itemClientesLista;
    private JMenu menuVeiculos;
    private JMenuItem itemVeiculosCadastro;  
    private JMenu menuPagamentos;    
    private JMenu menuRelatorios;    
    
    private JLabel lblBuscar;
    private JTextField textBuscar;
    private JButton btnBuscar;
    
    private JTable table;
    private JButton btnSair;
    private JButton btnNovaReserva;
    private JButton btnNovoEmprestimo;
    
    // Internacionalização
    private ResourceBundle bundle = null;
    private String idioma = null;
    
    private ArrayList<Veiculo> veiculos = null;
    
    
    public ListarVeiculosView(String idioma) {
    	StartLocale locale = new StartLocale(idioma);
    	
        this.bundle = locale.getLocale();
        this.idioma = idioma;
    }
    
    /**
     * @param args
     */
    public void exibirFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container c = this.getContentPane();   
        c.setLayout(new BorderLayout());
        GridBagConstraints gbc = new GridBagConstraints();  
    
        // Define panels
        JPanel panelHeader = new JPanel();
        panelHeader.setLayout(new GridBagLayout());        
        
        JPanel panelBody = new JPanel();
        panelBody.setLayout(new GridBagLayout());     
        
        JPanel panelFooter = new JPanel();
        panelFooter.setLayout(new GridBagLayout());     
        
        
        /**
         * Inicia elementos
         */
        lblBuscar = new JLabel(bundle.getString("LABEL_BUSCAR"));
        textBuscar = new JTextField();
        textBuscar.setPreferredSize(new Dimension(200, 25));
        
        
        btnBuscar          = new JButton(bundle.getString("BTN_BUSCAR"));
        btnSair            = new JButton(bundle.getString("BTN_SAIR"));
        btnNovaReserva     = new JButton(bundle.getString("BTN_NOVA_RESERVA"));
        btnNovoEmprestimo  = new JButton(bundle.getString("BTN_NOVO_EMPRESTIMO"));
        
        
        btnBuscar.addActionListener(this);
        btnSair.addActionListener(this);
        btnNovaReserva.addActionListener(this);
        btnNovoEmprestimo.addActionListener(this);
        
       

        /**
         * Menu
         */
        barra = new JMenuBar();
        setJMenuBar(barra);
        
        menuArquivo     = new JMenu("Arquivo");
        menuEmprestimos = new JMenu("Empréstimos");
        menuReservas    = new JMenu("Reservas");
        menuDevolucoes  = new JMenu("Devoluções");
        menuClientes    = new JMenu("Clientes");
        menuVeiculos    = new JMenu("Veículos");
        menuPagamentos  = new JMenu("Pagamentos");
        menuRelatorios  = new JMenu("Relatórios");

        itemEmprestimosCadastro = new JMenuItem("Cadastro");
        itemReservasCadastro    = new JMenuItem("Cadastro");
        itemDevolucoesRegistrar = new JMenuItem("Registrar");
        itemClientePFCadastro   = new JMenuItem("Cadastro PF");
        itemClientePJCadastro   = new JMenuItem("Cadastro PJ");
        itemClientesLista       = new JMenuItem("Listar clientes");
        itemVeiculosCadastro    = new JMenuItem("Cadastro");       
        itemArquivoSair         = new JMenuItem("Sair");
        
        itemArquivoSair.addActionListener(this);
        itemEmprestimosCadastro.addActionListener(this);
        itemReservasCadastro.addActionListener(this);
        itemDevolucoesRegistrar.addActionListener(this);
        itemClientePFCadastro.addActionListener(this);
        itemClientePJCadastro.addActionListener(this);
        itemClientesLista.addActionListener(this);
        itemVeiculosCadastro.addActionListener(this);
        
        
        menuArquivo.add(itemArquivoSair);
        menuEmprestimos.add(itemEmprestimosCadastro);
        menuReservas.add(itemReservasCadastro);
        menuDevolucoes.add(itemDevolucoesRegistrar);
        menuClientes.add(itemClientePFCadastro);
        menuClientes.add(itemClientePJCadastro);
        menuClientes.add(itemClientesLista);
        menuVeiculos.add(itemVeiculosCadastro);
//        menuPagamentos.add();
//        menuRelatorios.add();
        
        
        barra.add(menuArquivo);
        barra.add(menuEmprestimos);
        barra.add(menuReservas);
        barra.add(menuDevolucoes);
        barra.add(menuClientes);
        barra.add(menuVeiculos);
        barra.add(menuPagamentos);
        barra.add(menuRelatorios);
        
        
          
        /***********tabela***********/        

        veiculos = Veiculo.getArrayObjects();
        VeiculoTableModel model = new VeiculoTableModel(veiculos);
        
        table = new JTable(model);        
        table.setPreferredScrollableViewportSize(new Dimension(775, 150));
        table.setFillsViewportHeight(true);
        
        JScrollPane scroll = new JScrollPane(table);
        scroll.setAutoscrolls(true);  

        table.addMouseListener(this);
        
        /*****fim da tabela***********/
        

        
        // Barra de pesquisa
        gbc.insets = new Insets(35, 0, 0, 5);
        gbc.anchor = GridBagConstraints.LINE_START;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelHeader.add(lblBuscar, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        panelHeader.add(textBuscar, gbc);
        
        gbc.gridx = 6;
        gbc.gridy = 0;
        panelHeader.add(btnBuscar, gbc);
        
        
        // Sem layout
        panelBody.add(scroll);        
        
        
        // Botões no rodapé
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 350;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 25, 15, 0);
        panelFooter.add(btnSair, gbc);        
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 15, 5);
        panelFooter.add(btnNovaReserva, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 15, 25);
        panelFooter.add(btnNovoEmprestimo, gbc);
        
        c.add(panelHeader, BorderLayout.NORTH);
        c.add(panelBody, BorderLayout.CENTER);
        c.add(panelFooter, BorderLayout.SOUTH);

        setLocation(300, 225);
        setSize(850, 350);
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    	if (e.getSource() == itemVeiculosCadastro) {     		
    		VeiculoController ctlVeiculo = new VeiculoController(idioma);
    		ctlVeiculo.executar();
        }
    	else if (e.getSource() == itemClientePFCadastro) {     		
    		ClienteController ctlCliente = new ClienteController(idioma);
    		ctlCliente.executarPF();
        }
    	else if (e.getSource() == itemClientePJCadastro) {     		
    		ClienteController ctlCliente = new ClienteController(idioma);
    		ctlCliente.executarPJ();
        }
    	else if (e.getSource() == itemClientesLista) {  
    		ListarClientesController ctlListarClientes = new ListarClientesController(idioma);
    		ctlListarClientes.executar();
    		
    	}
    	else if(e.getSource() == btnBuscar) {
    		veiculos = Veiculo.buscar(textBuscar.getText());
    		VeiculoTableModel novaModel = new VeiculoTableModel(veiculos);
    		
    		table.setModel(novaModel);
    	}
    	else if (e.getSource() == btnSair) {       
    		System.exit(0);
    	}
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (e.getClickCount() == 2 && e.getSource() == table) {		    		
			Veiculo veiculo = veiculos.get(table.getSelectedRow());
			
    		VeiculoController ctlVeiculo = new VeiculoController(idioma);
    		ctlVeiculo.setObject(veiculo);
    		ctlVeiculo.executar();
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