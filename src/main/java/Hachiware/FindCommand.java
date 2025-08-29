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
    public void execute(TaskList tasks, Ui ui, StoreFile storeFile) throws HachiwareException {
        ArrayList<Task> filteredTasks = new ArrayList<>();

        if (keyword == null || keyword.isBlank()) {
            throw new HachiwareException("MEOW! You need to provide a keyword to search for!");
        }

        for (Task task : tasks.getAll()) {
            if (task.description.contains(keyword)) {
                filteredTasks.add(task);
            }
        }

        ui.printLine();
        if (filteredTasks.isEmpty()) {
            System.out.println("No matching tasks found for: " + keyword);
        } else {
            System.out.println("Here are the matching tasks in your list:");
            for (int i = 0; i < filteredTasks.size(); i++) {
                System.out.println((i + 1) + "." + filteredTasks.get(i));
            }
        }
        ui.printLine();
    }
}

