DROP TABLE IF EXISTS API_KEY;
DROP TABLE IF EXISTS PROPERTY;

CREATE TABLE PROPERTY (
    PROPERTY_ID     VARCHAR (50) NOT NULL,
    NAME            VARCHAR (250) NOT NULL,
    DESCRIPTION     VARCHAR (500),
    PRICE           DOUBLE,
    PROPERTY_TYPE   VARCHAR (50),
    STATUS          VARCHAR (20),
    STATUS_COMMENT  VARCHAR (250),
    STATUS_DATE     TIMESTAMP (6),
    UPDATED_USR_ID  VARCHAR (50),
    UPDATED_TIMSTM  TIMESTAMP (6),
    PRIMARY KEY ("PROPERTY_ID")
);

CREATE TABLE API_KEY (
    ID              NUMBER NOT NULL,
    KEY             VARCHAR (50) NOT NULL,
    PRIMARY KEY ("ID")
);

CREATE TABLE product (
       id VARCHAR(255) not null,
        category VARCHAR(255) not null,
        context VARCHAR(1500) not null,
        description VARCHAR(500) not null,
        image VARCHAR(255) not null,
        time VARCHAR(255) not null,
        title VARCHAR(255) not null,
        PRIMARY KEY (id)
    );

CREATE TABLE contact (
       id VARCHAR(255) not null,
        email VARCHAR(255) not null,
        message VARCHAR(255) not null,
        name VARCHAR(255) not null,
        PRIMARY KEY (id)
    );
