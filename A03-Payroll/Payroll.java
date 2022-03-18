/**
 * Accepts input on the number of employees to be printed out
 * Prints total hours each employee worked on each day of the week
 * Prints total hours worked by each employee
 * Prints employees that worked over time and how much
 * Finally prints each employees total pay for the week
 * @author    David Pavlicek
 */
import java.util.*;

public class Payroll {
    public static void main(String[] args)throws Exception{
        boolean loop = true;
        int amountEmployees = 0;
        int[][] employeeHours;

        //Print purpose of program to user
        System.out.println("\nThis program will calculate the payroll for 5-20 employees");

        //Accept input for number of employees
        Scanner input = new Scanner(System.in);  // Create Scanner object
        System.out.print("Enter Number of Employees to Process:");

        try{
            amountEmployees = input.nextInt();
        }
        catch(Exception NumberFormatException){
            System.out.println("\nIncorrect input format. Please enter a number of employees 5-20.");
            System.out.println("This program will now exit");
            System.exit(0);
        }
        if(amountEmployees < 5 || amountEmployees > 20){
            System.out.println("\nNumber out of range. Please enter a number  of employees 5-20.");
            System.out.println("This program will now exit");
            System.exit(0);
        }

        System.out.println("Printing employees hours and pay.\n");

        //Create 2D array the size of the total number of employees by the number of days worked
        employeeHours = new int[amountEmployees][5];

        //Generate random hours worked each day 0-12
        Random rand = new Random();
        for(int i=0; i< employeeHours.length; i++){
            for(int j=0; j < 5; j++){
                employeeHours[i][j] = rand.nextInt(13);
            }
        }

        //Call calculatePayroll method to print out all info
        calculatePayroll(employeeHours);
    }

    static void calculatePayroll(int[][] employeeHours){
        //Print Header
        System.out.println(String.format("%-15s%-5s%-5s%-5s%-5s%-5s\n", "","MON","TUES","WED", "THU", "FRI"));

        //Iterate through each employee and print how many hours were worked on each day
        for(int i=0; i< employeeHours.length; i++){
            System.out.println(String.format("%-15s%-5s%-5s%-5s%-5s%-5s\n", "Employee " + (i+1), employeeHours[i][0],employeeHours[i][1],employeeHours[i][2], employeeHours[i][3],employeeHours[i][4]));
        }

        //Print header
        System.out.println("\nHours worked by each employee\n");

        //Iterate through each employee, adding up and then print total hours worked
        for(int i=0; i< employeeHours.length; i++){
            int hoursWorked = employeeHours[i][0] + employeeHours[i][1] + employeeHours[i][2] + employeeHours[i][3] + employeeHours[i][4];
            System.out.println("Employee " + (i+1) + " worked " + hoursWorked + " hours.");
        }

        //Print Header
        System.out.println("\nEmployee's that worked overtime\n");

        //Iterate through each employee, if the number of hours they worked is over 40 then print out the total number of hours over 40
        for(int i=0; i< employeeHours.length; i++){
            int hoursWorked = employeeHours[i][0] + employeeHours[i][1] + employeeHours[i][2] + employeeHours[i][3] + employeeHours[i][4];
            if(hoursWorked > 40){
                System.out.println("Employee " + (i+1) + " overtime = " + (hoursWorked - 40) + " hours.");
            }
        }

        //Print Header
        System.out.println("\nPAYROLL FOR THIS WEEK\n");

        //Iterate through each employee printing out total amount paid for the week
        for(int i=0; i< employeeHours.length; i++){
            int hoursWorked = employeeHours[i][0] + employeeHours[i][1] + employeeHours[i][2] + employeeHours[i][3] + employeeHours[i][4];
            if(hoursWorked > 40){
                System.out.println("Employee " + (i+1) + " pay: $" +  String.format("%.2f",(((hoursWorked - 40) * 21.75) + 580)));
            }
            else{
                System.out.println("Employee " + (i+1) + " pay: $" + String.format("%.2f", (hoursWorked * 14.50)));
            }
        }
    }
}
