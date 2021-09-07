CREATE TABLE items
(
	
    item_id  SERIAL PRIMARY KEY,
    item_name   varchar(256) NOT NULL,
    price    float NOT NULL,
    quantity        FLOAT(40) NULL,
    item_date      DATE NULL,
    create_on        DATE NULL,
    updated_on DATE NULL
);
