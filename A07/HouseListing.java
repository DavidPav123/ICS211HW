/**
 * 
 * @author    David Pavlicek
 */
import java.util.*;

public class HouseListing {

    static int menuSelect = 10;

    public static void main(String[] args)throws Exception{
        House[] HouseArr = new House[0];

        while(true){
            int mls = 0;
            int bedrooms = 0;
            double price = 0;
            boolean duplicateHouse = false;
            boolean houseRemoved = false;
            String seller;
            int menuSelect = 10; //Reset variable to clear input

            System.out.println("\n\n1.add a house\n2.remove a house\n3.print houses that cost less than a given price\n4.print all the houses\n0.end this program");

            Scanner input = new Scanner(System.in);  // Create Scanner object
            System.out.print("Enter Number:");
            String userSelect = input.nextLine();

            try{
                menuSelect = Integer.parseInt(userSelect);
            }
            catch(Exception NumberFormatException){
                System.out.println("Incorrect input format. Please enter a number 0-4.");
                continue;
            }

            if(menuSelect < 0 || menuSelect > 4){
                System.out.println("Number out of range. Please enter a number 0-4");
                continue;
            }

            if(menuSelect == 1) {
                try{
                    System.out.print("MLS:");
                    mls = input.nextInt();
                    System.out.print("Bedrooms:");
                    bedrooms = input.nextInt();
                    System.out.print("Price:");
                    price = input.nextDouble();
                }
                catch (Exception InputMismatchException){
                    System.out.println("Incorrect input format. Please enter a number.");
                }

                input.nextLine();
                System.out.print("Seller:");
                seller = input.nextLine();

                for(int i=0; i< HouseArr.length; i++){
                    if(HouseArr[i].getMls() == mls){
                        System.out.print("Duplicate House");
                        duplicateHouse = true;
                    }
                }
                if(duplicateHouse == false){
                    House newHouse = new House(mls, bedrooms, price, seller);

                    House[]  tempArr = HouseArr.clone();

                    HouseArr = Arrays.copyOf(tempArr, tempArr.length +1);

                    HouseArr[HouseArr.length -1] = newHouse;

                    System.out.print("House Added");
                }
            }

            if(menuSelect == 2) {
                int tobeRemoved = HouseArr.length + 1;
                try{
                    System.out.print("MLS:");
                    mls = input.nextInt();
                }
                catch (Exception InputMismatchException){
                    System.out.println("Incorrect input format. Please enter a number.");
                    continue;
                }
                if(mls < 10001 || mls > 99999){
                    System.out.println("Number out of range. Please enter a number between 10001 - 99999");
                    continue;
                }
                for(int i=0; i< HouseArr.length; i++){
                    if(HouseArr[i].getMls() == mls){
                        tobeRemoved = i;
                        houseRemoved = true;
                    }
                }

                if(houseRemoved == true){
                    House[]  tempArr = new House[HouseArr.length-1];

                    for (int i = 0, j = 0; i < HouseArr.length; i++) {
                        if (i != tobeRemoved) {
                            tempArr[j++] = HouseArr[i];
                        }
                    }

                    HouseArr = tempArr.clone();

                    System.out.print("House Removed");
                }
                else{
                    System.out.print("House Not Found");
                }
            }

            if(menuSelect == 3) {
                try{
                    System.out.print("Price:");
                    price = input.nextDouble();
                }
                catch (Exception InputMismatchException){
                    System.out.println("Incorrect input format. Please enter a number.");
                    continue;
                }
                if(mls < 0 || mls > 1000000){
                    System.out.println("Number out of range. Please enter a number from 0 - 1,000,000");
                    continue;
                }
                for(int i=0; i< HouseArr.length; i++){
                    try{
                        if(HouseArr[i].getPrice() < price){
                            System.out.println("\n\nHouse " + (i+1) + ":");
                            System.out.print(HouseArr[i].toString());
                        }
                    }
                    catch(Exception NullPointerException){

                    }
                }
            }

            if(menuSelect == 4) {
                try{
                    for(int i=0; i< HouseArr.length; i++){
                        System.out.println("\n\nHouse " + (i+1) + ":");
                        System.out.print(HouseArr[i].toString());
                    }
                }
                catch (Exception NullPointerException){
                    continue;
                }
            }

            if(menuSelect == 0) {
                System.out.println("Thank you!");
                break;
            }
        }
    }
    
}
