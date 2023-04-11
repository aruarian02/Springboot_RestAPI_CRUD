package org.youtube.restapi.data.dto;

import lombok.*;
import org.youtube.restapi.data.entity.ProductEntity;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    String productId;
    String productName;
    Integer productPrice;
    Integer productStock;

    public ProductEntity dtoToEntity() {
        return ProductEntity.builder()
                .productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .productStock(productStock)
                .build();
    }
}
