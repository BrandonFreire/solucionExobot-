-- database: ../DataBase/Data.sqlite
/*
Autor: David Morales
Autor: Ismael Freire
Autor: Ivonne Ayala
Script: Creacion de la tabla sexo + datos
*/

DROP TABLE IF EXISTS Sexo;

CREATE TABLE Sexo (
    IdIFSexo        INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    Nombre          VARCHAR(10) NOT NULL UNIQUE,
    Estado          VARCHAR(1) NOT NULL DEFAULT('A'),
    FechaCrea       DATETIME DEFAULT(DATETIME('now','localtime')),
    FechaModifica   DATETIME
);

----------------------------

INSERT INTO Sexo(Nombre) VALUES
("Femenino"),
("Masculino"),
("Hibrido");

SELECT * FROM Sexo;
SELECT IdIFSexo, Nombre, Estado  FROM Sexo WHERE Estado='A';

SELECT IdIFSexo, Nombre, Estado, FechaCrea, FechaModifica FROM Sexo  WHERE Estado='A';

SELECT *
FROM Sexo
WHERE Estado = 'A';



SELECT IdIFSexo
,Nombre
,Estado
,FechaCrea
,FechaModifica
FROM Sexo
WHERE Estado ='A';