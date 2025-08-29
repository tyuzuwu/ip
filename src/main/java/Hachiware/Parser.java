package Hachiware;

public class Parser {

    public static Command parse(String fullCommand) throws HachiwareException {
        String[] words = fullCommand.split(" ", 2);
        String command = words[0];
        String args = words.length > 1 ? words[1] : "";

        switch (command) {
            case "bye":
                return new ByeCommand();
            case "list":
                return new ListCommand();
            case "mark":
                return new MarkCommand(args);
            case "unmark":
                return new UnmarkCommand(args);
            case "todo":
                return new TodoCommand(args);
            case "deadline":
                return new DeadlineCommand(args);
            case "event":
                return new EventCommand(args);
            case "delete":
                return new DeleteCommand(args);
            default:
                throw new HachiwareException("MEOW! Hachiware.Hachiware.Command doesn't exist.");
        }
    }
}
