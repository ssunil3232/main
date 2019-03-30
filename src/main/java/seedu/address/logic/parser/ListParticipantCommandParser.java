package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.ListParticipantCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.FindingParticipantPredicate;


/**
 * Parses input arguments and creates a new FindCommand object
 */
public class ListParticipantCommandParser implements Parser<ListParticipantCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns an FindCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ListParticipantCommand parse(String args) throws ParseException {
        String trimmedArgs = "Participant";
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ListParticipantCommand.MESSAGE_USAGE));
        }

        String[] nameKeywords = trimmedArgs.split("\\s+");

        return new ListParticipantCommand(new FindingParticipantPredicate(Arrays.asList(nameKeywords)));
    }

}
