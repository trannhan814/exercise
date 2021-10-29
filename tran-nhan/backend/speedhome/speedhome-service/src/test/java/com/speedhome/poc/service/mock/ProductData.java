package com.speedhome.poc.service.mock;

import com.speedhome.poc.api.model.Product;
import com.speedhome.poc.api.model.ProductRequest;
import com.speedhome.poc.api.model.ProductRequestPatch;
import com.speedhome.poc.api.model.Products;
import com.speedhome.poc.service.model.ProductEntity;

import java.util.Arrays;
import java.util.List;

public class ProductData {
    public static final String ID = "8c9ca010-3259-4b70-8570-d3e4c47ae718";
    public static final String TITLE = "ngày hôm nay";
    public static final String IMAGE = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg";
    public static final String TIME = "24/09/2021";
    public static final String CATEGORY = "Music";
    public static final String DESCRIPTION = "hôm nay nhiều mây trời trong sáng không mưa";
    public static final String CONTEXT = "ngày hôm nay nhiều nắng cực, viết văn bla bla";

    public static Object mockProduct(){
        Product product = new Product();

        product.setId(ID);
        product.setTitle(TITLE);
        product.setCategory(CATEGORY);
        product.setContext(CONTEXT);
        product.setDescription(DESCRIPTION);
        product.setImage(IMAGE);
        product.setTime(TIME);
        return product;
    }
    public  static Products mockProducts(){
        Products products = new Products();
        products.add((Product) mockProduct());
        return products;
    }
    public  static ProductRequest mockProductR(){
        ProductRequest productRequest = new ProductRequest();

        productRequest.setId(ID);
        productRequest.setTitle(TITLE);
        productRequest.setCategory(CATEGORY);
        productRequest.setContext(CONTEXT);
        productRequest.setDescription(DESCRIPTION);
        productRequest.setImage(IMAGE);
        productRequest.setTime(TIME);
        return productRequest;
    }
    public static ProductRequestPatch mockProductRq(){
        ProductRequestPatch productRequestPatch = new ProductRequestPatch();
        productRequestPatch.setId(ID);
        productRequestPatch.setTitle(TITLE);
        productRequestPatch.setCategory(CATEGORY);
        productRequestPatch.setContext(CONTEXT);
        productRequestPatch.setDescription(DESCRIPTION);
        productRequestPatch.setImage(IMAGE);
        productRequestPatch.setTime(TIME);
        return productRequestPatch;
    }
    public static ProductEntity mockProductEntity(){
        ProductEntity entity = new ProductEntity();
        entity.setId(ID);
        entity.setTitle(TITLE);
        entity.setCategory(CATEGORY);
        entity.setContext(CONTEXT);
        entity.setDescription(DESCRIPTION);
        entity.setImage(IMAGE);
        entity.setTime(TIME);
        return entity;
    }
    public static List<ProductEntity> mockProductEntitys(){
        return Arrays.asList(mockProductEntity());
    }

}
