package com.speedhome.poc.service.validator;

import com.speedhome.poc.api.model.ProductRequest;
import com.speedhome.poc.api.model.PropertyReq;
import com.speedhome.poc.service.exception.BadRequestException;
import com.speedhome.poc.service.exception.EntityNotFoundException;
import com.speedhome.poc.service.mock.ProductData;
import com.speedhome.poc.service.mock.PropertyData;
import com.speedhome.poc.service.repository.ProductRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductValidatorTest {
    @InjectMocks
    ProductValidator validator;
    @Mock
    ProductRepository repository;
    @Rule
    public ExpectedException exception = ExpectedException.none();
    @Test
    public void validateUpdateProduct(){
        when(repository.existsById(ProductData.ID)).thenReturn(true);
        validator.validateUpdateProduct(ProductData.ID, ProductData.mockProductR());
    }
    @Test
    public void validateUpdateProductShowExceptionWhenWrongId() {
        exception.expect(EntityNotFoundException.class);
        exception.expectMessage("Product does not exist");
        when(repository.existsById(ProductData.ID)).thenReturn(false);
        validator.validateUpdateProduct(ProductData.ID, ProductData.mockProductR());
    }
    @Test
    public void validateAddProduct() {
        validator.validatorAddProduct(ProductData.mockProductR());
    }
    @Test
    public void validateAddProductShowExceptionWhenRequiredFieldIsNull() {
        exception.expect(BadRequestException.class);
        exception.expectMessage("Product name is requested");

        ProductRequest productRequest = ProductData.mockProductR();
        productRequest.setTitle("");

        validator.validatorAddProduct(productRequest);
    }

}
