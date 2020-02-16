import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int MAX = 10;
        List<String> list = new ArrayList<String>();
        int choice = 0;

        while (choice != 3) {
            System.out.println();
            System.out.println("Type 1 to add a new thing to your to do list.");
            System.out.println("Type 2 to print the to do list.");
            System.out.println("Type 3 to exit the program.");
            System.out.print("Select an option: ");

            choice = getChoice(input);

            String userEnteredItem;
            if (choice == 1) {
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
            } else if (choice == 2) {
                int count = list.size();
                System.out.println("count = " + count);
                if (count > 0) {
//                    listPosition += 1;
//                    String tableElement = list[index];
                    for (int index = 0; index < count; index++) {
                        System.out.println("Pozycja listy nr " + index + ": " + list.get(index));
                    }
                } else {
                    System.out.println("Brak elementów listy do wydrókowania");
                }
            } else {
                System.exit(0);

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
