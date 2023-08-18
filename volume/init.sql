CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE CLIENTS
(
    id uuid default uuid_generate_v4(),
    name   text,
    age    integer
);

INSERT INTO CLIENTS(name, age)
VALUES
    ('Ira4', 13),
    ('Max1', 10),
    ('Ira1', 10),
    ('Ira5', 14),
    ('Ira3', 12),
    ('Max2', 11),
    ('Max5', 14),
    ('Ira2', 11),
    ('Max3', 12),
    ('Max4', 13)
