package Hachiware;

public class EventCommand extends Command {
    private final String description;
    private final String from;
    private final String to;

    public EventCommand(String args) throws HachiwareException {
        if (!args.contains("/from") || !args.contains("/to")) {
            throw new HachiwareException("MEOW! An event must have both /from and /to times.");
        }
        String[] parts = args.split("/from", 2);
        this.description = parts[0].trim();
        String[] timing = parts[1].split("/to", 2);
        this.from = timing[0].trim();
        this.to = timing[1].trim();

        if (this.description.isEmpty()) {
            throw new HachiwareException("MEOW! The description of an event cannot be empty.");
        }
    }

    @Override
    public String execute(TaskList tasks, Ui ui, StoreFile storage) throws HachiwareException {
        Task task;
        try {
            task = new Event(description, from, to);
        } catch (Exception e) {
            throw new HachiwareException(e.getMessage());
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
