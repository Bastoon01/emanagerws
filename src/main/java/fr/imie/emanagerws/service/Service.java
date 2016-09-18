package fr.imie.emanagerws.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.imie.emanagerws.entity.Contact;


public class Service {
	
	/**
	 * Collection of contacts
	 */
	private final static List<Contact> contacts = new ArrayList<Contact>();
    
	/**
	 * The default constructor 
	 * 
	 * This adds some data for testing purpose
	 */
    public Service (){
    	// Add some testing data
    	if ( contacts.size() == 0){
    		contacts.add( new Contact (1L, "Nantes, France", "03838386"));
        	contacts.add( new Contact (2L, "Rennes, France", "03838385"));
        	contacts.add( new Contact (3L, "Paris, France", "03838384"));
        	contacts.add( new Contact (4L, "Mans, France", "03838383"));
    	}
    }

    /**
     * Gets the list of contacts
     * @return
     */
	public List<Contact> getContacts() {
		return contacts;
	}
    
	/**
	 * Gets contact by id
	 * 
	 * Note : Makes use of Java8 streams
	 * 
	 * @param id : the id of the contact to get
	 * @return {@link Contact}}
	 */
    public Contact findContactById ( final long id ){
    	Optional<Contact> contact = contacts.stream().filter(cont -> { return cont.getId() == id ;}).findFirst();
    	return contact.isPresent() ? contact.get() : null;
    }
}
