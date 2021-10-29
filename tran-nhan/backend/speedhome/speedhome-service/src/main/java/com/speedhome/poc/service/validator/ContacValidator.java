package com.speedhome.poc.service.validator;

import com.speedhome.poc.api.model.ContactRequest;
import com.speedhome.poc.api.model.OwnerRequest;
import com.speedhome.poc.service.exception.BadRequestException;
import com.speedhome.poc.service.exception.EntityNotFoundException;
import com.speedhome.poc.service.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContacValidator {
    private static final  String CONTACT_DOES_NOT_EXIST = "Contact does not exist";
    private static final  String NAME_REQUEST = "Contact name is requested";
    private final ContactRepository repository;
    @Autowired
    public ContacValidator(ContactRepository repository){
        this.repository = repository;
    }
    public void validatorAddContact(ContactRequest request){
        checkRequiredField(request.getName(),NAME_REQUEST);

    }
    private void  validatePropertyExist(String id){
        if (repository.existsById(id)){
            return;
        }
        throw new EntityNotFoundException(CONTACT_DOES_NOT_EXIST);
    }
    private void checkRequiredField(String value, String errorMsg) {

        if (null == value || value.trim().isEmpty()) {
            throw new BadRequestException(errorMsg);
        }
    }
    public void validateUpdateContact(String id,ContactRequest request){
        validatePropertyExist(id);
        checkRequiredField(request.getName(),NAME_REQUEST);
    }
    public void validateremoveContact(String id){
        validatePropertyExist(id);
    }
}
