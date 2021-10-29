package com.speedhome.poc.service.mock;

import com.speedhome.poc.api.model.*;
import com.speedhome.poc.service.model.ContactEntity;
import com.speedhome.poc.service.model.ProductEntity;

import java.util.Arrays;
import java.util.List;

public class ContactData {
    public static final String ID = "f217e291-eafc-49f9-a079-0c15c3a99bc7";
    public static final String NAME = "Vi vanw ninh ";
    public static final String EMAIL = "donkey.n1160@gmail.com";
    public static final String MESSAGE = "thoong tin ca nhan  cua toi";

    public static Object mockContact(){
        Contact contact = new Contact();

        contact.setId(ID);
        contact.setName(NAME);
        contact.setEmail(EMAIL);
        contact.setMessage(MESSAGE);
        return contact;
    }
    public  static Contacts mockContacts(){
        Contacts contacts = new Contacts();
        contacts.add((Contact) mockContact());
        return contacts;
    }
    public  static ContactRequest mockContactR(){
        ContactRequest contactRequest = new ContactRequest();

        contactRequest.setId(ID);
        contactRequest.setName(NAME);
        contactRequest.setEmail(EMAIL);
        contactRequest.setMessage(MESSAGE);
        return contactRequest;
    }
    public static ContactRequestPatch mockContactRq(){
        ContactRequestPatch contactRequestPatch = new ContactRequestPatch();
        contactRequestPatch.setId(ID);
        contactRequestPatch.setName(NAME);
        contactRequestPatch.setEmail(EMAIL);
        contactRequestPatch.setMessage(MESSAGE);
        return contactRequestPatch;
    }
    public static ContactEntity mockContactEntity(){
        ContactEntity entity = new ContactEntity();
        entity.setId(ID);
        entity.setName(NAME);
        entity.setEmail(EMAIL);
        entity.setMessage(MESSAGE);
        return entity;
    }
    public static List<ContactEntity> mockPContactEntitys(){
        return Arrays.asList(mockContactEntity());
    }
}
