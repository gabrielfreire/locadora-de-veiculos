package projeto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
	
	public boolean validar(String login, String senha) {
        String sql = "SELECT * FROM atendente WHERE email = ? and senha = ?";
    
        PreparedStatement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        
    
        try {
            
            Conn bd = new Conn();
            conn = bd.obtemConexao();
            
            stm = conn.prepareStatement(sql);
            stm.setString(1, login);
            stm.setString(2, senha);
            rs = stm.executeQuery();
            
            boolean existe_usuario = false;
           
            if (rs.next())
            	existe_usuario = true;
            
            rs.close();
            return existe_usuario;
            
            
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
}
