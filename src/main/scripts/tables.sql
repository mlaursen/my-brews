-------------------------------------------------
-- Lookup Tables
CREATE TABLE Yeast
( id   SERIAL
, name TEXT
, type TEXT
, CONSTRAINT pk_Yeast_Id PRIMARY KEY(id)
);

CREATE TABLE Malt
( id     SERIAL
, name   TEXT
, CONSTRAINT pk_Malt_Id PRIMARY KEY(id)
);

CREATE TABLE Grain
( id     SERIAL
, name   TEXT
, CONSTRAINT pk_Grain_Id PRIMARY KEY(id)
);

CREATE TABLE Hops
( id       SERIAL
, name     TEXT
, CONSTRAINT pk_Hops_Id PRIMARY KEY(id)
);

CREATE TABLE Event_Type
( id    SERIAL
, name  TEXT
, color TEXT
, CONSTRAINT pk_Event_Type_Id PRIMARY KEY(id)
);

CREATE TABLE Beer_Color
( name TEXT
, CONSTRAINT pk_Beer_Color_Name PRIMARY KEY(name)
);

CREATE TABLE Beer_Style
( name TEXT
, CONSTRAINT pk_Beer_Style_Name PRIMARY KEY(name)
);

---------------------------------------------------
-- Table Data
CREATE TABLE Beer
( id               SERIAL
, name             TEXT
, style            TEXT
, color            TEXT
, description      TEXT
, CONSTRAINT pk_Beer_Id PRIMARY KEY(id)
, CONSTRAINT fk_Beer_Beer_Style
    FOREIGN KEY(style) REFERENCES Beer_Style(name)
, CONSTRAINT fk_Beer_Beer_Color
    FOREIGN KEY(color) REFERENCES Beer_Color(name)
);

CREATE TABLE Recipe
( id             SERIAL
, yeast_id       INTEGER
, boil_time      INTEGER
, CONSTRAINT pk_Recipe_Id PRIMARY KEY(id)
, CONSTRAINT fk_Recipe_Yeast_Id 
      FOREIGN KEY (yeast_id) REFERENCES Yeast(id)
);

CREATE TABLE Brewed_Beer
( id          SERIAL
, beer_id     INTEGER
, recipe_id   INTEGER
, og          DECIMAL
, fg          DECIMAL
, ibu         INTEGER -- international bittering units
, abv         DECIMAL -- alcohol by volume
, description TEXT
, CONSTRAINT pk_Brewed_Beer_Id PRIMARY KEY(id)
, CONSTRAINT fk_Brewed_Beer_Beer_Id
    FOREIGN KEY(beer_id) REFERENCES Beer(id)
, CONSTRAINT fk_Brewed_Beer_Recipe_Id
    FOREIGN KEY(recipe_id) REFERENCES Recipe(id)
);

CREATE TABLE Event
( brewed_beer_id INTEGER
, event_type_id  INTEGER
, event_date     DATE
, CONSTRAINT pk_Event PRIMARY KEY(brewed_beer_id, event_type_id)
, CONSTRAINT fk_Event_Brewed_Beer_Id
    FOREIGN KEY(brewed_beer_id) REFERENCES Brewed_Beer(id)
, CONSTRAINT fk_Event_Event_Type_Id
    FOREIGN KEY(event_type_id) REFERENCES Event_Type(id)
);

CREATE TABLE Recipe_Malt
( recipe_id INTEGER
, malt_id   INTEGER
, amount    DECIMAL
, unit      TEXT
, CONSTRAINT pk_Recipe_Malt PRIMARY KEY(recipe_id, malt_id)
, CONSTRAINT fk_Recipe_Malt_Recipe_Id
    FOREIGN KEY(recipe_id) REFERENCES Recipe(id)
, CONSTRAINT fk_Recipe_Malt_Malt_Id
    FOREIGN KEY(malt_id) REFERENCES Malt(id)
);

CREATE TABLE Recipe_Grain
( recipe_id INTEGER
, grain_id  INTEGER
, amount    DECIMAL
, unit      TEXT
, CONSTRAINT pk_Recipe_Grain PRIMARY KEY(recipe_id, grain_id)
, CONSTRAINT fk_Recipe_Hops_Recipe_Id
    FOREIGN KEY(recipe_id) REFERENCES Recipe(id)
, CONSTRAINT fk_Recipe_Hops_Grain_Id
    FOREIGN KEY(grain_id) REFERENCES Grain(id)
);

CREATE TABLE Recipe_Hops
( recipe_id INTEGER
, hops_id   INTEGER
, amount    DECIMAL
, unit      TEXT
, boil_time INTEGER
, CONSTRAINT pk_Recipe_Hops PRIMARY KEY(recipe_id, hops_id)
, CONSTRAINT fk_Recipe_Hops_Recipe_Id
    FOREIGN KEY(recipe_id) REFERENCES Recipe(id)
, CONSTRAINT fk_Recipe_Hops_Hops_Id
    FOREIGN KEY(hops_id) REFERENCES Hops(id)
);

