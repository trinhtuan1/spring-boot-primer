INSERT INTO employee(id, name, age)
VALUES ('1', 'Tom', 30);

/* User master */
INSERT INTO m_user(user_id, password, user_name, birthday, age, gender, department_id, role)
VALUES ('tuan1@gmail.com', 'password1', 'trinh tuan', '1995-11-09', 26, 1, 1, 'ROLE_GENERAL'),
       ('tuan2@gmail.com', 'password2', 'trinh tuan1', '1995-11-09', 26, 1, 2, 'ROLE_GENERAL'),
       ('tuan3@gmail.com', 'password3', 'trinh tuan2', '2005-11-09', 16, 1, 2, 'ROLE_GENERAL');

/* Department master */
INSERT INTO m_department(department_id, department_name)
VALUES (1, 'Sales'), (2, 'Marketing');

/* Salary table */
INSERT INTO t_salary(user_id, year_month, salary)
VALUES ('tuan1@gmail.com', '10/2021', 2323),
       ('tuan1@gmail.com', '11/2021', 2880),
       ('tuan1@gmail.com', '12/2021', 3990);