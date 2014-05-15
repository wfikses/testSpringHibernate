package org.testspring;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.testspring.dao.ContactDao;
import org.testspring.domain.Contact;
import org.testspring.domain.ContactTelDetail;
import org.testspring.domain.Hobby;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-config.xml");
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);

        List<Contact> contactList = contactDao.findAll();
        listContacts(contactList);

        contactList = contactDao.findAllWithDetail();
        listContactsWithDetail(contactList);

        Contact contact;

        contact = contactDao.findById(1L);
        System.out.println("");
        System.out.println("Contact with id 1:" + contact);
        System.out.println("");



    }

    private static void listContacts(List<Contact> contacts) {
        System.out.println("");
        System.out.println("Listing contacts without details:");
        for (Contact contact: contacts) {
            System.out.println(contact);
            System.out.println();
        }
    }

    private static void listContactsWithDetail(List<Contact> contacts) {
        System.out.println("");
        System.out.println("Listing contacts with details:");
        for(Contact contact : contacts) {
            System.out.println(contact);
            System.out.println();
            if (contact.getContactTelDetails() != null) {
                for(ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
                    System.out.println(contactTelDetail);
                }
            }

            if (contact.getHobbies() != null) {
                for (Hobby hobby: contact.getHobbies()) {
                    System.out.println(hobby);
                }
            }
            System.out.println();

        }
    }
}
