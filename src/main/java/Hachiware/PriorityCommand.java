package Hachiware;

public class PriorityCommand extends Command {
    private final int taskIndex;
    private final Priority priority;

    public PriorityCommand(String args) throws HachiwareException {
        int[] parsed = parseArgs(args);
        this.taskIndex = parsed[0];
        this.priority = Priority.values()[parsed[1]];
    }

    @Override
    public String execute(TaskList tasks, Ui ui, StoreFile storage) throws HachiwareException {
        if (taskIndex < 0 || taskIndex >= tasks.size()) {
            throw new HachiwareException("MEOW! Task number out of bounds");
        }
        Task task = tasks.get(taskIndex);
        task.setPriority(priority);
        storage.save(tasks.getAll());
        return "Priority set to " + priority + " for task:\n" + task;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    private int[] parseArgs(String args) throws HachiwareException {
        String[] parts = args.trim().split(" ", 2);
        if (parts.length < 2) {
            throw new HachiwareException("Usage: priority <task number> <HIGH|MEDIUM|LOW>");
        }

        int taskIdx;
        try {
            taskIdx = Integer.parseInt(parts[0]) - 1;
        } catch (NumberFormatException e) {
            throw new HachiwareException("MEOW! Invalid task number.");
        }

        int priorityOrdinal;
        try {
            Priority parsedPriority = Priority.valueOf(parts[1].trim().toUpperCase());
            priorityOrdinal = parsedPriority.ordinal();
        } catch (IllegalArgumentException e) {
            throw new HachiwareException("MEOW! Invalid priority level. Use HIGH, MEDIUM, or LOW.");
        }

        return new int[]{taskIdx, priorityOrdinal};
    }
}