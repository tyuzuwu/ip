package Hachiware;

public class ByeCommand extends Command {
    @Override
    public String execute(TaskList tasks, Ui ui, StoreFile storage) {

        return "Bye. Hope to see you again soon!";
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
