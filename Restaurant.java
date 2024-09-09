package restaurant;

import java.util.Scanner;
import menu.*;
import people.Customers.Customer;
import people.Staff.core.StaffMember;

public class Restaurant {

    public static void main(String[] args) {
        // Hi babies :) 
        System.out.println("   (  )   (   )  )");
        System.out.println("     ) (   )  (  (");
        System.out.println("     ( )  (    ) )");
        System.out.println("     _____________");
        System.out.println("    <_____________> ___");
        System.out.println("    |             |/ _ \\");
        System.out.println("    |               | | |");
        System.out.println("    |               |_| |");
        System.out.println(" ___|             |\\___/");
        System.out.println("/    \\___________/    \\");
        System.out.println("\\_____________________/");

        // Create a new store named "Happy Store"
        Menu my_store = new Menu("Happy Store");

        // Print a welcome message to the user
        System.out.printf("         Welcome to %s !!!\n", my_store.getName());
        System.out.println("++++++++ Select Operation from Menu +++++++++++++");

        try {
            // Initialize a scanner object to take input from the user
            Scanner input = new Scanner(System.in);
            int choice = 0;

            // Main loop to display menu options and take input from the user
            do {
                // Display the main menu options with a polished ASCII art box
                System.out.println("+--------------------------------------------+");
                System.out.println("|                Main Menu                   |");
                System.out.println("+--------------------------------------------+");
                System.out.println("| 1 - Food Management                        |");
                System.out.println("| 2 - Customer & Employee Management         |");
                System.out.println("| 3 - Buy Food                               |");
                System.out.println("| 4 - Show Special Food Items                |");
                System.out.println("| 5 - Exit                                   |");
                System.out.println("+--------------------------------------------+");
                System.out.print(">>> "); // Prompt the user for input

                choice = input.nextInt(); // Get the user's choice

                // Switch statement to handle the different choices made by the user
                switch (choice) {
                    case 1: // Food management section
                        int selectNumber1 = 0;
                        do {
                            // Display the food management options 
                            System.out.println("#############################################");
                            System.out.println("#               Food Management             #");
                            System.out.println("#-------------------------------------------#");
                            System.out.println("# 1 - Add Food Item                         #");
                            System.out.println("# 2 - Remove Food Item                      #");
                            System.out.println("# 3 - Print All Food Items                  #");
                            System.out.println("# 4 - Back to Main Menu                     #");
                            System.out.println("#############################################");
                            System.out.print(">>> ");
                            selectNumber1 = input.nextInt(); // Get the user's choice
                            // Sub_Menu for managing food items
                            switch (selectNumber1) {
                                case 1: // Add a new food item
                                    System.out.print("Food name: "); // Prompt for the name of the food
                                    String food_name = input.next();

                                    System.out.print("Food price: "); // Prompt for the price of the food
                                    double price = input.nextDouble();

                                    System.out.print("Food category (e.g., Fast Food): "); // Prompt for the category of the food
                                    String category = input.next();

                                    MenuItem new_Food = new MenuItem(food_name, price, category); // Create a new food Item
                                    my_store.addItem(new_Food); // Add the new product to the store
                                    break;

                                case 2: // Remove a food item
                                    System.out.print("Enter employee ID: "); // Prompt for the employee's ID
                                    int id = input.nextInt();

                                    // Check if the employee is a manager !!!!!!!!!!!
                                    if (my_store.checkManager(id)) {

                                        System.out.print("Enter food item name to remove: "); // Prompt for the name of the food to remove
                                        food_name = input.next();
                                        my_store.removeItem(food_name); // Remove the food item
                                        System.out.println("Removal complete!");
                                    } else {
                                        System.out.println("Only managers can remove food items!"); // Print error if employee is not a manager
                                    }
                                    break;

                                case 3: // Print all food items in the store
                                    if (my_store.Items.isEmpty()) {
                                        System.out.println("The store is empty!"); // If no food items exist, notify the user
                                    } else {
                                        System.out.println("Food items available in the store:");
                                        my_store.printItem();// Print all available food items
                                    }
                                    break;
                            }
                        } while (selectNumber1 != 4); // Exit the food management menu and return to the main menu if the user selects option 4
                        break;

                    case 2: // Customer and Employee management section
                        int selectNumber2 = 0;
                        do {
                            // Display the user management options with an ASCII art box
                            System.out.println("+--------------------------------------------------+");
                            System.out.println("|    Customer & Employee Management                |");
                            System.out.println("+--------------------------------------------------+");
                            System.out.println("| 1 - Add Customer                                 |");
                            System.out.println("| 2 - Add Employee                                 |");
                            System.out.println("| 3 - Update Employee Salary                       |"); // ---> increase all salarys :) 
                            System.out.println("| 4 - Print Users                                  |");
                            System.out.println("| 5 - Back to Main Menu                            |");
                            System.out.println("+--------------------------------------------------+");
                            System.out.print(">>>"); // Prompt the user for input
                            selectNumber2 = input.nextInt(); // Get the user's choice

                            // Submenu for managing users
                            switch (selectNumber2) {
                                case 1: // Add a new customer
                                    System.out.print("Customer name: "); // Prompt for the customer's name
                                    String Customer_Name = input.next();
                                    Customer new_Customer = new Customer(Customer_Name); // Create a new customer
                                    my_store.customers.add(new_Customer); // Add the new customer to the store
                                    break;

                                case 2: // Add a new employee
                                    System.out.print("Employee name: "); // Prompt for the employee's name
                                    String Employee_Name = input.next();

                                    System.out.print("Employee Salary: "); // Prompt for the employee's salary
                                    double salary = input.nextDouble();

                                    System.out.print("Is the employee a manager? (1:yes, 2:no): "); // Ask if the employee is a manager
                                    int is_Manager = input.nextInt();

                                    String type_Of_Employee;
                                    // Assign "Manager" role if selected, or leave null if not
                                    if (is_Manager == 1) {
                                        type_Of_Employee = "Manager";
                                    } else {
                                        type_Of_Employee = null;
                                    }
                                    StaffMember new_Employee = new StaffMember(Employee_Name, salary, type_Of_Employee); // Create a new employee
                                    my_store.employees.add(new_Employee); // Add the employee to the store
                                    break;

                                case 3: // Increase employee salaries
                                    System.out.print("Enter salary increase percentage: "); // Prompt for the percentage of salary increase
                                    double percentage = input.nextDouble();
                                    my_store.increase_Salary(percentage); // Apply the salary increase to all employees
                                    break;

                                case 4: // Print the list of all customers and employees
                                    if ((my_store.customers.isEmpty()) && (my_store.employees.isEmpty())) {
                                        System.out.println("No users to display!"); // If no users are found, print a message
                                    } else {
                                        System.out.println("List of Customers and Employees:");
                                        my_store.printCustomers(); // Print customers
                                        my_store.printEmployee(); // Print employees
                                    }
                                    break;
                            }
                        } while (selectNumber2 != 5); // Exit the user management menu and return to the main menu if the user selects option 5
                        break;

                    case 3: // Customer purchasing food items
                        int selectNumber3 = 0;
                        int n = 0;

                        System.out.print("Enter customer ID: "); // Prompt for the customer's ID
                        int Customer_Id = input.nextInt();

                        // Loop through customers to find the one matching the provided ID
                        for (int i = 0; i < my_store.customers.size(); i++) {
                            if (Customer_Id == my_store.customers.get(i).getID()) {
                                System.out.println(my_store.customers.get(i).toString()); // Display the customer's info

                                // Allow customer to purchase multiple items
                                while (selectNumber3 != -1) {
                                    System.out.print("Enter food item ID: "); // Prompt for the food item ID
                                    int food_id = input.nextInt();

                                    // Loop through the list of food items
                                    for (int j = 0; j < my_store.Items.size(); j++) {
                                        if (food_id == my_store.Items.get(j).getID()) {
                                            System.out.println(my_store.Items.get(j).toString()); // Print the selected food item details
                                            my_store.customers.get(i).addPurchased(my_store.Items.get(j)); // Add the food item to the customer's purchase list
                                            n = i;
                                            break;
                                        } else if (food_id != my_store.Items.get(j).getID()) {
                                            System.out.println("Food item not found in store!"); // If no match found, print error message
                                            break;
                                        }
                                    }
                                    System.out.print("Enter 0 to add another food item or -1 when finished: "); // Allow the user to add more food or finish
                                    selectNumber3 = input.nextInt();
                                }
                            }
                        }

                        // Print the customer's receipt, update visits, and clear the purchased list
                        System.out.printf("%s: %s\n", my_store.customers.get(n).getTypeOfCustomer(), my_store.customers.get(n).getName());
                        System.out.println("Bought:");
                        my_store.totalPrice(Customer_Id); // Calculate the total price of purchased items

                        my_store.buy(Customer_Id); // Confirm the purchase   ,  also don't forget this method removes items from the store !
                        my_store.customers.get(n).setVisits(); // Update the customer's visit count
                        my_store.customers.get(n).purchased.clear(); // Clear the customer's purchased items after checkout  !!!!
                        break;

                    case 4: // Display special food items (e.g., Fast Food)
                        System.out.println("++++++++++ Special Food Items ++++++++++ ");
                        my_store.print_special_Item(); // Call the method to print special food items
                        break;
                }

                System.out.println("-----------------------");
            } while (choice != 5); // Exit the main loop if the user selects option 5 (Exit)

        } catch (Exception e) {
            // Catch any input errors and print an error message
            System.out.println("Invalid input!");
        }

        // Print a goodbye message when the program exits
        System.out.println("+-----------------------------+");
        System.out.println("|        Thank You!           |");
        System.out.println("|         Goodbye!            |");
        System.out.println("+-----------------------------+");
    }
}
