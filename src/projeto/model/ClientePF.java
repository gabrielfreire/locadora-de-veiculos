package projeto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ClientePF extends Cliente {

	private String rg              = null;
	private String passaporte      = null;
	private String data_nascimento = null;
	private String genero          = null;
	private String habilitacao     = null;
	private String registro        = null;
	private String estado_emissor  = null;
	private String validade        = null;
	
	
	
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getPassaporte() {
		return passaporte;
	}

	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getHabilitacao() {
		return habilitacao;
	}

	public void setHabilitacao(String habilitacao) {
		this.habilitacao = habilitacao;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getEstado_emissor() {
		return estado_emissor;
	}

	public void setEstado_emissor(String estado_emissor) {
		this.estado_emissor = estado_emissor;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	
	public static ArrayList<ClientePF> getArrayObjects() {
		
		PreparedStatement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        
        ArrayList<ClientePF> clientes = new ArrayList<ClientePF>();
    
        try {
            
        	String sql = "SELECT * FROM cliente WHERE tipo = ? ORDER BY nome ASC";
            Conn bd = new Conn();
            conn = bd.obtemConexao();
            
            stm = conn.prepareStatement(sql);
            stm.setString(1, "PF");
            
            rs = stm.executeQuery();
            
            while (rs.next()) {    
            	ClientePF cliente = new ClientePF();
            	cliente.setCpf(rs.getLong("cpf"));
            	cliente.setNome(rs.getString("nome"));
            	cliente.setTelefone(rs.getString("telefone"));
            	cliente.setEmail(rs.getString("email"));
            	cliente.setEndereco(rs.getString("endereco"));
            	cliente.setCidade(rs.getString("cidade"));
            	cliente.setEstado(rs.getString("estado"));
            	cliente.setCep(rs.getString("cep"));
        		            	
            	cliente.setRg(rs.getString("rg"));
            	cliente.setPassaporte(rs.getString("passaporte"));
            	cliente.setData_nascimento(rs.getString("data_nascimento"));
            	cliente.setGenero(rs.getString("genero"));
            	cliente.setHabilitacao(rs.getString("habilitacao"));
            	cliente.setRegistro(rs.getString("registro"));
            	cliente.setEstado_emissor(rs.getString("estado_emissor"));
            	cliente.setValidade(rs.getString("validade"));
            	
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

        	String sqlInsert = "INSERT INTO cliente"
        			+ "(cpf, nome, telefone, email, endereco, cidade, estado, cep, "
        			+ "rg, passaporte, data_nascimento, genero, habilitacao, registro, estado_emissor, validade, tipo) "
        			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
    		stm.setString(9, getRg());
    		stm.setString(10, getPassaporte());
    		stm.setString(11, getData_nascimento());
    		stm.setString(12, getGenero());
    		stm.setString(13, getHabilitacao());
    		stm.setString(14, getRegistro());
    		stm.setString(15, getEstado_emissor());
    		stm.setString(16, getValidade());
    		stm.setString(17, getTipo());
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
        			+ "nome = ?, telefone = ?, email = ?, endereco = ?, cidade = ?, estado = ?, cep = ?, "
        			+ "rg = ?, passaporte = ?, data_nascimento = ?, genero = ?, habilitacao = ?, registro = ?, "
        			+ "estado_emissor = ?, validade = ?, tipo = ? "
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
    		stm.setString(8, getRg());
    		stm.setString(9, getPassaporte());
    		stm.setString(10, getData_nascimento());
    		stm.setString(11, getGenero());
    		stm.setString(12, getHabilitacao());
    		stm.setString(13, getRegistro());
    		stm.setString(14, getEstado_emissor());
    		stm.setString(15, getValidade());
    		stm.setString(16, getTipo());
    		stm.setLong(  17, getCpf());
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
	public boolean excluir() {
		// TODO Stub de método gerado automaticamente
		return false;
	}
}
