package com.speedhome.poc.service.service;

import com.speedhome.poc.api.model.*;
import com.speedhome.poc.service.mapper.ContactMapper;
import com.speedhome.poc.service.model.ContactEntity;
import com.speedhome.poc.service.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    private  final ContactMapper mapper;
    private  final ContactRepository repository ;
    @Autowired
    public ContactService(ContactMapper mapper,ContactRepository repository){
        this.mapper = mapper;
        this.repository = repository;
    }
    public Contact createContact(ContactRequest request) {
        ContactEntity entity = mapper.mapContactEnityFromContactReq(request);
        return  mapper.mapContactFromContactEnity(repository.save(entity));
    }
    public Contact updateContact(String id, ContactRequest request) {
        ContactEntity entity = mapper.mapContactEnityFromContactReq(id,request);
        return mapper.mapContactFromContactEnity(repository.save(entity));
    }

    public void removeContact(String id) {
        repository.deleteById(id);
    }
    public Contacts getAllContact() {
        List<ContactEntity> enityList = repository.findAll();
        return mapper.mapContactsFromContactEntity(enityList);
    }

}
