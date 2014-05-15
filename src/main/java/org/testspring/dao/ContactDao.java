package org.testspring.dao;

import org.testspring.domain.Contact;

import java.util.List;

/**
 * Created by admin on 15.05.2014.
 */
public interface ContactDao {

    // Find all contacts
    public List<Contact> findAll();

    // Find all contacts with telephone and hobbies
    public List<Contact> findAllWithDetail();

    // Find a contact with details by id
    public Contact findById(Long id);

    // Insert or update a contact
    public Contact save(Contact contact);

    // Delete a contact
    public void delete(Contact contact);
}
