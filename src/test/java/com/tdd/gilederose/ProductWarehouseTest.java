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

    @Test
    public void should_update_normal_product_info_with_downing_2_point_successfully(){
        Product product = new NormalProduct(1L,"normal product",-1, 10);
        ProductWarehouse productWarehouse = new ProductWarehouse();
        productWarehouse.addProduct(product);

        List<Product> productList = productWarehouse.getProductList();
        int stockId = productWarehouse.getStockId(product.getId());
        productWarehouse.updateStockInfo(stockId);

        assertThat(productList.get(stockId).getSellIn(), is(-2));
        assertThat(productList.get(stockId).getQuality(), is(8));
    }

    @Test
    public void should_not_update_normal_product_info_when_quality_is_0(){
        Product product = new NormalProduct(1L,"normal product",-1, 0);
        ProductWarehouse productWarehouse = new ProductWarehouse();
        productWarehouse.addProduct(product);

        List<Product> productList = productWarehouse.getProductList();
        int stockId = productWarehouse.getStockId(product.getId());
        productWarehouse.updateStockInfo(stockId);

        assertThat(productList.get(stockId).getSellIn(), is(-2));
        assertThat(productList.get(stockId).getQuality(), is(0));
    }

    @Test
    public void should_update_backstage_pass_product_info_with_downing_1_point_successfully(){
        Product product = new BackstagePassProduct(2L,"backstage pass product",15, 10);
        ProductWarehouse productWarehouse = new ProductWarehouse();
        productWarehouse.addProduct(product);

        List<Product> productList = productWarehouse.getProductList();
        int stockId = productWarehouse.getStockId(product.getId());
        productWarehouse.updateStockInfo(stockId);

        assertThat(productList.get(stockId).getSellIn(), is(14));
        assertThat(productList.get(stockId).getQuality(), is(9));
    }

    @Test
    public void should_update_backstage_pass_product_info_with_rising_2_point_successfully(){
        Product product = new BackstagePassProduct(2L,"backstage pass product",9, 10);
        ProductWarehouse productWarehouse = new ProductWarehouse();
        productWarehouse.addProduct(product);

        List<Product> productList = productWarehouse.getProductList();
        int stockId = productWarehouse.getStockId(product.getId());
        productWarehouse.updateStockInfo(stockId);

        assertThat(productList.get(stockId).getSellIn(), is(8));
        assertThat(productList.get(stockId).getQuality(), is(12));
    }

    @Test
    public void should_update_backstage_pass_product_info_with_rising_3_point_successfully(){
        Product product = new BackstagePassProduct(2L,"backstage pass product",4, 10);
        ProductWarehouse productWarehouse = new ProductWarehouse();
        productWarehouse.addProduct(product);

        List<Product> productList = productWarehouse.getProductList();
        int stockId = productWarehouse.getStockId(product.getId());
        productWarehouse.updateStockInfo(stockId);

        assertThat(productList.get(stockId).getSellIn(), is(3));
        assertThat(productList.get(stockId).getQuality(), is(13));
    }

    @Test
    public void should_not_update_backstage_pass_product_quality_when_quality_is_50(){
        Product product = new BackstagePassProduct(2L,"backstage pass product",4, 50);
        ProductWarehouse productWarehouse = new ProductWarehouse();
        productWarehouse.addProduct(product);

        List<Product> productList = productWarehouse.getProductList();
        int stockId = productWarehouse.getStockId(product.getId());
        productWarehouse.updateStockInfo(stockId);

        assertThat(productList.get(stockId).getSellIn(), is(3));
        assertThat(productList.get(stockId).getQuality(), is(50));
    }

    @Test
    public void should_update_backstage_pass_product_quality_to_0_successfully(){
        Product product = new BackstagePassProduct(2L,"backstage pass product",-1, 10);
        ProductWarehouse productWarehouse = new ProductWarehouse();
        productWarehouse.addProduct(product);

        List<Product> productList = productWarehouse.getProductList();
        int stockId = productWarehouse.getStockId(product.getId());
        productWarehouse.updateStockInfo(stockId);

        assertThat(productList.get(stockId).getSellIn(), is(-2));
        assertThat(productList.get(stockId).getQuality(), is(0));
    }
}
