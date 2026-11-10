import java.time.LocalDate;

public class Venda {
    private int id;
    private LocalDate data;
    private String produto;
    private String vendedor;
    private int quantidade;
    private double precoUnitario;

    public Venda(int id, LocalDate data, String produto, String vendedor, int quantidade, double precoUnitario) {
        this.id = id;
        this.data = data;
        this.produto = produto;
        this.vendedor = vendedor;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public double getTotal() {
        return quantidade * precoUnitario;
    }

    public int getId() { return id; }
    public LocalDate getData() { return data; }
    public String getProduto() { return produto; }
    public String getVendedor() { return vendedor; }
    public int getQuantidade() { return quantidade; }
    public double getPrecoUnitario() { return precoUnitario; }
}