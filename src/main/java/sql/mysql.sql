use soc;create table employee(id int not null auto_increment, name varchar(50) not null, salary int, primary key (id));
show tables;
alter table employee modify column age int default 0;

update employee set age =0 where age is null and id > 0;

update employee set age=floor(rand() * 60) +18 where id >0;

insert into employee (name, salary) values ('zeeshan', 1000), ('shaikh', 2000);
delete from employee where id in (2,3,4);
Select * from employee where name='Aaron Mitchell';
show index from employee where Column_name = 'name';
create index idx_name on employee (name);
select * from employee;
select count(*) from employee;
create database soc;
show databases;

-- to check if connection is working
select 1;

-- remove duplicates
-- delete e1 from employee e1 , employee e2 where e1.name=e2.name and e1.id >0;

-- multiple insert query
INSERT INTO employee (name, salary)
VALUES 
  ('John Doe', 50000),
  ('Jane Smith', 60000),
  ('Bob Johnson', 70000),
  ('Alice Williams', 55000),
  ('Tom Wilson', 65000),
  ('Julie Brown', 75000),
  ('Mike Davis', 80000),
  ('Sarah Lee', 45000),
  ('Chris Baker', 90000),
  ('Linda Jones', 55000),
  ('Samuel Miller', 60000),
  ('Emily Taylor', 70000),
  ('Daniel Anderson', 75000),
  ('Karen Moore', 55000),
  ('Alex Johnson', 65000),
  ('Olivia Garcia', 80000),
  ('William Taylor', 45000),
  ('Isabella Hernandez', 90000),
  ('Michael Martinez', 55000),
  ('Sophia Jackson', 60000),
  ('Robert Davis', 70000),
  ('Ava Miller', 75000),
  ('Jacob Wilson', 55000),
  ('Mia Anderson', 65000),
  ('David Perez', 80000),
  ('Emma Gonzalez', 45000),
  ('Ethan Carter', 90000),
  ('Grace Martin', 55000),
  ('Noah Ramirez', 60000),
  ('Madison Foster', 70000),
  ('James Cooper', 75000),
  ('Chloe Collins', 55000),
  ('Logan Reed', 65000),
  ('Natalie Bailey', 80000),
  ('Benjamin Murphy', 45000),
  ('Audrey Cox', 90000),
  ('Mason Flores', 55000),
  ('Avery Perry', 60000),
  ('Evelyn Bryant', 70000),
  ('Lucas Nelson', 75000),
  ('Hannah Torres', 55000),
  ('Alexander Gray', 65000),
  ('Elizabeth West', 80000),
  ('Jackson Mitchell', 45000),
  ('Scarlett Reyes', 90000),
  ('Elijah Hill', 55000),
  ('Aria Cruz', 60000),
  ('Gabriel Gonzalez', 70000),
  ('Sofia Peterson', 75000),
  ('Caleb Bell', 55000),
  ('Victoria Ramirez', 65000),
  ('Grayson Cooper', 80000),
  ('Leah Collins', 45000),
  ('Luke Reed', 90000),
  ('Zoe Bailey', 55000),
  ('Isaac Murphy', 60000),
  ('Bella Cox', 70000),
  ('Landon Flores', 75000),
  ('Genesis Perry', 55000),
  ('Mateo Bryant', 65000),
  ('Lillian West', 80000),
  ('Christopher Mitchell', 45000),
  ('Aaliyah Reyes', 90000),
  ('Nathan Hill', 55000),
  ('Arianna Cruz', 60000),
  ('Nicholas Gonzalez', 70000),
  ('Aubrey Peterson', 75000),
  ('Eva Bell', 55000),
  ('Ryan Ramirez', 65000),
  ('Adam Cooper', 80000),
  ('Maria Collins', 45000),
  ('Owen Reed', 90000),
  ('Lila Bailey', 55000),
  ('Sebastian Murphy', 60000),
  ('Avery Cox', 70000),
