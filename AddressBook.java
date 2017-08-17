package com.hotmail.a_asultan.Inlamningsuppgift1;


import java.security.Provider;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;



public class AddressBook {
    private static final Logger log = Logger.getLogger(Provider.Service.class.getName());
    ArrayList<Person> personList = new ArrayList<>();
    AddressBookManager addressBookManager = new AddressBookManager();

     ArrayList<Person> getPersonList() {
        return personList;
    }


    public void addContact(String firstName, String lastName, String email) {
        personList.add(new Person(UUID.randomUUID(), firstName, lastName, email));
        System.out.println("a new contact added to Address Book");
        log.fine("add commando and a new person info is added to the Address Book");
    }


    public void search(ArrayList<Person> list, String searchWord) {
        log.fine("search commando and search for contact");
        ArrayList<Person> searchResult = new ArrayList<>();
        boolean found = false;
        addressBookManager.sortAddressBook(getPersonList());
        for (int i = 0; i < list.size(); i++) {
            try {
                if (searchWord.equalsIgnoreCase(list.get(i).getFirstName().substring(0, searchWord.length())) ||
                        searchWord.equalsIgnoreCase(list.get(i).getLastName().substring(0, searchWord.length()))) {
                    searchResult.add(list.get(i));
                    found = true;
                    log.fine("contact found after search for " + searchWord);
                }
            } catch (StringIndexOutOfBoundsException e) {
                log.log(Level.SEVERE, "Something wrong occurred", e);
            }
        }
        if (found) {
            addressBookManager.showPersonList(searchResult);
        } else {
            System.out.printf("No Contact Found have (%s) in first name \n", searchWord);
            log.fine("contact not found after search for " + searchWord);
        }
    }


    public void deleteContact(ArrayList<Person> list, String userId) {
        log.fine("delete commando!");
        boolean found = false;
        for (int i = 0; i < list.size(); i++) {
            if (userId.equalsIgnoreCase(String.valueOf(list.get(i).getId()))) {
                list.remove(i);
                found = true;
                log.fine("delete commando and a contact is deleted");
            }
        }
        System.out.println(found ? "The Contact Deleted !" : "The Contact is Not Found!!");
    }



    public void ListContatctsInfo() {
        addressBookManager.sortAddressBook(getPersonList());
        addressBookManager.showPersonList(getPersonList());
        log.fine("list commando and show list for contacts info");
    }



    public void printHelp() {
        log.fine("help commando and show help list");
        System.out.println(
                "(add)     To add a new contact \n" +
                        "(delete)  To delete a contact\n" +
                        "(list)    TO show list for all contacts\n" +
                        "(search)  To search  a contact\n");
    }
}
