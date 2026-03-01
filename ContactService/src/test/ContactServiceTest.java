import static org.junit.Assert.*;
import org.junit.Test;

public class ContactServiceTest {

    @Test
    public void addAndDeleteContact_succeeds() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        service.deleteContact("1"); // should not throw
    }

    @Test(expected = IllegalArgumentException.class)
    public void addContact_duplicateId_fails() {
        ContactService service = new ContactService();
        service.addContact(new Contact("1", "John", "Doe", "1234567890", "123 Main St"));
        service.addContact(new Contact("1", "Jane", "Smith", "0987654321", "456 Oak Ave"));
    }

    @Test
    public void updateContactFields_succeeds() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);

        service.updateFirstName("1", "Mike");
        service.updatePhone("1", "0987654321");

        assertEquals("Mike", contact.getFirstName());
        assertEquals("0987654321", contact.getPhone());
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateMissingContact_fails() {
        ContactService service = new ContactService();
        service.updateFirstName("missing", "Mike");
    }
}

