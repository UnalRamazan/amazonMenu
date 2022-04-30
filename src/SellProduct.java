import java.util.ArrayList;

public class SellProduct extends NewOperations {

    public SellProduct() {
    }

    public SellProduct(ArrayList<String> idOfProduct, ArrayList<String> nameOfProduct, ArrayList<String> purchasePriceOfProduct, ArrayList<String> sellingPriceOfProduct, ArrayList<String> quantityOfProduct) {
        super(idOfProduct, nameOfProduct, purchasePriceOfProduct, sellingPriceOfProduct, quantityOfProduct);
    }

    public void sellProduct() {
        String name;
        int index = 0, quantity;
        boolean result = false, result1 = false;

        if (nameOfProduct.isEmpty()) {
            System.out.println("There are currently no products in stock. We will be with you soon with our new products.");
            if (controlYesNo()) {
                addProduct();
            }
        } else {
            System.out.println("Welcome...");
            printProduct();
            do {
                System.out.print("Please enter the name of the product you want to buy: ");
                name = scanner.next();

                int i = 0;
                for (String s : nameOfProduct) {
                    if (s.toLowerCase().equals(name.toLowerCase())) {
                        index = i;//index = nameOfProduct.indexOf(name);
                        result1 = true;
                        break;
                    }
                    i++;
                }


                if (result1 && Integer.parseInt(quantityOfProduct.get(index)) != 0) {
                    result = true;

                    do {
                        System.out.print("Please enter the number of products you want to buy: ");
                        quantity = scanner.nextInt();

                        if (quantity <= 0 || quantity > Integer.parseInt(quantityOfProduct.get(index))) {
                            System.out.println("Product quantity cannot be less than or equal to zero and the product quantity is not more than stock. Please try again...");
                        }
                    } while (quantity <= 0 || quantity > Integer.parseInt(quantityOfProduct.get(index)));

                    int box = Integer.parseInt(quantityOfProduct.get(index)) - quantity;
                    quantityOfProduct.set(index, String.valueOf(box));


                    String str = "Sale," + idOfProduct.get(index) + "," + quantity;
                    styleWriterToTransaction(str);

                    System.out.println("The sale was successful...");
                } else {
                    System.out.println("The product with the name you entered was not found or products are out of stock. please enter the names of the available products.");
                }
            } while (!result);
            printInterface();
        }
    }
}
