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
import projeto.controller.DevolucaoController;
import projeto.controller.ListarClientesController;
import projeto.controller.LocacaoController;
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
    private JButton btnReservas;
    private JButton btnLocacoes;

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
        
        
        btnBuscar       = new JButton(bundle.getString("BTN_BUSCAR"));
        btnSair         = new JButton(bundle.getString("BTN_SAIR"));
        btnReservas     = new JButton(bundle.getString("BTN_RESERVAS"));
        btnLocacoes     = new JButton(bundle.getString("BTN_LOCACOES"));
        
        
        btnBuscar.addActionListener(this);
        btnSair.addActionListener(this);
        btnReservas.addActionListener(this);
        btnLocacoes.addActionListener(this);
        
       

        /**
         * Menu
         */
        barra = new JMenuBar();
        setJMenuBar(barra);
        
        menuArquivo     = new JMenu(bundle.getString("MENU_ARQUIVO"));
        menuEmprestimos = new JMenu(bundle.getString("MENU_EMPRESTIMOS"));
        menuReservas    = new JMenu(bundle.getString("MENU_RESERVAS"));
        menuDevolucoes  = new JMenu(bundle.getString("MENU_DEVOLUCOES"));
        menuClientes    = new JMenu(bundle.getString("MENU_CLIENTES"));
        menuVeiculos    = new JMenu(bundle.getString("MENU_VEICULOS"));
        menuPagamentos  = new JMenu(bundle.getString("MENU_PAGAMENTOS"));
        menuRelatorios  = new JMenu(bundle.getString("MENU_RELATORIOS"));

        itemEmprestimosCadastro = new JMenuItem(bundle.getString("ITEM_CADASTRO"));
        itemReservasCadastro    = new JMenuItem(bundle.getString("ITEM_CADASTRO"));
        itemDevolucoesRegistrar = new JMenuItem(bundle.getString("ITEM_REGISTRAR"));
        itemClientePFCadastro   = new JMenuItem(bundle.getString("ITEM_CADASTRO_PF"));
        itemClientePJCadastro   = new JMenuItem(bundle.getString("ITEM_CADASTRO_PJ"));
        itemClientesLista       = new JMenuItem(bundle.getString("ITEM_LISTAR_CLIENTES"));
        itemVeiculosCadastro    = new JMenuItem(bundle.getString("ITEM_CADASTRO"));       
        itemArquivoSair         = new JMenuItem(bundle.getString("ITEM_SAIR"));
        
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
        table.setPreferredScrollableViewportSize(new Dimension(980, 175));
        table.setFillsViewportHeight(true);
        
        JScrollPane scroll = new JScrollPane(table);
        scroll.setAutoscrolls(true);  
        
        table.addMouseListener(this);
        /*****fim da tabela***********/
        

        
        // Barra de pesquisa
        gbc.insets = new Insets(10, 0, 0, 5);
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
        
        gbc.ipady = 7;
        
        // Botões no rodapé
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 350;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 8, 15, 0);
        panelFooter.add(btnSair, gbc);        
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 15, 5);
        panelFooter.add(btnReservas, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 15, 10);
        panelFooter.add(btnLocacoes, gbc);
        
        c.add(panelHeader, BorderLayout.NORTH);
        c.add(panelBody, BorderLayout.CENTER);
        c.add(panelFooter, BorderLayout.SOUTH);

        setResizable(false);
        setLocation(200, 225);
        setSize(1000, 350);
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
    	else if (e.getSource() == btnBuscar) {
    		veiculos = Veiculo.buscar(textBuscar.getText());
    		VeiculoTableModel novaModel = new VeiculoTableModel(veiculos);
    		
    		table.setModel(novaModel);
    	}
    	else if (e.getSource() == itemDevolucoesRegistrar) {
    		DevolucaoController ctlDevolucao = new DevolucaoController(idioma);
    		ctlDevolucao.executar();
    	}
    	else if (e.getSource() == btnLocacoes) {
    		LocacaoController ctlLocacao = new LocacaoController(idioma);
    		ctlLocacao.executar();
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