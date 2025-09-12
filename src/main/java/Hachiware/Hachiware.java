package Hachiware;

import java.util.Scanner;

public class Hachiware {
    private StoreFile storage;
    private TaskList tasks;
    private Ui ui;

    private static final String LOAD_ERROR = "Failed to load tasks!";

    public Hachiware(String filePath) {
        ui = new Ui();
        storage = new StoreFile(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (HachiwareException e) {
            ui.showError(LOAD_ERROR);
            tasks = new TaskList();
        }
    }

    public TaskList getTasks() {
        return tasks;
    }

    public StoreFile getStorage() {
        return storage;
    }


}
