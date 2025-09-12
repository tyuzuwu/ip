package Hachiware;

import java.util.ArrayList;

public class FindCommand extends Command {

    private final String keyword;
    public static final String SEARCH_NO_MATCH = "No matching tasks found for: ";
    public static final String SEARCH_RESULTS_HEADER = "Here are the matching tasks in your list:\n";

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, StoreFile storeFile) throws HachiwareException {

        validateKeyword();

        ArrayList<Task> filteredTasks = filterTasks(tasks);

        return formatResults(filteredTasks);

    }

    private void validateKeyword() throws HachiwareException {
        if (keyword == null || keyword.isBlank()) {
            throw new HachiwareException("MEOW! You need to provide a keyword to search for!");
        }
    }

    private ArrayList<Task> filterTasks(TaskList tasks) {
        ArrayList<Task> filtered = new ArrayList<>();
        for (Task task : tasks.getAll()) {
            if (task.description.contains(keyword)) {
                filtered.add(task);
            }
        }
        return filtered;
    }

    private String formatResults(ArrayList<Task> filteredTasks) {
        if (filteredTasks.isEmpty()) {
            return SEARCH_NO_MATCH + keyword;
        }
        StringBuilder sb = new StringBuilder(SEARCH_RESULTS_HEADER);
        for (int i = 0; i < filteredTasks.size(); i++) {
            sb.append(i + 1).append(". ").append(filteredTasks.get(i)).append("\n");
        }
        return sb.toString();
    }
}

