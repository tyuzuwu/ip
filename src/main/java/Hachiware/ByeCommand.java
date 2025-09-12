package Hachiware;

public class ByeCommand extends Command {
    public static final String BYE_MESSAGE = "Bye. Hope to see you again soon!";

    @Override
    public String execute(TaskList tasks, Ui ui, StoreFile storage) {

        return BYE_MESSAGE;
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
