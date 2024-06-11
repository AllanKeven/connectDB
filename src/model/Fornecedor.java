package model;

public class Fornecedor {
    private int id_fornecedor;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;

    
    public int getId_fornecedor() {
        return id_fornecedor;
    }
    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public Fornecedor(int id_fornecedor, String nome, String telefone, String email, String endereco) {
        this.id_fornecedor = id_fornecedor;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }
    @Override
    public String toString() {
        return "Fornecedor [id_fornecedor=" + id_fornecedor + ", nome=" + nome + ", telefone=" + telefone + ", email="
                + email + ", endereco=" + endereco + "]";
    }
    
}
