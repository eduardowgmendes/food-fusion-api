-- SEQUENCE: public.menu_items_id_seq

-- DROP SEQUENCE IF EXISTS public.menu_items_id_seq;

CREATE SEQUENCE IF NOT EXISTS public.menu_items_id_seq
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

-- Table: public.menu_items

-- DROP TABLE IF EXISTS public.menu_items;

CREATE TABLE IF NOT EXISTS public.menu_items
(
    id BIGINT NOT NULL DEFAULT nextval('menu_items_id_seq'),
    item_name VARCHAR(255) NOT NULL,
    item_description TEXT,
    menu_id BIGINT,
    CONSTRAINT PK_menu_items PRIMARY KEY (id),
    CONSTRAINT FK_menu_menu_items FOREIGN KEY(menu_id)
    REFERENCES public.menus(id) MATCH SIMPLE
    ON DELETE CASCADE
    ON UPDATE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.menu_items
OWNER TO postgres;

ALTER SEQUENCE public.menu_items_id_seq
OWNED BY menu_items.id;