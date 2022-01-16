INSERT INTO employee(id, name, age)
VALUES ('1', 'Tom', 30);

/* User master */
INSERT INTO m_user(user_id, password, user_name, birthday, age, gender, department_id, role)
VALUES ('trinhtuan@gmail.com', 'password', 'trinh tuan', '2021-11-09', 21, 1, 1, 'ROLE_GENERAL');

/* Department master */
INSERT INTO m_department(department_id, department_name)
VALUES (1, 'Sales'), (2, 'Marketing');

/* Salary table */
INSERT INTO t_salary(user_id, year_month, salary)
VALUES ('trinhtuan@gmail.com', '11/2021', 2880),
       ('trinhtuan1@gmail.com', '12/2021', 3990);