import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Objects;

public class StoreFile {
    private final String filePath = "./data/Hachiware.txt";

    public StoreFile(String filePath) {

    }

    //Function to convert task line in the text file to a Task object
    //Line in the form of T | 1 | read book
    private Task convertTask(String line) throws HachiwareException {
        String[] parts = line.split(" \\| ");
        String taskType = parts[0];
        boolean isDone = Objects.equals(parts[1], "1");
        String descript = parts[2];

        switch (taskType) {
            case "T":
                Task todo = new ToDo(descript);
                if (isDone) {
                    todo.markAsDone();
                }
                return todo;

            case "D":
                String by = parts[3];
                Task deadline = new Deadline(descript, by);
                if (isDone) {
                    deadline.markAsDone();
                }
                return deadline;

            case "E":
                String from = parts[3];
                String to = parts[4];
                Task event = new Event(descript, from, to);
                if (isDone) {
                    event.markAsDone();
                }
                return event;

            default:
                throw new HachiwareException("Unknown task type: " + taskType);

        }

    }

    //Function to convert Tasks into text file format
    private String convertTaskToSave(Task task) throws HachiwareException {
        String done = task.isDone ? "1" : "0";

        if (task instanceof ToDo) {
            return "T | " + done + " | " + task.description;
        } else if (task instanceof Deadline) {
            Deadline d = (Deadline) task;
            return "D | " + done + " | " + d.description + " | " + d.by;
        } else if (task instanceof Event) {
            Event e = (Event) task;
            return "E | " + done + " | " + e.description + " | " + e.from + " | " + e.to;
        } else {
            throw new HachiwareException("Unknown task type");
        }
    }

    //Loading tasks from text file into ArrayList<Task>
    public ArrayList<Task> load() throws HachiwareException {
        ArrayList<Task> tasks = new ArrayList<>();

        try {
            File file = new File(filePath);
            File parent = file.getParentFile();
            //Check if folder exist and create if it doesnt
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }

            //Using BufferedReader as it can read line by line instead
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    tasks.add(convertTask(line));
                }
            }
        } catch (IOException e) {
            throw new HachiwareException("Failed to load tasks: " + e.getMessage());
        }

        return tasks;
    }

    //Function to save current tasks into the file
    public void save(ArrayList<Task> tasks) throws HachiwareException {
        try {
            File file = new File(filePath);
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (Task task : tasks) {
                    String line = convertTaskToSave(task);
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            throw new HachiwareException("Failed to save tasks: " + e.getMessage());
        }
    }
}
