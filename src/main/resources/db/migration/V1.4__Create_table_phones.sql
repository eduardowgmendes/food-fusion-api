
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
restaurant_id BIGINT,
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
