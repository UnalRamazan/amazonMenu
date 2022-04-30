import java.io.*;
import java.util.ArrayList;

public class WriterFile {

    public WriterFile() {

    }

    public void productsWriter(ArrayList<String> idOfProduct, ArrayList<String> nameOfProduct, ArrayList<String> purchasePrice, ArrayList<String> sellingPrice, ArrayList<String> quantity) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Products.txt"));
            for (int i = 0; i < idOfProduct.size(); i++) {
                writer.write(idOfProduct.get(i) + "," + nameOfProduct.get(i) + "," + purchasePrice.get(i) + "," + sellingPrice.get(i) + "," + quantity.get(i));
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Dosya yazılırken sıkıntı çıktı...");
        }
    }

    public void inventoryWriter(ArrayList<String> idOfProduct, ArrayList<String> quantity) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Inventory.txt"));
            for (int i = 0; i < idOfProduct.size(); i++) {
                writer.write(idOfProduct.get(i) + "," + quantity.get(i));
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Dosya yazılırken sıkıntı çıktı...");
        }
    }

    public void transactionsWriter(String str) {
        String line;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("Transactions.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try {
            if ((line = reader.readLine()) == null) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("Transactions.txt"));
                writer.write("Operation,0,0,0/0/0,0:0:0");
                writer.newLine();
                writer.close();
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("Transactions.txt", true));
            writer.write(str);
            writer.newLine();
            writer.close();

        } catch (Exception e) {
            System.out.println("Dosya yazılırken sıkıntı çıktı...");
        }
    }
}