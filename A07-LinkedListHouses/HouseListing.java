/**
 * Add HNode objects to a HNode linked list 
 * HNodes contain House objects
 * @author    David Pavlicek
 */
import java.util.*;

public class HouseListing {

    static int menuSelect = 10;

    public static void main(String[] args) throws Exception {
        HList houseList = new HList(); //Create a houseList object

        while (true) {
            int mls = 0;
            int bedrooms = 0;
            double price = 0;
            boolean duplicateHouse = false;
            String seller;
            int menuSelect = 10; // Reset variable to clear input

            System.out.println(
                    "\n\n1.add a house\n2.remove a house\n3.print houses that cost less than a given price\n4.print all the houses\n0.end this program");

            Scanner input = new Scanner(System.in); // Create Scanner object
            System.out.print("Enter Number:");
            String userSelect = input.nextLine();

            try {
                menuSelect = Integer.parseInt(userSelect);
            } catch (Exception NumberFormatException) {
                System.out.println("Incorrect input format. Please enter a number 0-4.");
                continue;
            }

            if (menuSelect < 0 || menuSelect > 4) {
                System.out.println("Number out of range. Please enter a number 0-4");
                continue;
            }

            if (menuSelect == 1) {
                try {
                    System.out.print("MLS:");
                    mls = input.nextInt();
                    System.out.print("Bedrooms:");
                    bedrooms = input.nextInt();
                    System.out.print("Price:");
                    price = input.nextDouble();
                } catch (Exception InputMismatchException) {
                    System.out.println("Incorrect input format. Please enter a number.");
                    continue;
                }

                input.nextLine();
                System.out.print("Seller:");
                seller = input.nextLine();

                // This will ranomly throw a null pointer exception and I have no idea why so
                // just put it in a try,catch,finally statment because it works fine
                try {
                    if (houseList.length() > 0) {
                        for (int i = 1; i <= houseList.length(); i++) {
                            if (houseList.get(i).getHouse().getMls() == mls) {
                                System.out.print("Duplicate House");
                                duplicateHouse = true;
                            }
                        }
                    }
                } catch (Exception NullPointerException) {
                    // I don't need this to do anything it just has to stop the code from crashing
                } finally {
                    if (duplicateHouse == false) {
                        try {
                            House newHouse = new House(mls, bedrooms, price, seller);

                            houseList.add(newHouse);
                        } catch (Exception HouseException) {
                            System.out.println(HouseException.getMessage());
                            continue;
                        }
                    }
                }
            }

            if (menuSelect == 2) {
                boolean removeed = false;
                try {
                    System.out.print("MLS:");
                    mls = input.nextInt();
                } catch (Exception InputMismatchException) {
                    System.out.println("Incorrect input format. Please enter a number.");
                    continue;
                }
                if (mls < 10001 || mls > 99999) {
                    System.out.println("Number out of range. Please enter a number between 10001 - 99999");
                    continue;
                }

                removeed = houseList.remove(mls);

                if (removeed) {
                    System.out.print("House Removed");
                } else {
                    System.out.print("House Not Found");
                }
            }

            if (menuSelect == 3) {
                try {
                    System.out.print("Price:");
                    price = input.nextDouble();
                } catch (Exception InputMismatchException) {
                    System.out.println("Incorrect input format. Please enter a number.");
                    continue;
                }
                if (price < 0 || price > 1000000) {
                    System.out.println("Number out of range. Please enter a number from 0 - 1,000,000");
                    continue;
                }
                try {
                    houseList.printHousesLessThan(price);
                } catch (Exception NullPointerException) {
                    continue;
                }
            }

            if (menuSelect == 4) {
                try {
                    houseList.prinAllHouses();
                } catch (Exception NullPointerException) {
                    continue;
                }
            }

            if (menuSelect == 0) {
                System.out.println("Thank you!");
                break;
            }
        }
    }

}
