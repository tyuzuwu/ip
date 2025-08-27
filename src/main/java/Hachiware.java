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

        //Handle the loading of the tasks here from the file
        StoreFile storage = new StoreFile("./data/Hachiware.txt");
        ArrayList<Task> tasks;
        try {
            tasks = storage.load();
        } catch (HachiwareException e) {
            System.out.println("Failed to load tasks: " + e.getMessage());
            tasks = new ArrayList<>();
        }

        //While loop to repeatedly get user input
        while (true) {
            String input = scan.nextLine();

            try {
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
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                    System.out.println("-----------------------------------------------");
                } else if (input.startsWith("mark")) { //Marking task
                    if (input.length() <= 4) {
                        throw new HachiwareException("MEOW!!! OI The task to mark cannot be empty!");
                    }
                    int taskIndex = Integer.parseInt(input.substring(5)) - 1; //5th Character of the input onwards, -1 because of indexing

                    if (taskIndex < 0 || taskIndex > tasks.size()) {
                        throw new HachiwareException("Task number out of bounds");
                    }
                    Task currentTask = tasks.get(taskIndex);
                    currentTask.markAsDone();

                    //Saving the update to file
                    try {
                        storage.save(tasks);
                    } catch (HachiwareException e) {
                        System.out.println("Failed to save tasks: " + e.getMessage());
                    }

                    System.out.println("-----------------------------------------------");
                    System.out.println("Nice! I've marked this task as done: ");
                    System.out.println(currentTask);
                    System.out.println("-----------------------------------------------");

                } else if (input.startsWith("unmark")) {
                    if (input.length() <= 6) {
                        throw new HachiwareException("MEOW!!! OI The task to unmark cannot be empty!");
                    }
                    int taskIndex = Integer.parseInt(input.substring(7)) - 1; //7th Character of the input onwards, -1 because of indexing
                    if (taskIndex < 0 || taskIndex > tasks.size()) {
                        throw new HachiwareException("Task number out of bounds");
                    }
                    Task currentTask = tasks.get(taskIndex);
                    currentTask.markAsNotDone();

                    try {
                        storage.save(tasks);
                    } catch (HachiwareException e) {
                        System.out.println("Failed to save tasks: " + e.getMessage());
                    }

                    System.out.println("-----------------------------------------------");
                    System.out.println("OK, I've marked this task as not done yet: ");
                    System.out.println(currentTask);
                    System.out.println("-----------------------------------------------");
                } else if (input.startsWith("todo")) {

                    if (input.length() <= 4) {
                        throw new HachiwareException("MEOW!!! OI The description of a todo cannot be empty.");
                    }
                    String descript = input.substring(5);
                    Task newTask = new ToDo(descript);
                    tasks.add(newTask);

                    try {
                        storage.save(tasks);
                    } catch (HachiwareException e) {
                        System.out.println("Failed to save tasks: " + e.getMessage());
                    }

                    System.out.println("-----------------------------------------------");
                    System.out.println("Got it. I've added this task:");
                    System.out.println(newTask);
                    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    System.out.println("-----------------------------------------------");
                } else if (input.startsWith("deadline")) {
                    if (!input.contains("/by")) {
                        throw new HachiwareException("MEOW! A deadline must have a /by time.");
                    }
                    //Split input into description and deadline by
                    String[] parts = input.substring(9).split("/by", 2);
                    if (parts[0].isEmpty()) {
                        throw new HachiwareException("MEOW! The description of a deadline cannot be empty.");
                    }
                    String descript = parts[0];
                    String by = parts[1];
                    Task newTask = new Deadline(descript, by);
                    tasks.add(newTask);

                    try {
                        storage.save(tasks);
                    } catch (HachiwareException e) {
                        System.out.println("Failed to save tasks: " + e.getMessage());
                    }

                    System.out.println("-----------------------------------------------");
                    System.out.println("Got it. I've added this task:");
                    System.out.println(newTask);
                    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    System.out.println("-----------------------------------------------");
                } else if (input.startsWith("event")) {
                    if (!input.contains("/from") || !input.contains("/to")) {
                        throw new HachiwareException("MEOW! An event must have both /from and /to times.");
                    }
                    //Similarly split into parts first
                    String[] parts = input.substring(6).split("/from", 2);
                    String descript = parts[0];
                    if (parts[0].isEmpty()) {
                        throw new HachiwareException("MEOW! The description of a deadline cannot be empty.");
                    }
                    //Further split 2nd half into the 2 timings
                    String[] timing = parts[1].split("/to", 2);
                    String from = timing[0];
                    String to = timing[1];
                    Task newTask = new Event(descript, from, to);
                    tasks.add(newTask);

                    try {
                        storage.save(tasks);
                    } catch (HachiwareException e) {
                        System.out.println("Failed to save tasks: " + e.getMessage());
                    }

                    System.out.println("-----------------------------------------------");
                    System.out.println("Got it. I've added this task:");
                    System.out.println(newTask);
                    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    System.out.println("-----------------------------------------------");
                } else if (input.startsWith("delete")) {
                    if (input.length() <= 6) {
                        throw new HachiwareException("MEOW!!! OI What task do you want to delete?");
                    }
                    int taskIndex = Integer.parseInt(input.substring(7)) - 1;
                    //Temp task to hold
                    Task deletedTask = tasks.remove(taskIndex);

                    try {
                        storage.save(tasks);
                    } catch (HachiwareException e) {
                        System.out.println("Failed to save tasks: " + e.getMessage());
                    }

                    System.out.println("-----------------------------------------------");
                    System.out.println("Noted. I've removed this task:");
                    System.out.println(deletedTask);
                    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    System.out.println("-----------------------------------------------");

                } else {
                    throw new HachiwareException("MEOW! Command doesn't exist.");
                }
            } catch (HachiwareException e) {
                System.out.println("-----------------------------------------------");
                System.out.println(e.getMessage());
                System.out.println("-----------------------------------------------");
            }
        }

        scan.close();

    }
}
