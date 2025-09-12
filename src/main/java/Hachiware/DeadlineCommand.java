package Hachiware;

public class DeadlineCommand extends Command {
    private final String description;
    private final String by;

    public DeadlineCommand(String args) throws HachiwareException {
        //Split input into description and due date
        String[] parts = args.split("/by", 2);

        //Check if there are 2 arguments
        if (parts.length < 2) {
            throw new HachiwareException("MEOW! Hachiware.Hachiware.Deadline must have a /by date.");
        } else if (parts[0].trim().isEmpty()) { //Check if description exist
            throw new HachiwareException("MEOW! Hachiware.Hachiware.Deadline must have a description.");
        }
        this.description = parts[0].trim();
        this.by = parts[1].trim();
    }

    @Override
    public String execute(TaskList tasks, Ui ui, StoreFile storage) throws HachiwareException {
        assert tasks != null : "TaskList cannot be null";
        assert storage != null : "StoreFile cannot be null";

        Task task;
        try {
            task = new Deadline(description, by);
        } catch (Exception e) {
            throw new HachiwareException("Invalid date format. Use yyyy-MM-dd");
        }
        tasks.add(task);
        storage.save(tasks.getAll());
        return ui.showAddTaskMessage(task, tasks.size());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
