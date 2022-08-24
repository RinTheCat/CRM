package ru.otus.project.dto;

import ru.otus.project.domain.ProductQuantity;

public class ProductQuantityDto {
    private long productId;
    private String name;
    private int quantity;

    public ProductQuantityDto(long productId, String name, int quantity) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static ProductQuantityDto toDto(ProductQuantity productQuantity) {
        return new ProductQuantityDto(productQuantity.getProduct().getId(), productQuantity.getProduct().getName(), productQuantity.getQuantity());
    }

}
