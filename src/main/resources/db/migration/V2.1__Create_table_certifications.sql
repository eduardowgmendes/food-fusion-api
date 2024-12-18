-- Table: public.certifications

-- DROP TABLE IF EXISTS public.certifications;

CREATE TABLE IF NOT EXISTS public.certifications
(
id bigint NOT NULL,
certifications TEXT COLLATE pg_catalog."default",
CONSTRAINT FK_certifications_goods FOREIGN KEY (id)
REFERENCES public.goods (id) MATCH SIMPLE
ON UPDATE CASCADE
ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.certifications
OWNER to postgres;