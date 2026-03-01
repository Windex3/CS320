import java.util.HashMap;
import java.util.Map;

public class ContactService {
    //Stores contacts, key = contactId, value = Contact
    private final Map<String, Contact> contacts = new HashMap<>();

    /**
    *Adds a new contact
    *
    *@param contact Contact object to add 
    */

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("contact must not be null");
        }

        String id = contact.getContactId();

        //Enforces unique contact IDs
        if (contacts.containsKey(id)) {
            throw new IllegalArgumentException("contactId must be unique");
        }
        contacts.put(id, contact);
    }

    /** 
    *Deletes a contact by contactId
    *
    *@param contactId ID of the contact to delete 
    */

    public void deleteContact(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("contactId must not be null");
        }

        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("contactId not found");
        }

        contacts.remove(contactId);
    }

    //Updates the firstName of an existing contact by contactId
    public void updateFirstName(String contactId, String firstName) {
        getExisting(contactId).setFirstName(firstName);
    }

    //Updates the lastName of an existing contact by contactId
    public void updateLastName(String contactId, String lastName) {
        getExisting(contactId).setLastName(lastName);
    }

    //Updates the phone number of an existing contact by contactId
    public void updatePhone(String contactId, String phone) {
        getExisting(contactId).setPhone(phone);
    }

    //Updates the address of an existing contact by contactId
    public void updateAddress(String contactId, String address) {
        getExisting(contactId).setAddress(address);
    }

    //Helper method used to retrieve an existing contact
    private Contact getExisting(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("contactId must not be null");
        }

        Contact existing = contacts.get(contactId);
        if (existing == null) {
            throw new IllegalArgumentException("contactId not found");
        }

        return existing;
    }
}
