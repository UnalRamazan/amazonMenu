import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu extends Products {
    Scanner scanner = new Scanner(System.in);

    NewOperations operations = new NewOperations(idOfProduct, nameOfProduct, purchasePriceOfProduct, sellingPriceOfProduct, quantityOfProduct);
    ManageInventoryOperations operations1 = new ManageInventoryOperations(idOfProduct, nameOfProduct, purchasePriceOfProduct, sellingPriceOfProduct, quantityOfProduct);
    ManageProductsOperations operations2 = new ManageProductsOperations(idOfProduct, nameOfProduct, purchasePriceOfProduct, sellingPriceOfProduct, quantityOfProduct);
    SellProduct operations3 = new SellProduct(idOfProduct, nameOfProduct, purchasePriceOfProduct, sellingPriceOfProduct, quantityOfProduct);
    ReportOperations operations4 = new ReportOperations(idOfProduct, nameOfProduct, purchasePriceOfProduct, sellingPriceOfProduct, quantityOfProduct);

    public void printMenu() {
        int choice;

        operations.printInterface();
        do {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy  k:m:s");
            Date date = new Date();

            System.out.println("Main Menu (" + format.format(date) + ")");
            System.out.println("1. Sell Product");
            System.out.println("2. Manage Inventory");
            System.out.println("3. Manage Products");
            System.out.println("4. Reports");
            System.out.println("5. Exist");
            System.out.print("Option: ");
            choice = scanner.nextInt();
            operations.printInterface();

            switch (choice) {
                case 1 -> operations3.sellProduct();
                case 2 -> printInventoryMenu();
                case 3 -> printProductOperations();
                case 4 -> {
                    operations4.reportApplication();
                    operations.writer();
                    operations.printInterface();
                    printReportsMenu();
                }
                case 5 -> {
                    System.out.println("Thank you for choosing us. We hope you come again...");
                    operations.writer();
                    operations.printInterface();
                }
                default -> System.out.println("You made the wrong choice, please try again(1-5).");
            }
        } while (choice != 5);
    }

    public void printInventoryMenu() {
        int choice;

        do {
            System.out.println("Manage Inventory Menu");
            System.out.println("1. Add (buy) Product");
            System.out.println("2. Update Product in Inventory");
            System.out.println("3. Delete Product from Inventory");
            System.out.println("4. Return to Main Menu");
            System.out.print("Choice: ");
            choice = scanner.nextInt();
            operations1.printInterface();

            switch (choice) {
                case 1 -> {
                    operations1.printProduct();
                    if (operations1.controlYesNo()) {
                        operations1.addProduct();
                    }
                }
                case 2 -> operations1.updateProduct();
                case 3 -> operations1.deleteProduct();
                case 4 -> {
                    System.out.println("You return to the main menu...");
                    operations1.printInterface();
                }
                default -> System.out.println("You made the wrong choice, please try again(1-4).");
            }
        } while (choice != 4);
    }

    public void printProductOperations() {
        int choice;

        do {
            System.out.println("Product Inventory Menu");
            System.out.println("1. Print all products");
            System.out.println("2. Add new Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Update Product");
            System.out.println("5. Return to Main Menu");
            System.out.print("Choice: ");
            choice = scanner.nextInt();
            operations.printInterface();

            switch (choice) {
                case 1 -> operations2.printProduct();
                case 2 -> operations2.addProduct();
                case 3 -> operations2.deleteProduct();
                case 4 -> operations2.updateProduct();
                case 5 -> {
                    System.out.println("You return to the main menu...");
                    operations.printInterface();
                }
                default -> System.out.println("You made the wrong choice, please try again(1-5).");
            }
        } while (choice != 5);
    }

    public void printReportsMenu() {
        int choice;

        do {
            System.out.println("1. Print a list of product names that are sold between two time period");
            System.out.println("2. Print the name of the Best Selling Product");
            System.out.println("3. Print list of products sold on specified Month (Jan, Feb, etc.)");
            System.out.println("4. Print all products sold on specified week day (Mon, Tue, Wed, etc.)");
            System.out.println("5. Return to Main Menu");
            System.out.print("Option: ");
            choice = scanner.nextInt();
            operations.printInterface();

            switch (choice) {
                case 1 -> operations4.reportMenuQuestion1();
                case 2 -> operations4.reportMenuQuestion2();
                case 3 -> operations4.reportMenuQuestion3();
                case 4 -> operations4.reportMenuQuestion4();
                case 5 -> {
                    System.out.println("You return to the main menu...");
                    operations.printInterface();
                }
                default -> System.out.println("You made the wrong choice, please try again(1-5).");
            }
        } while (choice != 5);
    }

    public void fileReader() {
        operations.reader();
    }
}
