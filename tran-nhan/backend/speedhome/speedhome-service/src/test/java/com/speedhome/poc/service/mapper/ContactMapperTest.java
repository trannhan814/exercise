package com.speedhome.poc.service.mapper;

import com.speedhome.poc.api.model.*;
import com.speedhome.poc.service.mock.ContactData;
import com.speedhome.poc.service.mock.ProductData;
import com.speedhome.poc.service.model.ContactEntity;
import com.speedhome.poc.service.model.ProductEntity;
import com.speedhome.poc.service.repository.ContactRepository;
import com.speedhome.poc.service.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContactMapperTest {
    @InjectMocks
    ContactMapper mapper;
    @Mock
    ContactRepository repository ;
    @Test
    public void ensureMapContactEntityFromContactReqForAdd() {

        ContactRequest contactRequest = ContactData.mockContactR();

        ContactEntity entity = mapper.mapContactEnityFromContactReq(contactRequest);

        assertThat(entity.getId() != null, is(true));
        assertThat(entity.getEmail(), is(contactRequest.getEmail()));
        assertThat(entity.getMessage(), is(contactRequest.getMessage()));
        assertThat(entity.getName(), is(contactRequest.getName()));
    }
    @Test
    public void ensureMapContactEntityFromContactReqForUpdate() {
        ContactEntity contact = ContactData.mockContactEntity();

        when(repository.getOne(ContactData.ID)).thenReturn(contact);

        ContactRequest contactRequest = ContactData.mockContactR();

        ContactEntity entity = mapper.mapContactEnityFromContactReq(ContactData.ID, contactRequest);
        assertThat(entity.getId() != null, is(true));
//        assertThat(entity.getId(), is(contactRequest.getId()));
        assertThat(entity.getEmail(), is(contactRequest.getEmail()));
        assertThat(entity.getMessage(), is(contactRequest.getMessage()));
        assertThat(entity.getName(), is(contactRequest.getName()));

    }
    @Test
    public void ensureMapContactFromContactEntity() {
        ContactEntity contactEntity = ContactData.mockContactEntity();

        Contact contact = mapper.mapContactFromContactEnity(contactEntity);

        assertContact(contact, contactEntity);
    }

    @Test
    public void ensureMapContactsFromContactEntities() {
        List<ContactEntity> contactEntities = ContactData.mockPContactEntitys();

        Contacts contacts = mapper.mapContactsFromContactEntity(contactEntities);

        assertContacts(contacts, contactEntities);
    }
    private void assertContact(Contact contact, ContactEntity contactEntity) {
        assertThat(contact.getId(), is(contactEntity.getId()));
        assertThat(contact.getId(), is(contactEntity.getId()));
        assertThat(contact.getEmail(), is(contactEntity.getEmail()));
        assertThat(contact.getMessage(), is(contactEntity.getMessage()));
        assertThat(contact.getName(), is(contactEntity.getName()));
    }
    private void assertContacts(Contacts contacts, List<ContactEntity> entities) {
        assertContact(contacts.get(0), entities.get(0));
    }
}
