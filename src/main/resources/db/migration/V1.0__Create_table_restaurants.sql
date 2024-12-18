
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
created_at TIMESTAMP(6) WITH TIME ZONE,
deleted_at TIMESTAMP(6) WITH TIME ZONE,
updated_at TIMESTAMP(6) WITH TIME ZONE,
is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
CONSTRAINT PK_restaurants PRIMARY KEY (id),
CONSTRAINT restaurants_type_check CHECK (type::text = ANY (ARRAY['ITALIAN'::VARCHAR, 'JAPANESE'::VARCHAR, 'THAI'::VARCHAR, 'CHINESE'::VARCHAR, 'MEXICAN'::VARCHAR, 'INDIAN'::VARCHAR, 'AMERICAN'::VARCHAR, 'FRENCH'::VARCHAR, 'BRAZILIAN'::VARCHAR, 'MEDITERRANEAN'::VARCHAR, 'SPANISH'::VARCHAR, 'GREEK'::VARCHAR, 'KOREAN'::VARCHAR, 'VIETNAMESE'::VARCHAR, 'TURKISH'::VARCHAR, 'ARABIC'::VARCHAR]::text[]))
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.restaurants
OWNER to postgres;

ALTER SEQUENCE public.restaurants_id_seq
OWNED BY restaurants.id;