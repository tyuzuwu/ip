package Hachiware;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a Deadline task.
 * A Deadline task has a description and a due date.
 */
public class Deadline extends Task {
    /** Deadline of the task. */
    protected LocalDate by;
    /** Formatting for the deadline. */
    private static final DateTimeFormatter DISPLAY_FORMAT = DateTimeFormatter.ofPattern("MMM d yyyy");

    /**
     * Creates a new Deadline task.
     *
     * @param description description of the deadline task
     * @param by due date in {@code yyyy-MM-dd} format
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = LocalDate.parse(by);
    }

    /**
     * Returns the string representation of the Deadline task
     * denoted by [D] in front to represent Deadline.
     *
     * @return task string with deadline date formatted
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() +
                " (by: " + by.format(DISPLAY_FORMAT) + ")";
    }

    public LocalDate getBy() {
        return by;
    }
}
