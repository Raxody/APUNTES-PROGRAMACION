CREATE DATABASE empresa;

--\c  “Nombre base de datos”;   para cargar la base de datos

\c empresa;

--Para listar las tablas se usa \dt

\dt;

-- Para mirar los datos de una tabla \d “nombre tabla”

\d empleado;

-- \! Cls;    Para limpiar la pantalla

\! Cls;

-- \l para mirar las bases de datos que hay

\l

-- Crear tablas

CREATE TABLE departamento(
    id INT NOT NULL,
    nombre varchar(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE empleado(
    id INT NOT NULL,
    nombre varchar(40) NOT NULL,
    direccion varchar(20) NOT NULL,
    fecha_nto date NOT NULL,
    cod_dpto INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (cod_dpto) REFERENCES departamento(id)
);


-- Para quitarle el NOT NULL A UNA COLUMNA DE UNA TABLA
ALTER TABLE empleado ALTER COLUMN cod_dpto DROP NOT NULL;


-- Insertar datos

INSERT INTO departamento VALUES (2050,'Recursos Humanos');
INSERT INTO departamento VALUES (2060,'Sistemas');
INSERT INTO departamento VALUES (2070,'Finanzas');
INSERT INTO empleado VALUES (1010,'Maria Sanchez','Calle 80','1994-06-15',2060);
INSERT INTO empleado VALUES (1075,'Carlos Hernandez','Calle 80','1994-06-15',2050);
INSERT INTO empleado (id,nombre,fecha_nto,direccion,cod_dpto) VALUES (399,'Angelica Barrett','2022-06-29','371-8179 Ut Street',2050);
INSERT INTO empleado (id,nombre,fecha_nto,direccion,cod_dpto) VALUES (76,'Hillary Caldwell','2021-10-09 05:06:40','154-9753 Tristique St.',2060);
INSERT INTO empleado (id,nombre,fecha_nto,direccion,cod_dpto) VALUES (316,'Beck Spencer','2021-05-02 21:41:52','595-4014 Aliquam Av.',2050);
INSERT INTO empleado (id,nombre,fecha_nto,direccion,cod_dpto) VALUES (373,'Cullen Hensley','2022-07-09 17:09:37','3763 Donec Rd.',2060);
INSERT INTO empleado (id,nombre,fecha_nto,direccion) VALUES (475,'Quail Maddox','2022-10-07','P.O Box 747, 1700 Ac');

-- NATURAL JOIN Intenta mirar si cod_dpto y id son iguales para traerlos
SELECT e.* FROM empleado e NATURAL JOIN departamento d WHERE d.nombre = 'Sistemas';

-- INNER JOIN Intenta mirar si en ambas tablas existe cod_dpto con el USING
SELECT e.* FROM empleado e INNER JOIN departamento d USING (cod_dpto) WHERE d.nombre = 'Sistemas';

-- JOIN Intenta mirar si en ambas tablas existe cod_dpto con el USING
SELECT e.* FROM empleado e JOIN departamento d USING (cod_dpto) WHERE d.nombre = 'Sistemas';

-- Usa el INNER JOIN con la primaria de depeartamento y la foranea de empleado
-- dentro de el ON igualandolo (esta si sirve)
SELECT e.* FROM empleado e INNER JOIN departamento d ON (e.cod_dpto = d.id) WHERE d.nombre = 'Sistemas';


------------- TENGA EN CUENTA QUE ES SEGUN A LA IZQUIERA O LA DERECHA DEL JOIN QUE SE TOMA OSEA EL ORDEN EN QUE ESTA ESCRITO-----------------
-- Tiene en cuenta todos los datos de la izquiera así no esten relacionados
-- Y aparte los que si esten relacionados
SELECT * FROM empleado e LEFT JOIN departamento d ON (e.cod_dpto = d.id);

-- Tiene en cuenta todos los datos de la derecha así no esten relacionados
-- Y aparte los que si esten relacionados

SELECT * FROM empleado e RIGHT JOIN departamento d ON (e.cod_dpto = d.id);

-- Tiene en cuenta todos los datos tanto de derecha como de izquiera así no esten relacionados
-- Y aparte los que si esten relacionados

SELECT * FROM empleado e FULL JOIN departamento d ON (e.cod_dpto = d.id);



-- OPERADOR UNION-- 

-- Une los resultados de dos sentencias, es conmutativa

SELECT * FROM empleado e LEFT JOIN departamento d ON (e.cod_dpto = d.id)
UNION
SELECT * FROM empleado e RIGHT JOIN departamento d ON (e.cod_dpto = d.id);


-- OPERADOR EXCEPT (Que es la diferencia)-- 

-- Solo muestra los datos que no sean iguales osea los diferentes (una tabla menos los de la otra) 
-- La diferencia es conmutativa, osea es distinto el orden en que se trabaje

SELECT * FROM empleado e LEFT JOIN departamento d ON (e.cod_dpto = d.id)
EXCEPT
SELECT * FROM empleado e RIGHT JOIN departamento d ON (e.cod_dpto = d.id);

-- no conmutatividad

SELECT * FROM empleado e RIGHT JOIN departamento d ON (e.cod_dpto = d.id)
EXCEPT
SELECT * FROM empleado e LEFT JOIN departamento d ON (e.cod_dpto = d.id);


-- OPERADOR INTERSECT-- 

-- Muestra los datos que comparten ambas tablas, es conmutativa

SELECT * FROM empleado e LEFT JOIN departamento d ON (e.cod_dpto = d.id)
INTERSECT
SELECT * FROM empleado e RIGHT JOIN departamento d ON (e.cod_dpto = d.id);


---------------REVISION DE CONSTRAINTS-----------------

-- Genero tabla para pruebas

CREATE TABLE empleado_sin(
    id INT NOT NULL,
    nombre varchar(40) NOT NULL,
    direccion varchar(20) NOT NULL,
    fecha_nto date NOT NULL,
    cod_dpto INT NOT NULL
);

-- Eliminar una base de datos

DROP DATABASE nombreDeLaBaseDeDatos;

-- Eliminar los datos de una tabla

DELETE FROM nombreTabla;

-- Agregar llave primaria a una tabla

ALTER TABLE empleado_sin ADD CONSTRAINT PK_ID PRIMARY KEY(id);


-- Agregar llave fonarea a una tabla


ALTER TABLE empleado_sin ADD CONSTRAINT FK_COD FOREIGN KEY(cod_dpto) REFERENCES departamento(id);


-- Agregar un CHECK a una columna

ALTER TABLE empleado_sin ADD CONSTRAINT validador CHECK (genero= 'M' OR genero = 'F');

ALTER TABLE empleado_sin ADD CONSTRAINT validor CHECK(genero in('F','M'));


-- Agregar un UNIQUE osea que no se repite el dato siendo similar a una llave primaria compuesta

ALTER TABLE empleado_sin ADD CONSTRAINT emp_unique UNIQUE (nombre,genero);

-- o tambien a una columna sola 

ALTER TABLE empleado_sin ADD CONSTRAINT emp_unique UNIQUE (nombre);

-- SUBCONSULTAS

-- Para validar la existencia o si se encuentra dentro de un conjunto revisando con el otro
-- En este caso mirariamos cada valor de a1 en b1 tupla por tupla y si se encuentra lo muestra es como un for
-- IN es esta o es igual y tiene la contradiccion usando el NOT IN
SELECT * FROM A WHERE a1 IN (SELECT b1 FROM B);

-- Comparacion de conjuntos




-- Para saber si existe una tupla utilizamos el EXISTS y en caso dado que en b1 haya un valor mayor a 20 mostrara todos 
-- los datos de la primera consulta

SELECT * FROM A WHERE EXISTS (SELECT * FROM B WHERE b1 > 20);







CREATE DATABASE universidad;

\c universidad;

CREATE TABLE estudiante(
    codigo int NOT NULL,
    nombre varchar (40) NOT NULL,
    PRIMARY KEY (codigo)
);

CREATE TABLE asignatura(
    codigo int NOT NULL,
    nombre varchar (40) NOT NULL,
    PRIMARY KEY (codigo)
);


CREATE TABLE inscripcion(
    cod_est int NOT NULL,
    cod_asig int NOT NULL,
    PRIMARY KEY (cod_est,cod_asig),
    FOREIGN KEY (cod_est) REFERENCES estudiante(codigo),
    FOREIGN KEY (cod_asig) REFERENCES asignatura(codigo)

);


insert into estudiante values(3010,'Alvaro Castang');
insert into estudiante values(3020,'Daniela Uraba');
insert into estudiante values(3030,'Johny Deep');
insert into estudiante values(3040,'Camilo Buitrago');
insert into estudiante values(3050,'Daniel alvarado');


insert into asignatura values(10,'Logica de programacion');
insert into asignatura values(20,'Estructura de datos');
insert into asignatura values(30,'Bases de datos');
insert into asignatura values(40,'Bases de datos avanzadas');
insert into asignatura values(50,'Daniel alvarado Diseño logico');


insert into inscripcion values(3010,10);
insert into inscripcion values(3010,20);
insert into inscripcion values(3020,30);
insert into inscripcion values(3020,50);
insert into inscripcion values(3030,10);
insert into inscripcion values(3030,20);
insert into inscripcion values(3040,30);
insert into inscripcion values(3040,50);
insert into inscripcion values(3050,10);
insert into inscripcion values(3050,20);
insert into inscripcion values(3040,40);
insert into inscripcion values(3050,40);


-- Mostrar todos los datos del estudiante donde  su codigo de asignatura sea 30

SELECT * FROM  estudiante WHERE codigo IN (SELECT cod_est FROM inscripcion  WHERE cod_asign = 30);


SELECT * FROM  estudiante WHERE codigo IN (SELECT cod_est FROM inscripcion  WHERE cod_asig IN (SELECT codigo FROM asignatura WHERE nombre = 'Bases de datos'));

-- Obtener todos los datos de los estudiantes que hayan obtenido una nota mayor que alguno de los estudiantes que han cursado Diseño logico 

ALTER TABLE inscripcion ADD COLUMN nota int;

UPDATE inscripcion SET nota =40 WHERE cod_est = 3010 and cod_asig = 10 ;
UPDATE inscripcion SET nota =35 WHERE cod_est = 3010 and cod_asig = 20 ;
UPDATE inscripcion SET nota =40 WHERE cod_est = 3020 and cod_asig = 30;
UPDATE inscripcion SET nota =37 WHERE cod_est = 3020 and cod_asig = 50;
UPDATE inscripcion SET nota =25 WHERE cod_est = 3030 and cod_asig = 10;
UPDATE inscripcion SET nota =30 WHERE cod_est = 3030 and cod_asig = 20;
UPDATE inscripcion SET nota =30 WHERE cod_est = 3040 and cod_asig = 30;
UPDATE inscripcion SET nota =45 WHERE cod_est = 3050 and cod_asig = 10;
UPDATE inscripcion SET nota =20 WHERE cod_est = 3050 and cod_asig = 20;
UPDATE inscripcion SET nota =38 WHERE cod_est = 3040 and cod_asig = 40;
UPDATE inscripcion SET nota =40 WHERE cod_est = 3040 and cod_asig = 50;
UPDATE inscripcion SET nota =35 WHERE cod_est = 3050 and cod_asig = 40;

SELECT  * FROM estudiante WHERE codigo IN (SELECT cod_est FROM inscripcion WHERE  nota > SOME(SELECT nota FROM inscripcion WHERE cod_asig=50));

SELECT  * FROM estudiante WHERE codigo IN (SELECT cod_est FROM inscripcion WHERE  nota > SOME(SELECT nota FROM inscripcion WHERE cod_asig=50));

// all

-- Obtener los datos de los estudiantes si la asignatura bd con codigo 30 tiene estudiantes inscritos

SELECT * FROM estudiante WHERE EXISTS (SELECT * FROM inscripcion  WHERE  cod_asig =30);

-- Obtener los datos de los estudiantes que tienen inscrita la asignatura bd si la asignatura estructuras de datos con codigo 20 tiene estudiantes inscritos


SELECT * FROM estudiante WHERE EXISTS (SELECT * FROM inscripcion  WHERE  cod_asig =20) AND  codigo IN (SELECT cod_est FROM inscripcion  WHERE cod_asig =30);


SELECT * FROM estudiante WHERE EXISTS (SELECT * FROM inscripcion  WHERE  cod_asig = 20) AND  codigo IN (SELECT cod_est FROM inscripcion  WHERE cod_asig IN (SELECT codigo FROM asignatura WHERE  nombre = 'Bases de datos'));


-- Los indices son para encontrar mas facil los registros
-- Los autonumericos son datos que se van generando solos sumandose de 1 en 1m es una pk ficticia porque no se repite 

--Cuando se quiere un increment de uno en uno se usa el serial

CREATE TABLE xS (
x1 INT NOT NULL,
x2 SERIAL,
x3 VARCHAR(20),
x4 varchar(30) NOT NULL,
PRIMARY KEY (x1)
);

CREATE INDEX pruba_idx  ON xS(x2);

-- si se quiere con condiciones se usa un SEQUENCE

-- Para listar todas las secuencias usamos

\ds 

-- Para mirar una secuencia especifica

\d sec_princ;

-- Se crea el sequence con su identificador, y propiedades
CREATE SEQUENCE sec_princ
START WITH 1000
INCREMENT BY 5
MAXVALUE 1000000
CACHE 1;


CREATE TABLE X(
	X1 INT NOT NULL,
	X2 INT,
	X3 VARCHAR(20),
	X4 VARCHAR(30) NOT NULL,
	PRIMARY KEY(X1) 
);

ALTER TABLE X ALTER COLUMN X2 SET DEFAULT NEXTVAL('sec_princ');

INSERT INTO X(X1,X3,X4) VALUES (1,'equis',5);
INSERT INTO X(X1,X3,X4) VALUES (2,'equis2',6);

alter table X
 add constraint unique_column
 unique (x2);

 -- Para aumentar la secuencia utilizo esta sentencia

 SELECT  NEXTVAL('sec_princ'); 


--\h y el nombre de lo que se quiere hacer muestra la documentacion 



-- para crear funciones o procedimientos almacenados

-- con \df llamo a las funciones

-- funcion con SQL

CREATE OR REPLACE FUNCTION multiplicar2(integer,integer)
RETURNS integer
AS 
'select $1 * $2;'
LANGUAGE SQL;

-- para invocar la funcion se pone SELECT el nombre de la funcion y los argumentos que reciba

SELECT multiplicar2(4,3);

SELECT multiplicar2((SELECT nota FROM inscripcion WHERE cod_est = 3010 and cod_asig = 10),9);

-- funcion con plpgsql

CREATE OR REPLACE FUNCTION multiplicar2_1(i integer, j integer)
RETURNS integer
AS
$$
BEGIN
return i*j;
END 
$$
LANGUAGE plpgsql;

-- el setof es como un array y en este caso hara el array de  estudiantes

CREATE OR REPLACE FUNCTION lista_est()
RETURNS SETOF estudiante
AS
$$
SELECT * FROM estudiante;
$$
LANGUAGE sql;


-- Para generar copias de los datos de una tabla se hace asi 

CREATE TABLE estudiante1 
AS SELECT * FROM estudiante;

-- split_part es para separar caracteres, split_part(nombre de la columna, separador a usar, que pedazo quiere tomar);

SELECT split_part(nombre,' ',2) FROM estudiante;

-- juntando los dos anteriores

CREATE TABLE estudiante2 
AS SELECT codigo, split_part(nombre,' ',1) nombre1, split_part(nombre,' ',2) apellido FROM estudiante;


ALTER TABLE estudiante2
ADD PRIMARY KEY (codigo);

ALTER TABLE estudiante2 ADD COLUMN apellido2 varchar(20);
ALTER TABLE estudiante2 ADD COLUMN nombre_completo varchar(60);


-- Para crear un trigger se retorna el mismo

CREATE OR REPLACE FUNCTION nombre_c()
RETURNS trigger
AS
$nombre_c$
BEGIN
    NEW.nombre_completo := NEW.nombre1 || ' ' || NEW.apellido;
    RETURN NEW;
END;
$nombre_c$
LANGUAGE plpgsql;

CREATE TRIGGER nombre_c_tr
BEFORE INSERT OR UPDATE
ON estudiante2
FOR EACH ROW 
EXECUTE PROCEDURE nombre_c();

-- Para listar los trigger que hay

\dft 

-- Para mostrar los trigers de cada tabala \d nombreTabla

\d estudiante2;

insert INTO estudiante2 (codigo,nombre1,apellido) VALUES (3060,'Manuel','Henao');


ALTER TABLE inscripcion ADD CONSTRAINT validor_nota CHECK(nota > 0);


-- Para crear reglas 

-- Acá estamos creando una regla desde un metodo

CREATE OR REPLACE RULE nota_rango 
    AS ON UPDATE  -- Acá le digo que use sobre el motodo actualizar
    TO inscripcion WHERE NEW.nota < 0 OR NEW.nota >5 -- Despues del TO se pone la tabla a trabajar
    DO INSTEAD NOTHING;  -- El DO es haga el INSTEAD es en vez de y con el NOTHING le decimos que no haga nada


-- Para mirar las reglas se usa

SELECT * FROM pg_rules;

update inscripcion set nota=-1 where cod_est = 3010  and cod_asig = 10;

UPDATE inscripcion SET nota =55 WHERE cod_est = 3010 and cod_asig = 20 ;


-- Para crear vistas es como un producto cartesiano


CREATE VIEW nombre_vista(nombre_columna1,nombre_columna2)-- Esto es como un AS, acá se puede poner los nombresa que se desee
AS
SELECT FRPM WHERE ;


CREATE VIEW xyz(Valor_x1,Valor_x2)
AS
SELECT X1,Y1,Y2,Z FROM X,Y,Z ;

            -- Obtener el codigo y el nombre del estudiante y el codigo y nombre de la asignatura inscrita por cada estudiante
            CREATE VIEW materias_estudiantes(nodigo_estudiante,nombre_estudiante, codigo_asignatura, nombre_asignatura)
            AS
            select e.codigo, e.nombre, a.codigo, a.nombre from estudiante e  join inscripcion i on (i.cod_est = e.codigo)  join asignatura a on (a.codigo = i.cod_asig) ORDER BY e.codigo;

            INSERT INTO inscripcion VALUES (3010,40,35);

-- Para mostrar la vista:

SELECT * FROM nombre_vista;

SELECT * FROM materias_estudiantes;

-- Para eliminar una vista 

DROP VIEW nombre_vista;


-- Para crear una vista materializada es como una copia de una tabla o de un select pero queda guardado con lo que este hasta el momento 

CREATE MATERIALIZED VIEW nombre_vista
AS
SELECT
FROM
WHERE;

    CREATE MATERIALIZED VIEW materias_estudiantes_materializada(nodigo_estudiante,nombre_estudiante, codigo_asignatura, nombre_asignatura)
            AS
            select e.codigo, e.nombre, a.codigo, a.nombre from estudiante e  join inscripcion i on (i.cod_est = e.codigo)  join asignatura a on (a.codigo = i.cod_asig) ORDER BY e.codigo;

    DELETE FROM inscripcion WHERE cod_est=3010 AND cod_asig = 40;

    -- Para mostrar una vista materializada 

    SELECT * FROM materias_estudiantes_materializada;

-- Para limpiar la vista osea refrescarla tanto estructura como datos es con refresh osea va a traer nuevos datos

REFRESH MATERIALIZED VIEW nombre_vista WITH DATA;


REFRESH MATERIALIZED VIEW materias_estudiantes_materializada WITH DATA;


-- para eliminar en cascade


CREATE TABLE inscripcion1
AS 
SELECT * FROM inscripcion;

CREATE TABLE estudiante3
AS 
SELECT * FROM estudiante;

ALTER TABLE inscripcion1 ADD CONSTRAINT pk_ins1 PRIMARY KEY (cod_est,cod_asig);

ALTER TABLE inscripcion1 ADD CONSTRAINT fk_ins1 FOREIGN KEY (cod_est) REFERENCES estudiante3(codigo);
ALTER TABLE inscripcion1 DROP CONSTRAINT fk_ins1 ;
ALTER TABLE inscripcion1 ADD CONSTRAINT fk_ins1 FOREIGN KEY (cod_est) REFERENCES estudiante3(codigo) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE estudiante3 ADD CONSTRAINT pk_est2 PRIMARY KEY (codigo);

UPDATE estudiante3 SET codigo = 30101 WHERE codigo = 3010;
DELETE FROM inscripcion1  WHERE cod_est = 30101;



-- Para generar un type osea un tipo en concreto como por ejemplo un objeto es parecido a una validacion


ALTER TABLE estudiante3 ADD COLUMN genero VARCHAR(15);

CREATE TYPE genero AS ENUM ('Femenino','Masculino');

ALTER TABLE estudiante3 ALTER COLUMN genero TYPE genero USING genero::genero;

INSERT INTO estudiante3 VALUES (307,'Pepito Perez','Masculino') ;


-- Para revisar los usuarios

SELECT * FROM pg_user;

-- Para la cracion de roles

CREATE ROLE profesor CREATEDB LOGIN,

-- Para revisar los roles

SELECT * FROM pg_roles;

-- Para la creacion de usuarios 

CREATE USER profesor PASSWORD 'profesor';


CREATE USER juan PASSWORD 'juan' IN ROLE profesor;

 
-- Los permisos los da el administrador y se dan así con GRANT

GRANT SELECT ON estudiante3 TO juan;

GRANT INSERT ON estudiante3 TO juan;

INSERT INTO estudiante3 VALUES (3080,'Maria Perez','Femenino') ;

GRANT UPDATE ON estudiante3 TO juan;

UPDATE estudiante3 SET genero = 'Masculino' WHERE codigo = 3050;

    -- para darle todos los permisos con el ALL 

    GRANT ALL ON estudiante3 TO juan;

    -- Para quitarle permisos se usa el REVOKE

    REVOKE DELETE ON estudiante3 FROM juan;
