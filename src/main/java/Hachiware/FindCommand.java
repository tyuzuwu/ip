package Hachiware;

import java.util.ArrayList;

public class FindCommand extends Command {

    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, StoreFile storeFile) throws HachiwareException {
        ArrayList<Task> filteredTasks = new ArrayList<>();

        if (keyword == null || keyword.isBlank()) {
            throw new HachiwareException("MEOW! You need to provide a keyword to search for!");
        }

        for (Task task : tasks.getAll()) {
            if (task.description.contains(keyword)) {
                filteredTasks.add(task);
            }
        }


        if (filteredTasks.isEmpty()) {
            return "No matching tasks found for: " + keyword;
        } else {
            StringBuilder sb = new StringBuilder("Here are the matching tasks in your list:\n");
            for (int i = 0; i < filteredTasks.size(); i++) {
                sb.append((i + 1)).append(". ").append(filteredTasks.get(i)).append("\n");
            }
            return sb.toString();
        }

    }
}

