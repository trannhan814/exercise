package com.speedhome.poc.service.api;

import com.speedhome.poc.api.ProductApi;
import com.speedhome.poc.api.model.*;
import com.speedhome.poc.service.service.ProductService;
import com.speedhome.poc.service.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/speedhome/backend/v1")
@CrossOrigin
public class ProductController implements ProductApi {
    private final ProductService service ;
    private final ProductValidator validator;
    @Autowired
    public ProductController(ProductService service,ProductValidator validator){
        this.service = service;
        this.validator = validator;
    }
    @Override
    public ResponseEntity<Product> addProduct(@RequestBody ProductRequest request) {
        validator.validatorAddProduct(request);
        Product product = service.createProduct(request);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @Override
    public  ResponseEntity<Product> updateProduct( @PathVariable("id") String id,
                                               @RequestBody ProductRequest request) {
        validator.validateUpdateProduct(id,request);
        Product product = service.updateProduct(id,request);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Void> removeProduct(@PathVariable("id") String id){
        validator.validateremoveProduct(id);
        service.removeProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Products> getAllProduct(){
        return new ResponseEntity<>(service.getAllProduct(), HttpStatus.OK);
    }

}
