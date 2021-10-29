package com.speedhome.poc.service.service;

import com.speedhome.poc.service.mapper.ProductMapper;
import com.speedhome.poc.service.mock.ProductData;
import com.speedhome.poc.service.repository.ProductRepository;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest extends TestCase {
    @InjectMocks
    ProductService productService;
    @Mock
    ProductMapper productMapper;
    @Mock
    ProductRepository productRepository;
    @Test
    public void createProduct(){
        productService.createProduct(ProductData.mockProductR());
    }
    @Test
    public void updateProduct(){
        productService.updateProduct(ProductData.ID,ProductData.mockProductR());
    }
    @Test
    public void removeProduc(){
        productService.removeProduct(ProductData.ID);
    }
    @Test
    public void getallProduct(){
        productService.getAllProduct();
    }

}
