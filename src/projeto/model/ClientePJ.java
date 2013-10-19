package projeto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientePJ extends Cliente {
	
	private String razao_social        = null;
	private String nome_comercial      = null;
	private long   cnpj                = 0;
	private String inscricao_estadual  = null;
	private String data_fundacao       = null;
	private int    numero_funcionarios = 0;
	

	public String getRazao_social() {
		return razao_social;
	}

	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}

	public String getNome_comercial() {
		return nome_comercial;
	}

	public void setNome_comercial(String nome_comercial) {
		this.nome_comercial = nome_comercial;
	}

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricao_estadual() {
		return inscricao_estadual;
	}

	public void setInscricao_estadual(String inscricao_estadual) {
		this.inscricao_estadual = inscricao_estadual;
	}

	public String getData_fundacao() {
		return data_fundacao;
	}

	public void setData_fundacao(String data_fundacao) {
		this.data_fundacao = data_fundacao;
	}

	public int getNumero_funcionarios() {
		return numero_funcionarios;
	}

	public void setNumero_funcionarios(int numero_funcionarios) {
		this.numero_funcionarios = numero_funcionarios;
	}

	
	

	public static ArrayList<ClientePJ> getArrayObjects() {
		
		PreparedStatement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        
        ArrayList<ClientePJ> clientes = new ArrayList<ClientePJ>();
    
        try {
            
        	String sql = "SELECT * FROM cliente ORDER BY nome ASC";
            Conn bd = new Conn();
            conn = bd.obtemConexao();
            
            stm = conn.prepareStatement(sql);            
            rs = stm.executeQuery();
            
            while (rs.next()) {    
            	ClientePJ cliente = new ClientePJ();
            	cliente.setCpf(rs.getLong("cpf"));
            	cliente.setNome(rs.getString("nome"));
            	cliente.setTelefone(rs.getString("telefone"));
            	cliente.setEmail(rs.getString("email"));
            	cliente.setEndereco(rs.getString("endereco"));
            	cliente.setCidade(rs.getString("cidade"));
            	cliente.setEstado(rs.getString("estado"));
            	cliente.setCep(rs.getString("cep"));
        		            	
            	cliente.setRazao_social(rs.getString("razao_social"));
            	cliente.setNome_comercial(rs.getString("nome_comercial"));
            	cliente.setCnpj(rs.getLong("cnpj"));
            	cliente.setInscricao_estadual(rs.getString("inscricao_estadual"));
            	cliente.setData_fundacao(rs.getString("data_fundacao"));
            	cliente.setNumero_funcionarios(rs.getInt("numero_funcionarios"));
            	cliente.setTipo("PJ");
            	
            	clientes.add(cliente);
            }            

            rs.close();            
            return clientes;
            
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            try {
                conn.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }	            
            return clientes;
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
	
	
	@Override
	public boolean inserir() {		
		
		PreparedStatement stm = null;
        Connection conn = null;
        
        try {

        	String sqlInsert = "INSERT INTO cliente "
        			+ "(cpf, nome, telefone, email, endereco, cidade, estado, cep, "
        			+ "razao_social, nome_comercial, cnpj, inscricao_estadual, data_fundacao, numero_funcionarios, tipo) "
        			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            Conn bd = new Conn();
            conn = bd.obtemConexao();
           
    		stm = conn.prepareStatement(sqlInsert);
    		
    		stm.setLong(  1, getCpf());
    		stm.setString(2, getNome());
    		stm.setString(3, getTelefone());
    		stm.setString(4, getEmail());
    		stm.setString(5, getEndereco());
    		stm.setString(6, getCidade());
    		stm.setString(7, getEstado());
    		stm.setString(8, getCep());
    		stm.setString(9, getRazao_social());
    		stm.setString(10, getNome_comercial());
    		stm.setLong(  11, getCnpj());
    		stm.setString(12, getInscricao_estadual());
    		stm.setString(13, getData_fundacao());
    		stm.setInt(   14, getNumero_funcionarios());
    		stm.setString(15, getTipo());
    		stm.execute();
            
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

	@Override
	public boolean editar() {

		Connection conn = null;
		PreparedStatement stm = null;
		
		try {
		
			String sqlUpdate = "UPDATE cliente SET "
        			+ "cpf = ?, nome = ?, telefone = ?, email = ?, endereco = ?, cidade = ?, estado = ?, cep = ?, "
        			+ "razao_social = ?, nome_comercial = ?, cnpj = ?, inscricao_estadual = ?, data_fundacao = ?, "
        			+ "numero_funcionarios = ?, tipo = ? "
        			+ "WHERE cpf = ?";
			
			Conn bd = new Conn();
            conn = bd.obtemConexao();
			
			stm = conn.prepareStatement(sqlUpdate);

    		stm.setString(1, getNome());
    		stm.setString(2, getTelefone());
    		stm.setString(3, getEmail());
    		stm.setString(4, getEndereco());
    		stm.setString(5, getCidade());
    		stm.setString(6, getEstado());
    		stm.setString(7, getCep());
    		stm.setString(8, getRazao_social());
    		stm.setString(9, getNome_comercial());
    		stm.setLong(  10, getCnpj());
    		stm.setString(11, getInscricao_estadual());
    		stm.setString(12, getData_fundacao());
    		stm.setInt(   13, getNumero_funcionarios());
    		stm.setString(14, getTipo());
    		stm.setLong(  15, getCpf());
    		stm.execute();
            			
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return false;			
		} 
		finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}

	@Override
	protected boolean excluir() {
		// TODO Stub de método gerado automaticamente
		return false;
	}
}
