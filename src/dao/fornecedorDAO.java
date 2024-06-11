package dao;

import conexao.conexao;
import model.Fornecedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class fornecedorDAO {

    
    private  Connection connection;

    public fornecedorDAO() throws SQLException {
        this.connection = conexao.getConnection();
    }

    public void addFornecedor(Fornecedor fornecedor) {
        String sql = "INSERT INTO Fornecedor (nome, telefone, email, endereco) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getTelefone());
            stmt.setString(3, fornecedor.getEmail());
            stmt.setString(4, fornecedor.getEndereco());
            stmt.executeUpdate();
            System.out.println("Fornecedor adicionado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Fornecedor> listFornecedores() {
        List<Fornecedor> fornecedores = new ArrayList<>();
        String sql = "SELECT * FROM Fornecedor";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor(0, sql, sql, sql, sql);
                fornecedor.setId_fornecedor(rs.getInt("id_fornecedor"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedores.add(fornecedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fornecedores;
    }


    public void updateFornecedor(int id, Fornecedor fornecedor) {
        String sql = "UPDATE Fornecedor SET nome = ?, telefone = ?, email = ?, endereco = ? WHERE id_fornecedor = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getTelefone());
            stmt.setString(3, fornecedor.getEmail());
            stmt.setString(4, fornecedor.getEndereco());
            stmt.setInt(5, id);
            stmt.executeUpdate();
            System.out.println("Fornecedor atualizado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        
    
    
    public void deleteFornecedor(int id_fornecedor) {
        String sql = "DELETE FROM Fornecedor WHERE id_fornecedor = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id_fornecedor);
            stmt.executeUpdate();
            System.out.println("Fornecedor removido com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addFornecedoresBatch(List<Fornecedor> fornecedores) {
        String sql = "INSERT INTO Fornecedor (nome, telefone, email, endereco) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false); // Desabilita o commit automático
            
            for (Fornecedor fornecedor : fornecedores) {
                stmt.setString(1, fornecedor.getNome());
                stmt.setString(2, fornecedor.getTelefone());
                stmt.setString(3, fornecedor.getEmail());
                stmt.setString(4, fornecedor.getEndereco());
                stmt.addBatch(); // Adiciona o insert ao batch
            }
            
            stmt.executeBatch(); // Executa todos os inserts em uma transação única
            connection.commit(); // Commit da transação
            System.out.println("Fornecedores adicionados com sucesso.");
        } catch (SQLException e) {
            try {
                connection.rollback(); // Em caso de erro, faz rollback da transação
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true); // Reabilita o commit automático
            } catch (SQLException autoCommitEx) {
                autoCommitEx.printStackTrace();
            }
        }
    }
    public void addFornecedoresIndividuais(List<Fornecedor> fornecedores) {
        String sql = "INSERT INTO Fornecedor (nome, telefone, email, endereco) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            for (Fornecedor fornecedor : fornecedores) {
                stmt.setString(1, fornecedor.getNome());
                stmt.setString(2, fornecedor.getTelefone());
                stmt.setString(3, fornecedor.getEmail());
                stmt.setString(4, fornecedor.getEndereco());
                stmt.executeUpdate();
            }

            System.out.println("Fornecedores adicionados com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


