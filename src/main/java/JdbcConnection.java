import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class JdbcConnection {

    private final List<String> listProduct = new ArrayList<>();
    private final List<Integer> id = new ArrayList<>();
    private final List<Double> priceProduct = new ArrayList<>();

    Connection connection;
    PreparedStatement queryDB;

    public void connect() {

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:banco.db");
            System.out.println("Conectando ao banco");

            queryDB = connection.prepareStatement("SELECT * FROM marketPlace");

            ResultSet resultSet = queryDB.executeQuery();

            while(resultSet.next()) {
                listProduct.add(resultSet.getString("product"));
                priceProduct.add(resultSet.getDouble("price_product"));
                id.add(resultSet.getInt("ID_product"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*public void search(String product) {
        try {
            if(!connection.isClosed())
                System.out.println("Buscando por -> " + product);
            queryDB = connection.prepareStatement("SELECT * FROM marketPlace WHERE product LIKE " + product.replace("\"\"", "''").toUpperCase().indexOf(0));
        } catch (SQLException e) {
            System.out.println("Falha na Conexão, verifique se o bd está conectado");
        }
    }*/

    public List<String> getListProduct() {
        return listProduct;
    }

    public List<Integer> getId() {
        return id;
    }

    public List<Double> getPriceProduct() {
        return priceProduct;
    }
}