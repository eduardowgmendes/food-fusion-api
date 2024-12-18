-- Table: public.notes

-- DROP TABLE IF EXISTS public.notes;

CREATE TABLE IF NOT EXISTS public.notes
(
supplier_id bigint NOT NULL,
notes TEXT COLLATE pg_catalog."default",
CONSTRAINT FK_suppliers_notes FOREIGN KEY (supplier_id)
REFERENCES public.suppliers (id) MATCH SIMPLE
ON UPDATE CASCADE
ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.notes
OWNER to postgres;