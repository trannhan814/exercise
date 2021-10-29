package com.speedhome.poc.service.mapper;

import com.speedhome.poc.api.model.*;
import com.speedhome.poc.service.mock.ProductData;
import com.speedhome.poc.service.model.ProductEntity;
import com.speedhome.poc.service.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductMapperTest {
    @InjectMocks
    ProductMapper mapper;
    @Mock
    ProductRepository repository ;
    @Test
    public void ensureMapProductEntityFromProductReqForAdd() {

        ProductRequest productRequest = ProductData.mockProductR();

        ProductEntity entity = mapper.mapProductEnityFromProductReq(productRequest);

        assertThat(entity.getId() != null, is(true));
//        assertThat(entity.getId(), is(productRequest.getId()));
        assertThat(entity.getCategory(), is(productRequest.getCategory()));
        assertThat(entity.getContext(), is(productRequest.getContext()));
        assertThat(entity.getDescription(), is(productRequest.getDescription()));
        assertThat(entity.getImage(), is(productRequest.getImage()));
        assertThat(entity.getTime(), is(productRequest.getTime()));
        assertThat(entity.getTitle(), is(productRequest.getTitle()));
    }
    @Test
    public void ensureMapProductEntityFromProductReqForUpdate() {
        ProductEntity product = ProductData.mockProductEntity();

        when(repository.getOne(ProductData.ID)).thenReturn(product);

        ProductRequest productRequest = ProductData.mockProductR();

        ProductEntity entity = mapper.mapProductEnityFromProductReq(ProductData.ID, productRequest);

//        assertThat(entity.getId(), is(productRequest.getId()));
        assertThat(entity.getCategory(), is(productRequest.getCategory()));
        assertThat(entity.getContext(), is(productRequest.getContext()));
        assertThat(entity.getDescription(), is(productRequest.getDescription()));
        assertThat(entity.getImage(), is(productRequest.getImage()));
        assertThat(entity.getTime(), is(productRequest.getTime()));
        assertThat(entity.getTitle(), is(productRequest.getTitle()));

    }
    @Test
    public void ensureMapProductFromProductEntity() {
        ProductEntity productEntity = ProductData.mockProductEntity();

        Product product = mapper.mapProductFromProductEnity(productEntity);

        assertProduct(product, productEntity);
    }

    @Test
    public void ensureMapProductsFromProductEntities() {
        List<ProductEntity> productEntities = ProductData.mockProductEntitys();

        Products products = mapper.mapProductsFromProductEntity(productEntities);

        assertProducts(products, productEntities);
    }
    private void assertProduct(Product product, ProductEntity productEntity) {
//        assertThat(product.getId(), is(productEntity.getId()));
        assertThat(product.getCategory(), is(productEntity.getCategory()));
        assertThat(product.getContext(), is(productEntity.getContext()));
        assertThat(product.getDescription(), is(productEntity.getDescription()));
        assertThat(product.getImage(), is(productEntity.getImage()));
        assertThat(product.getTime(), is(productEntity.getTime()));
        assertThat(product.getTitle(), is(productEntity.getTitle()));
    }
    private void assertProducts(Products products, List<ProductEntity> entities) {
        assertProduct(products.get(0), entities.get(0));
    }
}
