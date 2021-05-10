
CREATE TABLE IF NOT EXISTS brands (
    id              bigserial PRIMARY KEY,
    brand_name      character varying(120) NOT NULL
);

CREATE TABLE IF NOT EXISTS prices (
    id              bigserial PRIMARY KEY,
    brand_id        bigint NOT NULL,
    product_id      bigint NOT NULL,
    start_date      timestamp(0) without time zone NOT null,
    end_date        timestamp(0) without time zone NOT null,
    priority        int NOT NULL,
    price           double NOT NULL,
    curr            character varying(3) NOT NULL,
    FOREIGN KEY (brand_id) REFERENCES brands(id)
);
