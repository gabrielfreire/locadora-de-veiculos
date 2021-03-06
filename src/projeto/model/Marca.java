package projeto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Marca {

	private int idMarca;
	private String nome;
	
	
	public int getIdMarca() {
		return idMarca;
	}

	public String getNome() {
		return nome;
	}
	
	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
		
	public static ArrayList<Marca> getArrObjects() {
		
		PreparedStatement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        
        ArrayList<Marca> marcas = new ArrayList<Marca>();
        
        try {
            String sql = "SELECT * FROM marcas"; 
            
            Conn bd = new Conn();
            conn = bd.obtemConexao();
            
            stm = conn.prepareStatement(sql);            
            rs = stm.executeQuery();
               
            while (rs.next()) {    
            	Marca marca = new Marca();
            	marca.setIdMarca(rs.getInt("id"));
            	marca.setNome(rs.getString("nome"));
            	
            	marcas.add(marca);
            }
            rs.close();
            return marcas;
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            try {
                conn.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }
            return marcas;
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
