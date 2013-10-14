package projeto.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável pela conexão com banco de dados mysql
 * 
 * @author lab02
 *
 */
public class Conn {


    // -----------------------------------------------------------
    // Carrega driver JDBC
    //
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // -----------------------------------------------------------
    public Connection obtemConexao() throws SQLException {
        return DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/locacao?user=root&password=mysql");
    }
}