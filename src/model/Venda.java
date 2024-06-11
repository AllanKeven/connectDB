package model;

public class Venda {

    private int id_venda;
    private String data_venda;
    private int id_cliente;
    private double valor_total;
    
    public int getId_venda() {
        return id_venda;
    }
    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }
    public String getData_venda() {
        return data_venda;
    }
    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }
    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public double getValor_total() {
        return valor_total;
    }
    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }
    public Venda(int id_venda, String data_venda, int id_cliente, double valor_total) {
        this.id_venda = id_venda;
        this.data_venda = data_venda;
        this.id_cliente = id_cliente;
        this.valor_total = valor_total;
    }

    
    
}
