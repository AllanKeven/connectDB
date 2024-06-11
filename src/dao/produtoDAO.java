package dao;

import conexao.conexao;
import model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class produtoDAO {

    private Connection connection;

    public produtoDAO() throws SQLException {
        this.connection = conexao.getConnection();
    }

    public void addProduto(Produto produto) {
        String sql = "INSERT INTO Produto (nome, categoria, preco, estoque, id_fornecedor) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getCategoria());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getEstoque());
            stmt.setInt(5, produto.getId_fornecedor());
            stmt.executeUpdate();
            System.out.println("Produto adicionado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Produto> listProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM Produto";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Produto produto = new Produto(0, sql, sql, 0, 0, 0);
                produto.setId_produto(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setEstoque(rs.getInt("estoque"));
                produto.setId_fornecedor(rs.getInt("id_fornecedor"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    public void updateProduto(Produto produto) {
        String sql = "UPDATE Produto SET nome = ?, categoria = ?, preco = ?, estoque = ?, id_fornecedor = ? WHERE id_produto = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getCategoria());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getEstoque());
            stmt.setInt(5, produto.getId_fornecedor());
            stmt.setInt(6, produto.getId_produto());
            stmt.executeUpdate();
            System.out.println("Produto atualizado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduto(int id_produto) {
        String sql = "DELETE FROM Produto WHERE id_produto = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id_produto);
            stmt.executeUpdate();
            System.out.println("Produto removido com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
