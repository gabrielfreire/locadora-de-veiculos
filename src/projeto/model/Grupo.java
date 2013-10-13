package projeto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Grupo {

	private int idGrupo;
	private String nome;
	private String sigla;
	
	
	public int getIdGrupo() {
		return idGrupo;
	}

	public String getNome() {
		return nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public static ArrayList<Grupo> getArrObjects() {
		
		PreparedStatement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        
        ArrayList<Grupo> grupos = new ArrayList<Grupo>();
        
        try {
            String sql = "SELECT * FROM grupo"; 
            
            Conn bd = new Conn();
            conn = bd.obtemConexao();
            
            stm = conn.prepareStatement(sql);            
            rs = stm.executeQuery();
               
            while (rs.next()) {  
            	Grupo grupo = new Grupo();
            	grupo.setIdGrupo(rs.getInt("id"));
            	grupo.setNome(rs.getString("nome"));
            	grupo.setSigla(rs.getString("sigla"));
            	
            	grupos.add(grupo);
            }
            rs.close();
            return grupos;
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            try {
                conn.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }
            return grupos;
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
