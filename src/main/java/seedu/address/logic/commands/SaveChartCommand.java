package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Save the pie charts to image files with specified name
 */

public class SaveChartCommand extends Command {

    public static final String COMMAND_WORD = "save_c";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Save the pie charts to image files. Parameters: "
            + "File Name";

    public static final String MESSAGE_SUCCESS = "Saved images";
    public static final String MESSAGE_NO_PERSON = "There is no information in the app.";

    private static String fileName;

    public SaveChartCommand() {
        this.fileName = "";
    }

    public SaveChartCommand(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        requireNonNull(model);

        if (model.isEmpty()) {
            throw new CommandException(MESSAGE_NO_PERSON);
        }

        model.setFileName(fileName);

        return new CommandResult(MESSAGE_SUCCESS, false, false, false, true);
    }
}
