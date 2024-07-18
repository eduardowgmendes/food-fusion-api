
-- SEQUENCE: public.restaurants_id_seq

-- DROP SEQUENCE IF EXISTS public.restaurants_id_seq;

CREATE SEQUENCE IF NOT EXISTS public.restaurants_id_seq
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

-- SEQUENCE: public.phones_id_seq

-- DROP SEQUENCE IF EXISTS public.phones_id_seq;


-- Table: public.restaurants

-- DROP TABLE IF EXISTS public.restaurants;

CREATE TABLE IF NOT EXISTS public.restaurants
(
id bigint NOT NULL DEFAULT nextval('restaurants_id_seq'),
restaurant_name VARCHAR(256) COLLATE pg_catalog."default" NOT NULL,
description text COLLATE pg_catalog."default",
logo text COLLATE pg_catalog."default",
type VARCHAR(255) COLLATE pg_catalog."default",
created_at timestamp(6) without time zone,
deleted_at timestamp(6) without time zone,
updated_at timestamp(6) without time zone,
is_deleted boolean NOT NULL,
CONSTRAINT PK_restaurants PRIMARY KEY (id),
CONSTRAINT restaurants_type_check CHECK (type::text = ANY (ARRAY['ITALIAN'::VARCHAR, 'JAPANESE'::VARCHAR, 'THAI'::VARCHAR, 'CHINESE'::VARCHAR, 'MEXICAN'::VARCHAR, 'INDIAN'::VARCHAR, 'AMERICAN'::VARCHAR, 'FRENCH'::VARCHAR, 'BRAZILIAN'::VARCHAR, 'MEDITERRANEAN'::VARCHAR, 'SPANISH'::VARCHAR, 'GREEK'::VARCHAR, 'KOREAN'::VARCHAR, 'VIETNAMESE'::VARCHAR, 'TURKISH'::VARCHAR, 'ARABIC'::VARCHAR]::text[]))
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.restaurants
OWNER to postgres;

ALTER SEQUENCE public.restaurants_id_seq
OWNED BY restaurants.id;

-- SEQUENCE: public.menus_id_seq

-- DROP SEQUENCE IF EXISTS public.menus_id_seq;

CREATE SEQUENCE IF NOT EXISTS public.menus_id_seq
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

-- Table: public.menus

-- DROP TABLE IF EXISTS public.menus;

CREATE TABLE IF NOT EXISTS public.menus
(
id bigint NOT NULL DEFAULT nextval('menus_id_seq'),
menu_id bigint NOT NULL,
restaurant_id bigint NOT NULL,
menu_name VARCHAR(256) COLLATE pg_catalog."default" NOT NULL,
description text COLLATE pg_catalog."default",
item_name VARCHAR(255) COLLATE pg_catalog."default" NOT NULL,
CONSTRAINT PK_menus PRIMARY KEY (id),
CONSTRAINT FK_restaurant_menus FOREIGN KEY (restaurant_id)
REFERENCES public.restaurants (id) MATCH SIMPLE
ON UPDATE CASCADE
ON DELETE CASCADE,
CONSTRAINT FK_restaurants_menu FOREIGN KEY (menu_id)
REFERENCES public.menus (id) MATCH SIMPLE
ON UPDATE CASCADE
ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.menus
OWNER to postgres;

ALTER SEQUENCE public.menus_id_seq
OWNED BY menus.id;

-- Table: public.showcase_pictures

-- DROP TABLE IF EXISTS public.showcase_pictures;

CREATE TABLE IF NOT EXISTS public.showcase_pictures
(
menu_id bigint NOT NULL,
showcase_pictures VARCHAR(255) COLLATE pg_catalog."default",
CONSTRAINT FK_menu_showcase_pictures FOREIGN KEY (menu_id)
REFERENCES public.menus (id) MATCH SIMPLE
ON UPDATE CASCADE
ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.showcase_pictures
OWNER to postgres;

CREATE SEQUENCE IF NOT EXISTS public.phones_id_seq
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

-- Table: public.phones

-- DROP TABLE IF EXISTS public.phones;

CREATE TABLE IF NOT EXISTS public.phones
(
id bigint NOT NULL DEFAULT nextval('phones_id_seq'),
prefix VARCHAR(3) COLLATE pg_catalog."default" NOT NULL,
phone_number VARCHAR(16) COLLATE pg_catalog."default" NOT NULL,
restaurant_id bigint NOT NULL,
CONSTRAINT PK_phones PRIMARY KEY (id),
CONSTRAINT FK_restaurant_phones FOREIGN KEY (restaurant_id)
REFERENCES public.restaurants (id) MATCH SIMPLE
ON UPDATE CASCADE
ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.phones
OWNER to postgres;

ALTER SEQUENCE public.phones_id_seq
OWNED BY phones.id;

-- SEQUENCE: public.addresses_id_seq

-- DROP SEQUENCE IF EXISTS public.addresses_id_seq;

CREATE SEQUENCE IF NOT EXISTS public.addresses_id_seq
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

-- Table: public.addresses

-- DROP TABLE IF EXISTS public.addresses;

CREATE TABLE IF NOT EXISTS public.addresses
(
id bigint NOT NULL DEFAULT nextval('addresses_id_seq'),
restaurant_id bigint NOT NULL,
city VARCHAR(255) COLLATE pg_catalog."default",
country VARCHAR(255) COLLATE pg_catalog."default",
local_number VARCHAR(255) COLLATE pg_catalog."default",
neighborhood VARCHAR(255) COLLATE pg_catalog."default",
state VARCHAR(255) COLLATE pg_catalog."default",
street VARCHAR(255) COLLATE pg_catalog."default",
zipcode VARCHAR(255) COLLATE pg_catalog."default",
CONSTRAINT PK_addresses PRIMARY KEY (id),
CONSTRAINT FK_restaurant_addresses FOREIGN KEY (restaurant_id)
REFERENCES public.restaurants (id) MATCH SIMPLE
ON UPDATE CASCADE
ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.addresses
OWNER to postgres;

ALTER SEQUENCE public.addresses_id_seq
OWNED BY addresses.id;

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
name VARCHAR(256) COLLATE pg_catalog."default",
description TEXT COLLATE pg_catalog."default",
maker VARCHAR(256) COLLATE pg_catalog."default",
model VARCHAR(256) COLLATE pg_catalog."default",
unit_price DECIMAL(10, 2),
gross_weight DECIMAL(10, 2),
net_weight DECIMAL(10, 2),
ean_8_code VARCHAR(8) COLLATE pg_catalog."default",
ean_13_code VARCHAR(13) COLLATE pg_catalog."default",
ean_14_code VARCHAR(14) COLLATE pg_catalog."default",
ean_128_code VARCHAR(80) COLLATE pg_catalog."default",
sku_code VARCHAR(16) COLLATE pg_catalog."default",
upc_code VARCHAR(12) COLLATE pg_catalog."default",
upc_a_code VARCHAR(12) COLLATE pg_catalog."default",
upc_e_code VARCHAR(6) COLLATE pg_catalog."default",
gtin_code VARCHAR(32) COLLATE pg_catalog."default",
ncm_code VARCHAR(8) COLLATE pg_catalog."default",
barcode TEXT COLLATE pg_catalog."default",
ingredients VARCHAR(255) COLLATE pg_catalog."default",
technical_specs VARCHAR(255) COLLATE pg_catalog."default",
CONSTRAINT PK_goods PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.goods
OWNER to postgres;


ALTER SEQUENCE public.goods_id_seq
OWNED BY goods.id;

-- Table: public.certifications

-- DROP TABLE IF EXISTS public.certifications;

CREATE TABLE IF NOT EXISTS public.certifications
(
id bigint NOT NULL,
certifications VARCHAR(255) COLLATE pg_catalog."default",
CONSTRAINT FK_certifications_goods FOREIGN KEY (id)
REFERENCES public.goods (id) MATCH SIMPLE
ON UPDATE CASCADE
ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.certifications
OWNER to postgres;

-- Table: public.patents

-- DROP TABLE IF EXISTS public.patents;

CREATE TABLE IF NOT EXISTS public.patents
(
id bigint NOT NULL,
patents VARCHAR(255) COLLATE pg_catalog."default",
CONSTRAINT FK_patents_goods FOREIGN KEY (id)
REFERENCES public.goods (id) MATCH SIMPLE
ON UPDATE CASCADE
ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.patents
OWNER to postgres;

-- SEQUENCE: public.suppliers_id_seq

-- DROP SEQUENCE IF EXISTS public.suppliers_id_seq;

CREATE SEQUENCE IF NOT EXISTS public.suppliers_id_seq
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

-- Table: public.suppliers

-- DROP TABLE IF EXISTS public.suppliers;

CREATE TABLE IF NOT EXISTS public.suppliers
(
id bigint NOT NULL DEFAULT nextval('suppliers_id_seq'),
category character varying(255) COLLATE pg_catalog."default",
company_name character varying(255) COLLATE pg_catalog."default",
document character varying(14) COLLATE pg_catalog."default" NOT NULL,
moq integer,
performance_rating numeric(10,2),
preferred_payment_method character varying(255) COLLATE pg_catalog."default",
trade_name character varying(255) COLLATE pg_catalog."default",
website character varying(255) COLLATE pg_catalog."default",
address_id bigint,
phone_id bigint,
CONSTRAINT PK_suppliers PRIMARY KEY (id),
CONSTRAINT AK_addresses UNIQUE (address_id),
CONSTRAINT AK_phones UNIQUE (phone_id),
CONSTRAINT FK_addresses_suppliers FOREIGN KEY (address_id)
REFERENCES public.addresses (id) MATCH SIMPLE
ON UPDATE CASCADE
ON DELETE CASCADE,
CONSTRAINT FK_phones_suppliers FOREIGN KEY (phone_id)
REFERENCES public.phones (id) MATCH SIMPLE
ON UPDATE CASCADE
ON DELETE CASCADE,
CONSTRAINT suppliers_category_check CHECK (category::text = ANY (ARRAY['ELECTRONICS'::character varying, 'FOOD_BEVERAGE'::character varying, 'OFFICE_SUPPLIES'::character varying, 'AUTOMOTIVE'::character varying, 'APPAREL'::character varying, 'RAW_MATERIALS'::character varying, 'PACKAGING'::character varying, 'MACHINERY'::character varying, 'FURNITURE'::character varying, 'CLEANING_SUPPLIES'::character varying, 'MEDICAL_SUPPLIES'::character varying, 'CONSTRUCTION'::character varying, 'IT_SERVICES'::character varying, 'MARKETING_SERVICES'::character varying, 'PROFESSIONAL_SERVICES'::character varying, 'AGRICULTURE'::character varying, 'PRINTING'::character varying, 'PRODUCE'::character varying, 'MEAT_SEAFOOD'::character varying, 'DAIRY'::character varying, 'BAKERY'::character varying, 'GROCERY'::character varying, 'BEVERAGES'::character varying, 'CONDIMENTS'::character varying, 'FROZEN_FOOD'::character varying, 'SANITATION'::character varying, 'EQUIPMENT'::character varying, 'INGREDIENTS'::character varying, 'SEAFOOD'::character varying]::text[])),
CONSTRAINT suppliers_preferred_payment_method_check CHECK (preferred_payment_method::text = ANY (ARRAY['CASH'::character varying, 'CREDIT_CARD'::character varying, 'DEBIT_CARD'::character varying, 'BANK_TRANSFER'::character varying, 'DIGITAL_WALLET'::character varying, 'ELECTRONIC_CHECK'::character varying, 'COD'::character varying, 'FINANCING'::character varying]::text[]))
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.suppliers
OWNER to postgres;

ALTER SEQUENCE public.suppliers_id_seq
OWNED BY suppliers.id;

-- Table: public.notes

-- DROP TABLE IF EXISTS public.notes;

CREATE TABLE IF NOT EXISTS public.notes
(
supplier_id bigint NOT NULL,
notes character varying(255) COLLATE pg_catalog."default",
CONSTRAINT FK_suppliers_notes FOREIGN KEY (supplier_id)
REFERENCES public.suppliers (id) MATCH SIMPLE
ON UPDATE CASCADE
ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.notes
OWNER to postgres;