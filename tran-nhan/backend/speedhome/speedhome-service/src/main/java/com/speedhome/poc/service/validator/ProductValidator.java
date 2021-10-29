package com.speedhome.poc.service.validator;

import com.speedhome.poc.api.model.ProductRequest;
import com.speedhome.poc.service.exception.EntityNotFoundException;
import com.speedhome.poc.service.exception.BadRequestException;
import com.speedhome.poc.service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductValidator {
    private static final  String PRODUCT_DOES_NOT_EXIST = "Product does not exist";
    private static final  String NAME_REQUEST = "Product name is requested";
    private  final ProductRepository repository;
    @Autowired
    public ProductValidator(ProductRepository repository){
        this.repository = repository;
    }
    public void validatorAddProduct(ProductRequest productRequest){
        checkRequiredField(productRequest.getTitle(),NAME_REQUEST);

    }
    private void  validatePropertyExist(String id){
        if (repository.existsById(id)){
            return;
        }
        throw new EntityNotFoundException(PRODUCT_DOES_NOT_EXIST);
    }
    private void checkRequiredField(String value, String errorMsg) {

        if (null == value || value.trim().isEmpty()) {
            throw new BadRequestException(errorMsg);
        }
    }
    public void validateUpdateProduct(String id,ProductRequest productRequest){
        validatePropertyExist(id);
        checkRequiredField(productRequest.getTitle(),NAME_REQUEST);
    }
    public void validateremoveProduct(String id){
        validatePropertyExist(id);
    }

}
