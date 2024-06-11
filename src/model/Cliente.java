package model;

public class Cliente {
    private int id_cliente;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public Cliente(int id_cliente, String nome, String endereco, String telefone, String email) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }
    @Override
    public String toString() {
        return "Cliente [id_cliente=" + id_cliente + ", nome=" + nome + ", endereco=" + endereco + ", telefone="
                + telefone + ", email=" + email + ", getEndereco()=" + getEndereco() + ", getEmail()=" + getEmail()
                + ", getId_cliente()=" + getId_cliente() + ", getNome()=" + getNome() + ", getTelefone()="
                + getTelefone() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }
    
  
}