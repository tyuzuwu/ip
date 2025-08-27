import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected LocalDateTime from;
    protected LocalDateTime to;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Event(String description, String from, String to) {
        super(description);
        this.from = LocalDateTime.parse(from, FORMATTER);
        this.to = LocalDateTime.parse(to, FORMATTER);

        if (this.to.isBefore(this.from)) {
            throw new IllegalArgumentException("Ending time cannot be before starting time.");
        }
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from: " + from.format(FORMATTER) + " to: " + to.format(FORMATTER) + ")";
    }
}
