package Hachiware;

public class MarkCommand extends Command {
    private final int index;

    public MarkCommand(String arg) throws HachiwareException {
        try {
            this.index = Integer.parseInt(arg.trim()) - 1;
        } catch (NumberFormatException e) {
            throw new HachiwareException("MEOW! Invalid task number.");
        }
    }

    @Override
    public String execute(TaskList tasks, Ui ui, StoreFile storage) throws HachiwareException {
        assert tasks != null : "TaskList cannot be null";
        assert storage != null : "StoreFile cannot be null";

        if (index < 0 || index >= tasks.size()) {
            throw new HachiwareException("Hachiware.Hachiware.Task number out of bounds");
        }
        Task task = tasks.get(index);
        task.markAsDone();
        storage.save(tasks.getAll());
        return "Nice! I've marked this task as done:\n" + task;
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
