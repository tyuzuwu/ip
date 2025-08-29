package Hachiware;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeadlineTest {

    @Test
    void markAsDoneAndUnmark() {
        Deadline deadline = new Deadline("Submit report", "2025-09-01");
        assertFalse(deadline.isDone, "Deadline should not be done by default");

        deadline.markAsDone();
        assertTrue(deadline.isDone, "Deadline should be marked done");

        deadline.markAsNotDone();
        assertFalse(deadline.isDone, "Deadline should be marked not done");
    }

    @Test
    void invalidDateThrowsException() {
        assertThrows(DateTimeParseException.class, () -> new Deadline("Test", "invalid-date"),
                "Invalid date expected to throw DateTimeParseException");
    }
}
