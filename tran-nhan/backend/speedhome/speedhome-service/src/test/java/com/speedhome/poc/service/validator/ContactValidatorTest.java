package com.speedhome.poc.service.validator;

import com.speedhome.poc.api.model.ContactRequest;
import com.speedhome.poc.api.model.ProductRequest;
import com.speedhome.poc.service.exception.BadRequestException;
import com.speedhome.poc.service.exception.EntityNotFoundException;
import com.speedhome.poc.service.mock.ContactData;
import com.speedhome.poc.service.mock.ProductData;
import com.speedhome.poc.service.repository.ContactRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContactValidatorTest {
    @InjectMocks
    ContacValidator validator ;
    @Mock
    ContactRepository repository;
    @Rule
    public ExpectedException exception = ExpectedException.none();
    @Test
    public void validateUpdateContact(){
        when(repository.existsById(ContactData.ID)).thenReturn(true);
        validator.validateUpdateContact(ContactData.ID, ContactData.mockContactR());
    }
    @Test
    public void validateUpdateContactShowExceptionWhenWrongId() {
        exception.expect(EntityNotFoundException.class);
        exception.expectMessage("Contact does not exist");
        when(repository.existsById(ContactData.ID)).thenReturn(false);
        validator.validateUpdateContact(ContactData.ID, ContactData.mockContactR());
    }
    @Test
    public void validateAddContact() {
        validator.validatorAddContact(ContactData.mockContactR());
    }
    @Test
    public void validateAddContactShowExceptionWhenRequiredFieldIsNull() {
        exception.expect(BadRequestException.class);
        exception.expectMessage("Contact name is requested");

        ContactRequest contactRequest = ContactData.mockContactR();
        contactRequest.setName("");

        validator.validatorAddContact(contactRequest);
    }
}
