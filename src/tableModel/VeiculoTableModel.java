package tableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import projeto.model.Veiculo;

public class VeiculoTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2136004293965767274L;
	private ArrayList<Veiculo> veiculos;	
	private String[] colunas = {"Grupo", "Modelo", "Tarifa", "Ano", "Marca"};
	

	public VeiculoTableModel(ArrayList<Veiculo> veiculos) {
		this.veiculos = veiculos;
		tableChanged();
	}
	
	public VeiculoTableModel() {
		veiculos = new ArrayList<Veiculo>();		
		tableChanged();
	}
	
	private void tableChanged() {
//		addTableModelListener(new TableModelListener() {
//			
//			@Override
//			public void tableChanged(TableModelEvent e) {
//				int linha = e.getFirstRow();
//				Veiculo v = veiculos.get(linha);
//				System.out.println(linha);
////				 aqui você atualiza no banco ou em outro lugar qualquer				
//			}
//		});
	}

	public void addRow(Veiculo veiculo) {
		veiculos.add(veiculo);
		fireTableDataChanged();
	}
	
	public void removeRow(int linha){
	    veiculos.remove(linha);
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
          case 0:  veiculos.get(linha).setIdGrupo( (Integer)valor );       break;
          case 1:  veiculos.get(linha).setModelo( (String) valor);         break;
          case 2:  veiculos.get(linha).setTarifaAluguel( (String) valor ); break;
          case 3:  veiculos.get(linha).setAno( (Integer) valor );          break;
          case 4:  veiculos.get(linha).setIdMarca( (Integer) valor );      break;
      }
      fireTableRowsUpdated(linha, linha);
  }

	
	@Override
	public int getRowCount() {		
		return veiculos.size();
	}
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		
      switch(coluna){
	        case 0: return veiculos.get(linha).getIdGrupo();
	        case 1: return veiculos.get(linha).getModelo();
	        case 2: return veiculos.get(linha).getTarifaAluguel();
	        case 3: return veiculos.get(linha).getAno();
	        case 4: return veiculos.get(linha).getIdMarca();
      }  
      return null;
	}

}
