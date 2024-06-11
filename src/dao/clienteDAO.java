package dao;


import conexao.conexao;
import model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class clienteDAO {

    private Connection connection;

    public clienteDAO() throws SQLException {
        this.connection = conexao.getConnection();
    }

    public void addCliente(Cliente cliente) {
        String sql = "INSERT INTO Cliente (nome, endereco, telefone, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.executeUpdate();
            System.out.println("Cliente adicionado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> listClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente(0, sql, sql, sql, sql);
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public void updateCliente(Cliente cliente) {
        String sql = "UPDATE Cliente SET nome = ?, endereco = ?, telefone = ?, email = ? WHERE id_cliente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setInt(5, cliente.getId_cliente());
            stmt.executeUpdate();
            System.out.println("Cliente atualizado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "clienteDAO [connection=" + connection + ", listClientes()=" + listClientes() + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    public void deleteCliente(int id_cliente) {
        String sql = "DELETE FROM Cliente WHERE id_cliente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id_cliente);
            stmt.executeUpdate();
            System.out.println("Cliente removido com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
