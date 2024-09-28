-- ISS
--get all certifications per employee
SELECT e.first_name, e.last_name, c.description
FROM employee e
JOIN employee_certification ec
ON e.id = '3513f636-8969-4d2b-a0c3-636027182994'
JOIN certification c
ON c.id = ec.certification_id;

--get all certifications per all employee
SELECT e.first_name, e.last_name, c.description
FROM employee e
JOIN employee_certification ec
ON e.id = ec.employee_id
JOIN certification c
ON c.id = ec.certification_id;