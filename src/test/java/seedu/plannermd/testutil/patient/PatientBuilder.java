package seedu.plannermd.testutil.patient;

import static seedu.plannermd.testutil.PersonBuilder.DEFAULT_ADDRESS;
import static seedu.plannermd.testutil.PersonBuilder.DEFAULT_BIRTH_DATE;
import static seedu.plannermd.testutil.PersonBuilder.DEFAULT_EMAIL;
import static seedu.plannermd.testutil.PersonBuilder.DEFAULT_NAME;
import static seedu.plannermd.testutil.PersonBuilder.DEFAULT_PHONE;
import static seedu.plannermd.testutil.PersonBuilder.DEFAULT_REMARK;

import java.util.HashSet;
import java.util.Set;

import seedu.plannermd.model.patient.Patient;
import seedu.plannermd.model.patient.Risk;
import seedu.plannermd.model.person.Address;
import seedu.plannermd.model.person.BirthDate;
import seedu.plannermd.model.person.Email;
import seedu.plannermd.model.person.Name;
import seedu.plannermd.model.person.Person;
import seedu.plannermd.model.person.Phone;
import seedu.plannermd.model.person.Remark;
import seedu.plannermd.model.tag.Tag;
import seedu.plannermd.model.util.SampleDataUtil;

/**
 * A utility class to help with building Patient objects.
 */
public class PatientBuilder {

    public static final String DEFAULT_RISK = "LOW";

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private BirthDate birthDate;
    private Remark remark;
    private Set<Tag> tags;
    private Risk risk;

    /**
     * Creates a {@code PatientBuilder} with the default details.
     */
    public PatientBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        birthDate = new BirthDate(DEFAULT_BIRTH_DATE);
        remark = new Remark(DEFAULT_REMARK);
        tags = new HashSet<>();
        risk = new Risk(DEFAULT_RISK);
    }

    /**
     * Initializes the PatientBuilder with the data of {@code personToCopy}.
     */
    public PatientBuilder(Person personToCopy) {
        name = personToCopy.getName();
        phone = personToCopy.getPhone();
        email = personToCopy.getEmail();
        address = personToCopy.getAddress();
        birthDate = personToCopy.getBirthDate();
        remark = personToCopy.getRemark();
        tags = new HashSet<>(personToCopy.getTags());
        risk = new Risk(DEFAULT_RISK);
    }

    /**
     * Initializes the PatientBuilder with the data of {@code patientToCopy}.
     */
    public PatientBuilder(Patient patientToCopy) {
        name = patientToCopy.getName();
        phone = patientToCopy.getPhone();
        email = patientToCopy.getEmail();
        address = patientToCopy.getAddress();
        birthDate = patientToCopy.getBirthDate();
        remark = patientToCopy.getRemark();
        tags = new HashSet<>(patientToCopy.getTags());
        risk = patientToCopy.getRisk();
    }

    /**
     * Sets the {@code Name} of the {@code Patient} that we are building.
     */
    public PatientBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the
     * {@code Patient} that we are building.
     */
    public PatientBuilder withTags(String... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Patient} that we are building.
     */
    public PatientBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Patient} that we are building.
     */
    public PatientBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Patient} that we are building.
     */
    public PatientBuilder withBirthDate(String birthDate) {
        this.birthDate = new BirthDate(birthDate);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Patient} that we are building.
     */
    public PatientBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Remark} of the
     * {@code Patient} that we are building.
     */
    public PatientBuilder withRemark(String remark) {
        this.remark = new Remark(remark);
        return this;
    }

    /**
     * Sets the {@code Risk} of the {@code Patient} that we are building. Accepts
     * UNCLASSIFIED risk.
     */
    public PatientBuilder withRisk(String risk) {
        this.risk = Risk.getUnclassifiableRisk(risk);
        return this;
    }

    public Patient build() {
        return new Patient(name, phone, email, address, birthDate, remark, tags, risk);
    }

}
