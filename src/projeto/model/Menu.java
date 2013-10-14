package projeto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Menu {
	
	
	/**
	 * Combobox para listar idiomas
	 */
	public static ArrayList<String> getArrIdiomas() {
    	
    	String sql = "SELECT * FROM idioma";
        
        PreparedStatement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        
        ArrayList<String> idiomas = new ArrayList<String>();
    
        
        try {
            
            Conn bd = new Conn();
            conn = bd.obtemConexao();
            
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            
            
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
    public static ArrayList<String> getArrAgencias() {

    	String sql = "SELECT * FROM agencia";
        
        PreparedStatement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        
        ArrayList<String> agencias = new ArrayList<String>();
        
        
        try {
            
            Conn bd = new Conn();
            conn = bd.obtemConexao();
            
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            
            
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
