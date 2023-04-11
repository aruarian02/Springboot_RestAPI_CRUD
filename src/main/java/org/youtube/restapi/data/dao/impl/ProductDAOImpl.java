package org.youtube.restapi.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.youtube.restapi.data.dao.ProductDAO;
import org.youtube.restapi.data.entity.ProductEntity;
import org.youtube.restapi.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        productRepository.save(productEntity);
        return productEntity;
    }

    @Override
    public ProductEntity getProduct(String productId) {
        Optional<ProductEntity> optEntity = productRepository.findById(productId);
        return optEntity.orElse(null);
    }

    @Override
    public String updateProudct(ProductEntity productEntity) {
        Optional<ProductEntity> optEntity = productRepository.findById(productEntity.getProductId());

        return optEntity.map(entity -> {
            entity.setProductName(productEntity.getProductName());
            entity.setProductPrice(productEntity.getProductPrice());
            entity.setProductStock(productEntity.getProductStock());

            productRepository.save(entity);

            return entity.toString();
        }).orElse(productEntity.getProductId() + "에 존재하는 product가 없습니다.");
    }

    @Override
    public boolean deleteProduct(String productId) {
        Optional<ProductEntity> optEntity = productRepository.findById(productId);

        if (optEntity.isPresent()) {
            productRepository.deleteById(productId);
            return true;
        }

        return false;
    }
}
