DROP TABLE IF EXISTS instruments;
DROP TABLE IF EXISTS market;
CREATE TABLE instruments (
  reference      	    VARCHAR NOT NULL primary KEY,
  account_iban  		VARCHAR NOT NULL,
  date			        TIMESTAMP,
  price		            INT,
  description			VARCHAR
);

CREATE TABLE market (
  reference      	    VARCHAR NOT NULL primary KEY,
  price		            INT,
  description			VARCHAR
);