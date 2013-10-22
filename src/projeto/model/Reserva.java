package projeto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Reserva {

	private int idReserva         = 0;
	private String data_retirada  = null;
	private String data_devolucao = null;
	private long cpf              = 0;
	private int agencia_id        = 0;
	private int pagamento_id      = 0;
	private int itens_id          = 0;
	
	

	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public String getData_retirada() {
		return data_retirada;
	}
	public void setData_retirada(String data_retirada) {
		this.data_retirada = data_retirada;
	}
	public String getData_devolucao() {
		return data_devolucao;
	}
	public void setData_devolucao(String data_devolucao) {
		this.data_devolucao = data_devolucao;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public int getAgencia_id() {
		return agencia_id;
	}
	public void setAgencia_id(int agencia_id) {
		this.agencia_id = agencia_id;
	}
	public int getPagamento_id() {
		return pagamento_id;
	}
	public void setPagamento_id(int pagamento_id) {
		this.pagamento_id = pagamento_id;
	}
	public int getItens_id() {
		return itens_id;
	}
	public void setItens_id(int itens_id) {
		this.itens_id = itens_id;
	}
	
	public static ArrayList<Reserva> getArrObjects() {
		
		PreparedStatement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		
		try {
            
        	String sql = "SELECT * FROM reserva ORDER BY id DESC";
            Conn bd = new Conn();
            conn = bd.obtemConexao();
            
            stm = conn.prepareStatement(sql);            
            rs = stm.executeQuery();
            
            while (rs.next()) {    
            	Reserva reserva = new Reserva();
            	reserva.setIdReserva(rs.getInt("id"));
            	reserva.setData_retirada(rs.getString("data_retirada"));
            	reserva.setData_devolucao(rs.getString("data_devolucao"));
            	reserva.setCpf(rs.getLong("cpf"));
            	reserva.setAgencia_id(rs.getInt("agencia_id"));
            	reserva.setPagamento_id(rs.getInt("pagamento_id"));
            	reserva.setItens_id(rs.getInt("itens_id"));
               	
            	reservas.add(reserva);
            }            

            rs.close();            
            return reservas;
            
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            try {
                conn.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }	            
            return reservas;
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
}
