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
menu_name VARCHAR(256) COLLATE pg_catalog."default" NOT NULL,
menu_description TEXT COLLATE pg_catalog."default",
restaurant_id BIGINT,
CONSTRAINT PK_menus PRIMARY KEY (id),
CONSTRAINT FK_restaurant_menus FOREIGN KEY (restaurant_id)
REFERENCES public.restaurants (id) MATCH SIMPLE
ON UPDATE CASCADE
ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.menus
OWNER to postgres;

ALTER SEQUENCE public.menus_id_seq
OWNED BY menus.id;