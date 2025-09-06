package Hachiware;

public class ExitCommand extends Command {
    @Override
    public String execute(TaskList tasks, Ui ui, StoreFile storeFile) {

        return "Bye. Hope to see you again soon!";
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
