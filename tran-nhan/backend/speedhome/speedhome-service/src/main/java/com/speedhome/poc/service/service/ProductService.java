package com.speedhome.poc.service.service;

import com.speedhome.poc.api.model.*;
import com.speedhome.poc.service.mapper.OnwerMapper;
import com.speedhome.poc.service.mapper.ProductMapper;
import com.speedhome.poc.service.model.OnwerEntity;
import com.speedhome.poc.service.model.ProductEntity;
import com.speedhome.poc.service.repository.OnwerRepository;
import com.speedhome.poc.service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductMapper mapper ;
    private final ProductRepository repository ;
    @Autowired
    public ProductService(ProductMapper mapper , ProductRepository repository){
        this.mapper = mapper ;
        this.repository = repository;
    }
    public Product createProduct(ProductRequest request) {
        ProductEntity entity = mapper.mapProductEnityFromProductReq(request);
        return  mapper.mapProductFromProductEnity(repository.save(entity));
    }
    public Product updateProduct(String id, ProductRequest request) {
        ProductEntity entity = mapper.mapProductEnityFromProductReq(id,request);
        return mapper.mapProductFromProductEnity(repository.save(entity));
    }
    public void removeProduct(String id) {
        repository.deleteById(id);
    }
    public Products getAllProduct() {
        List<ProductEntity> enityList = repository.findAll();
        return mapper.mapProductsFromProductEntity(enityList);
    }
}
