package tableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import projeto.model.Locacao;

public class LocacaoTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2136004293965767274L;
	private ArrayList<Locacao> locacoes;	
	private String[] colunas = {"CPF do cliente", "Data retirada", "Data devolução", "Cod. Agência"};
	
	public LocacaoTableModel(ArrayList<Locacao> locacoes) {		
		this.locacoes = locacoes;
	}
	
	public LocacaoTableModel() {
		locacoes = new ArrayList<Locacao>();
	}

	public void addRow(Locacao locacao) {
		locacoes.add(locacao);
		fireTableDataChanged();
	}
	
	public void removeRow(int linha){
	    locacoes.remove(linha);
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
          case 0:  locacoes.get(linha).setCpf( (Long)valor );               break;
          case 1:  locacoes.get(linha).setData_retirada( (String) valor);   break;
          case 2:  locacoes.get(linha).setData_devolucao( (String) valor ); break;
          case 3:  locacoes.get(linha).setAgencia_id( (Integer) valor );    break;
      }
      fireTableRowsUpdated(linha, coluna);
  }

	
	@Override
	public int getRowCount() {		
		return locacoes.size();
	}
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		
	  switch(coluna){
	      case 0:  return locacoes.get(linha).getCpf();           
	      case 1:  return locacoes.get(linha).getData_retirada(); 
	      case 2:  return locacoes.get(linha).getData_devolucao();
	      case 3:  return locacoes.get(linha).getAgencia_id(); 
	  }  
	  return null;
	}		
}






