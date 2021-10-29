package com.speedhome.poc.service.api;

import com.speedhome.poc.api.ContactApi;
import com.speedhome.poc.api.model.*;
import com.speedhome.poc.service.service.ContactService;
import com.speedhome.poc.service.validator.ContacValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/speedhome/backend/v1")
@CrossOrigin
public class ContactController implements ContactApi {
    private final ContactService service;
    private final ContacValidator validator;
    @Autowired
    public ContactController(ContactService service,ContacValidator validator){
        this.service = service;
        this.validator = validator;
    }
    @Override
    public ResponseEntity<Contact> addContact(@RequestBody ContactRequest request) {
        validator.validatorAddContact(request);
        Contact contact = service.createContact(request);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }
    @Override
    public  ResponseEntity<Contact> updateContact( @PathVariable("id") String id,
                                               @RequestBody ContactRequest request) {
        validator.validateUpdateContact(id,request);
        Contact contact = service.updateContact(id,request);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Void> removeContact(@PathVariable("id") String id){
        validator.validateremoveContact(id);
        service.removeContact(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Contacts> getAllContact(){
        return new ResponseEntity<>(service.getAllContact(), HttpStatus.OK);
    }
}
