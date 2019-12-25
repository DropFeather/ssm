create table student
(
  id int PRIMARY key auto_increment,
  name varchar(50),
  age int
);

create table course
(
  id int PRIMARY key auto_increment,
  name varchar(50)
);
create table score
(
  id int PRIMARY key auto_increment,
  sid int references student (id),
  cid int references  course (id),
  grade FLOAT
);
insert into student values(1,'zs',18);
insert into student values(2,'ls',18);
insert into course values (1,'java');
insert into course values (2,'.Net');
insert into course values (3,'.PHP');
insert into score values (1,1,1,100.0);
insert into score values (2,1,2,98.0);
insert into score values (3,1,3,96.0);
insert into score values (4,2,1,100.0);
insert into score values (5,2,2,98.0);
insert into score values (6,2,3,96.0);

select * from student ;
select * from score  ;
select * from course  ;
