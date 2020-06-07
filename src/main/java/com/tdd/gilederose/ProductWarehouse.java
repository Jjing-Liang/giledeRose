package com.tdd.gilederose;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ProductWarehouse {

    private List<Product> productList;

    public ProductWarehouse() {
        this.productList = new ArrayList<>();
    }

    public ProductWarehouse(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public int getStockId(Long productId) {
        return IntStream.range(0, productList.size())
                .filter(i -> productId.equals(productList.get(i).getId()))
                .findFirst()
                .orElse(-1);
    }

    public void updateStockInfo(int stockId) {
        Product updateProduct = productList.get(stockId);
        if (updateProduct.getQuality() < 0 || updateProduct.getQuality() > 50) {
            return;
        }

        updateProduct.setQuality(updateProduct.getQuality() + updateProduct.getQualityUpdateRuleBySellIn(updateProduct.getSellIn()));
        updateProduct.setSellIn(updateProduct.getSellIn() - 1);
    }
}
