package com.speedhome.poc.service.mapper;

import com.speedhome.poc.api.model.*;
import com.speedhome.poc.service.model.ProductEntity;
import com.speedhome.poc.service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ProductMapper {
    private final ProductRepository repository;
    @Autowired
    public ProductMapper(ProductRepository repository){
        this.repository = repository ;
    }
    public ProductEntity mapProductEnityFromProductReq(ProductRequest from) {
        ProductEntity to = new ProductEntity();
        to.setId(UUID.randomUUID().toString());
        to.setImage(from.getImage());
        to.setCategory(from.getCategory());
        to.setContext(from.getContext());
        to.setDescription(from.getDescription());
        to.setTime(from.getTime());
        to.setTitle(from.getTitle());
        return to;
    }

    public ProductEntity mapProductEnityFromProductReq(String id ,ProductRequest from ){
        ProductEntity to = repository.getOne(id);
        to.setId(UUID.randomUUID().toString());
        to.setImage(from.getImage());
        to.setCategory(from.getCategory());
        to.setContext(from.getContext());
        to.setDescription(from.getDescription());
        to.setTime(from.getTime());
        to.setTitle(from.getTitle());
        return to;
    }
    public Product mapProductFromProductEnity(ProductEntity from) {
        Product to = new Product();
        to.setId(UUID.randomUUID().toString());
        to.setImage(from.getImage());
        to.setCategory(from.getCategory());
        to.setContext(from.getContext());
        to.setDescription(from.getDescription());
        to.setTime(from.getTime());
        to.setTitle(from.getTitle());
        return to;
    }

    public Products mapProductsFromProductEntity(List<ProductEntity> enityList) {
        Products products = new Products();
        for ( ProductEntity entity : enityList) {
            products.add(mapProductFromProductEnity(entity));
        }
        return products;

    }
}
