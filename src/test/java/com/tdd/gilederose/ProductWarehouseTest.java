package com.tdd.gilederose;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ProductWarehouseTest {

    @Test
    public void should_update_normal_product_info_with_downing_1_point_successfully(){
        Product product = new NormalProduct(1L,"normal product",10, 10);
        ProductWarehouse productWarehouse = new ProductWarehouse();
        productWarehouse.addProduct(product);

        List<Product> productList = productWarehouse.getProductList();
        int stockId = productWarehouse.getStockId(product.getId());
        productWarehouse.updateStockInfo(stockId);

        assertThat(productList.get(stockId).getSellIn(), is(9));
        assertThat(productList.get(stockId).getQuality(), is(9));
    }
}