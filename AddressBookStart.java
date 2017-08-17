package com.hotmail.a_asultan.Inlamningsuppgift1;

import com.hotmail.a_asultan.LogginProject.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class AddressBookStart {


    private static final Logger log = Logger.getLogger(Service.class.getName());


    public static void runAddressBook() throws IOException, ClassNotFoundException {
        AddressBook addressbook = new AddressBook();
        AddressBookManager addressBookManager = new AddressBookManager();
        InputCommando inputCommando = new InputCommando();
        FileInOut fileInOut = new FileInOut();
        Scanner sc = new Scanner(System.in);
        log.info("Address Book Program Started");

        addressbook.personList = fileInOut.loadFromFile();
        if (addressbook.personList == null) {
            addressbook.personList = new ArrayList<>();
        }

        addressBookManager.autoSaveData(addressbook.getPersonList());

        System.out.println("******( Welcome to the Address Book ! ) ******");


        while (true) {
            String[] inputData = sc.nextLine().trim().split("\\s+");
                    String commando = inputCommando.testCommando(inputData);
            switch (commando) {

                case "add":
                    addressbook.addContact(inputData[1], inputData[2], inputData[3]);
                    break;

                case "list":
                    addressbook.ListContatctsInfo();
                    break;

                case "search":
                    addressbook.search(addressbook.personList, inputData[1]);
                    break;

                case "help":
                    addressbook.printHelp();
                    break;

                case "delete":
                    addressbook.deleteContact(addressbook.personList, inputData[1]);
                    break;

                case "quit":
                    addressBookManager.exitProgram(addressbook.getPersonList());
                    break;

                default: {
                    log.fine("Incorrect commando " + commando);
                    System.out.printf("Incorrect commando '%s' \n", commando);
                }
            }
        }
    }
}
