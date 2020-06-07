package com.tdd.gilederose;

public abstract class Product {
    protected Long id;
    protected String name;
    protected Integer sellIn;
    protected Integer quality;

    public Product() {
    }

    public Product(Long id, String name, Integer sellIn, Integer quality) {
        this.id = id;
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getSellIn() {
        return sellIn;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSellIn(Integer sellIn) {
        this.sellIn = sellIn;
    }

    public void setQuality(Integer quality) {
        if (quality <= 0) {
            this.quality = 0;
        } else if (quality >= 50) {
            this.quality = 50;
        } else {
            this.quality = quality;
        }
    }

    public abstract Integer getQualityUpdateRuleBySellIn(Integer sellIn);
}
