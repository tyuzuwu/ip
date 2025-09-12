package Hachiware;

public class AddCommand extends Command {
    private final Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, StoreFile storage) throws HachiwareException {

        tasks.add(task);
        storage.save(tasks.getAll());
        return ui.showAddTaskMessage(task, tasks.size());
    }

    @Override
    public boolean isExit() {
        return false;
    }

}
