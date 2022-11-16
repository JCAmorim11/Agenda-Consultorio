USE postgres;
CREATE DATABASE agenda_db WITH ENCODING 'UTF8';
DROP DATABASE agenda;
SET ACTIVE agenda_db;

---create tables----
CREATE TABLE IF NOT EXISTS tblMedicos(
	id SERIAL PRIMARY KEY,
	nome VARCHAR (255),
	CRM VARCHAR (255),
	especialidade VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS tblPacientes(
	id SERIAL PRIMARY KEY, 
	nome VARCHAR (255),
	cpf VARCHAR(255),
	telefone VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS tblConsultorios(
	id SERIAL PRIMARY KEY,
	numero_consultorio VARCHAR (20)
);

CREATE TABLE IF NOT EXISTS tblConsultas(
	id SERIAL PRIMARY KEY,
	numero_consulta SERIAL UNIQUE NOT NULL,
	fk_paciente INT NOT NULL,
	fk_medico INT NOT NULL,
	fk_consultorio INT NOT NULL,
	data_consulta TIMESTAMP WITHOUT TIME ZONE,
	status VARCHAR(255),
	FOREIGN KEY (fk_paciente)
      REFERENCES tblPacientes (id),
    FOREIGN KEY (fk_medico)
      REFERENCES tblMedicos (id),
    FOREIGN KEY (fk_medico)
      REFERENCES tblConsultorios (id)  
);
---create tables----

---Inserts-----
---PACIENTES
INSERT INTO tblPacientes (nome,cpf,telefone)
VALUES('Kurt cobain','873435464','957356481');
INSERT INTO tblPacientes (nome,cpf,telefone)
VALUES('Homero Escritor','933265464','957356481');
INSERT INTO tblPacientes (nome,cpf,telefone)
VALUES('Stepho Young','125435464','957356481');
INSERT INTO tblPacientes (nome,cpf,telefone)
VALUES('Geralt de Rivia','2330005464','957356481');
INSERT INTO tblPacientes (nome,cpf,telefone)
VALUES('SONIC','2432435464','95732323481');

---consultorios
INSERT INTO tblConsultorios(numero_consultorio)


---tblmedicos

----consultas
INSERT INTO tblconsultas(numero_consulta, fk_paciente, fk_medico, fk_consultorio, data_consulta, status)
VALUES(1001, 5, 1, 5, TO_TIMESTAMP('2022-07-10 12:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'CONCLUIDA');

INSERT INTO tblconsultas(numero_consulta, fk_paciente, fk_medico, fk_consultorio, data_consulta, status)
VALUES(1002, 2, 3, 5, TO_TIMESTAMP('2022-10-10 01:15:00', 'YYYY-MM-DD HH24:MI:SS'), 'CONCLUIDA');

INSERT INTO tblconsultas(numero_consulta, fk_paciente, fk_medico, fk_consultorio, data_consulta, status)
VALUES(1003, 2, 3, 3, TO_TIMESTAMP('2022-11-10 01:20:00', 'YYYY-MM-DD HH24:MI:SS'), 'CANCELADA');

INSERT INTO tblconsultas(numero_consulta, fk_paciente, fk_medico, fk_consultorio, data_consulta, status)
VALUES(1004, 4, 1, 2, TO_TIMESTAMP('2023-02-10 01:15:00', 'YYYY-MM-DD HH24:MI:SS'), 'PENDENTE');

INSERT INTO tblconsultas(numero_consulta, fk_paciente, fk_medico, fk_consultorio, data_consulta, status)
VALUES(1005, 5, 1, 3, TO_TIMESTAMP('2022-12-11 01:15:00', 'YYYY-MM-DD HH24:MI:SS'), 'PENDENTE');

INSERT INTO tblconsultas(fk_paciente, fk_medico, fk_consultorio, data_consulta, status)
VALUES(4, 2, 2, TO_TIMESTAMP('2022-12-10 01:15:00', 'YYYY-MM-DD HH24:MI:SS'), 'PENDENTE');

INSERT INTO tblconsultas(fk_paciente, fk_medico, fk_consultorio, data_consulta, status)
VALUES(3, 1, 1, TO_TIMESTAMP('2022-12-13 10:15:00', 'YYYY-MM-DD HH24:MI:SS'), 'PENDENTE');

---inserts--------


---SELECTS
SELECT * FROM tblmedicos 
SELECT * FROM tblPacientes
SELECT * FROM tblConsultorios
SELECT * FROM tblConsultas

SELECT t.numero_consulta, t2.nome, t3.nome, t3.especialidade, t4.numero_consultorio, t.data_consulta 
FROM tblconsultas t INNER JOIN tblpacientes t2 on fk_paciente=t2.id 
INNER JOIN tblmedicos t3 ON t.fk_consultorio=t3.id
INNER JOIN tblconsultorios t4 ON t.fk_consultorio=t4.id

---selectS 

----Drops
DROP TABLE IF EXISTS tblConsultas;
DROP TABLE IF EXISTS tblPacientes;
DROP TABLE IF EXISTS tblMedicos;
DROP TABLE IF EXISTS tblConsultorios;
