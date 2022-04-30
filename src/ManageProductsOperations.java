import java.util.ArrayList;

public class ManageProductsOperations extends NewOperations {

    public ManageProductsOperations() {
    }

    public ManageProductsOperations(ArrayList<String> idOfProduct, ArrayList<String> nameOfProduct, ArrayList<String> purchasePriceOfProduct, ArrayList<String> sellingPriceOfProduct, ArrayList<String> quantityOfProduct) {
        super(idOfProduct, nameOfProduct, purchasePriceOfProduct, sellingPriceOfProduct, quantityOfProduct);
    }

    @Override
    public void updateProduct() {
        String name;
        int index = 0, choice;
        boolean result = false;

        if (nameOfProduct.isEmpty()) {
            System.out.println("No item found in the list to be listed.");
            if (controlYesNo()) {
                addProduct();
            }
        } else {
            System.out.print("Please enter the name of the product for which you want to change the features: ");
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

                //Ürün özellikleri değiştirmek için
                do {
                    printInterface();
                    System.out.println("Please select the feature you want to change:");
                    System.out.println("1-Change id");
                    System.out.println("2-Change name");
                    System.out.println("3-Change purchase price");
                    System.out.println("4-Change selling price");
                    System.out.println("5-Change quantity");
                    System.out.println("6-Exist");
                    choice = scanner.nextInt();
                    printInterface();

                    switch (choice) {
                        case 1 -> {
                            System.out.print("Please enter new ID: ");
                            idOfProduct.set(index, String.valueOf(scanner.nextInt()));
                        }
                        case 2 -> {
                            System.out.print("Please enter new name: ");
                            nameOfProduct.set(index, scanner.next());
                        }
                        case 3 -> {
                            System.out.print("Please enter new purchase price: ");
                            purchasePriceOfProduct.set(index, String.valueOf(scanner.nextInt()));
                        }
                        case 4 -> {
                            System.out.print("Please enter new selling price: ");
                            sellingPriceOfProduct.set(index, String.valueOf(scanner.nextInt()));
                        }
                        case 5 -> {
                            System.out.print("Please enter new quantity: ");
                            quantityOfProduct.set(index, String.valueOf(scanner.nextInt()));
                        }
                        case 6 -> {
                            System.out.println("You return to the product menu...");
                            printInterface();
                        }
                        default -> System.out.println("You made the wrong choice, please try again(1-6).");
                    }

                } while (choice != 6);

                String str = "Updated," + idOfProduct.get(index) + "," + quantityOfProduct.get(index);
                styleWriterToTransaction(str);

            } else {
                System.out.println("No products found with the name you entered.");
                if (controlYesNo()) {
                    addProduct();
                }
            }
        }
    }
}
