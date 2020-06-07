package com.tdd.gilederose;

public class BackstagePassProduct extends Product {
    public BackstagePassProduct(Long id, String name, Integer sellIn, Integer quality) {
        super(id, name, sellIn, quality);
    }

    @Override
    public Integer getQualityUpdateRuleBySellIn(Integer sellIn) {
        if (sellIn > 10) {
            return -1;
        } else if (sellIn > 5) {
            return 2;
        } else if (sellIn > 0) {
            return 3;
        } else {
            return 0;
        }
    }
}
