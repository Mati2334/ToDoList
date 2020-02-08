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

            try {
                choice = input.nextInt();
            }catch (InputMismatchException ime){
                int wrongChoice = choice;
                System.out.println("Something went wrong. ");
                System.out.println("Type numbers from 1 to 3.");
                System.out.println(choice);
                input.next();

            }


            String userEnteredItem;
            if (choice == 1) {
                System.out.println("Keep hitting enter after to do's, if you want to stop, type 'stop'.");
                for (int i = 0; i < MAX; i++) {
                    userEnteredItem = input.nextLine();
                    if (!userEnteredItem.isEmpty()) {
                        list.add(userEnteredItem);
                        if (userEnteredItem.equalsIgnoreCase("stop")) {
                            //list[i] = null; // Do not entered "stop" on the list.
                            break;
                        }
                        //count++;
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
                //input.next();
            }
        }
    }
}
