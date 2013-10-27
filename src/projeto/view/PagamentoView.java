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
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import projeto.controller.PagamentoController;
import projeto.model.Cliente;
import projeto.model.Locacao;
import projeto.model.Pagamento;
import locale.start.StartLocale;

public class PagamentoView extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6555443714646866100L;
	private JLabel lblTitulo          = null;
	private JLabel lblBanco           = null;
	private JLabel lblAgencia         = null;
	private JLabel lblConta_corrente  = null;
	private JLabel lblNomeTitular     = null;
	private JLabel lblCpfCheque       = null;
	private JLabel lblCpfCredito      = null;
	private JLabel lblTelefone        = null;
	private JLabel lblBandeira_cartao = null;
	private JLabel lblNumero_cartao   = null;
	private JLabel lblValidade        = null;
	private JLabel lblCod_seguranca   = null;
	private JLabel lblValor_cobrado   = null;
	
	
	private JTextField textBanco                   = null;
	private JRadioButton radioPagamentoCheque      = null;
	private JRadioButton radioPagamentoCredito     = null;
	private JTextField textAgencia                 = null;
	private JTextField textConta_corrente          = null;
	private JTextField textNomeTitular             = null;
	private JTextField textCpfCheque               = null;
	private JTextField textCpfCredito              = null;
	private JTextField textTelefone                = null;
	private JComboBox<String> comboBandeira_cartao = null;
	private JTextField textNumero_cartao           = null;
	private JComboBox<String> comboValidade        = null;
	private JTextField textCod_seguranca           = null;
	private JTextField textValor_cobrado           = null;
	
	
	private JPanel panelTitulo      = null;
	private JPanel panelRadios      = null;
	private JPanel panelFormCheque  = null;
	private JPanel panelFormCredito = null;
	private JPanel panelBotoes      = null;
	
	
	private JButton btnCancelar = null;
	private JButton btnFinalizar = null;
	
	private Locacao locacao = null;
	
	
	// Internacionalização
	private ResourceBundle bundle = null;
	
	
	public PagamentoView(String idioma) {
		StartLocale locale = new StartLocale(idioma);		
        this.bundle = locale.getLocale();
	}
	
	public void setObjectLocacao(Locacao locacao) {
		this.locacao = locacao;
	}
	
	
	public void exibirFrame() {
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new GridBagLayout());
		
		panelTitulo      = new JPanel(new GridBagLayout());
		panelRadios      = new JPanel(new GridBagLayout());
		panelFormCheque  = new JPanel(new GridBagLayout());
		panelFormCredito = new JPanel(new GridBagLayout());
		panelBotoes      = new JPanel(new GridBagLayout());
		
		panelFormCredito.setVisible(false);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		lblTitulo          = new JLabel(bundle.getString("LABEL_TITULO_PAGAMENTO"));
		
		/*****Cheque*****/
		lblBanco           = new JLabel(bundle.getString("LABEL_BANCO"));
		lblAgencia         = new JLabel(bundle.getString("LABEL_AGENCIA"));
		lblConta_corrente  = new JLabel(bundle.getString("LABEL_CONTA_CORRENTE"));
		lblNomeTitular     = new JLabel(bundle.getString("LABEL_NOME_TITULAR"));
		lblCpfCheque       = new JLabel(bundle.getString("LABEL_CPF"));		
		lblTelefone        = new JLabel(bundle.getString("LABEL_TELEFONE"));
		
		/******Cartão crédito****/
		lblCpfCredito      = new JLabel(bundle.getString("LABEL_CPF"));
		lblBandeira_cartao = new JLabel(bundle.getString("LABEL_BANDEIRA_CARTAO"));
		lblNumero_cartao   = new JLabel(bundle.getString("LABEL_NUMERO_CARTAO"));
		lblValidade        = new JLabel(bundle.getString("LABEL_VALIDADE"));
		lblCod_seguranca   = new JLabel(bundle.getString("LABEL_COD_SEGURANCA"));
		
		lblValor_cobrado   = new JLabel(bundle.getString("LABEL_VALOR_COBRADO"));
		
		
		radioPagamentoCheque  = new JRadioButton(bundle.getString("RADIO_PG_CHEQUE"), true);
		radioPagamentoCredito = new JRadioButton(bundle.getString("RADIO_PG_CREDITO"));
		
		/****Cheque****/
		textCpfCheque        = new JTextField();
		textBanco            = new JTextField();
		textAgencia          = new JTextField();
		textConta_corrente   = new JTextField();
		textNomeTitular      = new JTextField();		
		textTelefone         = new JTextField();
		
		/****Cartão crédito****/
		textCpfCredito       = new JTextField();
		comboBandeira_cartao = new JComboBox<String>();
		textNumero_cartao    = new JTextField();
		comboValidade        = new JComboBox<String>();
		textCod_seguranca    = new JTextField();
		
		textValor_cobrado    = new JTextField();
		
		
		btnCancelar = new JButton(bundle.getString("BTN_CANCELAR"));
		btnFinalizar = new JButton(bundle.getString("BTN_FINALIZAR"));
		
		
		
		
		// Personalizar...
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        
        ButtonGroup group = new ButtonGroup();
        group.add(radioPagamentoCheque);
        group.add(radioPagamentoCredito);
        
        textBanco.setPreferredSize(new Dimension(200, 22));
        textAgencia.setPreferredSize(new Dimension(200, 22));
        textConta_corrente.setPreferredSize(new Dimension(200, 22));
        textNomeTitular.setPreferredSize(new Dimension(200, 22));
        textCpfCheque.setPreferredSize(new Dimension(200, 22));
        textCpfCredito.setPreferredSize(new Dimension(200, 22));
        textTelefone.setPreferredSize(new Dimension(200, 22));
        comboBandeira_cartao.setPreferredSize(new Dimension(100, 22));
        textNumero_cartao.setPreferredSize(new Dimension(200, 22));
        comboValidade.setPreferredSize(new Dimension(100, 22));
        textCod_seguranca.setPreferredSize(new Dimension(200, 22));
        textValor_cobrado.setPreferredSize(new Dimension(200, 22));
		
        
        radioPagamentoCheque.addMouseListener(this);
        radioPagamentoCredito.addMouseListener(this);
        btnCancelar.addActionListener(this);
        btnFinalizar.addActionListener(this);
        
        // Atribui cpf da tela anterior recebido por parâmetro
        textCpfCheque.setText(String.valueOf(locacao.getCpf()));
        textCpfCredito.setText(String.valueOf(locacao.getCpf()));
        
        
        gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 0, 20, 0);
		panelTitulo.add(lblTitulo, gbc);
		

		/*****Radios*****/
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 0, 5, 0);
		panelRadios.add(radioPagamentoCheque, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 0, 5, 0);
		panelRadios.add(radioPagamentoCredito, gbc);
		
		
		
		/*********Formulário de cheque*************/
		gbc.insets = new Insets(0, 5, 5, 0);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		panelFormCheque.add(lblCpfCheque, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		panelFormCheque.add(textCpfCheque, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		panelFormCheque.add(lblAgencia, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		panelFormCheque.add(textAgencia, gbc);
		
		
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		panelFormCheque.add(lblConta_corrente, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		panelFormCheque.add(textConta_corrente, gbc);
		
		
		
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		panelFormCheque.add(lblNomeTitular, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		panelFormCheque.add(textNomeTitular, gbc);
		
		
		

		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		panelFormCheque.add(lblBanco, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		panelFormCheque.add(textBanco, gbc);
		

		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		panelFormCheque.add(lblTelefone, gbc);

		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		panelFormCheque.add(textTelefone, gbc);
		
		
		
		/********Formulário cartão crédito*******/
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		panelFormCredito.add(lblCpfCredito, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		panelFormCredito.add(textCpfCredito, gbc);


		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		panelFormCredito.add(lblBandeira_cartao, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		panelFormCredito.add(comboBandeira_cartao, gbc);



		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		panelFormCredito.add(lblValidade, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		panelFormCredito.add(comboValidade, gbc);


		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		panelFormCredito.add(lblCod_seguranca, gbc);

		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		panelFormCredito.add(textCod_seguranca, gbc);



		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		panelFormCredito.add(lblValor_cobrado, gbc);

		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		panelFormCredito.add(textValor_cobrado, gbc);

		
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		panelFormCredito.add(lblNumero_cartao, gbc);

		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		panelFormCredito.add(textNumero_cartao, gbc);
		
		
		
		/********Botões**********/
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		panelBotoes.add(btnFinalizar, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		panelBotoes.add(btnCancelar, gbc);
		
		
		
		
		
		
		
		
		
		/*****Bordas*********/
		Border empty, compound;
		TitledBorder title;		
		
		empty = BorderFactory.createEmptyBorder(5, 200, 5, 200);
    	title = BorderFactory.createTitledBorder("");
    	title.setTitleJustification(TitledBorder.CENTER);
    	
    	compound = BorderFactory.createCompoundBorder(title, empty);    	
    	panelRadios.setBorder(compound);
    	

    	
		/*****Panels********/
    	gbc.insets = new Insets(5, 0, 5, 0);
    	gbc.anchor = GridBagConstraints.CENTER;
    	
    	gbc.gridx = 0;
		gbc.gridy = 0;
		c.add(panelTitulo, gbc);
		

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 20, 0);
		c.add(panelRadios, gbc);
				

		/*****Um formulário estará escondido e outro visível****/
		gbc.gridx = 0;
		gbc.gridy = 2;		
		gbc.insets = new Insets(0, 0, 0, 0);
		c.add(panelFormCheque, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;		
		gbc.insets = new Insets(0, 0, 0, 0);
		c.add(panelFormCredito, gbc);
		
		
		
		

		gbc.gridx = 0;
		gbc.gridy = 3;		
		gbc.insets = new Insets(30, 0, 5, 0);
		c.add(panelBotoes, gbc);
		
		setResizable(false);
		setSize(750, 320);
		setLocation(200, 150);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnCancelar) {
			setVisible(false);
		}
		else if (e.getSource() == btnFinalizar) {
			
			if (textCpfCheque.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "CPF é obrigatório", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if(radioPagamentoCheque.isSelected()) {
				
				long cpf = Long.parseLong(textCpfCheque.getText());
				
				if (Cliente.consultar(cpf) == false) {
					JOptionPane.showMessageDialog(null, "Não foi possível efetuar o pagamento!", "Erro", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				Pagamento p = new Pagamento();
				p.setCpf(cpf);
				p.setBanco(textBanco.getText());
				p.setAgencia(textAgencia.getText());
				p.setConta_corrente(textConta_corrente.getText());
				p.setNome_titular(textNomeTitular.getText());				
				p.setTelefone(textTelefone.getText());
				p.setStatus("Aguardando depósito");
							
				PagamentoController.inserirCheque(p);
				
				locacao.setPagamento_id(p.getIdPagamento());
				locacao.editarIdPagamento();
				
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Locação registrada com sucesso");
			}
			else if(radioPagamentoCredito.isSelected()) {
				
				long cpf = Long.parseLong(textCpfCredito.getText());
				
				if (Cliente.consultar(cpf) == false) {
					JOptionPane.showMessageDialog(null, "Não foi possível efetuar o pagamento!", "Erro", JOptionPane.ERROR_MESSAGE);
					return;
				}				
				else if (textNumero_cartao.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Digite o número do cartão de crédito!", "Erro", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else if (textCod_seguranca.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Digite o código de segurança!", "Erro", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				Pagamento p = new Pagamento();
				p.setCpf(cpf);
				p.setBandeira_cartao((String)comboBandeira_cartao.getSelectedItem());
				p.setNumero_cartao(Integer.parseInt(textNumero_cartao.getText()));
				p.setValidade((String)comboValidade.getSelectedItem());
				p.setCod_seguranca(Integer.parseInt(textCod_seguranca.getText()));				
				p.setValor_cobrado(textValor_cobrado.getText());
				p.setStatus("Aprovado");
							
				PagamentoController.inserirCredito(p);
				
				locacao.setPagamento_id(p.getIdPagamento());
				locacao.editarIdPagamento();
				
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Locação registrada com sucesso");
				
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (e.getSource() == radioPagamentoCheque) {
			panelFormCredito.setVisible(false);
			panelFormCheque.setVisible(true);
		}
		else if (e.getSource() == radioPagamentoCredito) {
			panelFormCredito.setVisible(true);
			panelFormCheque.setVisible(false);
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
