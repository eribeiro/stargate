-- Used to create the cql schema to generate the schema.json file
-- See GraphqlTest.java

CREATE KEYSPACE IF NOT EXISTS betterbotz
WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1 };

CREATE TABLE IF NOT EXISTS betterbotz."Products" (
    id uuid,
    name text,
    price decimal,
    created timestamp,
    "prodName" text,
    "customerName" text,
    description text,
    PRIMARY KEY ((id), name, price, created)
);

CREATE TABLE IF NOT EXISTS betterbotz."Orders" (
    "prodName" text,
    "customerName" text,
    id uuid,
    "prodId" uuid,
    address text,
    description text,
    price decimal,
    "sellPrice" decimal,
    PRIMARY KEY (("prodName"), "customerName")
);
