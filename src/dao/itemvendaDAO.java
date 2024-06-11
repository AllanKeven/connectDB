package dao;

import conexao.conexao;
import model.ItemVenda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class itemvendaDAO {

    private Connection connection;

    public itemvendaDAO() throws SQLException {
        this.connection = conexao.getConnection();
    }

    public void addItemVenda(ItemVenda itemVenda) {
        String sql = "INSERT INTO ItemVenda (id_venda, id_produto, quantidade, preco_unitario) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, itemVenda.getId_venda());
            stmt.setInt(2, itemVenda.getId_produto());
            stmt.setInt(3, itemVenda.getQuantidade());
            stmt.setDouble(4, itemVenda.getPreco_unitario());
            stmt.executeUpdate();
            System.out.println("Item de venda adicionado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ItemVenda> listItensVenda() {
        List<ItemVenda> itensVenda = new ArrayList<>();
        String sql = "SELECT * FROM ItemVenda";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ItemVenda itemVenda = new ItemVenda(0, 0, 0, 0, 0);
                itemVenda.setId_item_venda(rs.getInt("id_item_venda"));
                itemVenda.setId_venda(rs.getInt("id_venda"));
                itemVenda.setId_produto(rs.getInt("id_produto"));
                itemVenda.setQuantidade(rs.getInt("quantidade"));
                itemVenda.setPreco_unitario(rs.getDouble("preco_unitario"));
                itensVenda.add(itemVenda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itensVenda;
    }

    public void updateItemVenda(ItemVenda itemVenda) {
        String sql = "UPDATE ItemVenda SET id_venda = ?, id_produto = ?, quantidade = ?, preco_unitario = ? WHERE id_item_venda = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, itemVenda.getId_venda());
            stmt.setInt(2, itemVenda.getId_produto());
            stmt.setInt(3, itemVenda.getQuantidade());
            stmt.setDouble(4, itemVenda.getPreco_unitario());
            stmt.setInt(5, itemVenda.getId_item_venda());
            stmt.executeUpdate();
            System.out.println("Item de venda atualizado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteItemVenda(int id_item_venda) {
        String sql = "DELETE FROM ItemVenda WHERE id_item_venda = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id_item_venda);
            stmt.executeUpdate();
            System.out.println("Item de venda removido com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
