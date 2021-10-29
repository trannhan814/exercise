package com.speedhome.poc.service.mapper;

import com.speedhome.poc.api.model.*;
import com.speedhome.poc.service.model.ContactEntity;
import com.speedhome.poc.service.model.OnwerEntity;
import com.speedhome.poc.service.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ContactMapper {
    private final ContactRepository repository;
    @Autowired
    public ContactMapper(ContactRepository repository ){
        this.repository = repository;
    }
    public ContactEntity mapContactEnityFromContactReq(ContactRequest from) {
        ContactEntity to = new ContactEntity();
        to.setId(UUID.randomUUID().toString());
        to.setName(from.getName());
        to.setEmail(from.getEmail());
        to.setMessage(from.getMessage());
        return to;
    }
    public ContactEntity mapContactEnityFromContactReq(String id ,ContactRequest from ){
        ContactEntity to = repository.getOne(id);
        to.setId(UUID.randomUUID().toString());
        to.setName(from.getName());
        to.setEmail(from.getEmail());
        to.setMessage(from.getMessage());
        return to;
    }
    public Contact mapContactFromContactEnity(ContactEntity from) {
        Contact to = new Contact();
        to.setId(from.getId());
        to.setName(from.getName());
        to.setEmail(from.getEmail());
        to.setMessage(from.getMessage());
        return to;
    }

    public Contacts mapContactsFromContactEntity(List<ContactEntity> enityList) {
        Contacts contacts = new Contacts();
        for ( ContactEntity entity : enityList) {
            contacts.add(mapContactFromContactEnity(entity));
        }
        return contacts;

    }
}
