package dao;

import conexao.conexao;
import model.Animal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class animalDAO {

    private Connection connection;

    public animalDAO() throws SQLException {
        this.connection = conexao.getConnection();
    }

    public void addAnimal(Animal animal) {
        String sql = "INSERT INTO Animal (nome, especie, raca, idade, id_cliente) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getEspecie());
            stmt.setString(3, animal.getRaca());
            stmt.setInt(4, animal.getIdade());
            stmt.setInt(5, animal.getId_cliente());
            stmt.executeUpdate();
            System.out.println("Animal adicionado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Animal> listAnimals() {
        List<Animal> animals = new ArrayList<>();
        String sql = "SELECT * FROM Animal";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Animal animal = new Animal(0, sql, sql, sql, 0, 0);
                animal.setId_animal(rs.getInt("id_animal"));
                animal.setNome(rs.getString("nome"));
                animal.setEspecie(rs.getString("especie"));
                animal.setRaca(rs.getString("raca"));   
                animal.setIdade(rs.getInt("idade"));
                animal.setId_cliente(rs.getInt("id_cliente"));
                animals.add(animal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animals;
    }

    public void updateAnimal(Animal animal) {
        String sql = "UPDATE Animal SET nome = ?, especie = ?, raca = ?, idade = ?, id_cliente = ? WHERE id_animal = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getEspecie());
            stmt.setString(3, animal.getRaca());
            stmt.setInt(4, animal.getIdade());
            stmt.setInt(5, animal.getId_cliente());
            stmt.setInt(6, animal.getId_animal());
            stmt.executeUpdate();
            System.out.println("Animal atualizado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAnimal(int id_animal) {
        String sql = "DELETE FROM Animal WHERE id_animal = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id_animal);
            stmt.executeUpdate();
            System.out.println("Animal removido com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
