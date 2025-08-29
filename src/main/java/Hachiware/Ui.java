package Hachiware;

public class Ui {

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

    public void bye() {
        printLine();
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
    }

    public void printLine() {
        System.out.println("-----------------------------------------------");
    }

    public void showError(String message) {
        printLine();
        System.out.println(message);
        printLine();
    }
}
