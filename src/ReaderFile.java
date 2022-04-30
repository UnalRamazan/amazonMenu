import java.io.*;
import java.util.ArrayList;

public class ReaderFile {

    public ReaderFile() {

    }

    public void productReader(ArrayList<String> idOfProduct, ArrayList<String> nameOfProduct, ArrayList<String> purchasePrice, ArrayList<String> sellingPrice, ArrayList<String> quantity) {
        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Products.txt"));

            while ((line = bufferedReader.readLine()) != null) {

                idOfProduct.add(line.split(",")[0]);
                nameOfProduct.add(line.split(",")[1]);
                purchasePrice.add(line.split(",")[2]);
                sellingPrice.add(line.split(",")[3]);
                quantity.add(line.split(",")[4]);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Dosya okunurken sıkıntı çıktı...Reader");
        }
    }

    public void transactionsReader(ArrayList<String> operations, ArrayList<String> ID, ArrayList<String> quantity, ArrayList<String> year, ArrayList<String> hourTime) {

        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Transactions.txt"));

            while ((line = bufferedReader.readLine()) != null) {
                operations.add(line.split(",")[0]);
                ID.add(line.split(",")[1]);
                quantity.add(line.split(",")[2]);
                year.add(line.split(",")[3]);
                hourTime.add(line.split(",")[4]);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Dosya okunurken sıkıntı çıktı...Transsac");
        }

    }
}
