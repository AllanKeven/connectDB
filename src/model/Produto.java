package model;

public class Produto {
    private int id_produto;
    private String nome;
    private String categoria;
    private double preco;
    private int estoque;
    private int id_fornecedor;
    
    public int getId_produto() {
        return id_produto;
    }
    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getEstoque() {
        return estoque;
    }
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    public int getId_fornecedor() {
        return id_fornecedor;
    }
    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }
    public Produto(int id_produto, String nome, String categoria, double preco, int estoque, int id_fornecedor) {
        this.id_produto = id_produto;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.estoque = estoque;
        this.id_fornecedor = id_fornecedor;
    }

    
    
}
