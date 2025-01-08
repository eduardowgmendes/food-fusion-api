-- SEQUENCE: public.service_times_id_seq

-- DROP SEQUENCE IF EXISTS public.service_times_id_seq;

CREATE SEQUENCE IF NOT EXISTS public.service_times_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

-- Table: public.service_times

-- DROP TABLE IF EXISTS public.service_times;

CREATE TABLE IF NOT EXISTS public.service_times
(
    id bigint NOT NULL DEFAULT nextval('service_times_id_seq'::regclass),
    name character varying(128) COLLATE pg_catalog."default" NOT NULL,
    opens_at TIME NOT NULL,
    closes_at TIME NOT NULL,
    restaurant_id bigint,
    CONSTRAINT pk_service_times PRIMARY KEY (id),
    CONSTRAINT fk_restaurant_service_times FOREIGN KEY (restaurant_id)
        REFERENCES public.restaurants (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.service_times
    OWNER to postgres;

ALTER SEQUENCE public.service_times_id_seq
OWNED BY service_times.id;