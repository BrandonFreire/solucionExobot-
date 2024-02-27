-- database: ../DataBase/Exobot.sqlite
DROP TABLE IF EXISTS IABot;
DROP TABLE IF EXISTS Exobots;
DROP TABLE IF EXISTS ArmaIzquierda;
DROP TABLE IF EXISTS ArmaDerecha;
DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS Cargo;

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
    CONSTRAINT fk_IABot FOREIGN KEY (IdIABot) REFERENCES IABot(IdIABot),
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

CREATE TABLE Cargo(
    IdCargo   INTEGER PRIMARY KEY AUTOINCREMENT
    ,Descp    TEXT NOT NULL
    ,Estado   VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCrea  DATETIME DEFAULT CURRENT_TIMESTAMP
    ,FechaMod   DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Persona (
    IdPersona   INTEGER PRIMARY KEY AUTOINCREMENT
    ,Nombre     TEXT NOT NULL
    ,IdCargo    INTEGER NOT NULL
    ,Estado     VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCrea  DATETIME DEFAULT CURRENT_TIMESTAMP
    ,FechaMod   DATETIME DEFAULT CURRENT_TIMESTAMP
    ,CONSTRAINT fk_IdCargo FOREIGN KEY (IdCargo) REFERENCES Cargo(IdCargo)
);


CREATE TABLE PersonaCargo AS
SELECT pe.IdPersona AS IdPersona, pe.Nombre AS Nombre, ca.Descp AS Cargo
FROM Persona pe
JOIN Cargo ca ON pe.IdCargo = ca.IdCargo
WHERE pe.Estado = 'A' AND ca.Estado = 'A';
