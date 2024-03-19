import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Theatre {
    static final int[] row_1 = new int[12]; //Declaring the array to store seats in Row 1.
    static final int[] row_2 = new int[16];//Declaring the array to store seats in Row 2.
    static final int[] row_3 = new int[20];//Declaring the array to store seats in Row 3.
    static ArrayList<Ticket> Tickets = new ArrayList<>();
    // Create an ArrayList to store all tickets details.
    static ArrayList<Ticket> Tickets_sort = new ArrayList<>();
    // Create an ArrayList to store the sort details.

    //Using final keyword to remove ability to override the existing values//
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {  //To stop crashing the program from an invalid input.
                System.out.println("-------------------------------------------------");
                System.out.println("Welcome to the New Theatre");
                System.out.println("-------------------------------------------------");
                System.out.println("Please select an option:");
                System.out.println("1) Buy a ticket");
                System.out.println("2) Print seating area");
                System.out.println("3) Cancel ticket");
                System.out.println("4) List available seats");
                System.out.println("5) Save to file");
                System.out.println("6) Load from file");
                System.out.println("7) Print ticket information and total price");
                System.out.println("8)Sort tickets by price");
                System.out.println("     0)Quit");
                System.out.println("-------------------------------------------------");
                System.out.println("Enter option:");
                String option = input.next();
                switch (option) {
                    case "0": {
                        System.out.println("Goodbye!");
                        System.exit(0);
                    }
                    case "1":
                        buy_ticket(); //To call the buy_ticket method
                        break;
                    case "2":
                        print_seating_area(); //To call the print_seating_area method
                        break;
                    case "3":
                        cancel_ticket(); //To call the cancel_ticket method
                        break;
                    case "4":
                        show_available(); //To call show available method
                        break;
                    case "5":
                        save(); //To call the save method
                        break;
                    case "6":
                        load(); //To call the load method
                        break;
                    case "7":
                        show_tickets_info(); //To call show_ticket_info method
                        break;
                    case "8":
                        sort_tickets(); //To call the sort_tickets method
                        break;
                    default:
                        System.out.println("Invalid option! Please try again.");
                        System.out.println();
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please try again"); //To stop the program from crashing from an invalid input
            }
        }
    }

    /*
    When user inputs option "1" the buy ticket
    method is called to reserve tickets.
     */
    private static void buy_ticket() {
        Scanner input = new Scanner(System.in);
        System.out.println("------Ticket Price Information------");
        System.out.println("Row 1: £30");
        System.out.println("Row 2: £20");
        System.out.println("Row 3: £10");
        System.out.println();
        System.out.print("Enter first name:");
        String name = input.nextLine();

        System.out.print("Enter surname:");
        String surname = input.nextLine();

        System.out.print("Enter the email address:");
        String email = input.next();

        System.out.print("Enter row number (1-3): ");
        int row = input.nextInt();
        System.out.print("Enter seat number: ");
        int seat = input.nextInt();

        int price;
        if (row == 1) {
            price = 30;
        } else if (row == 2) {
            price = 20;
        } else {
            price = 10;
        }

        Person person = new Person(name, surname, email);  //Create an object class
        Ticket ticket = new Ticket(row, seat, price, person); //Create an object class


        if (row < 0 || row > 3) {   //Validating the user input.
            System.out.println("Invalid row number! Please enter row number between 1 to 3");
        }
        switch (row) {
            case 1:
                if (seat > 0 && seat <= row_1.length && row_1[seat - 1] == 0) {
                    row_1[seat - 1] = 1;        //Validation and check the array length with the user input.
                    Tickets.add(ticket);        //To add the input into the Ticket Arraylist
                    Tickets_sort.add(ticket);   //To add the input into the Ticket_sort Arraylist
                    System.out.println();
                    System.out.println("Ticket purchased successfully!");
                    System.out.println();
                } else if (seat > 12 || seat<=0) { //To check the entered seat number is in the range of seat numbers for Row 1
                    System.out.println();
                    System.out.println("Sorry!! Row 1 only has 12 seats");

                } else {
                    System.out.println();
                    System.out.println("Seat is not available"); //If the seat is already booked for Row 1
                    System.out.println();
                }
                break;
            case 2:
                if (seat > 0 && seat <= row_2.length && row_2[seat - 1] == 0) {
                    row_2[seat - 1] = 1;       //Validation and check the array length with the user input.
                    Tickets.add(ticket);       //To add the input into the Ticket Arraylist
                    Tickets_sort.add(ticket);  //To add the input into the Ticket_sort Arraylist
                    System.out.println();
                    System.out.println("Ticket purchased successfully!");
                    System.out.println();
                } else if (seat > 16 || seat <=0) { //To check the entered seat number is in the range of seat numbers for Row 2
                    System.out.println();
                    System.out.println("Sorry!! Row 2 only has 16 seats");
                } else {
                    System.out.println();
                    System.out.println("Seat is not available");//If the seat is already booked for Row 2
                    System.out.println();
                }
                break;
            case 3:
                if (seat > 0 && seat <= row_3.length && row_3[seat - 1] == 0) {
                    row_3[seat - 1] = 1;       //Validation and check the array length with the user input.
                    Tickets.add(ticket);       //To add the input into the Ticket Arraylist
                    Tickets_sort.add(ticket);  //To add the input into the Ticket_sort Arraylist
                    System.out.println();
                    System.out.println("Ticket purchased successfully!");
                    System.out.println();
                } else if (seat > 20 || seat <= 0) { //To check the entered seat number is in the range of seat numbers for Row 3
                    System.out.println();
                    System.out.println("Sorry!! Row 3 only has 20 seats");
                } else {
                    System.out.println();
                    System.out.println("Seat is not available");//If the seat is already booked for R0w 3
                    System.out.println();
                }break;
        }
    }

        /*
    When user inputs option "2" the print_seating_area method
    is called an outputs the available and reserved seats in the theatre.
     */
    private static void print_seating_area() {
        System.out.println("     ***********");
        System.out.println("     *  STAGE  *");
        System.out.println("     ***********");
        System.out.print("    ");
        for (int i = 0; i < row_1.length; i++) { //For loop to print the seats.
            if (row_1[i] == 0) {
                System.out.print("O"); //Print the available seats
            } else {
                System.out.print("X"); //Print the reserved seats
            }
            if (i == 5) { //To print the gap between row 1
                System.out.print(" ");
            }
        }
        System.out.println();
        System.out.print("  ");
        for (int j = 0; j < row_2.length; j++) { //For loop to print the seats.
            if (row_2[j] == 0) {
                System.out.print("O"); //Print the available seats
            } else {
                System.out.print("X"); // Print the reserved seats
            }
            if (j == 7) { //To print the gap between row 2
                System.out.print(" ");
            }
        }
        System.out.println();
        for (int k = 0; k < row_3.length; k++) { //For loop to print the seats.
            if (row_3[k] == 0) {
                System.out.print("O"); // Print the available seats
            } else {
                System.out.print("X"); //Print the reserved seats
            }
            if (k == 9) { //To print the gap between row 3
                System.out.print(" ");
            }
        }
        System.out.println();
        System.out.println();
    }
    /*
       When user inputs option "3" the method is called
       to cancel a reserved seat.
     */
    private static void cancel_ticket() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter row number: "); //Enter the row number
        int row = input.nextInt();
        System.out.print("Enter seat number: "); //Enter the seat number
        int seat = input.nextInt();
        for (int i = 0; i < Tickets.size(); i++) {
            Ticket ticket = Tickets.get(i);

            if (ticket.getRow() == row && ticket.getSeat() == seat) {
                Tickets.remove(i);  //Remove the entered seat from Ticket Arraylist
                Tickets_sort.remove(i);  //Remove the entered seat from Ticket_sort Arraylist
            }
        }
        switch (row) {
            case 1:
                if (seat> 12 || seat <=0) { //To check if the input number is in range for number of seats for row 1
                    System.out.println();
                    System.out.println("Sorry!! Row 1 only has 12 seats");
                } else if (seat <= row_1.length && row_1[seat - 1] == 1) {
                    row_1[seat - 1] = 0; //Validation and to check the array
                    System.out.println();
                    System.out.println("Successfully cancelled");
                } else {
                    System.out.println();
                    System.out.println("Seat is already available");
                }
                break;
            case 2:
                if (seat > 16|| seat <=0) { //To check if the input number is in range for number of seats for row 2
                    System.out.println();
                    System.out.println("Sorry!! Row 2 only has 16 seats");
                } else if (seat<=row_2.length && row_2[seat - 1] == 1) {
                    row_2[seat - 1] = 0;
                    System.out.println();
                    System.out.println("Successfully cancelled");
                } else {
                    System.out.println();
                    System.out.println("Seat is already available");
                }
                break;
            case 3:
                if (seat > 20 ||seat <=0) { //To check if the input number is in range for number of seats for row 3
                    System.out.println();
                    System.out.println("Sorry!! Row 3 only has 20 seats");
                } else if (seat <= row_3.length && row_3[seat - 1] == 1) {
                    row_3[seat - 1] = 0;
                    System.out.println();
                    System.out.println("Successfully cancelled");
                } else {
                    System.out.println();
                    System.out.println("Seat is already available");
                }
                break;
            default:
                System.out.println("Enter a valid row number");
        }
    }
    /*
     When user inputs option "4" the show_available
     method is called to print all the seats.
     */
    private static void show_available() {
        System.out.println("Seats available in row 1:");
        for (int i = 0; i < row_1.length; i++) { //To print the seats in Row 1
            if (row_1[i] == 0) {
                System.out.print(i + 1);
                System.out.print(" ");
            }
        }

        System.out.println();
        System.out.println("Seats available in row 2:");
        for (int j = 0; j < row_2.length; j++) { //To print the seats in Row 2
            if (row_2[j] == 0) {
                System.out.print(j + 1);
                System.out.print(" ");
            }
        }
        System.out.println();
        System.out.println("Seats available in row 3:");
        for (int k = 0; k < row_3.length; k++) { //To print the seats in Row 3
            if (row_3[k] == 0) {
                System.out.print(k + 1);
                System.out.print(" ");
            }
        }
        System.out.println();
        System.out.println();
    }

    /*
        When user inputs option "5" the save method  is called
        to save reserved seats and available seats to a text file.
     */
    private static void save() {
        try {
            File file = new File("Theatre.txt");
            boolean file_created = file.createNewFile(); //Create text file
            if (file_created) {
                System.out.println("File created: " + file.getName());
            } else if (file.exists()) { //Condition if the file already exists.
                System.out.println("File already exists");
            } else {
                System.out.println("Error while creating file: " + file.getName());
                //If an error is occurred while creating the text file.
            }
            FileWriter filewrite = new FileWriter("Theatre.txt");
            int i = 0;
            int j = 0;
            int k = 0;
            while (i < row_1.length) { //For loop to write the array elements to the save file. l
                filewrite.write(row_1[i] + " "); //Write the elements to the file
                i++;
            }
            filewrite.write("\n");
            while (j < row_2.length) {
                filewrite.write(row_2[j] + " "); //Write the elements to the file
                j++;
            }
            filewrite.write("\n");
            while (k < row_3.length) {
                filewrite.write(row_3[k] + " "); //Write the elements to the file
                k++;
            }
            System.out.println("Successfully wrote to the file!");
            filewrite.close(); //To close the connection between the source code and the external file.
        } catch (IOException ex) { //Error handling
            System.out.println(ex);
        }
    }

    /*
    When user inputs Option "6" the data written to the
    text will be given as an output.
     */
    private static void load() {
        try {
            File file = new File("Theatre.txt");
            Scanner file_reader = new Scanner(file); //Read from the text file
            System.out.println("Successfully loaded from the file!");
            while (file_reader.hasNextLine()) {
                String text = file_reader.nextLine();
                System.out.println(text);
            }
            file_reader.close(); //To close the connection between the source code and the external file.
        } catch (IOException ex) {
            System.out.println(ex); //Error exception.

        }
    }
    /*
    When user inputs option "7" show_tickets_info method is called
    to show the Person and Ticket details that has given by the user
     */
    private static void show_tickets_info() {
        int total_price = 0; //Setting an Integer
        System.out.println("Tickets Information:");
        for (Ticket ticket : Tickets) {
            ticket.print(); //Called the print function in the Ticket class
            System.out.println();
            total_price += ticket.getPrice(); //Adding prices to calculate the total.
        }
        System.out.println("Total price:£" + total_price);
    }

    /*
    When user inputs Option "8" sort_tickets method is called
    to sort the price in ascending order.
     */
    private static void sort_tickets() {
        int finalIndex = Tickets_sort.size() - 2; //This is the index of the second-to-last element in the Tickets_sort array
        Ticket temp;                 //Declares a ticket variable called temp
        int total_price = 0;        //Setting an Integer to calculate the total
        boolean exchanged = true;
                                  //"Exchange" will be used to track whether any exchanges have been made during a pass through the array.
        while (exchanged) {
            exchanged = false;


            for (int i = 0; i <= finalIndex; i++) {
                int price_1 = Tickets_sort.get(i).getPrice();
                int price_2 = Tickets_sort.get(i + 1).getPrice();
                //These are used determine whether the two tickets should be swapped

                if (price_1 > price_2) {
                    temp = Tickets_sort.get(i);
                    Tickets_sort.set(i, Tickets_sort.get(i + 1));
                    Tickets_sort.set(i + 1, temp);
                    exchanged = true;

                }
            }
            finalIndex--;
        }
        for (Ticket ticket :Tickets_sort) { //To print the sorted tickets
            total_price += ticket.getPrice(); //Adding prices to calculate the total.
            ticket.print();
            System.out.println();
            System.out.println("Total price:£" + total_price); //Printing the total
        }

    }
}






