package projeto.view;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import projeto.controller.VeiculoController;
import projeto.model.Cor;
import projeto.model.Grupo;
import projeto.model.Marca;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ResourceBundle;

import locale.start.StartLocale;


public class VeiculoView extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1358031435910110817L;
	private JLabel lblTitulo;;
	private JLabel lblChassi;
	private JLabel lblPlaca;
	private JLabel lblCidade;
	private JLabel lblEstado;
	private JLabel lblModelo;
	private JLabel lblFabricante;
	private JLabel lblAno;
	private JLabel lblMarca;
	private JLabel lblCor;
	private JLabel lblTarifaAluguel;
	private JLabel lblKmRodado;
	private JLabel lblGrupo;
	private JLabel lblAcessorios;
	
	private JTextField textChassi;
	private JTextField textPlaca;
	private JTextField textCidade;
	private JComboBox<String> comboEstado;
	private JTextField textModelo;
	private JTextField textFabricante;
	private JComboBox<Integer> comboAno;
	private JComboBox<String> comboMarca;
	private JComboBox<String> comboCor;
	private JTextField textTarifaAluguel;
	private JTextField textKmRodado;
	private JComboBox<String> comboGrupo;
	private JCheckBox checkAcessorioGPS;
	private JCheckBox checkAcessorioCadeiraBebe;
	private JCheckBox checkAcessorioMotorista;
	
	private JButton btnCancelar;
	private JButton btnCadastrar;	
	private JButton btnExcluir;
	private JButton btnSalvar;
	
	private ArrayList<Grupo> grupos;
	private ArrayList<Marca> marcas;
	private ArrayList<Cor> cores;
	
    // Internacionalização
    private ResourceBundle bundle = null;
    private String idioma = null;

    public VeiculoView(String idioma) {
    	StartLocale locale = new StartLocale(idioma);
    	
        this.bundle = locale.getLocale();
        this.idioma = idioma;
    }
	
	
	public void exibirFrame(String estados[], int anos[], 
			                ArrayList<Grupo> grupos, ArrayList<Marca> marcas, ArrayList<Cor> cores) {
		
    	StartLocale locale = new StartLocale(idioma);
        bundle = locale.getLocale();
                
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
				
		// Declara panels
		JPanel panelHeader = new JPanel(new GridBagLayout());				
		JPanel panelBody = new JPanel(new GridBagLayout());			
		JPanel panelFooter = new JPanel(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
	
        
		
		
		boolean inserir = true;
		boolean editar = false;
		
		if (inserir)
			lblTitulo = new JLabel(bundle.getString("LABEL_TITULO_CADASTRAR_VEICULO"));
		else
			lblTitulo = new JLabel(bundle.getString("LABEL_TITULO_EDITAR_VEICULO"));
        lblChassi = new JLabel(bundle.getString("LABEL_CHASSI"));
        lblPlaca = new JLabel(bundle.getString("LABEL_PLACA"));
        lblCidade = new JLabel(bundle.getString("LABEL_CIDADE"));
        lblEstado = new JLabel(bundle.getString("LABEL_ESTADO"));
        lblModelo = new JLabel(bundle.getString("LABEL_MODELO"));
        lblFabricante = new JLabel(bundle.getString("LABEL_FABRICANTE"));
        lblAno = new JLabel(bundle.getString("LABEL_ANO"));
        lblMarca = new JLabel(bundle.getString("LABEL_MARCA"));
        lblCor = new JLabel(bundle.getString("LABEL_COR"));
        lblTarifaAluguel = new JLabel(bundle.getString("LABEL_TARIFA"));
        lblKmRodado = new JLabel(bundle.getString("LABEL_KM"));
        lblGrupo = new JLabel(bundle.getString("LABEL_GRUPO"));
        lblAcessorios = new JLabel(bundle.getString("LABEL_ACESSORIOS"));
        
        textChassi = new JTextField();
        textChassi.setPreferredSize(new Dimension(200, 25));
        
        textPlaca = new JTextField();
        textPlaca.setPreferredSize(new Dimension(200, 25));
        
        textCidade = new JTextField();
        textCidade.setPreferredSize(new Dimension(200, 25));
        
        comboEstado = new JComboBox<String>();
        comboEstado.setPreferredSize(new Dimension(100, 25));
        
        for (int i=0; i<estados.length; i++) {
        	comboEstado.addItem(estados[i]);        	
        }
        
        textModelo = new JTextField();
        textModelo.setPreferredSize(new Dimension(200, 25));
        
        textFabricante = new JTextField();
        textFabricante.setPreferredSize(new Dimension(200, 25));
        
        comboAno = new JComboBox<Integer>();
        comboAno.setPreferredSize(new Dimension(100, 25));

        // Listar Anos na combo
        for (int i=0; i<anos.length; i++) {
        	comboAno.addItem(anos[i]);
        }
        
        
        comboMarca = new JComboBox<String>();
        comboMarca.setPreferredSize(new Dimension(100, 25));

        // Listar marcas na combo
        for (int i=0; i<marcas.size(); i++) {
        	comboMarca.addItem(marcas.get(i).getNome());
        }        
        this.marcas = marcas;
        
        
        comboCor = new JComboBox<String>();
        comboCor.setPreferredSize(new Dimension(100, 25));
    
        // Listar cores na combo
        for (int i=0; i<cores.size(); i++) {
        	comboCor.addItem(cores.get(i).getNome());
        }        
        this.cores = cores;
        
        
        textTarifaAluguel = new JTextField();
        textTarifaAluguel.setPreferredSize(new Dimension(200, 25));
        
        textKmRodado = new JTextField();
        textKmRodado.setPreferredSize(new Dimension(200, 25));
        
        comboGrupo = new JComboBox<String>();
        comboGrupo.setPreferredSize(new Dimension(200, 25));
        
        // Listar grupos na combo
        for (int i=0; i<grupos.size(); i++) {
        	comboGrupo.addItem(grupos.get(i).getNome());
        }        
        this.grupos = grupos;    
        
        
        
        checkAcessorioGPS = new JCheckBox(bundle.getString("CHECKBOX_ACESSORIO_GPS"));
        checkAcessorioGPS.setPreferredSize(new Dimension(200, 25));
        
        checkAcessorioCadeiraBebe = new JCheckBox(bundle.getString("CHECKBOX_ACESSORIO_CADEIRA_BEBE"));
        checkAcessorioCadeiraBebe.setPreferredSize(new Dimension(200, 25));
        
        checkAcessorioMotorista = new JCheckBox(bundle.getString("CHECKBOX_ACESSORIO_MOTORISTA"));
        checkAcessorioMotorista.setPreferredSize(new Dimension(200, 25));
		
        btnCadastrar = new JButton(bundle.getString("BTN_CADASTRAR"));        
        btnCadastrar.addActionListener(this);
        
        btnSalvar = new JButton(bundle.getString("BTN_EDITAR"));
        btnSalvar.addActionListener(this);
        
        btnExcluir = new JButton(bundle.getString("BTN_EXCLUIR"));
        btnExcluir.addActionListener(this);
        
        btnCancelar = new JButton(bundle.getString("BTN_CANCELAR"));
        btnCancelar.addActionListener(this);
        
    	panelHeader.add(lblTitulo);        
        
        
        gbc.insets = new Insets(0, 5, 2, 0);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        panelBody.add(lblChassi, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        panelBody.add(textChassi, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        panelBody.add(lblPlaca, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        panelBody.add(textPlaca, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        panelBody.add(lblCidade, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        panelBody.add(textCidade, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        panelBody.add(lblEstado, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        panelBody.add(comboEstado, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_END;
        panelBody.add(lblModelo, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_START;
        panelBody.add(textModelo, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_END;
        panelBody.add(lblFabricante, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_START;
        panelBody.add(textFabricante, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.LINE_END;
        panelBody.add(lblAno, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.LINE_START;
        panelBody.add(comboAno, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.LINE_END;
        panelBody.add(lblMarca, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.LINE_START;
        panelBody.add(comboMarca, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.LINE_END;
        panelBody.add(lblCor, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.LINE_START;
        panelBody.add(comboCor, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.LINE_END;
        panelBody.add(lblTarifaAluguel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.LINE_START;
        panelBody.add(textTarifaAluguel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.LINE_END;
        panelBody.add(lblKmRodado, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.LINE_START;
        panelBody.add(textKmRodado, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.LINE_END;
        panelBody.add(lblGrupo, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.LINE_START;
        panelBody.add(comboGrupo, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.anchor = GridBagConstraints.LINE_END;
        panelBody.add(lblAcessorios, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 12;
        gbc.anchor = GridBagConstraints.LINE_START;
        panelBody.add(checkAcessorioGPS, gbc);

        gbc.gridx = 1;
        gbc.gridy = 13;
        gbc.anchor = GridBagConstraints.LINE_START;
        panelBody.add(checkAcessorioCadeiraBebe, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 14;
        gbc.anchor = GridBagConstraints.LINE_START;
        panelBody.add(checkAcessorioMotorista, gbc);

        
        // Botões do rodapé
        if (inserir) {
        	gbc.gridx = 0;
        	gbc.gridy = 0;
        	gbc.insets = new Insets(0, 100, 25, 0);
        	gbc.anchor = GridBagConstraints.LINE_END;
        	panelFooter.add(btnCancelar, gbc);
        	
        	gbc.gridx = 1;
        	gbc.gridy = 0;
        	gbc.insets = new Insets(0, 5, 25, 0);
        	gbc.anchor = GridBagConstraints.LINE_END;
        	panelFooter.add(btnCadastrar, gbc);
        }
        if (editar) {
        	panelFooter.add(btnCancelar);
        	panelFooter.add(btnExcluir);
        	panelFooter.add(btnSalvar);
        }
        
        // Adicionar panels
        c.add(panelHeader, BorderLayout.NORTH);
        c.add(panelBody, BorderLayout.CENTER);
        c.add(panelFooter, BorderLayout.SOUTH);

        setResizable(false);
        setLocation(500, 125);
        setSize(400, 550);
        setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		
		if (e.getSource() == btnCadastrar) {
			int idGrupoSelecionado = grupos.get(comboGrupo.getSelectedIndex()).getIdGrupo();
			int idMarcaSelecionada = marcas.get(comboMarca.getSelectedIndex()).getIdMarca();
			int idCorSelecionada   = cores.get(comboCor.getSelectedIndex()).getIdCor();

			// Caso o usuário deixe o campo em branco, o padrão é zero para evitar erro
			String kmRodado = textKmRodado.getText().isEmpty() ? "0" : textKmRodado.getText();
			
			boolean cadastrou = VeiculoController.inserir(
				      				textChassi.getText(),               textPlaca.getText(), 
	                                textCidade.getText(),               (String)comboEstado.getSelectedItem(), 
	                                textModelo.getText(),               textFabricante.getText(), 
	                                (int)comboAno.getSelectedItem(),    (String)comboMarca.getSelectedItem(), 
	                                (String)comboCor.getSelectedItem(), textTarifaAluguel.getText(), 
	                                Double.parseDouble(kmRodado),       idGrupoSelecionado,
	                                idMarcaSelecionada,                 idCorSelecionada);
	
			if (cadastrou) {
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso!");
			}
			else {
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Falha no cadastro!");
			}
		}
		else if (e.getSource() == btnCancelar) {
			setVisible(false);
		}
	}

}
