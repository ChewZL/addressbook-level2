package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, #21-03, 123456";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be 4 alphanumeric strings seperated by commas";
    public static final String ADDRESS_VALIDATION_REGEX = ".+, .+, .+, .+";

    public final Block block;
    public final Street street;
    public final Unit unit;
    public final PostalCode code;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] splitted = address.split(",");
        this.block = new Block(splitted[0]);
        this.street = new Street(splitted[1]);
        this.unit = new Unit(splitted[2]);
        this.code = new PostalCode(splitted[3]);
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return block + ", " + street + ", " + unit + ", " + code;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}