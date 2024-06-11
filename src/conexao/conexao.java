package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao{
    private static final String url ="jdbc:mysql://localhost:3306/sistema_pets";
    private static final String user = "root";
    private static final String password = "1234";

    private static Connection conn;

    public static Connection getConnection() throws SQLException{

        try{
            if(conn == null){
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            }else{
                return conn;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Desconectado do banco de dados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}