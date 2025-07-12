package com.unisew.order_service.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum ClothSize {

    BOY_SHIRT_S("shirt", "S", "S", "boy", 0, 0, 0, 0),
    BOY_SHIRT_M("shirt", "M", "M", "boy", 0, 0, 0, 0),
    BOY_SHIRT_L("shirt", "L", "L", "boy", 0, 0, 0, 0),
    BOY_SHIRT_XL("shirt", "XL", "XL", "boy", 0, 0, 0, 0),
    BOY_SHIRT_XXL("shirt", "XXL", "XXL", "boy", 0, 0, 0, 0),
    BOY_SHIRT_3XL("shirt", "3XL", "XXXL", "boy", 0, 0, 0, 0),
    BOY_SHIRT_4XL("shirt", "4XL", "XXXXL", "boy", 0, 0, 0, 0),

    GIRL_SHIRT_S("shirt", "S", "S", "girl", 0, 0, 0, 0),
    GIRL_SHIRT_M("shirt", "M", "M", "girl", 0, 0, 0, 0),
    GIRL_SHIRT_L("shirt", "L", "L", "girl", 0, 0, 0, 0),
    GIRL_SHIRT_XL("shirt", "XL", "XL", "girl", 0, 0, 0, 0),
    GIRL_SHIRT_XXL("shirt", "XXL", "XXL", "girl", 0, 0, 0, 0),
    GIRL_SHIRT_3XL("shirt", "3XL", "XXXL", "girl", 0, 0, 0, 0),
    GIRL_SHIRT_4XL("shirt", "4XL", "XXXXL", "girl", 0, 0, 0, 0),

    BOY_PANTS_S("pants", "S", "S", "boy", 0, 0, 0, 0),
    BOY_PANTS_M("pants", "M", "M", "boy", 0, 0, 0, 0),
    BOY_PANTS_L("pants", "L", "L", "boy", 0, 0, 0, 0),
    BOY_PANTS_XL("pants", "XL", "XL", "boy", 0, 0, 0, 0),
    BOY_PANTS_XXL("pants", "XXL", "XXL", "boy", 0, 0, 0, 0),
    BOY_PANTS_3XL("pants", "3XL", "XXXL", "boy", 0, 0, 0, 0),
    BOY_PANTS_4XL("pants", "4XL", "XXXXL", "boy", 0, 0, 0, 0),

    GIRL_PANTS_S("pants", "S", "S", "girl", 0, 0, 0, 0),
    GIRL_PANTS_M("pants", "M", "M", "girl", 0, 0, 0, 0),
    GIRL_PANTS_L("pants", "L", "L", "girl", 0, 0, 0, 0),
    GIRL_PANTS_XL("pants", "XL", "XL", "girl", 0, 0, 0, 0),
    GIRL_PANTS_XXL("pants", "XXL", "XXL", "girl", 0, 0, 0, 0),
    GIRL_PANTS_3XL("pants", "3XL", "XXXL", "girl", 0, 0, 0, 0),
    GIRL_PANTS_4XL("pants", "4XL", "XXXXL", "girl", 0, 0, 0, 0),

    GIRL_SKIRT_S("skirt", "S", "S", "girl", 0, 0, 0, 0),
    GIRL_SKIRT_M("skirt", "M", "M", "girl", 0, 0, 0, 0),
    GIRL_SKIRT_L("skirt", "L", "L", "girl", 0, 0, 0, 0),
    GIRL_SKIRT_XL("skirt", "XL", "XL", "girl", 0, 0, 0, 0),
    GIRL_SKIRT_XXL("skirt", "XXL", "XXL", "girl", 0, 0, 0, 0),
    GIRL_SKIRT_3XL("skirt", "3XL", "XXXL", "girl", 0, 0, 0, 0),
    GIRL_SKIRT_4XL("skirt", "4XL", "XXXXL", "girl", 0, 0, 0, 0),
    ;

    private final String type;
    private final String size;
    private final String name;
    private final String gender;
    private final int maxHeight;
    private final int minHeight;
    private final int maxWeight;
    private final int minWeight;

    public static ClothSize findByNameAndTypeAndGender(String name, String type, String gender) {
        return Arrays.stream(ClothSize.values())
                .filter(
                        clothSize ->
                        clothSize.getName().equalsIgnoreCase(name)
                                && clothSize.getType().equalsIgnoreCase(type)
                                && clothSize.getGender().equalsIgnoreCase(gender)
                )
                .findFirst().orElse(null);
    }
}
