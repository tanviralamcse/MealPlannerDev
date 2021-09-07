CREATE TABLE bazzar
(
    bazzar_id  SERIAL PRIMARY KEY,
    bazzar_item varchar(255),
    user_id   INT,
    price    FLOAT NOT NULL,
    quantity        FLOAT(40) NULL,
    unit varchar(255),
    bazzar_date      DATE NULL,
    create_on        DATE NULL,
    updated_on DATE NULL,
    CONSTRAINT bazzar_user FOREIGN KEY (user_id)  REFERENCES Users(user_id)
	
);
