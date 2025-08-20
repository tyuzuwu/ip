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

        //While loop to repeatedly get user input
        while (true) {
            String input = scan.nextLine();

            //If bye, exit loop
            if (input.equals("bye")) {

                System.out.println("-----------------------------------------------");
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("-----------------------------------------------");
                break;
            }

            //Normal Echo
            System.out.println("-----------------------------------------------");
            System.out.println(input);
            System.out.println("-----------------------------------------------");
        }

        scan.close();

    }
}
