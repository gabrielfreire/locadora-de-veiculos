package projeto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class Locacao {

	private int idLocacao         = 0;
	private String data_retirada  = null;
	private String data_devolucao = null;
	private long cpf              = 0;
	private int agencia_id        = 0;
	private int pagamento_id      = 0;
	private String status         = null;
	

	
	public int getIdLocacao() {
		return idLocacao;
	}
	public void setIdLocacao(int idLocacao) {
		this.idLocacao = idLocacao;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

	public static ArrayList<Locacao> getArrObjects() {
		
		PreparedStatement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        
		ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
		
		try {
            
        	String sql = "SELECT * FROM emprestimo ORDER BY id DESC";
            Conn bd = new Conn();
            conn = bd.obtemConexao();
            
            stm = conn.prepareStatement(sql);            
            rs = stm.executeQuery();
            
            while (rs.next()) {    
            	Locacao locacao = new Locacao();
            	locacao.setIdLocacao(rs.getInt("id"));
            	locacao.setData_retirada(rs.getString("data_retirada"));
            	locacao.setData_devolucao(rs.getString("data_devolucao"));
            	locacao.setCpf(rs.getLong("cpf"));
            	locacao.setAgencia_id(rs.getInt("agencia_id"));
            	locacao.setPagamento_id(rs.getInt("pagamento_id"));
     
               	
            	locacoes.add(locacao);
            }            

            rs.close();            
            return locacoes;
            
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            try {
                conn.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }	            
            return locacoes;
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
	
	public boolean inserirItem(int idVeiculoItem) {

		PreparedStatement stm = null;
        Connection conn = null;
        
        try {

        	String sqlInsert = "INSERT INTO itensEmprestimo "
        			+ "(emprestimo_id, veiculo_id) "
        			+ "VALUES (?, ?)";

            Conn bd = new Conn();
            conn = bd.obtemConexao();
           
    		stm = conn.prepareStatement(sqlInsert);
    	
    		stm.setInt(1, getIdLocacao());
    		stm.setInt(2, idVeiculoItem);
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
	
	
	public boolean inserir() {

        PreparedStatement stm = null;
        Connection conn = null;
        
        try {

        	String sqlInsert = "INSERT INTO emprestimo "
        			+ "(data_retirada, data_devolucao, cpf, agencia_id, pagamento_id) "
        			+ "VALUES (?, ?, ?, ?, ?)";

            Conn bd = new Conn();
            conn = bd.obtemConexao();
           
    		stm = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
    		
    		stm.setString(1, getData_retirada());
    		stm.setString(2, getData_devolucao());
    		stm.setLong(  3, getCpf());
    		stm.setInt(   4, getAgencia_id());
    		stm.setInt(   5, getPagamento_id());
    		stm.execute();
            
    		// Setar id que acabou de ser inserido
    		ResultSet rs = stm.getGeneratedKeys();
    		if (rs.next()) {
    			setIdLocacao(rs.getInt(1));
    		}
    		return true;
            
            
        } catch (SQLException e) {
        	
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
	
	
		

	public static boolean checar(long cpf) {
	
		PreparedStatement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        
    
        try {
            
        	String sql = "SELECT * FROM emprestimo WHERE cpf = ? && status = ?";
            Conn bd = new Conn();
            conn = bd.obtemConexao();
            
            stm = conn.prepareStatement(sql);            
            stm.setLong(1, cpf);
            stm.setString(2, "locado");
            
            rs = stm.executeQuery();
            
            
            if (rs.next()) {
            	rs.close();
            	return true;
            }            

            rs.close();            
            return false;
            
            
        } catch (SQLException e) {
            
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
	
	public boolean editarIdPagamento() {
		
		Connection conn = null;
		PreparedStatement stm = null;
		
		try {
		
			String sqlUpdate = "UPDATE emprestimo SET "
	    			+ "pagamento_id = ? "
	    			+ "WHERE id = ?";
			
			Conn bd = new Conn();
            conn = bd.obtemConexao();
			
			stm = conn.prepareStatement(sqlUpdate);

			stm.setInt(1, getPagamento_id());
			stm.setInt(2, getIdLocacao());
			stm.execute();

			return true;

		} catch (Exception e) {
			
			System.out.print(e.getMessage());
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

	
	public boolean editarStatus() {
		
		Connection conn = null;
		PreparedStatement stm = null;
		
		try {
		
			String sqlUpdate = "UPDATE emprestimo SET "
        			+ "status = ? "
        			+ "WHERE cpf = ? && status = ?";
			
			Conn bd = new Conn();
            conn = bd.obtemConexao();
			
			stm = conn.prepareStatement(sqlUpdate);

    		stm.setString(1, getStatus());
    		stm.setLong(  2, getCpf());   
    		stm.setString(3, "locado");
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

	
}
