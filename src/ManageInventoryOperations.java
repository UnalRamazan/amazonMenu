import java.util.ArrayList;

public class ManageInventoryOperations extends NewOperations {

    public ManageInventoryOperations() {
    }

    public ManageInventoryOperations(ArrayList<String> idOfProduct, ArrayList<String> nameOfProduct, ArrayList<String> purchasePriceOfProduct, ArrayList<String> sellingPriceOfProduct, ArrayList<String> quantityOfProduct) {
        super(idOfProduct, nameOfProduct, purchasePriceOfProduct, sellingPriceOfProduct, quantityOfProduct);
    }

    @Override
    public void updateProduct() {
        String name;
        int i = 0, newQuantity, index = 0;
        boolean result = false;

        if (nameOfProduct.isEmpty()) {
            System.out.println("No item found in the list to be listed.");
            if (controlYesNo()) {
                addProduct();
            }
        } else {
            System.out.println("Please enter the name of the product for which you want to change the stock quantity: ");
            name = scanner.next();

            int j = 0;
            for (String s : nameOfProduct) {
                if (s.toLowerCase().equals(name.toLowerCase())) {
                    result = true;
                    index = j; //index = nameOfProduct.indexOf(name);
                    break;
                }
                j++;
            }


            if (result) {

                System.out.println("Current stock: " + quantityOfProduct.get(index));
                System.out.print("Please enter the new stock information: ");
                newQuantity = scanner.nextInt();
                quantityOfProduct.set(index, String.valueOf(newQuantity));
                System.out.println("New stock: " + quantityOfProduct.get(index));

                String str = "Updated," + idOfProduct.get(i) + "," + newQuantity;
                styleWriterToTransaction(str);
            } else {
                System.out.println("No products found with the name you entered.");
                if (controlYesNo()) {
                    addProduct();
                }
            }
        }
        printInterface();
    }

    @Override
    public void printProduct() {
        if (nameOfProduct.isEmpty()) {
            System.out.println("No item found in the list to be listed.");
        } else {

            for (String s : nameOfProduct) {
                System.out.println("->" + s + "<-");
            }
            String str = "Print,0,0";
            styleWriterToTransaction(str);

            printInterface();
        }
    }
}
