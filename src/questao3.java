import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class DiaFaturamento {
    int dia;
    double valor;
}

public class questao3 {
    public static void main(String[] args) {
        List<DiaFaturamento> faturamento = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/dados.json"))) {
            StringBuilder json = new StringBuilder();
            String linha;
            while ((linha = br.readLine()) != null) {
                json.append(linha);
            }

            String jsonString = json.toString().replace("[", "").replace("]", "");
            String[] items = jsonString.split("},");

            for (String item : items) {
                item = item.replace("{", "").replace("}", "");
                String[] pairs = item.split(",");

                DiaFaturamento diaFaturamento = new DiaFaturamento();
                for (String pair : pairs) {
                    String[] keyValue = pair.split(":");
                    String key = keyValue[0].trim().replace("\"", "");
                    String value = keyValue[1].trim();

                    if (key.equals("dia")) {
                        diaFaturamento.dia = Integer.parseInt(value);
                    } else if (key.equals("valor")) {
                        diaFaturamento.valor = Double.parseDouble(value);
                    }
                }
                faturamento.add(diaFaturamento);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        double menorValor = Double.MAX_VALUE;
        double maiorValor = Double.MIN_VALUE;
        double soma = 0;
        int diasComFaturamento = 0;
        List<Double> valoresValidos = new ArrayList<>();

        // Processando os valores
        for (DiaFaturamento dia : faturamento) {
            if (dia.valor > 0) {
                valoresValidos.add(dia.valor);
                soma += dia.valor;
                diasComFaturamento++;

                if (dia.valor < menorValor) {
                    menorValor = dia.valor;
                }
                if (dia.valor > maiorValor) {
                    maiorValor = dia.valor;
                }
            }
        }

        double mediaMensal = soma / diasComFaturamento;
        int diasAcimaDaMedia = 0;

        for (double valor : valoresValidos) {
            if (valor > mediaMensal) {
                diasAcimaDaMedia++;
            }
        }

        System.out.printf("Menor valor de faturamento: R$ %.2f \n" , menorValor);
        System.out.printf("Maior valor de faturamento: R$ %.2f \n" , maiorValor);
        System.out.println("Número de dias acima da média mensal: " + diasAcimaDaMedia);
    }
}
