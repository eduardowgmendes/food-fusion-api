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
restaurant_id BIGINT,
city VARCHAR(255) COLLATE pg_catalog."default",
country VARCHAR(255) COLLATE pg_catalog."default",
local_number VARCHAR(255) COLLATE pg_catalog."default",
neighborhood VARCHAR(255) COLLATE pg_catalog."default",
state VARCHAR(255) COLLATE pg_catalog."default",
street VARCHAR(255) COLLATE pg_catalog."default",
zipcode VARCHAR(255) COLLATE pg_catalog."default",
type VARCHAR(255) COLLATE pg_catalog."default",
CONSTRAINT PK_addresses PRIMARY KEY (id),
CONSTRAINT FK_restaurant_addresses FOREIGN KEY (restaurant_id)
REFERENCES public.restaurants (id) MATCH SIMPLE
ON UPDATE CASCADE
ON DELETE CASCADE,
CONSTRAINT address_type_check CHECK (type::text = ANY (ARRAY['RESIDENTIAL'::VARCHAR, 'COMMERCIAL'::VARCHAR, 'CORRESPONDENCE'::VARCHAR]::text[]))
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.addresses
OWNER to postgres;

ALTER SEQUENCE public.addresses_id_seq
OWNED BY addresses.id;