import java.util.List;

public class AllProducts {

    private List<String> product;
    private List<Integer> idProduct;
    private List<Double> priceProduct;

    public List<String> getProduct() {
        return product;
    }

    public void setProduct(List<String> product) {
        this.product = product;
    }

    public List<Integer> getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(List<Integer> idProduct) {
        this.idProduct = idProduct;
    }

    public List<Double> getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(List<Double> priceProduct) {
        this.priceProduct = priceProduct;
    }
}