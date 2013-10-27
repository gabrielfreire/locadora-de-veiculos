package projeto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Pagamento {

	private int idPagamento        = 0;
	private String banco           = null;
	private String agencia         = null;
	private String conta_corrente  = null;
	private String nome_titular    = null;
	private long cpf               = 0;
	private String telefone        = null;
	private String bandeira_cartao = null;
	private int numero_cartao      = 0;
	private String validade        = null;
	private int cod_seguranca      = 0;
	private String valor_cobrado   = null;
	private String status          = null;
	
	
	
	public int getIdPagamento() {
		return idPagamento;
	}
	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getConta_corrente() {
		return conta_corrente;
	}
	public void setConta_corrente(String conta_corrente) {
		this.conta_corrente = conta_corrente;
	}
	public String getNome_titular() {
		return nome_titular;
	}
	public void setNome_titular(String nome_titular) {
		this.nome_titular = nome_titular;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getBandeira_cartao() {
		return bandeira_cartao;
	}
	public void setBandeira_cartao(String bandeira_cartao) {
		this.bandeira_cartao = bandeira_cartao;
	}
	public int getNumero_cartao() {
		return numero_cartao;
	}
	public void setNumero_cartao(int numero_cartao) {
		this.numero_cartao = numero_cartao;
	}
	public String getValidade() {
		return validade;
	}
	public void setValidade(String validade) {
		this.validade = validade;
	}
	public int getCod_seguranca() {
		return cod_seguranca;
	}
	public void setCod_seguranca(int cod_seguranca) {
		this.cod_seguranca = cod_seguranca;
	}
	public String getValor_cobrado() {
		return valor_cobrado;
	}
	public void setValor_cobrado(String valor_cobrado) {
		this.valor_cobrado = valor_cobrado;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	public boolean inserirCheque() {
		
		PreparedStatement stm = null;
        Connection conn = null;
        
        try {

        	String sqlInsert = "INSERT INTO pagamento "
        			+ "(cpf, banco, agencia, conta_corrente, nome_titular, telefone, status) "
        			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

        	
        	
            Conn bd = new Conn();
            conn = bd.obtemConexao();
            
    		stm = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
                		
    		stm.setLong(  1, getCpf());
    		stm.setString(2, getBanco());
    		stm.setString(3, getAgencia());
    		stm.setString(4, getConta_corrente());
    		stm.setString(5, getNome_titular());    		
    		stm.setString(6, getTelefone());
    		stm.setString(7, getStatus());
    		stm.execute();
            
    		// Setar id que acabou de ser inserido
    		ResultSet rs = stm.getGeneratedKeys();
    		if (rs.next()) {
    			setIdPagamento(rs.getInt(1));
    		}
    		
    		return true;
            
            
        } catch (SQLException e) {
    
            System.out.print(e.getMessage());
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

	
	public boolean inserirCredito() {
		
		PreparedStatement stm = null;
        Connection conn = null;
        
        try {

        	String sqlInsert = "INSERT INTO pagamento "
        			+ "(cpf, bandeira_cartao, numero_cartao, validade, cod_seguranca, "
        			+ "valor_cobrado, status) "
        			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

            Conn bd = new Conn();
            conn = bd.obtemConexao();
            
    		stm = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
    		    		
    		stm.setLong(  1, getCpf());
    		stm.setString(2, getBandeira_cartao());
    		stm.setInt(   3, getNumero_cartao());
    		stm.setString(4, getValidade());
    		stm.setInt(   5, getCod_seguranca());
    		stm.setString(6, getValor_cobrado());
    		stm.setString(7, getStatus());
    		stm.execute();
            
    		// Setar id que acabou de ser inserido
    		ResultSet rs = stm.getGeneratedKeys();
    		if (rs.next()) {
    			setIdPagamento(rs.getInt(1));
    		}
    		
    		return true;
            
            
        } catch (SQLException e) {
    
            System.out.print(e.getMessage());
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

	
}
