package com.speedhome.poc.service.validator;

import com.speedhome.poc.api.model.OwnerRequest;
import com.speedhome.poc.service.exception.BadRequestException;
import com.speedhome.poc.service.exception.EntityNotFoundException;
import com.speedhome.poc.service.repository.OnwerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OnwerValidator {
    private static final  String PROPERTY_DOES_NOT_EXIST = "Property does not exist";
    private static final  String NAME_REQUEST = "Property name is requested";
    private  final OnwerRepository onwerRepository;
    @Autowired
    public OnwerValidator(OnwerRepository onwerRepository){
        this.onwerRepository = onwerRepository ;
    }
    public void validatorAddOnwer(OwnerRequest  ownerRequest){
        checkRequiredField(ownerRequest.getFullName(),NAME_REQUEST);

    }
    private void  validatePropertyExist(String id){
        if (onwerRepository.existsById(id)){
            return;
        }
        throw new EntityNotFoundException(PROPERTY_DOES_NOT_EXIST);
    }
    private void checkRequiredField(String value, String errorMsg) {

        if (null == value || value.trim().isEmpty()) {
            throw new BadRequestException(errorMsg);
        }
    }
    public void validateUpdateOnwer(String idOwner,OwnerRequest ownerRequest){
        validatePropertyExist(idOwner);
        checkRequiredField(ownerRequest.getFullName(),NAME_REQUEST);
    }
    public void validateremoveOnwer(String idOwner){
        validatePropertyExist(idOwner);
    }
}
