package projeto.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import projeto.controller.VeiculoController;
import projeto.model.Veiculo;
import locale.start.StartLocale;

public class ListarVeiculosView extends JFrame implements ActionListener {

	
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
    private JMenuItem itemClientesCadastro; 
    private JMenu menuVeiculos;
    private JMenuItem itemVeiculosCadastro;  
    private JMenu menuPagamentos;    
    private JMenu menuRelatorios;    
    
    private JLabel lblBuscar;
    private JTextField textBuscar;
    private JComboBox<String> comboBuscarMarca;
    private JComboBox<String> comboBuscarModelo;
    private JComboBox<String> comboBuscarAno;
    private JComboBox<String> comboBuscarCor;
    private JButton btnBuscar;
    
    private JTable table;
    private JButton btnSair;
    private JButton btnNovaReserva;
    private JButton btnNovoEmprestimo;
    
    // Internacionalização
    private ResourceBundle bundle = null;
    private String idioma = null;
    
    
    public ListarVeiculosView(String idioma) {
    	StartLocale locale = new StartLocale(idioma);
    	
        this.bundle = locale.getLocale();
        this.idioma = idioma;
    }
    
    /**
     * @param args
     */
    public void exibirFrame(ArrayList<Veiculo> veiculos) {
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
        
        
        // Inicia elementos
        lblBuscar = new JLabel(bundle.getString("LABEL_BUSCAR"));
        textBuscar = new JTextField();
        textBuscar.setPreferredSize(new Dimension(200, 25));
        
        comboBuscarMarca = new JComboBox<String>();
        comboBuscarMarca.setPreferredSize(new Dimension(100, 25));
        
        comboBuscarModelo = new JComboBox<String>();
        comboBuscarModelo.setPreferredSize(new Dimension(100, 25));
        
        comboBuscarAno = new JComboBox<String>();
        comboBuscarAno.setPreferredSize(new Dimension(100, 25));
        
        comboBuscarCor = new JComboBox<String>();
        comboBuscarCor.setPreferredSize(new Dimension(100, 25));
        
        btnBuscar = new JButton(bundle.getString("BTN_BUSCAR"));
        
        
        btnSair  = new JButton(bundle.getString("BTN_SAIR"));
        btnSair.addActionListener(this);
        
        btnNovaReserva = new JButton(bundle.getString("BTN_NOVA_RESERVA"));
        btnNovaReserva.addActionListener(this);
        
        btnNovoEmprestimo  = new JButton(bundle.getString("BTN_NOVO_EMPRESTIMO"));
        btnNovoEmprestimo.addActionListener(this);

        /**
         * Menu
         */
        barra = new JMenuBar();
        setJMenuBar(barra);
        
        menuArquivo = new JMenu("Arquivo");
        menuEmprestimos = new JMenu("Empréstimos");
        menuReservas = new JMenu("Reservas");
        menuDevolucoes = new JMenu("Devoluções");
        menuClientes = new JMenu("Clientes");
        menuVeiculos = new JMenu("Veículos");
        menuPagamentos = new JMenu("Pagamentos");
        menuRelatorios = new JMenu("Relatórios");
        
        itemArquivoSair = new JMenuItem("Sair");
        itemArquivoSair.addActionListener(this);
        
        itemEmprestimosCadastro = new JMenuItem("Cadastro");
        itemEmprestimosCadastro.addActionListener(this);
        
        itemReservasCadastro = new JMenuItem("Cadastro");
        itemReservasCadastro.addActionListener(this);
        
        itemDevolucoesRegistrar = new JMenuItem("Registrar");
        itemDevolucoesRegistrar.addActionListener(this);
        
        itemClientesCadastro = new JMenuItem("Cadastro");
        itemClientesCadastro.addActionListener(this);
        
        itemVeiculosCadastro = new JMenuItem("Cadastro");
        itemVeiculosCadastro.addActionListener(this);
        
        menuArquivo.add(itemArquivoSair);
        menuEmprestimos.add(itemEmprestimosCadastro);
        menuReservas.add(itemReservasCadastro);
        menuDevolucoes.add(itemDevolucoesRegistrar);
        menuClientes.add(itemClientesCadastro);
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
        
        
        DefaultTableModel model = new DefaultTableModel();        
        
        model.addColumn("Grupo");
        model.addColumn("Modelo");
        model.addColumn("Tarifa");
        model.addColumn("Ano");
        model.addColumn("Marca");
        
        
        
        Iterator<Veiculo> it = veiculos.iterator();
        while (it.hasNext()) {
        	
        	Veiculo v = it.next();

        	String[] linha = {
        			String.valueOf(v.getIdGrupo()), 
        			v.getModelo(), 
        			v.getTarifaAluguel(), 
        			String.valueOf(v.getAno()), 
        			v.getMarca()
        			};
        	
        	model.addRow(linha);
        }

        table = new JTable(model);        
        table.setPreferredScrollableViewportSize(new Dimension(775, 150));
        table.setFillsViewportHeight(true);
        
        JScrollPane scroll = new JScrollPane(table);
        scroll.setAutoscrolls(true);      
        
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
        
        gbc.gridx = 2;
        gbc.gridy = 0;
        panelHeader.add(comboBuscarMarca, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 0;
        panelHeader.add(comboBuscarModelo, gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 0;
        panelHeader.add(comboBuscarAno, gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 0;
        panelHeader.add(comboBuscarCor, gbc);
        
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
    		setVisible(false);
    		VeiculoController ctlVeiculo = new VeiculoController(idioma);
    		ctlVeiculo.executar();
        }
    	else if (e.getSource() == btnSair) {       
    		System.exit(0);
    	}
    }
}