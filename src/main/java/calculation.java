import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class calculation {

    private final Map<String, Double> listBuy = new HashMap<>();

    public void setListBuy(String product, Double price) {
        listBuy.put(product, price);
    }

    public Map<String, Double> getListBuy() {
        return listBuy;
    }

    public void finish() {
        System.out.println("####NOTINHA#####" +
                "\n\tQuantidade: " + listBuy.size());
        if(!listBuy.isEmpty())
            System.err.println("\t" + listBuy);
        else
            System.err.println("\tCarrinho vazio");
    }
}