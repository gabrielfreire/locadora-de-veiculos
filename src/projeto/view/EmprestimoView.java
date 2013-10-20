package projeto.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;

public class EmprestimoView extends JFrame implements ActionListener {

	public void exibirFrame() {
		

		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
				
		// Declara panels
		JPanel panelHeader = new JPanel(new GridBagLayout());				
		JPanel panelBody = new JPanel(new GridBagLayout());			
		JPanel panelFooter = new JPanel(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
						
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Stub de método gerado automaticamente
		
	}
}
