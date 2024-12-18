-- Table: public.patents

-- DROP TABLE IF EXISTS public.patents;

CREATE TABLE IF NOT EXISTS public.patents
(
id bigint NOT NULL,
patents TEXT COLLATE pg_catalog."default",
CONSTRAINT FK_patents_goods FOREIGN KEY (id)
REFERENCES public.goods (id) MATCH SIMPLE
ON UPDATE CASCADE
ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.patents
OWNER to postgres;