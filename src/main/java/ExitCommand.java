public class ExitCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, StoreFile storeFile) {
        ui.bye();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
