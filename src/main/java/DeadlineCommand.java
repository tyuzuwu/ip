public class DeadlineCommand extends Command {
    private final String description;
    private final String by;

    public DeadlineCommand(String args) throws HachiwareException {
        String[] parts = args.split("/by", 2);
        if (parts.length < 2 || parts[0].trim().isEmpty()) {
            throw new HachiwareException("MEOW! Deadline must have a description and /by date.");
        }
        this.description = parts[0].trim();
        this.by = parts[1].trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, StoreFile storage) throws HachiwareException {
        Task task;
        try {
            task = new Deadline(description, by);
        } catch (Exception e) {
            throw new HachiwareException("Invalid date format. Use yyyy-MM-dd");
        }
        tasks.add(task);
        storage.save(tasks.getAll());
        ui.printLine();
        System.out.println("Got it. I've added this task:");
        System.out.println(task);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        ui.printLine();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
