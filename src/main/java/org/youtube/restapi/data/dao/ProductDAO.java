package org.youtube.restapi.data.dao;

import org.youtube.restapi.data.entity.ProductEntity;

public interface ProductDAO {
    ProductEntity saveProduct(ProductEntity productEntity);
    ProductEntity getProduct(String productId);

    String updateProudct(ProductEntity productEntity);

    boolean deleteProduct(String productId);
}
