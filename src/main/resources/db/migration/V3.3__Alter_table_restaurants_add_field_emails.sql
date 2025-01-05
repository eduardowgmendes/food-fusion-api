-- SEQUENCE: public.emails_id_seq

-- DROP SEQUENCE IF EXISTS public.emails_id_seq;

CREATE SEQUENCE IF NOT EXISTS public.emails_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

-- Table: public.emails

-- DROP TABLE IF EXISTS public.emails;

CREATE TABLE IF NOT EXISTS public.emails
(
    id bigint NOT NULL DEFAULT nextval('emails_id_seq'::regclass),
    email character varying(128) COLLATE pg_catalog."default" NOT NULL,
    restaurant_id bigint,
    CONSTRAINT pk_emails PRIMARY KEY (id),
    CONSTRAINT fk_restaurant_emails FOREIGN KEY (restaurant_id)
        REFERENCES public.restaurants (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.phones
    OWNER to postgres;

ALTER SEQUENCE public.emails_id_seq
OWNED BY emails.id;