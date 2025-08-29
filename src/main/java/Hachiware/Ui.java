package Hachiware;

/**
 * The {@code Ui} class handles all user interface interactions for Hachiware.
 * It provides methods to display welcome and exit messages, print lines,
 * print error messages, to ensure consistency in display.
 */
public class Ui {

    /**
     * Prints the welcome message along with a cat logo
     */
    public void welcome() {
        String logo =
                " /\\_/\\  \n"
                        + "( o.o )  \n"
                        + " > ^ <   \n";
        System.out.println(logo);
        printLine();
        System.out.println("Hello~! I'm Hachiware.Hachiware \nWhat can I do for you?");
        printLine();
    }

    /**
     * Prints the exit message when the program terminates.
     */
    public void bye() {
        printLine();
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
    }

    /**
     * Prints a horizontal line for formatting.
     */
    public void printLine() {
        System.out.println("-----------------------------------------------");
    }

    public void showError(String message) {
        printLine();
        System.out.println(message);
        printLine();
    }
}
