
import java.sql.SQLException;

import java.util.List;

import conexao.conexao;
import dao.*;
import model.*;

public class App {
    public static void main(String[] args) throws SQLException {

        
             
        clienteDAO clienteDAO = new clienteDAO();
        List<Cliente> clientes = clienteDAO.listClientes();
        for(Cliente cliente : clientes){
            System.out.println(cliente);
        }
              
            // Fechando a conexão
            conexao.closeConnection();
        }
        


        
    
}
