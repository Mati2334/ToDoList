import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ToDoList {

    final static int MAX = 10;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> list = new ArrayList<String>();
        int choice = 0;

        while (choice != 3) {
            System.out.println();
            System.out.println("Type 1 to add a new thing to your to do list.");
            System.out.println("Type 2 to print the to do list.");
            System.out.println("Type 3 to exit the program.");
            System.out.print("Select an option: ");

            choice = getChoice(input);

            if (choice == 1) {
                add_item_to_list(input, list);
            } else if (choice == 2) {
                print_items_list(list);
            } else {
                System.exit(0);

            }
        }

    }

    private static void print_items_list(List<String> list) {
        int count = list.size();
        int intedxToPrint;
        System.out.println("count = " + count);
        if (count > 0) {

            for (int index = 0; index < count; index++) {
                intedxToPrint = index;
                intedxToPrint++;
                System.out.println("Pozycja listy nr " + intedxToPrint + ": " + list.get(index));
            }
        } else {
            System.out.println("Brak elementów listy do wydrókowania");
        }
    }

    private static void add_item_to_list(Scanner input, List<String> list) {
        String userEnteredItem;
        System.out.println("Keep hitting enter after to do's, if you want to stop, type 'stop'.");
        for (int i = 0; i < MAX; i++) {
            userEnteredItem = input.nextLine();

            if (!userEnteredItem.isEmpty()) {
                list.add(userEnteredItem);
                if (userEnteredItem.equalsIgnoreCase("stop")) {
                    list.remove(i); // To not enter "stop" on the list.
                    break;
                }
            } else {
                i--; // Do not increase index for empty item.
            }
        }
    }

    private static int getChoice(Scanner input) {
        int numberOfTries = 0;
        int choice = 0;
        do {
            try {
                numberOfTries++;
                choice = input.nextInt();
            } catch (InputMismatchException exeption) {
                System.out.println("Something went wrong. " + input.next());
                System.out.println("Type numbers from 1 to 3.");

            }
        } while (numberOfTries < 6 && choice <= 0);
        return choice;
    }
}
