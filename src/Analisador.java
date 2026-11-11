import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Analisador {
    private List<Venda> vendas;

    public Analisador(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public Map<String, Double> totalPorProduto() {
        Map<String, Double> totais = new HashMap<>();

        for (Venda v : vendas) {
            totais.merge(v.getProduto(), v.getTotal(), Double::sum);
        }
        return totais;
    }

    public Map<String, Double> totalPorVendedor() {
        Map<String, Double> totais = new HashMap<>();

        for (Venda v : vendas) {
            totais.merge(v.getVendedor(), v.getTotal(), Double::sum);
        }
        return totais;
    }
}