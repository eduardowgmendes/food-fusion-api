-- SEQUENCE: public.showcase_pictures_id_seq

-- DROP SEQUENCE IF EXISTS public.showcase_pictures_id_seq;

CREATE SEQUENCE IF NOT EXISTS public.showcase_pictures_id_seq
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

-- Table: public.showcase_pictures

-- DROP TABLE IF EXISTS public.showcase_pictures;

CREATE TABLE IF NOT EXISTS public.showcase_pictures
(
id BIGINT NOT NULL DEFAULT nextval('showcase_pictures_id_seq'),
base64 TEXT COLLATE pg_catalog."default",
menu_item_id BIGINT NOT NULL,
CONSTRAINT PK_showcase_pictures PRIMARY KEY (id),
CONSTRAINT FK_menu_items_showcase_pictures FOREIGN KEY (menu_item_id)
REFERENCES public.menu_items(id) MATCH SIMPLE
ON UPDATE CASCADE
ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.showcase_pictures
OWNER to postgres;