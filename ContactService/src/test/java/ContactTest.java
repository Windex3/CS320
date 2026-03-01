import static org.junit.Assert.*;
import org.junit.Test;

public class ContactTest{
    //tests contact creation
    @Test
    public void createContact_validContact_succeeds() {
        Contact contact = new Contact(
            "1234567890",
            "John",
            "doe",
            "1234567890",
            "123 Main Street"
        );

        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    //contactId constraints
    @Test(expected = IllegalArgumentException.class)
    public void createContact_contactIdNull_fails() {
        new Contact(null, "John", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createContact_contactIdTooLong_fails() {
        new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
    }

    //firstName constraints
    @Test(expected = IllegalArgumentException.class)
    public void createContact_firstNameNull_fails() {
         new Contact("1", null, "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createContact_firstNameTooLong_fails() {
        new Contact("1", "ABCDEFGHIJK", "Doe", "1234567890", "123 Main St");
    }

    //phone constraints
    @Test(expected = IllegalArgumentException.class)
    public void createContact_phoneTooShort_fails() {
        new Contact("1", "John", "Doe", "123456789", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createContact_phoneTooLong_fails() {
        new Contact("1", "John", "Doe", "12345678901", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createContact_phoneNonDigits_fails() {
        new Contact("1", "John", "Doe", "12345abcde", "123 Main St");
    }

    //address constraints
    @Test(expected = IllegalArgumentException.class)
    public void createContact_addressTooLong_fails() {
        new Contact("1", "John", "Doe", "1234567890", "1234567890123456789012345678901");
    }
}