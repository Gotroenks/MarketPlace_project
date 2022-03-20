import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class product extends JdbcConnection{

    AllProducts products = new AllProducts();
    calculation calc = new calculation();
    Scanner scan = new Scanner(System.in);

    int i = 0;

    public void list() {
        if(!products.getProduct().isEmpty())
            products.getProduct().stream().map(t -> t + (t.length() > 7 ? "  Price: ": "\t  Price: ")
                            + products.getPriceProduct().toArray()[i++])
                              .forEach(System.err::println);
        else
            System.out.println("Nenhum produto disponivel");
    }

    public void getDB(){
        connect();
        products.setProduct(getListProduct());
        products.setIdProduct(getId());
        products.setPriceProduct(getPriceProduct());
    }

    public void searchProduct(@NotNull String product) {
        i = 0;
        if(products.getProduct().contains(validateProduct(product))) {
            products.getProduct().stream().map(t -> t + " \t|\t price: " + products.getPriceProduct().toArray()[i++])
                    .filter(t -> t.contains(product)).forEach(System.err::println);

            System.out.println("\n\nDeseja colocar no carrinho ?");
            String insert = scan.nextLine();
            switch (insert.toUpperCase()) {
                case "YES", "SIM", "1", "Y", "S" -> pickProduct(product);
            }
        }
        else
            System.out.println("Produto não encontrado");
    }

    public void pickProduct(String product) {
        if(!products.getProduct().contains(validateProduct(product)))
            System.out.println("Produto não encontrado");
        else {
            Double price = (double) getPriceProduct().toArray()[products.getProduct().indexOf(validateProduct(product))];
            calc.setListBuy(product, price);
            System.out.println("Produto adicionado ao carrinho");
        }
    }

    @SuppressWarnings("SuspiciousMethodCalls")
    public void deleteProduct(@NotNull String product) {
        if(!product.equalsIgnoreCase("ALL"))
            if(!calc.getListBuy().containsKey(validateProduct(product)))
                System.out.println("Esse produto não foi adicionado");
            else {
                calc.getListBuy().remove(product, getPriceProduct().toArray()[products.getProduct().indexOf(validateProduct(product))]);
                System.out.println("\n" + product + " foi removido");
            }
        else {
            calc.getListBuy().clear();
            System.out.println("\nCarrinho limpo");
        }
    }

    private @NotNull String validateProduct(String product) {
        product = product.substring(0,1).toUpperCase() + product.substring(1);
        return product;
    }

    public void finish() {
        calc.finish();
    }
}