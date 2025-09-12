package Hachiware;

public class EventCommand extends Command {
    private final String description;
    private final String from;
    private final String to;

    public EventCommand(String args) throws HachiwareException {
        validateArgs(args);
        this.description = parseDescription(args);
        String[] timings = parseTimings(args);
        this.from = timings[0];
        this.to = timings[1];


    }

    @Override
    public String execute(TaskList tasks, Ui ui, StoreFile storage) throws HachiwareException {
        assert tasks != null : "TaskList cannot be null";
        assert storage != null : "StoreFile cannot be null";

        Task task;
        try {
            task = new Event(description, from, to);
        } catch (Exception e) {
            throw new HachiwareException(e.getMessage());
        }
        tasks.add(task);
        storage.save(tasks.getAll());
        return ui.showAddTaskMessage(task, tasks.size());
    }

    @Override
    public boolean isExit() {
        return false;
    }

    private void validateArgs(String args) throws HachiwareException {
        if (!args.contains("/from") || !args.contains("/to")) {
            throw new HachiwareException("MEOW! An event must have both /from and /to times.");
        }
    }

    private String parseDescription(String args) throws HachiwareException {
        String[] parts = args.split("/from", 2);
        String desc = parts[0].trim();
        if (desc.isEmpty()) {
            throw new HachiwareException("MEOW! The description of an event cannot be empty.");
        }
        return desc;
    }

    private String[] parseTimings(String args) {
        String[] parts = args.split("/from", 2);
        return parts[1].split("/to", 2);
    }
}