('Phillips Flores', 75000),
('Adeline Perry', 55000),
('Julian Bryant', 65000),
('Makayla West', 80000),
('Aaron Mitchell', 45000),
('Genesis Reyes', 90000),
('Eli Hill', 55000),
('Samantha Cruz', 60000),
('Dominic Gonzalez', 70000),
('Naomi Peterson', 75000),
('Zachary Bell', 55000),
('Allison Ramirez', 65000),
('Christian Cooper', 80000),
('Alyssa Collins', 45000),
('Levi Reed', 90000),
('Aubree Bailey', 55000),
('Carter Murphy', 60000),
('Jasmine Cox', 70000),
('Miles Flores', 75000),
('Autumn Perry', 55000),
('Jordan Bryant', 65000),
('Brooklyn West', 80000),
('Caden Mitchell', 45000),
('Savannah Reyes', 90000),
('Asher Hill', 55000),
('Taylor Cruz', 60000),
('Isabelle Gonzalez', 70000),
('Parker Peterson', 75000),
('Lila Bell', 55000),
('Nicholas Ramirez', 65000),
('Hazel Cooper', 80000),
('Mason Collins', 45000),
('Wyatt Reed', 90000),
('Lucy Bailey', 55000),
('Leah Murphy', 60000),
('Landon Cox', 70000),
('Riley Flores', 75000),
('Claire Perry', 55000),
('Charlie Bryant', 65000),
('Nova West', 80000),
('Oscar Mitchell', 45000),
('Katherine Reyes', 90000),
('Theodore Hill', 55000),
('Lauren Cruz', 60000),
('Elena Gonzalez', 70000),
('Levi Peterson', 75000),
('Aria Bell', 55000),
('Julian Ramirez', 65000),
('Addison Cooper', 80000),
('Mila Collins', 45000),
('Ethan Reed', 90000),
('Avery Bailey', 55000),
('Emma Murphy', 60000),
('Daniel Cox', 70000),
('Gabriella Flores', 75000),
('Evan Perry', 55000),
('Violet Bryant', 65000),
('Madelyn West', 80000),
('Connor Mitchell', 45000),
('Sofia Reyes', 90000),
('Evelyn Hill', 55000),
('Aiden Cruz', 60000),
('Angel Gonzalez', 70000),
('Hudson Peterson', 75000),
('Avery Bell', 55000),
('Caroline Ramirez', 65000),
('William Cooper', 80000),
('Madeline Collins', 45000),
('Caleb Reed', 90000),
('Makenna Bailey', 55000),
('Nicholas Murphy', 60000),
('Natalie Cox', 70000),
('Owen Flores', 75000),
('Aurora Perry', 55000),
('Tyler Bryant', 65000),
('Brielle West', 80000),
('Amelia Reyes', 90000),
('Gavin Hill', 55000),
('Eva Cruz', 60000),
('Diego Gonzalez', 70000),
('Emma Peterson', 75000),
('Nora Bell', 55000),
('Henry Ramirez', 65000),
('Sophie Cooper', 80000),
('Anthony Collins', 45000),
('Olivia Reed', 90000),
('Liam Bailey', 55000),
('Aaliyah Murphy', 60000),
('Cameron Cox', 70000),
('Liliana Flores', 75000),
('Alex Perry', 55000),
('Gabriel Bryant', 65000),
('Samantha West', 80000),
('Leah Mitchell', 45000),
('Elizabeth Reyes', 90000),
('Isaiah Hill', 55000),
('Chloe Cruz', 60000),
('Julia Gonzalez', 70000),
('Nicholas Peterson', 75000),
('Avery Bell', 55000),
('Sophia Ramirez', 65000),
('David Cooper', 80000),
('Avery Collins', 45000),
('Charlotte Reed', 90000),
('Adam Bailey', 55000),
('Isabella Murphy', 60000),
('Caleb Cox', 70000),
('Evelyn Flores', 75000),
('Anthony Perry', 55000),
('Landon Bryant', 65000),
('Aria West', 80000),
('Sofia Mitchell', 45000),
('Ethan Reyes', 90000),
('Lila Hill', 55000),
('Lucas Cruz', 60000),
('Camila Gonzalez', 70000),
('Emma Peterson', 75000),
('Ethan Bell', 55000),
('Avery Ramirez', 65000),
('Makayla Cooper', 80000),
('Levi Collins', 45000),
('Aubrey Reed', 90000),
('Carter Bailey', 55000),
('Sophie Murphy', 60000),
('Daniel Cox', 70000),
('Madison Flores', 75000),
('Lucas Perry', 55000),
('Avery Bryant', 65000),
('Aaliyah West', 80000),
('Jacob Mitchell', 45000),
('Aria Reyes', 90000),
('Jayden Hill', 55000),
('Eleanor Cruz', 60000),
('Sebastian Gonzalez', 70000),
('Hazel Peterson', 75000),
('Carter Bell', 55000),
('Evelyn Ramirez', 65000),
('Benjamin Cooper', 80000),
('Amelia Collins', 45000),
('Landon Reed', 90000),
('Lila Bailey', 55000),
('Natalie Murphy', 60000),
('Elijah Cox', 70000),
('Avery Flores', 75000),
('Mila Perry', 55000),
('Zachary Bryant', 65000),
('Isabella West', 80000),
('Owen Mitchell', 45000),
('Gabrielle Reyes', 90000),
('Henry Hill', 55000),
('Scarlett Cruz', 60000),
('Julian Gonzalez', 70000),
('Anthony Bell', 55000),
('Victoria Ramirez', 65000),
('Christopher Cooper', 80000),
('Chloe Collins', 45000),
('Maxwell Reed', 90000),
('Penelope Bailey', 55000),
('Oscar Murphy', 60000),
('Sofia Cox', 70000),
('Gabriel Flores', 75000),
('Madelyn Perry', 55000),
('Avery Bryant', 65000),
('Liam West', 80000),
('Ava Mitchell', 45000),
('Charlotte Reyes', 90000),
('Aiden Hill', 55000),
('Avery Cruz', 60000),
('Lila Gonzalez', 70000),
('William Peterson', 75000),
('Mia Bell', 55000),
('Gabriel Ramirez', 65000),
('Aubrey Cooper', 80000),
('Avery Collins', 45000),
('Aria Reed', 90000),
('Ethan Bailey', 55000),
('Luna Murphy', 60000),
('Caleb Cox', 70000),
('Leah Flores', 75000),
('Isaac Perry', 55000),
('Avery Bryant', 65000),
('Madison West', 80000),
('Noah Mitchell', 45000),
('Samantha Reyes', 90000),
('Nathan Hill', 55000),
('Mila Cruz', 60000),
('Lucas Gonzalez', 70000),
('Lila Peterson', 75000),
('Ella Bell', 55000),
('Jacob Ramirez', 65000),
('Chloe Cooper', 80000),
('Cameron Collins', 45000),
('Sophie Reed', 90000),
('Gabriel Bailey', 55000),
('Evelyn Murphy', 60000),
('Avery Cox', 70000),
('Aria Flores', 75000),
('Landon Perry', 55000),
('Audrey Bryant', 65000),
('Alexander West', 80000),
('Ethan Mitchell', 45000),
('Sofia Reyes', 90000),
('Luke Hill', 55000),
('Lily Cruz', 60000),
('Diego Gonzalez', 70000),
('Emma Peterson', 75000),
('William Bell', 55000),
('Leah Ramirez', 65000),
('Daniel Cooper', 80000),
('Avery Collins', 45000),
('Olivia Reed', 90000),
('Liam Bailey', 55000),
('Aaliyah Murphy', 60000),
('Caleb Cox', 70000),
('Liliana Flores', 75000),
('Alex Perry', 55000),
('Gabriel Bryant', 65000),
('Samantha West', 80000),
('Leah Mitchell', 45000),
('Elizabeth Reyes', 90000),
('Isaiah Hill', 55000),
('Chloe Cruz', 60000),
('Julia Gonzalez', 70000),
('Nicholas Peterson', 75000),
('Avery Bell', 55000),
('Sophia Ramirez', 65000),
('David Cooper', 80000),
('Avery Collins', 45000),
('Ethan Bailey', 55000),
('Luna Murphy', 60000),
('Caleb Cox', 70000),
('Leah Flores', 75000),
('Isaac Perry', 55000),
('Avery Bryant', 65000),
('Madison West', 80000),
('Noah Mitchell', 45000),
('Samantha Reyes', 90000),
('Nathan Hill', 55000),
('Mila Cruz', 60000),
('Lucas Gonzalez', 70000),
('Lila Peterson', 75000),
('Ella Bell', 55000),
('Jacob Ramirez', 65000),
('Chloe Cooper', 80000),
('Cameron Collins', 45000),
('Sophie Reed', 90000),
('Gabriel Bailey', 55000),
('Evelyn Murphy', 60000),
('Avery Cox', 70000),
('Aria Flores', 75000),
('Landon Perry', 55000),
('Audrey Bryant', 65000),
('Alexander West', 80000),
('Ethan Mitchell', 45000),
('Sofia Reyes', 90000),
('Luke Hill', 55000),
('Lily Cruz', 60000),
('Diego Gonzalez', 70000),
('Emma Peterson', 75000),
('William Bell', 55000),
('Leah Ramirez', 65000),
('Daniel Cooper', 80000),
('Avery Collins', 45000),
('Olivia Reed', 90000),
('Liam Bailey', 55000),
('Aaliyah Murphy', 60000),
('Caleb Cox', 70000),
('Liliana Flores', 75000),
('Alex Perry', 55000),
('Gabriel Bryant', 65000),
('Samantha West', 80000),
('Leah Mitchell', 45000),
('Elizabeth Reyes', 90000),
('Isaiah Hill', 55000),
('Chloe Cruz', 60000),
('Julia Gonzalez', 70000),
('Nicholas Peterson', 75000),
('Avery Bell', 55000),
('Sophia Ramirez', 65000),
('David Cooper', 80000),
('Avery Collins', 45000),
('Charlotte Reed', 90000),
('Oliver Bailey', 55000),
('Aria Murphy', 60000),
('Lucas Cox', 70000),
('Avery Flores', 75000),
('Julia Perry', 55000),
('Avery Bryant', 65000),
('Sophia West', 80000),
('Aiden Mitchell', 45000),
('Aria Reyes', 90000),
('Lila Hill', 55000),
('Liam Cruz', 60000),
('Victoria Gonzalez', 70000),
('Christopher Peterson', 75000),
('Chloe Bell', 55000),
('Maxwell Ramirez', 65000),
('Penelope Cooper', 80000),
('Oscar Collins', 45000),
('Sofia Reed', 90000),
('Gabriel Bailey', 55000),
('Madelyn Murphy', 60000),
('Avery Cox', 70000),
('Landon Flores', 75000);