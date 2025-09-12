package Hachiware;

public class DeleteCommand extends Command {
    private final int index;

    public DeleteCommand(String arg) throws HachiwareException {
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
        Task removed = tasks.delete(index);
        storage.save(tasks.getAll());
        return ui.showDeleteTaskMessage(removed, tasks.size());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
