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
import projeto.model.Veiculo;

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

import locale.start.StartLocale;


public class VeiculoView extends JFrame implements ActionListener {

	// Labels
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
	
	// Caixas de texto e combos
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
	
	// Botões
	private JButton btnCancelar;
	private JButton btnCadastrar;	
	private JButton btnExcluir;
	private JButton btnSalvar;
	
	// ArrayList das combos que chamam a base
	private ArrayList<Grupo> grupos;
	private ArrayList<Marca> marcas;
	private ArrayList<Cor> cores;
	
		
    // Internacionalização
    private ResourceBundle bundle = null;
    
    // Objeto que receberá para editar veículo
    private Veiculo veiculo = null;
    

    
    public VeiculoView(String idioma) {
    	StartLocale locale = new StartLocale(idioma);
    	
        this.bundle = locale.getLocale();
    }
    
    
    public void setObject(Veiculo veiculo) {
    	this.veiculo = veiculo;
    }
	
	
	public void exibirFrame(String estados[], int anos[], 
			                ArrayList<Grupo> grupos, 
			                ArrayList<Marca> marcas, 
			                ArrayList<Cor> cores) {
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
				
		// Declara panels
		JPanel panelHeader = new JPanel(new GridBagLayout());				
		JPanel panelBody = new JPanel(new GridBagLayout());			
		JPanel panelFooter = new JPanel(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
						
		
		// Criar objeto de elementos
		lblTitulo = new JLabel(bundle.getString("LABEL_TITULO_VEICULO"));
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
        textPlaca = new JTextField();
        textCidade = new JTextField();        
        textModelo = new JTextField(); 
        textFabricante = new JTextField();
        textTarifaAluguel = new JTextField();
        textKmRodado = new JTextField();
        
        comboEstado = new JComboBox<String>();
        comboAno = new JComboBox<Integer>();
        comboGrupo = new JComboBox<String>();
        comboMarca = new JComboBox<String>();
        comboCor = new JComboBox<String>();
        
        checkAcessorioGPS = new JCheckBox(bundle.getString("CHECKBOX_ACESSORIO_GPS"));
        checkAcessorioCadeiraBebe = new JCheckBox(bundle.getString("CHECKBOX_ACESSORIO_CADEIRA_BEBE"));
        checkAcessorioMotorista = new JCheckBox(bundle.getString("CHECKBOX_ACESSORIO_MOTORISTA"));        
		
        btnCadastrar = new JButton(bundle.getString("BTN_CADASTRAR"));
        btnSalvar = new JButton(bundle.getString("BTN_EDITAR"));
        btnExcluir = new JButton(bundle.getString("BTN_EXCLUIR"));
        btnCancelar = new JButton(bundle.getString("BTN_CANCELAR"));
        
        
        // Listar combos    
        for (int i=0; i<estados.length; i++) 
        	comboEstado.addItem(estados[i]);        	
        
        for (int i=0; i<anos.length; i++) 
        	comboAno.addItem(anos[i]);    
        
        for (int i=0; i<marcas.size(); i++)
        	comboMarca.addItem(marcas.get(i).getNome());               
        
        for (int i=0; i<cores.size(); i++) 
        	comboCor.addItem(cores.get(i).getNome());         
        
        for (int i=0; i<grupos.size(); i++)
        	comboGrupo.addItem(grupos.get(i).getNome());            
        
        
        // Preciso dessas propriedas para pegar o valor selecionado no actionPerformed
        this.marcas = marcas;
        this.cores = cores;
        this.grupos = grupos;  
                
        
        // Add ação nos botões
        btnCadastrar.addActionListener(this);
        btnSalvar.addActionListener(this);
        btnExcluir.addActionListener(this);
        btnCancelar.addActionListener(this);
        
        // Add tamanho nos elementos
        textChassi.setPreferredSize(new Dimension(200, 25));
        textPlaca.setPreferredSize(new Dimension(200, 25));
        textCidade.setPreferredSize(new Dimension(200, 25));
        comboEstado.setPreferredSize(new Dimension(100, 25));
        textModelo.setPreferredSize(new Dimension(200, 25));
        textFabricante.setPreferredSize(new Dimension(200, 25));
        comboAno.setPreferredSize(new Dimension(100, 25));
        comboMarca.setPreferredSize(new Dimension(100, 25));
        comboCor.setPreferredSize(new Dimension(100, 25));
        textTarifaAluguel.setPreferredSize(new Dimension(200, 25));
        textKmRodado.setPreferredSize(new Dimension(200, 25));
        comboGrupo.setPreferredSize(new Dimension(200, 25));
        checkAcessorioGPS.setPreferredSize(new Dimension(200, 25));
        checkAcessorioCadeiraBebe.setPreferredSize(new Dimension(200, 25));
        checkAcessorioMotorista.setPreferredSize(new Dimension(200, 25));
        
        
		// Linha do Jtable selecionada, trazer os dados no formulário
		if (veiculo != null) {			
			textChassi.setText(veiculo.getChassi());
			textPlaca.setText(veiculo.getPlaca());
			textCidade.setText(veiculo.getCidade());
			comboEstado.setSelectedItem(veiculo.getEstado());			
			textModelo.setText(veiculo.getModelo());
			textFabricante.setText(veiculo.getFabricante());
			comboAno.setSelectedItem(veiculo.getAno());
			textTarifaAluguel.setText(veiculo.getTarifaAluguel());
			textKmRodado.setText(String.valueOf(veiculo.getKmRodado()));
			
			Iterator<Grupo> itGrupo = grupos.iterator();
			while(itGrupo.hasNext()) {
				Grupo grupo = itGrupo.next();
				
				if ( veiculo.getIdGrupo() == grupo.getIdGrupo() ) {
					comboGrupo.setSelectedItem(grupo.getNome());
					break;
				}
			}	
			
			Iterator<Marca> itMarca = marcas.iterator();
			while(itMarca.hasNext()) {
				Marca marca = itMarca.next();
				
				if ( veiculo.getIdMarca() == marca.getIdMarca() ) {
					comboMarca.setSelectedItem(marca.getNome());
					break;
				}
			}
			
			Iterator<Cor> itCor = cores.iterator();
			while(itCor.hasNext()) {
				Cor cor = itCor.next();
				
				if ( veiculo.getIdCor() == cor.getIdCor() ) {
					comboCor.setSelectedItem(cor.getNome());
					break;
				}
			}
		}
        
        // Título do formulário
    	panelHeader.add(lblTitulo);        
        
        
    	// Posição dos elementos
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

        
        
        gbc.ipady = 5;
    	
        // Botões do rodapé
        if (veiculo == null) { 
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
        else {
        	gbc.gridx = 0;
        	gbc.gridy = 0;
        	gbc.insets = new Insets(0, 35, 25, 0);
        	gbc.anchor = GridBagConstraints.LINE_END;
        	panelFooter.add(btnCancelar, gbc);
        	
        	gbc.gridx = 1;
        	gbc.gridy = 0;
        	gbc.insets = new Insets(0, 5, 25, 0);
        	gbc.anchor = GridBagConstraints.LINE_END;
        	panelFooter.add(btnExcluir, gbc);
        	
        	gbc.gridx = 2;
        	gbc.gridy = 0;
        	gbc.insets = new Insets(0, 5, 25, 0);
        	gbc.anchor = GridBagConstraints.LINE_END;
        	panelFooter.add(btnSalvar, gbc);
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
		
		setVisible(false);
		
		if (e.getSource() == btnCadastrar || e.getSource() == btnSalvar) {
			
			int idGrupoSelecionado = grupos.get(comboGrupo.getSelectedIndex()).getIdGrupo();
			int idMarcaSelecionada = marcas.get(comboMarca.getSelectedIndex()).getIdMarca();
			int idCorSelecionada   = cores.get(comboCor.getSelectedIndex()).getIdCor();

			// Caso o usuário deixe o campo em branco, o padrão é zero para evitar erro
			String kmRodado = textKmRodado.getText().isEmpty() ? "0.0" : textKmRodado.getText();
			
			if (veiculo == null)
				veiculo = new Veiculo();
				
			veiculo.setChassi(textChassi.getText());
			veiculo.setPlaca(textPlaca.getText());
			veiculo.setCidade(textCidade.getText());
			veiculo.setEstado((String)comboEstado.getSelectedItem());
			veiculo.setModelo(textModelo.getText());
			veiculo.setFabricante(textFabricante.getText());
			veiculo.setAno((int)comboAno.getSelectedItem());
			veiculo.setTarifaAluguel(textTarifaAluguel.getText());
			veiculo.setKmRodado(Double.parseDouble(kmRodado));
			veiculo.setIdGrupo(idGrupoSelecionado);
			veiculo.setIdMarca(idMarcaSelecionada);
			veiculo.setIdCor(idCorSelecionada);	
			
			if (e.getSource() == btnCadastrar) {
				VeiculoController.inserir(veiculo);			
				JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso!");
			}
			else {			
				VeiculoController.editar(veiculo);			
				JOptionPane.showMessageDialog(null, "Veículo alterado com sucesso!");
			}
		}
		
		else if (e.getSource() == btnExcluir) {			
			int resp = JOptionPane.showConfirmDialog(null, "Tem certeza?", "Excluir veículo", JOptionPane.YES_NO_OPTION);
			
			if (resp == JOptionPane.YES_OPTION) {
				VeiculoController.excluir(veiculo);			
				JOptionPane.showMessageDialog(null, "Veículo excluído com sucesso!");
			}			
		}
	}
}
