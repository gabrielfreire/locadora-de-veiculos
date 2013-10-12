package projeto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Menu {
	
	private ArrayList<String> idiomas;
	private ArrayList<String> agencias;
	
	/**
	 * Combobox para listar idiomas
	 */
	public ArrayList<String> getArrIdiomas() {
    	
    	String sql = "SELECT * FROM idioma";
        
        PreparedStatement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        
        
    
        try {
            
            Conn bd = new Conn();
            conn = bd.obtemConexao();
            
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            
            idiomas = new ArrayList<String>();
            
            while (rs.next()) {            	
            	idiomas.add(rs.getString("nome"));
            }
            
            rs.close();   
            return idiomas;
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            try {
                conn.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }
            return idiomas;
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

	/**
	 * Combobox para listar agências
	 */
    public ArrayList<String> getArrAgencias() {

    	String sql = "SELECT * FROM agencia";
        
        PreparedStatement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        
        
        try {
            
            Conn bd = new Conn();
            conn = bd.obtemConexao();
            
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            
            agencias = new ArrayList<String>();
            
            while (rs.next()) {             	
            	agencias.add(rs.getString("nome"));
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
