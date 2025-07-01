package com.unisew.order_service.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ClothSize {

    BOY_SHIRT_S("shirt", "S", "boy", 0, 0, 0, 0),
    BOY_SHIRT_M("shirt", "M", "boy", 0, 0, 0, 0),
    BOY_SHIRT_L("shirt", "L", "boy", 0, 0, 0, 0),
    BOY_SHIRT_XL("shirt", "XL", "boy", 0, 0, 0, 0),
    BOY_SHIRT_XXL("shirt", "XXL", "boy", 0, 0, 0, 0),
    BOY_SHIRT_3XL("shirt", "3XL", "boy", 0, 0, 0, 0),
    BOY_SHIRT_4XL("shirt", "4XL", "boy", 0, 0, 0, 0),

    GIRL_SHIRT_S("shirt", "S", "girl", 0, 0, 0, 0),
    GIRL_SHIRT_M("shirt", "M", "girl", 0, 0, 0, 0),
    GIRL_SHIRT_L("shirt", "L", "girl", 0, 0, 0, 0),
    GIRL_SHIRT_XL("shirt", "XL", "girl", 0, 0, 0, 0),
    GIRL_SHIRT_XXL("shirt", "XXL", "girl", 0, 0, 0, 0),
    GIRL_SHIRT_3XL("shirt", "3XL", "girl", 0, 0, 0, 0),
    GIRL_SHIRT_4XL("shirt", "4XL", "girl", 0, 0, 0, 0),

    BOY_PANTS_28("pants", "S", "boy", 0, 0, 0, 0),
    BOY_PANTS_29("pants", "M", "boy", 0, 0, 0, 0),
    BOY_PANTS_30("pants", "L", "boy", 0, 0, 0, 0),
    BOY_PANTS_31("pants", "XL", "boy", 0, 0, 0, 0),
    BOY_PANTS_32("pants", "XXL", "boy", 0, 0, 0, 0),
    BOY_PANTS_33("pants", "3XL", "boy", 0, 0, 0, 0),
    BOY_PANTS_34("pants", "4XL", "boy", 0, 0, 0, 0),

    GIRL_PANTS_28("pants", "S", "girl", 0, 0, 0, 0),
    GIRL_PANTS_29("pants", "M", "girl", 0, 0, 0, 0),
    GIRL_PANTS_30("pants", "L", "girl", 0, 0, 0, 0),
    GIRL_PANTS_31("pants", "XL", "girl", 0, 0, 0, 0),
    GIRL_PANTS_32("pants", "XXL", "girl", 0, 0, 0, 0),
    GIRL_PANTS_33("pants", "3XL", "girl", 0, 0, 0, 0),
    GIRL_PANTS_34("pants", "4XL", "girl", 0, 0, 0, 0),

    GIRL_SKIRT_S("skirt", "S", "girl", 0, 0, 0, 0),
    GIRL_SKIRT_M("skirt", "M", "girl", 0, 0, 0, 0),
    GIRL_SKIRT_L("skirt", "L", "girl", 0, 0, 0, 0),
    GIRL_SKIRT_XL("skirt", "XL", "girl", 0, 0, 0, 0),
    GIRL_SKIRT_XXL("skirt", "XXL", "girl", 0, 0, 0, 0),
    GIRL_SKIRT_3XL("skirt", "3XL", "girl", 0, 0, 0, 0),
    GIRL_SKIRT_4XL("skirt", "4XL", "girl", 0, 0, 0, 0),
    ;

    private final String type;
    private final String size;
    private final String gender;
    private final int maxHeight;
    private final int minHeight;
    private final int maxWeight;
    private final int minWeight;
}
