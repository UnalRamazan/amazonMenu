import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class NewOperations {

    Scanner scanner = new Scanner(System.in);
    WriterFile writerFile = new WriterFile();
    ReaderFile readerFile = new ReaderFile();

    ArrayList<String> idOfProduct = new ArrayList<>();
    ArrayList<String> nameOfProduct = new ArrayList<>();
    ArrayList<String> purchasePriceOfProduct = new ArrayList<>();
    ArrayList<String> sellingPriceOfProduct = new ArrayList<>();
    ArrayList<String> quantityOfProduct = new ArrayList<>();

    public NewOperations() {

    }

    public NewOperations(ArrayList<String> idOfProduct, ArrayList<String> nameOfProduct, ArrayList<String> purchasePriceOfProduct, ArrayList<String> sellingPriceOfProduct, ArrayList<String> quantityOfProduct) {
        this.idOfProduct = idOfProduct;
        this.nameOfProduct = nameOfProduct;
        this.purchasePriceOfProduct = purchasePriceOfProduct;
        this.sellingPriceOfProduct = sellingPriceOfProduct;
        this.quantityOfProduct = quantityOfProduct;
    }

    public void addProduct() {
        int id;
        String name;
        int purchasePrice;
        int sellingPrice;
        int quantity;
        boolean result = false;


        System.out.print("Please enter the name of the product you want to add: ");
        name = scanner.next();
        for (String s : nameOfProduct) {
            if (s.toLowerCase().equals(name.toLowerCase())) {
                result = true;
                break;
            }
        }


        if (result) {
            System.out.println("The product you entered cannot be added because it is in the current list.");
        } else {

            do {
                System.out.print("Please enter the id of the product: ");
                id = scanner.nextInt();
                if (idOfProduct.contains(String.valueOf(id))) {
                    System.out.println("The product you entered cannot be added because it is in the current list. Please try again...");
                }
            } while (idOfProduct.contains(String.valueOf(id)));
            idOfProduct.add(String.valueOf(id));

            nameOfProduct.add(name);

            System.out.print("Please enter the purchase price of the product: ");
            purchasePrice = scanner.nextInt();
            purchasePriceOfProduct.add(String.valueOf(purchasePrice));

            System.out.print("Please enter the selling price of the product: ");
            sellingPrice = scanner.nextInt();
            sellingPriceOfProduct.add(String.valueOf(sellingPrice));

            System.out.print("Please enter the quantity of the product: ");
            quantity = scanner.nextInt();
            quantityOfProduct.add(String.valueOf(quantity));

            String str = "Purchase," + id + "," + quantity;
            styleWriterToTransaction(str);

            System.out.println("The product has been successfully added:)");
        }
        printInterface();
    }

    public void deleteProduct() {
        String name, id, quantity;
        int index = 0;
        boolean result = false;

        if (nameOfProduct.isEmpty()) {
            System.out.println("The item to be deleted was not found. The list is empty.");
        } else {
            System.out.print("Please enter the name of the product you want to delete: ");
            name = scanner.next();

            int i = 0;
            for (String s : nameOfProduct) {
                if (s.toLowerCase().equals(name.toLowerCase())) {
                    result = true;
                    index = i;//index = nameOfProduct.indexOf(name);
                    break;
                }
                i++;
            }


            if (result) {

                id = idOfProduct.get(index);//silmeden id dğerini tuttum
                idOfProduct.remove(index);
                nameOfProduct.remove(index);
                purchasePriceOfProduct.remove(index);
                sellingPriceOfProduct.remove(index);
                quantity = quantityOfProduct.get(index);//silmeden ürün miktarını dğerini tuttum
                quantityOfProduct.remove(index);

                String str = "Delete," + id + "," + quantity;
                styleWriterToTransaction(str);

                System.out.println("The product was successfully deleted.");
            } else {
                System.out.println("No products found with the name you entered.");
            }
        }


        printInterface();
    }

    public void updateProduct() {
        System.out.println("Error...");
    }

    public void printProduct() {
        if (nameOfProduct.isEmpty()) {
            System.out.println("No item found in the list to be listed.");
        } else {

            System.out.format("%-15s %-15s %-15s %-15s %-15s", "ID", "Name", "Purchase Price", "Selling Price", "Quantity");
            System.out.println();
            for (int i = 0; i < nameOfProduct.size(); i++) {

                if (Integer.parseInt(quantityOfProduct.get(i)) == 0) {
                    System.out.format("%-15s %-15s %-15s %-15s %-15s", idOfProduct.get(i), nameOfProduct.get(i), purchasePriceOfProduct.get(i), sellingPriceOfProduct.get(i), "Out of stock");
                } else {
                    System.out.format("%-15s %-15s %-15s %-15s %-15s", idOfProduct.get(i), nameOfProduct.get(i), purchasePriceOfProduct.get(i), sellingPriceOfProduct.get(i), quantityOfProduct.get(i));
                }
                System.out.println();
            }
            String str = "Print,0,0";
            styleWriterToTransaction(str);

            printInterface();
        }
    }

    public boolean controlYesNo() {
        String answer;
        boolean result = false;
        System.out.print("Would you like to add the product in current list(y/n)?");
        answer = scanner.next();

        if (answer.equals("y") || answer.equals("Y") || answer.equals("yes") || answer.equals("Yes")) {
            result = true;
        }

        return result;
    }

    public void reportWriter(String str) {
        writerFile.transactionsWriter(str);
    }

    public void styleWriterToTransaction(String str) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat newFormat = new SimpleDateFormat("k:m:s");
        Date date = new Date();
        str += "," + format.format(date) + "," + newFormat.format(date);
        reportWriter(str);
    }

    public void writer() {
        writerFile.productsWriter(idOfProduct, nameOfProduct, purchasePriceOfProduct, sellingPriceOfProduct, quantityOfProduct);
        writerFile.inventoryWriter(idOfProduct, quantityOfProduct);
    }

    public void reader() {
        readerFile.productReader(idOfProduct, nameOfProduct, purchasePriceOfProduct, sellingPriceOfProduct, quantityOfProduct);
    }

    public void printInterface() {
        System.out.println("--------------------------------------------------------------------------------------------");
    }
}
