CREATE TABLE Yeast
( id   SERIAL
, name TEXT
, type TEXT
, CONSTRAINT pk_Yeast_Id PRIMARY KEY(id)
);

CREATE TABLE Malt
( id     SERIAL
, name   TEXT
, amount DECIMAL
, unit   TEXT
, CONSTRAINT pk_Malt_Id PRIMARY KEY(id)
);

CREATE TABLE Grain
( id     SERIAL
, name   TEXT
, amount DECIMAL
, unit   TEXT
, CONSTRAINT pk_Grain_Id PRIMARY KEY(id)
);

CREATE TABLE Hops
( id       SERIAL
, name     TEXT
, amount   DECIMAL
, unit     TEXT
, boilTime INTEGER
, CONSTRAINT pk_Hops_Id PRIMARY KEY(id)
);

CREATE TABLE Recipe_Part
( id       SERIAL
, malt_id  INTEGER
, grain_id INTEGER
, hops_id  INTEGER
, CONSTRAINT pk_Recipe_Part_Id       PRIMARY KEY(id)
, CONSTRAINT fk_Recipe_Part_Malt_Id  FOREIGN KEY(malt_id)
                                     REFERENCES Malt(id)
, CONSTRAINT fk_Recipe_Part_Grain_Id FOREIGN KEY(grain_id)
                                     REFERENCES Grain(id)
, CONSTRAINT fk_Recipe_Part_Hops_Id  FOREIGN KEY(hops_id)
                                     REFERENCES Hops(id)
);

CREATE TABLE Recipe
( id             SERIAL
, recipe_part_id INTEGER
, yeast_id       INTEGER
, CONSTRAINT pk_Recipe_Id             PRIMARY KEY(id)
, CONSTRAINT fk_Recipe_Recipe_Part_Id FOREIGN KEY(recipe_part_id)
                                      REFERENCES Recipe_Part(id)
, constraint fk_Recipe_Yeast_Id       FOREIGN KEY (yeast_id)
                                      REFERENCES Yeast(id)
);


CREATE TABLE Beer
( id               SERIAL
, recipe_id        INTEGER
, name             TEXT
, original_gravity DECIMAL
, final_gravity    DECIMAL
, abv              DECIMAL
, date_brewed      DATE
, primary_end      DATE
, secondary_end    DATE
, drink_date       DATE
, style            TEXT
, color            TEXT
, description      TEXT
, CONSTRAINT pk_Beer_Id        PRIMARY KEY(id)
, CONSTRAINT fk_Beer_Recipe_Id FOREIGN KEY(recipe_id)
                               REFERENCES Recipe(id)
);
