package com.alraisent.alraisitassets.enums;

public enum AssetType {

    ACCESSORY("Accessory"),
    ASSET("Asset"),
    CONSUMABLE("Consumable"),
    COMPONENT("Component"),
    LICENSE("License");

    private final String displayValue;

    private AssetType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }


}
