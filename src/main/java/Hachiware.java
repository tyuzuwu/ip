import java.util.ArrayList;
import java.util.Scanner;

public class Hachiware {
    public static void main(String[] args) {
        String logo =
                " /\\_/\\  \n"
                + "( o.o )  \n"
                + " > ^ <   \n";
        System.out.println(logo);
        System.out.println("-----------------------------------------------");
        System.out.println("Hello~! I'm Hachiware \nWhat can I do for you?");
        System.out.println("-----------------------------------------------");

        //Use scanner to get user input
        Scanner scan = new Scanner(System.in);

        //Create array to hold tasks
        ArrayList<String> tasks = new ArrayList<>();

        //While loop to repeatedly get user input
        while (true) {
            String input = scan.nextLine();

            //If bye, exit loop
            if (input.equals("bye")) {

                System.out.println("-----------------------------------------------");
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("-----------------------------------------------");
                break;
            } else if (input.equals("list")) {
                //Print list
                System.out.println("-----------------------------------------------");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i+1) + ". " + tasks.get(i));
                }
                System.out.println("-----------------------------------------------");
            } else {
                //Add to tasks
                tasks.add(input);

                //Normal Echo
                System.out.println("-----------------------------------------------");
                System.out.println("added: " + input);
                System.out.println("-----------------------------------------------");
            }

        }

        scan.close();

    }
}
