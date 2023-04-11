package org.youtube.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.youtube.restapi.data.dao.ProductDAO;
import org.youtube.restapi.data.dto.ProductDto;
import org.youtube.restapi.data.entity.ProductEntity;

@RestController
@RequestMapping(value = "/api/v1/product-api/product")
public class ProductController {

    ProductDAO productDAO;

    @Autowired
    public ProductController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @GetMapping("/{productId}")
    public String getProduct(@PathVariable String productId) {
        ProductEntity productEntity = productDAO.getProduct(productId);
        if (productEntity == null) {
            return productId + " 에 해당하는 product가 없습니다.";
        }
        return productEntity.toString();
    }

    @PostMapping
    public String postProduct(@RequestBody ProductDto productDto) {
        ProductEntity entity = productDto.dtoToEntity();
        return productDAO.saveProduct(entity).toString();
    }

    @PutMapping("/update")
    public String updateProduct(@RequestBody ProductDto productDto) {
        ProductEntity entity = productDto.dtoToEntity();
        return productDAO.updateProudct(entity);
    }

    @DeleteMapping("/{productId}")
    public boolean deleteProduct(@PathVariable String productId) {
        return productDAO.deleteProduct(productId);
    }
}
