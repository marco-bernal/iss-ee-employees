-- ISS Employees DDL
CREATE TABLE employee
(
  id UUID NOT NULL,
  first_name character varying(50) NOT NULL,
  last_name character varying(50) NOT NULL,
  salary numeric NOT NULL,
  inactive boolean DEFAULT FALSE NOT NULL,
  creation_date TIMESTAMP,
  update_date TIMESTAMP,
  CONSTRAINT employee_pkey PRIMARY KEY (id)
);

CREATE TABLE certification
(
  id UUID NOT NULL,
  name character varying(60) NOT NULL,
  description character varying(150) NOT NULL,
  inactive boolean DEFAULT FALSE NOT NULL,
  creation_date TIMESTAMP,
  update_date TIMESTAMP,
  CONSTRAINT certification_pkey PRIMARY KEY (id)
);

CREATE TABLE employee_certification
(
  employee_id UUID REFERENCES employee(id) NOT NULL,
  certification_id UUID REFERENCES certification(id) NOT NULL
);
