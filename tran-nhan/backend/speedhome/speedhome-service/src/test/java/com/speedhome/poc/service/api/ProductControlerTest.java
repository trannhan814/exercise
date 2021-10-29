package com.speedhome.poc.service.api;

import com.speedhome.poc.api.model.*;
import com.speedhome.poc.service.mock.ProductData;
import com.speedhome.poc.service.mock.PropertyData;
import com.speedhome.poc.service.service.ProductService;
import com.speedhome.poc.service.validator.ProductValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
@RunWith(MockitoJUnitRunner.class)
public class ProductControlerTest {
    @InjectMocks
    ProductController controller ;
    @Mock
    ProductService service ;
    @Mock
    ProductValidator validator ;
    @Test
    public  void  testEndpointCreateProducts(){
        when(service.createProduct(any(ProductRequest.class)))
                .thenReturn((Product) ProductData.mockProduct());

        ResponseEntity<Product> responseEntity =
                controller.addProduct(ProductData.mockProductR());

        assertStatus200(responseEntity.getStatusCode());
        assertProduct(responseEntity.getBody());
    }
    @Test
    public void testEndpointUpdateProduct() {
        when(service.updateProduct(anyString(), any(ProductRequest.class)))
                .thenReturn((Product) ProductData.mockProduct());

        ResponseEntity<Product> responseEntity =
                controller.updateProduct(ProductData.ID, ProductData.mockProductR());

        assertStatus200(responseEntity.getStatusCode());
        assertProduct(responseEntity.getBody());
    }
    @Test
    public void testEndpointgetProducts() {
        when(service.getAllProduct())
                .thenReturn(ProductData.mockProducts());

        ResponseEntity<Products> responseEntity =
                controller.getAllProduct( );
        assertStatus200(responseEntity.getStatusCode());
        assertProducts(responseEntity.getBody());
    }


    private void assertProduct(Product actual) {
        assertThat(actual.getId(), is(ProductData.ID));
        assertThat(actual.getTitle(), is(ProductData.TITLE));
        assertThat(actual.getDescription(), is(ProductData.DESCRIPTION));
        assertThat(actual.getTime(), is(ProductData.TIME));
        assertThat(actual.getContext(), is(ProductData.CONTEXT));
        assertThat(actual.getImage(), is(ProductData.IMAGE));
    }

    private void assertProducts(Products actual) {
        assertProduct(actual.get(0));
    }

    private void assertStatus200(HttpStatus actual) {
        assertThat(actual, is(HttpStatus.OK));
    }

}
