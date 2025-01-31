package seedu.plannermd.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.plannermd.storage.JsonAdaptedDoctor.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.plannermd.testutil.Assert.assertThrows;
import static seedu.plannermd.testutil.doctor.TypicalDoctors.DR_BENSON;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.plannermd.commons.exceptions.IllegalValueException;
import seedu.plannermd.model.person.Address;
import seedu.plannermd.model.person.BirthDate;
import seedu.plannermd.model.person.Email;
import seedu.plannermd.model.person.Name;
import seedu.plannermd.model.person.Phone;

public class JsonAdaptedDoctorTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_ADDRESS = " ";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_BIRTH_DATE_1 = "10-10-2010";
    private static final String INVALID_BIRTH_DATE_2 = "42/2/2022";
    private static final String INVALID_BIRTH_DATE_3 = "13/01/2000 2222";
    private static final String INVALID_TAG = "#friend";

    private static final String VALID_NAME = DR_BENSON.getName().toString();
    private static final String VALID_PHONE = DR_BENSON.getPhone().toString();
    private static final String VALID_EMAIL = DR_BENSON.getEmail().toString();
    private static final String VALID_ADDRESS = DR_BENSON.getAddress().toString();
    private static final String VALID_BIRTH_DATE = DR_BENSON.getBirthDate().toString();
    private static final String VALID_REMARK = DR_BENSON.getRemark().toString();
    private static final List<JsonAdaptedTag> VALID_TAGS = DR_BENSON.getTags().stream().map(JsonAdaptedTag::new)
            .collect(Collectors.toList());

    @Test
    public void toModelType_validDoctorDetails_returnsDoctor() throws Exception {
        JsonAdaptedDoctor doctor = new JsonAdaptedDoctor(DR_BENSON);
        assertEquals(DR_BENSON, doctor.toModelType());
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedDoctor doctor = new JsonAdaptedDoctor(INVALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                VALID_BIRTH_DATE, VALID_REMARK, VALID_TAGS);
        String expectedMessage = Name.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, doctor::toModelType);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedDoctor doctor = new JsonAdaptedDoctor(null, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                VALID_BIRTH_DATE, VALID_REMARK, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, doctor::toModelType);
    }

    @Test
    public void toModelType_invalidPhone_throwsIllegalValueException() {
        JsonAdaptedDoctor doctor = new JsonAdaptedDoctor(VALID_NAME, INVALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                VALID_BIRTH_DATE, VALID_REMARK, VALID_TAGS);
        String expectedMessage = Phone.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, doctor::toModelType);
    }

    @Test
    public void toModelType_nullPhone_throwsIllegalValueException() {
        JsonAdaptedDoctor doctor = new JsonAdaptedDoctor(VALID_NAME, null, VALID_EMAIL, VALID_ADDRESS,
                VALID_BIRTH_DATE, VALID_REMARK, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, doctor::toModelType);
    }

    @Test
    public void toModelType_invalidEmail_throwsIllegalValueException() {
        JsonAdaptedDoctor doctor = new JsonAdaptedDoctor(VALID_NAME, VALID_PHONE, INVALID_EMAIL, VALID_ADDRESS,
                VALID_BIRTH_DATE, VALID_REMARK, VALID_TAGS);
        String expectedMessage = Email.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, doctor::toModelType);
    }

    @Test
    public void toModelType_nullEmail_throwsIllegalValueException() {
        JsonAdaptedDoctor doctor = new JsonAdaptedDoctor(VALID_NAME, VALID_PHONE, null, VALID_ADDRESS,
                VALID_BIRTH_DATE, VALID_REMARK, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, doctor::toModelType);
    }

    @Test
    public void toModelType_invalidAddress_throwsIllegalValueException() {
        JsonAdaptedDoctor doctor = new JsonAdaptedDoctor(VALID_NAME, VALID_PHONE, VALID_EMAIL, INVALID_ADDRESS,
                VALID_BIRTH_DATE, VALID_REMARK, VALID_TAGS);
        String expectedMessage = Address.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, doctor::toModelType);
    }

    @Test
    public void toModelType_nullAddress_throwsIllegalValueException() {
        JsonAdaptedDoctor doctor = new JsonAdaptedDoctor(VALID_NAME, VALID_PHONE, VALID_EMAIL, null,
                VALID_BIRTH_DATE, VALID_REMARK, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, doctor::toModelType);
    }

    @Test
    public void toModelType_nullBirthDate_throwsIllegalValueException() {
        JsonAdaptedDoctor doctor = new JsonAdaptedDoctor(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                null, VALID_REMARK, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, BirthDate.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, doctor::toModelType);
    }

    @Test
    public void toModelType_invalidBirthDate_throwsIllegalValueException() {
        JsonAdaptedDoctor doctor = new JsonAdaptedDoctor(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                INVALID_BIRTH_DATE_1, VALID_REMARK, VALID_TAGS);
        String expectedMessage = BirthDate.MESSAGE_CONSTRAINTS;

        assertThrows(IllegalValueException.class, expectedMessage, doctor::toModelType);
        JsonAdaptedDoctor doctor2 = new JsonAdaptedDoctor(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                INVALID_BIRTH_DATE_2, VALID_REMARK, VALID_TAGS);
        String expectedMessage2 = BirthDate.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage2, doctor2::toModelType);

        JsonAdaptedDoctor doctor3 = new JsonAdaptedDoctor(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                INVALID_BIRTH_DATE_3, VALID_REMARK, VALID_TAGS);
        String expectedMessage3 = BirthDate.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage3, doctor3::toModelType);
    }

    @Test
    public void toModelType_invalidTags_throwsIllegalValueException() {
        List<JsonAdaptedTag> invalidTags = new ArrayList<>(VALID_TAGS);
        invalidTags.add(new JsonAdaptedTag(INVALID_TAG));
        JsonAdaptedDoctor doctor = new JsonAdaptedDoctor(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                VALID_BIRTH_DATE, VALID_REMARK, invalidTags);
        assertThrows(IllegalValueException.class, doctor::toModelType);
    }
}
