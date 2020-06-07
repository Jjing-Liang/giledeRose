package com.tdd.gilederose;

public class NormalProduct extends Product {
    public NormalProduct(Long id, String name, Integer sellIn, Integer quality) {
        super(id, name, sellIn, quality);
    }

    @Override
    public Integer getQualityUpdateRuleBySellIn(Integer sellIn) {
        if (sellIn > 0) {
            return -1;
        } else
            return -2;
    }
}
