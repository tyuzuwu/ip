package Hachiware;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {

    @Test
    void addAndDeleteTask() {
        TaskList list = new TaskList();
        Task t1 = new ToDo("dying");
        Task t2 = new ToDo("eating");

        // Add tasks
        list.add(t1);
        list.add(t2);
        assertEquals(2, list.size(), "List expected to contain 2 tasks");

        // Delete task
        Task deleted = list.delete(0);
        assertEquals(t1, deleted, "Deleted task should equal the first task added");
        assertEquals(1, list.size(), "List should now only contain 1 remaining task");

        // Get remaining task
        assertEquals(t2, list.get(0), "Remaining task should be t2");
    }
}
