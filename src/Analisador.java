import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.Locale;

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

    public Map<String, Double> totalPorMes() {
        Map<String, Double> totais = new HashMap<>();

        for (Venda v : vendas) {
            String mes = v.getData().getMonth().getDisplayName(TextStyle.FULL, Locale.of("pt", "BR"));
            totais.merge(mes, v.getTotal(), Double::sum);
        }
        return totais;
    }

    public Map<String, Double> ordenarDecrescente(Map<String, Double> mapa) {
        Map<String, Double> ordenado = new LinkedHashMap<>();

        mapa.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).forEach(e -> ordenado.put(e.getKey(), e.getValue()));

        return ordenado;
    }
}