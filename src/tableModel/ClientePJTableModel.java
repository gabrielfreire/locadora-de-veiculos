package tableModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import projeto.model.ClientePJ;

public class ClientePJTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2136004293965767274L;
	private ArrayList<ClientePJ> clientes;	
	private String[] colunas = {"Nome", "CNPJ"};
	

	public ClientePJTableModel(ArrayList<ClientePJ> clientes) {
		this.clientes= clientes;
	}
	
	public ClientePJTableModel() {
		clientes = new ArrayList<ClientePJ>();		
	}

	public void addRow(ClientePJ cliente) {
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
          case 1:  clientes.get(linha).setCnpj( (Integer) valor); break;          
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
	        case 1: return clientes.get(linha).getCnpj();	        
      }  
      return null;
	}

}
