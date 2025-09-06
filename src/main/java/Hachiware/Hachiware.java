package Hachiware;

import java.util.Scanner;

public class Hachiware {
    private StoreFile storage;
    private TaskList tasks;
    private Ui ui;

    public Hachiware(String filePath) {
        ui = new Ui();
        storage = new StoreFile(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (HachiwareException e) {
            ui.showError("Failed to load tasks!");
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
