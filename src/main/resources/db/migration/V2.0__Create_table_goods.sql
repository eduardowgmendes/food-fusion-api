-- SEQUENCE: public.goods_id_seq

-- DROP SEQUENCE IF EXISTS public.goods_id_seq;

CREATE SEQUENCE IF NOT EXISTS public.goods_id_seq
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

-- Table: public.goods

-- DROP TABLE IF EXISTS public.goods;

CREATE TABLE IF NOT EXISTS public.goods
(
    id bigint NOT NULL DEFAULT nextval('goods_id_seq'),
    name VARCHAR COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default",
    maker VARCHAR COLLATE pg_catalog."default",
    model VARCHAR COLLATE pg_catalog."default",
    unit_price numeric(10,2) NOT NULL,
    gross_weight numeric(10,2),
    net_weight numeric(10,2),
    ean_8_code VARCHAR COLLATE pg_catalog."default",
    ean_13_code VARCHAR COLLATE pg_catalog."default",
    ean_14_code VARCHAR COLLATE pg_catalog."default",
    ean_128_code VARCHAR COLLATE pg_catalog."default",
    sku_code VARCHAR COLLATE pg_catalog."default",
    upc_code VARCHAR COLLATE pg_catalog."default",
    upc_a_code VARCHAR COLLATE pg_catalog."default",
    upc_e_code VARCHAR COLLATE pg_catalog."default",
    gtin_code VARCHAR COLLATE pg_catalog."default",
    ncm_code VARCHAR COLLATE pg_catalog."default",
    barcode text COLLATE pg_catalog."default",
    technical_specs TEXT COLLATE pg_catalog."default",
    ingredients TEXT COLLATE pg_catalog."default",
    category VARCHAR COLLATE pg_catalog."default",
    created_at TIMESTAMP(6) WITH TIME ZONE,
    updated_at TIMESTAMP(6) WITH TIME ZONE,
    deleted_at TIMESTAMP(6) WITH TIME ZONE,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT PK_goods PRIMARY KEY (id),
    CONSTRAINT goods_category_check CHECK (category::text = ANY (ARRAY['ELECTRONICS'::VARCHAR, 'HOME_GOODS'::VARCHAR, 'APPAREL'::VARCHAR, 'TOYS_AND_GAMES'::VARCHAR, 'SPORTS_AND_OUTDOORS'::VARCHAR, 'AUTOMOTIVE'::VARCHAR, 'BEAUTY_AND_HEALTH'::VARCHAR, 'OFFICE_SUPPLIES'::VARCHAR, 'PET_SUPPLIES'::VARCHAR, 'TOYS'::VARCHAR, 'BOARD_GAMES'::VARCHAR, 'VIDEO_GAMES'::VARCHAR, 'SPORTS_EQUIPMENT'::VARCHAR, 'MEN_CLOTHING'::VARCHAR, 'WOMEN_CLOTHING'::VARCHAR, 'CHILDREN_CLOTHING'::VARCHAR, 'SHOES'::VARCHAR, 'ACCESSORIES'::VARCHAR, 'FURNITURE'::VARCHAR, 'KITCHENWARE'::VARCHAR, 'BATHROOM'::VARCHAR, 'DECOR'::VARCHAR, 'COMPUTERS'::VARCHAR, 'CELL_PHONES'::VARCHAR, 'HOME_AUDIO'::VARCHAR, 'APPLIANCES'::VARCHAR, 'PRODUCE'::VARCHAR, 'MEAT_SEAFOOD'::VARCHAR, 'DAIRY'::VARCHAR, 'BAKERY'::VARCHAR, 'GROCERY'::VARCHAR, 'BEVERAGES'::VARCHAR, 'CONDIMENTS'::VARCHAR, 'SNACKS'::VARCHAR, 'FROZEN_FOOD'::VARCHAR, 'PANTRY_STAPLES'::VARCHAR, 'CONFECTIONERY'::VARCHAR, 'BAKERY_GOODS'::VARCHAR, 'CANNED_GOODS'::VARCHAR, 'DAIRY_PRODUCTS'::VARCHAR, 'OILS_VINEGARS'::VARCHAR, 'INTERNATIONAL_FOOD'::VARCHAR, 'HEALTHY_FOOD'::VARCHAR, 'BEER_WINE_SPIRITS'::VARCHAR]::text[]))
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.goods
    OWNER to postgres;


ALTER SEQUENCE public.goods_id_seq
OWNED BY goods.id;