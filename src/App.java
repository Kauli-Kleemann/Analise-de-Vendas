import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {

    public static List<Venda> lerVendas(String caminho) {
    List<Venda> vendas = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(caminho, StandardCharsets.UTF_8))) {

        br.readLine(); // pula o cabeçalho

        String linha;
        while ((linha = br.readLine()) != null) {
            if (linha.isBlank()) {
                continue; // ignora linhas vazias
            }

            String [] c = linha.split(",");
            vendas.add(new Venda(Integer.parseInt(c[0]), LocalDate.parse(c[1]), c[2], c[3], Integer.parseInt(c[4]), Double.parseDouble(c[5])));
        }
    } catch (IOException e) {
        System.out.println("Erro ao ler o arquivo: " + e.getMessage());
    }
    return vendas;
}

    public static void main(String[] args) {
        List<Venda> vendas = lerVendas("vendas.csv");

        System.out.println("Vendas lidas: " + vendas.size());
        for (Venda v : vendas) {
            System.out.println(v.getProduto() + " | " + v.getVendedor() + " | R$ " + v.getTotal());
        }

        Analisador analisador = new Analisador(vendas);

        System.out.println("Total por Produto:");
        for (Map.Entry<String, Double> e : analisador.totalPorProduto().entrySet()) {
            System.out.printf("%s: R$ %.2f%n", e.getKey(), e.getValue());
        }
    }
}
