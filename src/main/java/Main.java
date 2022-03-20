import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        product prod = new product();
        prod.getDB();

        System.out.println("Shopping Project - 2022");
        cabo : while(true) {

            System.out.println("\n\n\n\n1 - Produtos disponiveis" +
                    "\n2 - Escolher produto" +
                    "\n3 - Procurar produto" +
                    "\n4 - Retirar produto" +
                    "\n5 - Finalizar compra");

            String op = in.nextLine();
            switch (op) {
                case "1" -> prod.list();
                case "2" -> {
                    String pick = in.nextLine();
                    prod.pickProduct(pick);
                }
                case "3" -> {
                    String search = in.nextLine();
                    prod.searchProduct(search);
                }
                case "4" -> {
                    System.out.println("Para remover tudo insira \"all\"");
                    String deleteProduct = in.nextLine();
                    prod.deleteProduct(deleteProduct);
                }
                case "5" -> {
                    prod.finish();
                break cabo;
                }
            }
        }
    }
}