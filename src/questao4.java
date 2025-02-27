public class questao4 {

    public static void main(String[] args) {



    double sp = 67836.43;
    double rj = 36678.66;
    double mg = 29229.88;
    double es = 27165.48;
    double outros = 19849.53;

    double total = sp + rj + mg + es + outros;

    double porcentagemSp = (sp / total) * 100;
    double porcentagemRj = (rj / total) * 100;
    double porcentagemMg = (mg / total) * 100;
    double porcentagemEs = (es / total) * 100;
    double porcentagemOutros = (outros / total) * 100;

    System.out.println("Percentual de representação de cada estado:");
        System.out.printf("SP: %.2f%%\n", porcentagemSp);
        System.out.printf("RJ: %.2f%%\n", porcentagemRj);
        System.out.printf("MG: %.2f%%\n", porcentagemMg);
        System.out.printf("ES: %.2f%%\n", porcentagemEs);
        System.out.printf("Outros: %.2f%%\n", porcentagemOutros);
}
}
