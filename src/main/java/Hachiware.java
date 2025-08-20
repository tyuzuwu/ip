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

        //Create array of tasks to hold tasks
        ArrayList<Task> tasks = new ArrayList<>();

        //While loop to repeatedly get user input
        while (true) {
            String input = scan.nextLine();

            //If bye, exit loop
            if (input.equals("bye")) {

                System.out.println("-----------------------------------------------");
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("-----------------------------------------------");
                break;
            } else if (input.equals("list")) { //Listing tasks
                //Print list
                System.out.println("-----------------------------------------------");
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i+1) + ". " + tasks.get(i));
                }
                System.out.println("-----------------------------------------------");
            } else if (input.startsWith("mark ")) { //Marking tasks
                int taskIndex = Integer.parseInt(input.substring(5)) - 1; //5th Character of the input onwards, -1 because of indexing
                Task currentTask = tasks.get(taskIndex);
                currentTask.markAsDone();
                System.out.println("-----------------------------------------------");
                System.out.println("Nice! I've marked this task as done: ");
                System.out.println(currentTask);
                System.out.println("-----------------------------------------------");

            } else if (input.startsWith("unmark ")) {
                int taskIndex = Integer.parseInt(input.substring(7)) - 1; //7th Character of the input onwards, -1 because of indexing
                Task currentTask = tasks.get(taskIndex);
                currentTask.markAsNotDone();
                System.out.println("-----------------------------------------------");
                System.out.println("OK, I've marked this task as not done yet: ");
                System.out.println(currentTask);
                System.out.println("-----------------------------------------------");
            } else {
                //Add to tasks
                Task newTask = new Task(input);
                tasks.add(newTask);

                //Normal Echo
                System.out.println("-----------------------------------------------");
                System.out.println("added: " + input);
                System.out.println("-----------------------------------------------");
            }

        }

        scan.close();

    }
}
