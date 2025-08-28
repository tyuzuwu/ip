public class TodoCommand extends Command {
    private final String description;

    public TodoCommand(String description) throws HachiwareException {
        if (description.isEmpty()) {
            throw new HachiwareException("MEOW!!! OI The description of a todo cannot be empty.");
        }
        this.description = description;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, StoreFile storage) throws HachiwareException {
        Task task = new ToDo(description);
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
