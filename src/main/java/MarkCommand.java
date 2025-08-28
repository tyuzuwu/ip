public class MarkCommand extends Command {
    private final int index;

    public MarkCommand(String arg) throws HachiwareException {
        try {
            this.index = Integer.parseInt(arg.trim()) - 1;
        } catch (NumberFormatException e) {
            throw new HachiwareException("MEOW! Invalid task number.");
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui, StoreFile storage) throws HachiwareException {
        if (index < 0 || index >= tasks.size()) {
            throw new HachiwareException("Task number out of bounds");
        }
        Task task = tasks.get(index);
        task.markAsDone();
        storage.save(tasks.getAll());
        ui.printLine();
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println(task);
        ui.printLine();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
