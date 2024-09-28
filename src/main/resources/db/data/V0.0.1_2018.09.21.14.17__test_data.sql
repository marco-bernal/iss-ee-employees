--employee
INSERT INTO employee(id, first_name, last_name, salary, creation_date)
VALUES ('3513f636-8969-4d2b-a0c3-636027182994', 'Mab', 'Wilcox', 5200, CURRENT_DATE);

--certifications
INSERT INTO certification(id, name, description, creation_date)
VALUES ('cd355f5c-a528-450c-a6a6-1843884fed38', 'Java SE8 OCA', 'Java 8 Oracle Certified Associate', CURRENT_DATE);

INSERT INTO certification(id, name, description, creation_date)
VALUES ('0936354c-9906-57ee-acd5-6129aaa691c1', 'Java SE8 OCP', 'Java 8 Oracle Certified Programmer', CURRENT_DATE);

INSERT INTO certification(id, name, description, creation_date)
VALUES ('008317e6-ffd2-45aa-b5bc-ca28dd4167ce', 'Spring Framework', 'Spring 5 Core Framework', CURRENT_DATE);

INSERT INTO certification(id, name, description, creation_date)
VALUES ('00df7202-144e-4202-aa16-d0da4c0cc44c', 'AWS Cloud Practitioner', 'Fundamental AWS Cloud and industry knowledge', CURRENT_DATE);

INSERT INTO certification(id, name, description, creation_date)
VALUES ('00a1b16b-1f4d-4bd0-a7a2-01001e7a92a8', 'AWS Developer', 'AWS Certified Developer – Associate', CURRENT_DATE);

--Assign certifications to employee
INSERT INTO employee_certification(employee_id, certification_id)
VALUES ('3513f636-8969-4d2b-a0c3-636027182994', 'cd355f5c-a528-450c-a6a6-1843884fed38');

INSERT INTO employee_certification(employee_id, certification_id)
VALUES ('3513f636-8969-4d2b-a0c3-636027182994', '0936354c-9906-57ee-acd5-6129aaa691c1');


