package seedu.address.ui.testutil;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import guitests.guihandles.PersonCardHandle;
import guitests.guihandles.PersonListPanelHandle;
import guitests.guihandles.RedoCardHandle;
import guitests.guihandles.TextResultDisplayHandle;
import guitests.guihandles.UndoCardHandle;
import seedu.address.model.participant.Participant;

/**
 * A set of assertion methods useful for writing GUI tests.
 */
public class GuiTestAssert {
    /**
     * Asserts that {@code actualCard} displays the same values as {@code expectedCard}.
     */
    public static void assertCardEquals(PersonCardHandle expectedCard, PersonCardHandle actualCard) {
        assertEquals(expectedCard.getId(), actualCard.getId());
        assertEquals(expectedCard.getMajor(), actualCard.getMajor());
        assertEquals(expectedCard.getEmail(), actualCard.getEmail());
        assertEquals(expectedCard.getName(), actualCard.getName());
        assertEquals(expectedCard.getPhone(), actualCard.getPhone());
        assertEquals(expectedCard.getTags(), actualCard.getTags());
    }

    /**
     * Asserts that {@code actualCard} displays the details of {@code expectedParticipant}.
     */
    public static void assertCardDisplaysPerson(Participant expectedParticipant, PersonCardHandle actualCard) {
        assertEquals(expectedParticipant.getName().fullName, actualCard.getName());
        assertEquals("Sex: " + expectedParticipant.getSex().value, actualCard.getSex());
        assertEquals("Birthday: " + expectedParticipant.getBirthday().getFormattedBirthday(), actualCard.getBirthday());
        assertEquals("Phone Number: " + expectedParticipant.getPhone().value, actualCard.getPhone());
        assertEquals("Email: " + expectedParticipant.getEmail().value, actualCard.getEmail());
        assertEquals("Major: " + expectedParticipant.getMajor().getFullMajor(), actualCard.getMajor());
        assertEquals(expectedParticipant.getTags().stream().map(tag -> tag.tagName).collect(Collectors.toList()),
                actualCard.getTags());
    }

    /**
     * Assert that {@code actualCard} displays the {@undoCard}
     */
    public static void assertUndoCardDisplay(String commandText, UndoCardHandle undoCard) {
        assertEquals(commandText, undoCard.getCommand());
    }

    /**
     * Assert that {@code actualCard} displays the {@redoCard}
     */
    public static void assertRedoCardDisplay(String commandText, RedoCardHandle redoCard) {
        assertEquals(commandText, redoCard.getCommand());
    }

    /**
     * Asserts that the list in {@code personListPanelHandle} displays the details of {@code participants} correctly and
     * in the correct order.
     */
    public static void assertListMatching(PersonListPanelHandle personListPanelHandle, Participant... participants) {
        for (int i = 0; i < participants.length; i++) {
            personListPanelHandle.navigateToCard(i);
            assertCardDisplaysPerson(participants[i], personListPanelHandle.getPersonCardHandle(i));
        }
    }

    /**
     * Asserts that the list in {@code personListPanelHandle} displays the details of {@code participants} correctly and
     * in the correct order.
     */
    public static void assertListMatching(PersonListPanelHandle personListPanelHandle, List<Participant> participants) {
        assertListMatching(personListPanelHandle, participants.toArray(new Participant[0]));
    }

    /**
     * Asserts the size of the list in {@code personListPanelHandle} equals to {@code size}.
     */
    public static void assertListSize(PersonListPanelHandle personListPanelHandle, int size) {
        int numberOfPeople = personListPanelHandle.getListSize();
        assertEquals(size, numberOfPeople);
    }

    /**
     * Asserts the message shown in {@code textResultDisplayHandle} equals to {@code expected}.
     */
    public static void assertResultMessage(TextResultDisplayHandle textResultDisplayHandle, String expected) {
        assertEquals(expected, textResultDisplayHandle.getText());
    }
}
