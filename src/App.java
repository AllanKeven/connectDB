
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.conexao;
import dao.*;
import model.*;

public class App {
    public static void main(String[] args) throws SQLException {

        fornecedorDAO fornecedorDAO = new fornecedorDAO();
             
        List<Fornecedor> fornecedores = new ArrayList<>();
        long startTime = System.currentTimeMillis(); // tempo inicial

        for (int i = 1; i <= 10000; i++) {
            Fornecedor fornecedor = new Fornecedor(i, null, null, null, null);
            fornecedor.setNome("Nome " + i);
            fornecedor.setTelefone("Telefone " + i);
            fornecedor.setEmail("email" + i + "@exemplo.com");
            fornecedor.setEndereco("Endereco " + i);
            fornecedores.add(fornecedor);

        }
        fornecedorDAO.addFornecedoresIndividuais(fornecedores);

        long endTime = System.currentTimeMillis(); // tempo final
        long duration = endTime - startTime; // calcular a diferença de tempo

        int tempo =  (int) (duration/1000) ;
        System.out.println("Tempo total: " + tempo+ " segundos");   
            // Fechando a conexão
            conexao.closeConnection();
        }
        


        
    
}
