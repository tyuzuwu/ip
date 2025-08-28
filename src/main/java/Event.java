import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Task {
    protected LocalDateTime from;
    protected LocalDateTime to;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Event(String description, String from, String to) throws HachiwareException {
        super(description);
        try {
            this.from = LocalDateTime.parse(from, FORMATTER);
            this.to = LocalDateTime.parse(to, FORMATTER);
        } catch (DateTimeParseException e) {
            throw new HachiwareException("Invalid date & time format. Use yyyy-MM-dd HH:mm");
        }

        if (this.to.isBefore(this.from)) {
            throw new IllegalArgumentException("Ending time cannot be before starting time.");
        }
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from: " + from.format(FORMATTER) + " to: " + to.format(FORMATTER) + ")";
    }
}
