-- Table: inventory.goods

-- DROP TABLE IF EXISTS inventory.goods;

CREATE SCHEMA IF NOT EXISTS inventory;

CREATE TABLE IF NOT EXISTS inventory.goods
(
    gross_weight numeric(10,2),
    is_deleted boolean,
    net_weight numeric(10,2),
    unit_price numeric(10,2) NOT NULL,
    created_at timestamp(6) without time zone,
    deleted_at timestamp(6) without time zone,
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    updated_at timestamp(6) without time zone,
    barcode text COLLATE pg_catalog."default",
    category character varying(255) COLLATE pg_catalog."default",
    description text COLLATE pg_catalog."default",
    ean_128_code character varying(255) COLLATE pg_catalog."default",
    ean_13_code character varying(255) COLLATE pg_catalog."default",
    ean_14_code character varying(255) COLLATE pg_catalog."default",
    ean_8_code character varying(255) COLLATE pg_catalog."default",
    gtin_code character varying(255) COLLATE pg_catalog."default",
    ingredients character varying(255) COLLATE pg_catalog."default",
    maker character varying(255) COLLATE pg_catalog."default",
    model character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    ncm_code character varying(255) COLLATE pg_catalog."default",
    sku_code character varying(255) COLLATE pg_catalog."default",
    technical_specs character varying(255) COLLATE pg_catalog."default",
    upc_a_code character varying(255) COLLATE pg_catalog."default",
    upc_code character varying(255) COLLATE pg_catalog."default",
    upc_e_code character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT goods_pkey PRIMARY KEY (id),
    CONSTRAINT goods_category_check CHECK (category::text = ANY (ARRAY['ELECTRONICS'::character varying, 'HOME_GOODS'::character varying, 'APPAREL'::character varying, 'TOYS_AND_GAMES'::character varying, 'SPORTS_AND_OUTDOORS'::character varying, 'AUTOMOTIVE'::character varying, 'BEAUTY_AND_HEALTH'::character varying, 'OFFICE_SUPPLIES'::character varying, 'PET_SUPPLIES'::character varying, 'TOYS'::character varying, 'BOARD_GAMES'::character varying, 'VIDEO_GAMES'::character varying, 'SPORTS_EQUIPMENT'::character varying, 'MEN_CLOTHING'::character varying, 'WOMEN_CLOTHING'::character varying, 'CHILDREN_CLOTHING'::character varying, 'SHOES'::character varying, 'ACCESSORIES'::character varying, 'FURNITURE'::character varying, 'KITCHENWARE'::character varying, 'BATHROOM'::character varying, 'DECOR'::character varying, 'COMPUTERS'::character varying, 'CELL_PHONES'::character varying, 'HOME_AUDIO'::character varying, 'APPLIANCES'::character varying, 'PRODUCE'::character varying, 'MEAT_SEAFOOD'::character varying, 'DAIRY'::character varying, 'BAKERY'::character varying, 'GROCERY'::character varying, 'BEVERAGES'::character varying, 'CONDIMENTS'::character varying, 'SNACKS'::character varying, 'FROZEN_FOOD'::character varying, 'PANTRY_STAPLES'::character varying, 'CONFECTIONERY'::character varying, 'BAKERY_GOODS'::character varying, 'CANNED_GOODS'::character varying, 'DAIRY_PRODUCTS'::character varying, 'OILS_VINEGARS'::character varying, 'INTERNATIONAL_FOOD'::character varying, 'HEALTHY_FOOD'::character varying, 'BEER_WINE_SPIRITS'::character varying, 'PREPARED_MEALS'::character varying, 'FROZEN_PIZZA'::character varying, 'FROZEN_HAMBURGERS'::character varying, 'BURGER_KITS'::character varying, 'PIZZA_KITS'::character varying, 'COOKING_SAUCES'::character varying, 'PASTA_SAUCES'::character varying, 'PASTA'::character varying, 'RICE_AND_GRAINS'::character varying, 'SPICES_AND_HERBS'::character varying, 'SWEETENERS'::character varying, 'BAKING_INGREDIENTS'::character varying, 'PLANT_BASED_MEALS'::character varying, 'VEGAN_PRODUCTS'::character varying, 'VEGETARIAN_PRODUCTS'::character varying, 'GLUTEN_FREE_PRODUCTS'::character varying, 'SET_MEAL'::character varying, 'TAKEOUT_MEAL'::character varying]::text[]))
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS inventory.goods
    OWNER to postgres;