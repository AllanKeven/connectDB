package dao;

import conexao.conexao;
import model.Venda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class vendaDAO {

    private Connection connection;

    public vendaDAO() throws SQLException {
        this.connection = conexao.getConnection();
    }

    public void addVenda(Venda venda) {
        String sql = "INSERT INTO Venda (data_venda, id_cliente, valor_total) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, venda.getData_venda());
            stmt.setInt(2, venda.getId_cliente());
            stmt.setDouble(3, venda.getValor_total());
            stmt.executeUpdate();

            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    venda.setId_venda(generatedKeys.getInt(1));
                }
            }

            System.out.println("Venda adicionada com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Venda> listVendas() {
        List<Venda> vendas = new ArrayList<>();
        String sql = "SELECT * FROM Venda";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Venda venda = new Venda(0, sql, 0, 0);
                venda.setId_venda(rs.getInt("id_venda"));
                venda.setData_venda(rs.getString("data_venda"));
                venda.setId_cliente(rs.getInt("id_cliente"));
                venda.setValor_total(rs.getDouble("valor_total"));
                vendas.add(venda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendas;
    }

    public void updateVenda(Venda venda) {
        String sql = "UPDATE Venda SET data_venda = ?, id_cliente = ?, valor_total = ? WHERE id_venda = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, venda.getData_venda());
            stmt.setInt(2, venda.getId_cliente());
            stmt.setDouble(3, venda.getValor_total());
            stmt.setInt(4, venda.getId_venda());
            stmt.executeUpdate();
            System.out.println("Venda atualizada com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVenda(int id_venda) {
        String sql = "DELETE FROM Venda WHERE id_venda = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id_venda);
            stmt.executeUpdate();
            System.out.println("Venda removida com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}