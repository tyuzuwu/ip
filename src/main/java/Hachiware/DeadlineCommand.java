package Hachiware;

public class DeadlineCommand extends Command {
    private final String description;
    private final String by;

    public DeadlineCommand(String args) throws HachiwareException {
        String[] parts = args.split("/by", 2);
        if (parts.length < 2 || parts[0].trim().isEmpty()) {
            throw new HachiwareException("MEOW! Hachiware.Hachiware.Deadline must have a description and /by date.");
        }
        this.description = parts[0].trim();
        this.by = parts[1].trim();
    }

    @Override
    public String execute(TaskList tasks, Ui ui, StoreFile storage) throws HachiwareException {
        Task task;
        try {
            task = new Deadline(description, by);
        } catch (Exception e) {
            throw new HachiwareException("Invalid date format. Use yyyy-MM-dd");
        }
        tasks.add(task);
        storage.save(tasks.getAll());
        return "Got it. I've added this task:\n"
                + task + "\n"
                + "Now you have " + tasks.size() + " tasks in the list.";
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
