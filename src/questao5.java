import java.util.Scanner;

public class questao5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma string: ");
        String input = sc.nextLine();

        String invertida = inverterString(input);

        System.out.println("String invertida: " + invertida);

        sc.close();
    }

    public static String inverterString(String str) {
        char[] caracteres = str.toCharArray();
        int esquerda = 0;
        int direita = caracteres.length - 1;

        while (esquerda < direita) {
            char temp = caracteres[esquerda];
            caracteres[esquerda] = caracteres[direita];
            caracteres[direita] = temp;

            esquerda++;
            direita--;
        }

        return new String(caracteres);
    }
}