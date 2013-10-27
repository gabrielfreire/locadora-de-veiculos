package projeto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import auxiliar.Data;



public class Devolucao {

	private int idEmprestimo   = 0;
	private long cpf           = 0;
	private String data        = null;
	private String valor_multa = null;
	private int emprestimo_id  = 0;
	private int agencia_id     = 0;
	
	
	
	public int getIdEmprestimo() {
		return idEmprestimo;
	}
	public void setIdEmprestimo(int idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getValor_multa() {
		return valor_multa;
	}
	public void setValor_multa(String valor_multa) {
		this.valor_multa = valor_multa;
	}
	public int getEmprestimo_id() {
		return emprestimo_id;
	}
	public void setEmprestimo_id(int emprestimo_id) {
		this.emprestimo_id = emprestimo_id;
	}
	public int getAgencia_id() {
		return agencia_id;
	}
	public void setAgencia_id(int agencia_id) {
		this.agencia_id = agencia_id;
	}
	
	
	public boolean inserir() {

        PreparedStatement stm = null;
        Connection conn = null;
        
        try {

        	String sqlInsert = "INSERT INTO devolucao "
        			+ "(cpf, data, valor_multa) "
        			+ "VALUES (?, ?, ?)";

            Conn bd = new Conn();
            conn = bd.obtemConexao();
           
    		stm = conn.prepareStatement(sqlInsert);
    		
    		stm.setLong(  1, getCpf());
    		stm.setString(2, getData());
    		stm.setString(3, getValor_multa());
    		stm.execute();
            
    		return true;
            
            
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
            e.printStackTrace();
            try {
                conn.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }
            return false;
        }
        finally{
            if (stm != null) {
                try {
                    stm.close();
                }
                catch (SQLException e1) {
                    System.out.print(e1.getStackTrace());
                }
            }
        }
	}
	
	
	
	public static double calcularMulta(String data_devolucao) {
		  
		int diff = Data.diffDays(data_devolucao, String.valueOf(new Date()));
		
		if (diff > 0)
			return diff;
		
		return 0;
	}
	
}
