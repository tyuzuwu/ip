package Hachiware;

public class ByeCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, StoreFile storage) {
        ui.bye();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
