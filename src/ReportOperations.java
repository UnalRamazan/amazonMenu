import java.util.ArrayList;

public class ReportOperations extends NewOperations {

    ArrayList<String> hourTime = new ArrayList<>();
    ArrayList<String> year = new ArrayList<>();
    ArrayList<String> ID = new ArrayList<>();
    ArrayList<String> operations = new ArrayList<>();
    ArrayList<String> quantity = new ArrayList<>();
    ArrayList<String> box = new ArrayList<>();

    public ReportOperations() {

    }

    public ReportOperations(ArrayList<String> idOfProduct, ArrayList<String> nameOfProduct, ArrayList<String> purchasePriceOfProduct, ArrayList<String> sellingPriceOfProduct, ArrayList<String> quantityOfProduct) {
        super(idOfProduct, nameOfProduct, purchasePriceOfProduct, sellingPriceOfProduct, quantityOfProduct);
    }

    public void reportApplication() {
        ReaderFile reader = new ReaderFile();
        reader.transactionsReader(operations, ID, quantity, year, hourTime);
    }

    public void reportMenuQuestion1() {
        if (operations.isEmpty()) {
            System.out.println("No data found to process.");
        } else {

            boolean result = false;
            System.out.print("Please enter the start and end time: ");
            int firstTime = scanner.nextInt();
            int secondTime = scanner.nextInt();

            for (int i = 0; i < hourTime.size(); i++) {
                int hour = Integer.parseInt(hourTime.get(i).split(":")[0]);
                if (firstTime <= hour && hour <= secondTime) {
                    if (operations.get(i).equals("Sale")) {
                        if (idOfProduct.contains(ID.get(i))) {
                            int index = idOfProduct.indexOf(ID.get(i));
                            if (!box.contains(nameOfProduct.get(index))) {
                                box.add(nameOfProduct.get(index));
                            }
                        } else {
                            if (!box.contains("Satılan ürün Product.txt dosyasından silinmiş. ID: " + ID.get(i))) {
                                box.add("Satılan ürün Product.txt dosyasından silinmiş. ID: " + ID.get(i));
                            }
                        }
                        result = true;
                    }
                }
            }
            if (!result) {
                System.out.println("No product was sold in the specified range.");
            } else {
                for (String s : box) {
                    System.out.println("->" + s + "<-");
                }
                box.clear();
            }
        }
        printInterface();
    }

    public void reportMenuQuestion2() {
        if (operations.isEmpty()) {
            System.out.println("No data found to process.");
        } else {

            int max = 0, index = 0, amount = 0, j;
            boolean result = false;
            for (int i = 0; i < ID.size(); i++) {
                if (operations.get(i).equals("Sale")) {
                    amount = Integer.parseInt(quantity.get(i));
                    for (j = i + 1; j < ID.size(); j++) {
                        if (ID.get(i).equals(ID.get(j)) && operations.get(j).equals("Sale")) {
                            amount += Integer.parseInt(quantity.get(j));
                        }
                    }
                    if (amount > max) {
                        max = amount;
                        if (idOfProduct.contains(ID.get(i))) {
                            index = idOfProduct.indexOf(ID.get(i));
                        } else {
                            index = -1;
                        }
                    }
                    result = true;
                }
            }
            if (result) {
                if (index == -1) {
                    System.out.println("Product's name: null, Sales Quantity: " + max);
                } else {
                    System.out.println("Product's name: " + nameOfProduct.get(index) + " Sales Quantity: " + max);
                }

            } else {
                System.out.println("No product was sold in the specified range.");
            }
        }
        printInterface();
    }

    public void reportMenuQuestion3() {
        if (operations.isEmpty()) {
            System.out.println("No data found to process.");
        } else {

            boolean result = false;
            int fTime;
            int sTime;
            System.out.print("Please enter the start and end Month (Jan, Feb, Mar, Apr, May, June, July, Aug, Sep, Oct, Nov, Dec.): ");
            String firstTime = scanner.next();
            String secondTime = scanner.next();

            fTime = returnMonthInt(firstTime);
            sTime = returnMonthInt(secondTime);

            for (int i = 0; i < ID.size(); i++) {
                int month = Integer.parseInt(year.get(i).split("/")[1]);
                if (fTime >= month || month <= sTime) {
                    if (operations.get(i).equals("Sale")) {
                        if (idOfProduct.contains(ID.get(i))) {
                            int index = idOfProduct.indexOf(ID.get(i));
                            if (!box.contains(nameOfProduct.get(index))) {
                                box.add(nameOfProduct.get(index));
                            }
                        } else {
                            if (!box.contains("Satılan ürün Product.txt dosyasından silinmiş. ID: " + ID.get(i))) {
                                box.add("Satılan ürün Product.txt dosyasından silinmiş. ID: " + ID.get(i));
                            }
                        }
                        result = true;
                    }
                }
            }

            if (!result) {
                System.out.println("Sold product not found...");
            } else {
                for (String s : box) {
                    System.out.println("->" + s + "<-");
                }
                box.clear();
            }
        }
        printInterface();
    }

    public int returnMonthInt(String month) {
        int time;
        switch (month) {
            case "Jan" -> time = 1;
            case "Feb" -> time = 2;
            case "Mar" -> time = 3;
            case "Apr" -> time = 4;
            case "May" -> time = 5;
            case "June" -> time = 6;
            case "July" -> time = 7;
            case "Aug" -> time = 8;
            case "Sep" -> time = 9;
            case "Oct" -> time = 10;
            case "Nov" -> time = 11;
            case "Dec" -> time = 12;
            default -> time = 0;
        }
        return time;
    }

    public void reportMenuQuestion4() {
        if (operations.isEmpty()) {
            System.out.println("No data found to process.");
        } else {
            int dateTime;
            boolean result = false;
            System.out.println("Please enter the day(1, 2, 3, etc)");
            dateTime = scanner.nextInt();

            for (int i = 0; i < operations.size(); i++) {
                int day = returnDayInt(year.get(i).split("/")[0]);
                if (day == dateTime) {
                    if (operations.get(i).equals("Sale")) {
                        if (idOfProduct.contains(ID.get(i))) {
                            result = true;
                            int index = idOfProduct.indexOf(ID.get(i));
                            if (!box.contains(nameOfProduct.get(index))) {
                                box.add(nameOfProduct.get(index));
                            }
                        } else {
                            if (!box.contains("Satılan ürün Product.txt dosyasından silinmiş. ID: " + ID.get(i))) {
                                box.add("Satılan ürün Product.txt dosyasından silinmiş. ID: " + ID.get(i));
                            }
                        }
                    }
                }
            }

            if (!result) {
                System.out.println("Sold product not found...");
            } else {
                for (String s : box) {
                    System.out.println("->" + s + "<-");
                }
                box.clear();
            }
        }
        printInterface();
    }

    public int returnDayInt(String day) {
        return switch (day) {
            case "01" -> 1;
            case "02" -> 2;
            case "03" -> 3;
            case "04" -> 4;
            case "05" -> 5;
            case "06" -> 6;
            case "07" -> 7;
            case "08" -> 8;
            case "09" -> 9;
            default -> Integer.parseInt(day);
        };
    }
}