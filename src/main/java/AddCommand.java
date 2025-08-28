public class AddCommand extends Command {
    private final Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, StoreFile storage) throws HachiwareException {
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
