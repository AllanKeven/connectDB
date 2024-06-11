package model;

public class Animal {
    private int id_animal;
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private int id_cliente;
    
    public int getId_animal() {
        return id_animal;
    }
    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public Animal(int id_animal, String nome, String especie, String raca, int idade, int id_cliente) {
        this.id_animal = id_animal;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.id_cliente = id_cliente;
    }
    
    
}
