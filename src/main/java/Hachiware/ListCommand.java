package Hachiware;

public class ListCommand extends Command {
    @Override
    public String execute(TaskList tasks, Ui ui, StoreFile storage) {
        if (tasks.size() == 0) {
            return "Your task list is empty!";
        }
        StringBuilder sb = new StringBuilder("Here are the tasks in your list:\n");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append((i + 1)).append(". ").append(tasks.get(i)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
