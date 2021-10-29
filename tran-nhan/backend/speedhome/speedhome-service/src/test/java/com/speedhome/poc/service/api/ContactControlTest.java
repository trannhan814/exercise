package com.speedhome.poc.service.api;

import com.speedhome.poc.api.model.*;
import com.speedhome.poc.service.mock.ContactData;
import com.speedhome.poc.service.mock.ProductData;
import com.speedhome.poc.service.service.ContactService;
import com.speedhome.poc.service.validator.ContacValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContactControlTest {
    @InjectMocks
    ContactController controller ;
    @Mock
    ContactService service ;
    @Mock
    ContacValidator validator ;
    @Test
    public  void  testEndpointCreateContacts(){
        when(service.createContact(any(ContactRequest.class)))
                .thenReturn((Contact) ContactData.mockContact());

        ResponseEntity<Contact> responseEntity =
                controller.addContact(ContactData.mockContactR());

        assertStatus200(responseEntity.getStatusCode());
        assertContact(responseEntity.getBody());
    }
    @Test
    public void testEndpointUpdateContact() {
        when(service.updateContact(anyString(), any(ContactRequest.class)))
                .thenReturn((Contact) ContactData.mockContact());

        ResponseEntity<Contact> responseEntity =
                controller.updateContact(ContactData.ID, ContactData.mockContactR());

        assertStatus200(responseEntity.getStatusCode());
        assertContact(responseEntity.getBody());
    }
    @Test
    public void testEndpointgetContacts() {
        when(service.getAllContact())
                .thenReturn(ContactData.mockContacts());

        ResponseEntity<Contacts> responseEntity =
                controller.getAllContact( );
        assertStatus200(responseEntity.getStatusCode());
        assertContacs(responseEntity.getBody());
    }


    private void assertContact(Contact actual) {
        assertThat(actual.getId(), is(ContactData.ID));
        assertThat(actual.getEmail(), is(ContactData.EMAIL));
        assertThat(actual.getName(), is(ContactData.NAME));
        assertThat(actual.getMessage(), is(ContactData.MESSAGE));
    }

    private void assertContacs(Contacts actual) {
        assertContact(actual.get(0));
    }

    private void assertStatus200(HttpStatus actual) {
        assertThat(actual, is(HttpStatus.OK));
    }
}
