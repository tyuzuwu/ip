package Hachiware;

public class TodoCommand extends Command {
    private final String description;

    public TodoCommand(String description) throws HachiwareException {
        if (description.isEmpty()) {
            throw new HachiwareException("MEOW!!! OI The description of a todo cannot be empty.");
        }
        this.description = description;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, StoreFile storage) throws HachiwareException {
        assert tasks != null : "TaskList cannot be null";
        assert storage != null : "StoreFile cannot be null";

        Task task = new ToDo(description);
        tasks.add(task);
        storage.save(tasks.getAll());
        return ui.showAddTaskMessage(task, tasks.size());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
