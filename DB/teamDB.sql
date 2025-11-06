CREATE TABLE mysampleschema.employee (
	employee_id INTEGER PRIMARY KEY,
	first_name VARCHAR(50),
	last_name VARCHAR(50)
	)

CREATE TABLE mysampleschema.address (
	street_number INTEGER,
	street_name VARCHAR(100),
	PRIMARY KEY (
		street_number,
		street_name
		),
	city VARCHAR(30),
	state_id VARCHAR(30)
	)

CREATE TABLE mysampleschema.department (
	department_id INTEGER PRIMARY KEY,
	department_name VARCHAR(100),
	street_number INTEGER,
	street_name VARCHAR(100)
	)

ALTER TABLE mysampleschema.department ADD CONSTRAINT fk_address FOREIGN KEY (
	street_number,
	street_name
	) REFERENCES mysampleschema.address (
	street_number,
	street_name
	)

CREATE TABLE mysampleschema.employed (
	employee_id INTEGER,
	department_id INTEGER,
	PRIMARY KEY (
		employee_id,
		department_id
		)
	)

ALTER TABLE mysampleschema.employed ADD CONSTRAINT fk_employee_id FOREIGN KEY (employee_id) REFERENCES mysampleschema.employee (employee_id),
	ADD CONSTRAINT fk_department_id FOREIGN KEY (department_id) REFERENCES mysampleschema.department (department_id)

INSERT INTO mysampleschema.employee
VALUES (
	1,
	'Emma',
	'Johnson'
	);

INSERT INTO mysampleschema.employee
VALUES (
	2,
	'Liam',
	'Patel'
	);

INSERT INTO mysampleschema.employee
VALUES (
	3,
	'Sophia',
	'Chen'
	);

INSERT INTO mysampleschema.employee
VALUES (
	4,
	'Noah',
	'Smith'
	);

INSERT INTO mysampleschema.employee
VALUES (
	5,
	'Ava',
	'Garcia'
	);

INSERT INTO mysampleschema.address
VALUES (
	421,
	'Maple St.',
	'Chicago',
	'IL'
	);

INSERT INTO mysampleschema.address
VALUES (
	77,
	'Park Ave',
	'New York',
	'NY'
	);

INSERT INTO mysampleschema.address
VALUES (
	130,
	'Ocean Blvd',
	'Miami',
	'FL'
	);

INSERT INTO mysampleschema.department
VALUES (
	1,
	'Human Resources',
	421,
	'Maple St.'
	);

INSERT INTO mysampleschema.department
VALUES (
	2,
	'IT Support',
	77,
	'Park Ave'
	);

INSERT INTO mysampleschema.department
VALUES (
	3,
	'Marketing',
	130,
	'Ocean Blvd'
	);

INSERT INTO mysampleschema.employed
VALUES (
	1,
	1
	);

INSERT INTO mysampleschema.employed
VALUES (
	1,
	3
	);

INSERT INTO mysampleschema.employed
VALUES (
	2,
	1
	);

INSERT INTO mysampleschema.employed
VALUES (
	3,
	1
	);

INSERT INTO mysampleschema.employed
VALUES (
	3,
	2
	);

SELECT *
FROM employee
INNER JOIN employed ON employee.employee_id = employed.employee_id
INNER JOIN department ON employed.department_id = department.department_id

SELECT *
FROM department
INNER JOIN employed ON department.department_id = employed.department_id
INNER JOIN employee ON employed.employee_id = employee.employee_id