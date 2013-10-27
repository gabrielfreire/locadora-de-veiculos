package projeto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Agencia {

	private int codigo      = 0;
	private String nome     = null;
	private String endereco = null;
	private String cidade   = null;
	private String estado   = null;
	private String pais     = null;
	private int idioma_id   = 0;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public int getIdioma_id() {
		return idioma_id;
	}
	public void setIdioma_id(int idioma_id) {
		this.idioma_id = idioma_id;
	}
	
	public static ArrayList<Agencia> getArrayObjects() {
		
		PreparedStatement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        
        ArrayList<Agencia> agencias = new ArrayList<Agencia>();
    
        try {
            
        	String sql = "SELECT * FROM agencia ORDER BY codigo DESC";
            Conn bd = new Conn();
            conn = bd.obtemConexao();
            
            stm = conn.prepareStatement(sql);            
            rs = stm.executeQuery();
            
            while (rs.next()) {    
            	Agencia agencia = new Agencia();
            	agencia.setCodigo(rs.getInt("codigo"));
            	agencia.setNome(rs.getString("nome"));
            	agencia.setEndereco(rs.getString("endereco"));
            	agencia.setCidade(rs.getString("cidade"));
            	agencia.setEstado(rs.getString("estado"));
            	agencia.setPais(rs.getString("pais"));
            	agencia.setIdioma_id(rs.getInt("idioma_id"));
            	
            	agencias.add(agencia);
            }            

            rs.close();            
            return agencias;
            
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            try {
                conn.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }	            
            return agencias;
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
