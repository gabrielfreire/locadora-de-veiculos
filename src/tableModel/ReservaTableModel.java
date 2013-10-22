package tableModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import projeto.model.Reserva;

public class ReservaTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2136004293965767274L;
	private ArrayList<Reserva> reservas;	
	private String[] colunas = {"CPF do cliente", "Data retirada", "Data devolução", "Cod. Agência"};
	
	public ReservaTableModel(ArrayList<Reserva> reservas) {		
		this.reservas = reservas;
	}
	
	public ReservaTableModel() {
		reservas = new ArrayList<Reserva>();
	}

	public void addRow(Reserva reserva) {
		reservas.add(reserva);
		fireTableDataChanged();
	}
	
	public void removeRow(int linha){
	    reservas.remove(linha);
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
          case 0:  reservas.get(linha).setCpf( (Long)valor );               break;
          case 1:  reservas.get(linha).setData_retirada( (String) valor);   break;
          case 2:  reservas.get(linha).setData_devolucao( (String) valor ); break;
          case 3:  reservas.get(linha).setAgencia_id( (Integer) valor );    break;
      }
      fireTableRowsUpdated(linha, coluna);
  }

	
	@Override
	public int getRowCount() {		
		return reservas.size();
	}
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		
	  switch(coluna){
	      case 0:  return reservas.get(linha).getCpf();           
	      case 1:  return reservas.get(linha).getData_retirada(); 
	      case 2:  return reservas.get(linha).getData_devolucao();
	      case 3:  return reservas.get(linha).getAgencia_id(); 
	  }  
	  return null;
	}		
}






