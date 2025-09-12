package Hachiware;

public class ListCommand extends Command {
    private static final String TASK_LIST_EMPTY = "Your task list is empty!";
    private static final String TASK_LIST_HEADER = "Here are the tasks in your list:\n";

    @Override
    public String execute(TaskList tasks, Ui ui, StoreFile storage) {
        assert tasks != null : "TaskList cannot be null";

        if (tasks.size() == 0) {
            return TASK_LIST_EMPTY;
        }

        StringBuilder sb = new StringBuilder(TASK_LIST_HEADER);
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
