package br.com.edu.foodfusion.shared.database.enums;

import lombok.Getter;

@Getter
public enum GoodsCategoryEnum {
    ELECTRONICS("Electronics"),
    HOME_GOODS("Home Goods"),
    APPAREL("Apparel"),
    TOYS_AND_GAMES("Toys and Games"),
    SPORTS_AND_OUTDOORS("Sports and Outdoors"),
    AUTOMOTIVE("Automotive"),
    BEAUTY_AND_HEALTH("Beauty and Health"),
    OFFICE_SUPPLIES("Office Supplies"),
    PET_SUPPLIES("Pet Supplies"),
    TOYS("Toys"),
    BOARD_GAMES("Board Games"),
    VIDEO_GAMES("Video Games"),
    SPORTS_EQUIPMENT("Sports Equipment"),
    MEN_CLOTHING("Men Clothing"),
    WOMEN_CLOTHING("Women Clothing"),
    CHILDREN_CLOTHING("Children Clothing"),
    SHOES("Shoes"),
    ACCESSORIES("Accessories"),
    FURNITURE("Furniture"),
    KITCHENWARE("Kitchenware"),
    BATHROOM("Bathroom"),
    DECOR("Decor"),
    COMPUTERS("Computers"),
    CELL_PHONES("Cell Phone"),
    HOME_AUDIO("Home Audio"),
    APPLIANCES("Appliance"),
    PRODUCE("Produce"),
    MEAT_SEAFOOD("Meat & Seafood"),
    DAIRY("Dairy"),
    BAKERY("Bakery"),
    GROCERY("Grocery"),
    BEVERAGES("Beverages"),
    CONDIMENTS("Condiments"),
    SNACKS("Snacks"),
    FROZEN_FOOD("Frozen Food"),
    PANTRY_STAPLES("Pantry Staples"),
    CONFECTIONERY("Confectionery"),
    BAKERY_GOODS("Bakery Goods"),
    CANNED_GOODS("Canned Goods"),
    DAIRY_PRODUCTS("Dairy Products"),
    OILS_VINEGARS("Oils & Vinegars"),
    INTERNATIONAL_FOOD("International Food"),
    HEALTHY_FOOD("Healthy Food"),
    BEER_WINE_SPIRITS("Beer, Wine & Spirits"),

    // Novas categorias para alimentos compostos e ingredientes
    PREPARED_MEALS("Prepared Meals"),
    FROZEN_PIZZA("Frozen Pizza"),
    FROZEN_HAMBURGERS("Frozen Hamburgers"),
    BURGER_KITS("Burger Kits"),
    PIZZA_KITS("Pizza Kits"),
    COOKING_SAUCES("Cooking Sauces"),
    PASTA_SAUCES("Pasta Sauces"),
    PASTA("Pasta"),
    RICE_AND_GRAINS("Rice and Grains"),
    SPICES_AND_HERBS("Spices and Herbs"),
    SWEETENERS("Sweeteners"),
    BAKING_INGREDIENTS("Baking Ingredients"),
    PLANT_BASED_MEALS("Plant-based Meals"),
    VEGAN_PRODUCTS("Vegan Products"),
    VEGETARIAN_PRODUCTS("Vegetarian Products"),
    GLUTEN_FREE_PRODUCTS("Gluten-Free Products"),
    SET_MEAL("Set Meal"),
    TAKEOUT_MEAL("Takeout Meal");

    private final String displayName;

    GoodsCategoryEnum(String displayName) {
        this.displayName = displayName;
    }

}
