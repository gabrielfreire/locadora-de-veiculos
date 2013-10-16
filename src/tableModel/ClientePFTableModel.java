package tableModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import projeto.model.ClientePF;

public class ClientePFTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2136004293965767274L;
	private ArrayList<ClientePF> clientes;	
	private String[] colunas = {"Nome", "CPF"};
	

	public ClientePFTableModel(ArrayList<ClientePF> clientes) {
		this.clientes= clientes;
	}
	
	public ClientePFTableModel() {
		clientes = new ArrayList<ClientePF>();		
	}

	public void addRow(ClientePF cliente) {
		clientes.add(cliente);
		fireTableDataChanged();
	}
	
	public void removeRow(int linha){
	    clientes.remove(linha);
	    fireTableRowsDeleted(linha, linha);
	}

	public String getColumnName(int index) {
		return colunas[index];
	}
	
	public boolean isCellEditable(int linha, int coluna) {
	    return false;
	}

	public void setValueAt(Object valor, int linha, int coluna){
      if( valor == null) return;
       
      switch(coluna){
          case 0:  clientes.get(linha).setNome( (String)valor );  break;
          case 1:  clientes.get(linha).setCpf( (Integer) valor);  break;          
      }
      fireTableRowsUpdated(linha, linha);
  }

	
	@Override
	public int getRowCount() {		
		return clientes.size();
	}
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		
      switch(coluna){
	        case 0: return clientes.get(linha).getNome();
	        case 1: return clientes.get(linha).getCpf();	        
      }  
      return null;
	}

}
