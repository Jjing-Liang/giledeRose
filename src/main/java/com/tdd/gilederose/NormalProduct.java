package com.tdd.gilederose;

public class NormalProduct extends Product {
    public NormalProduct(Long id, String name, Integer sellIn, Integer quality) {
        super(id, name, sellIn, quality);
    }

    @Override
    public Integer getQualityUpdateRuleBySellIn(Integer sellIn) {
        return null;
    }
}