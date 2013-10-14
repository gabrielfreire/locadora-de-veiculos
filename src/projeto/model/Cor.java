package projeto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Cor {

	private int idCor;
	private String nome;
	
	
	public int getIdCor() {
		return idCor;
	}

	public String getNome() {
		return nome;
	}
	
	public void setIdCor(int idCor) {
		this.idCor = idCor;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
		
	public static ArrayList<Cor> getArrObjects() {
		
		PreparedStatement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        
        ArrayList<Cor> cores = new ArrayList<Cor>();
        
        try {
            String sql = "SELECT * FROM cores"; 
            
            Conn bd = new Conn();
            conn = bd.obtemConexao();
            
            stm = conn.prepareStatement(sql);            
            rs = stm.executeQuery();
               
            while (rs.next()) {
            	Cor cor = new Cor();
            	cor.setIdCor(rs.getInt("id"));
            	cor.setNome(rs.getString("nome"));
            	
            	cores.add(cor);
            }
            rs.close();
            return cores;
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            try {
                conn.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }
            return cores;
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
