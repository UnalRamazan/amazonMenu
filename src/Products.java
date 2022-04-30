import java.util.ArrayList;

public class Products {
    private int idProduct;
    private String nameProduct;
    private double purchasePrice;
    private double sellingPrice;
    private int quantity;

    ArrayList<String> idOfProduct = new ArrayList<>();
    ArrayList<String> nameOfProduct = new ArrayList<>();
    ArrayList<String> purchasePriceOfProduct = new ArrayList<>();
    ArrayList<String> sellingPriceOfProduct = new ArrayList<>();
    ArrayList<String> quantityOfProduct = new ArrayList<>();

    public Products() {

    }

    public Products(int idProduct, String nameProduct, double purchasePrice, double sellingPrice, int quantity) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
