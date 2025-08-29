package Hachiware;

public class UnmarkCommand extends Command {
    private final int index;

    public UnmarkCommand(String arg) throws HachiwareException {
        try {
            this.index = Integer.parseInt(arg.trim()) - 1;
        } catch (NumberFormatException e) {
            throw new HachiwareException("MEOW! Invalid task number.");
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui, StoreFile storage) throws HachiwareException {
        if (index < 0 || index >= tasks.size()) {
            throw new HachiwareException("Hachiware.Hachiware.Task number out of bounds");
        }
        Task task = tasks.get(index);
        task.markAsNotDone();
        storage.save(tasks.getAll());
        ui.printLine();
        System.out.println("OK, I've marked this task as not done yet: ");
        System.out.println(task);
        ui.printLine();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
