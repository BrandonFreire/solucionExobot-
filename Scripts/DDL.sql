-- database: ../DataBase/Data.sqlite
DROP TABLE IF EXISTS IABot;
DROP TABLE IF EXISTS Exobots;
DROP TABLE IF EXISTS ArmaIzquierda;
DROP TABLE IF EXISTS ArmaDerecha;

CREATE TABLE IABot (
    IdIABot     INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre      TEXT NOT NULL UNIQUE,
    FechaCrea   DATETIME    DEFAULT(datetime('now','localtime'))
);

CREATE TABLE Exobots (
    IdExaBot          INTEGER PRIMARY KEY AUTOINCREMENT,
    IdIABot           INTEGER NOT NULL,
    IdArmaIzquierda   INTEGER NOT NULL,
    IdArmaDerecha     INTEGER NOT NULL,
    Nombre            TEXT NOT NULL,
    Serie             TEXT NOT NULL,
    Estado            VARCHAR(1)  NOT NULL DEFAULT('A'),
    CONSTRAINT fk_IABot FOREIGN KEY (IdI
    ABot) REFERENCES IABot(IdIABot),
    CONSTRAINT fk_ArmaIzquierda FOREIGN KEY (IdArmaIzquierda) REFERENCES ArmaIzquierda(IdArmaIzquierda),
    CONSTRAINT fk_ArmaDerecha FOREIGN KEY (IdArmaDerecha) REFERENCES ArmaDerecha(IdArmaDerecha)
);

CREATE TABLE ArmaIzquierda (
    IdArmaIzquierda INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre TEXT NOT NULL
);

CREATE TABLE ArmaDerecha (
    IdArmaDerecha INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre TEXT NOT NULL
);
