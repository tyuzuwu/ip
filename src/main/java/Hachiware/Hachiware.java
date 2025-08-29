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

    public void run() {
        ui.welcome();
        Scanner scan = new Scanner(System.in);
        boolean isExit = false;

        while (!isExit) {
            String fullCommand = scan.nextLine();
            try {
                Command command = Parser.parse(fullCommand);
                command.execute(tasks, ui, storage);
                isExit = command.isExit();
            } catch (HachiwareException e) {
                ui.showError(e.getMessage());
            }
        }

        scan.close();
    }

    public static void main(String[] args) {
        new Hachiware("./data/Hachiware.Hachiware.txt").run();
    }


}
