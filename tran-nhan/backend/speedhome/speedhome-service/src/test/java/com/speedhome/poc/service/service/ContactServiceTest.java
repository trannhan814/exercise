package com.speedhome.poc.service.service;

import com.speedhome.poc.service.mapper.ContactMapper;
import com.speedhome.poc.service.mock.ContactData;
import com.speedhome.poc.service.mock.ProductData;
import com.speedhome.poc.service.repository.ContactRepository;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ContactServiceTest extends TestCase {
    @InjectMocks
    ContactService contactService;
    @Mock
    ContactMapper contactMapper;
    @Mock
    ContactRepository contactRepository;
    @Test
    public void createContact(){
        contactService.createContact(ContactData.mockContactR());
    }
    @Test
    public void updateContact(){
        contactService.updateContact(ContactData.ID,ContactData.mockContactR());
    }
    @Test
    public void removeContact(){
        contactService.removeContact(ContactData.ID);
    }
    @Test
    public void getallContact(){
        contactService.getAllContact();
    }
}
