create table account
(
  id int primary key auto_increment,
  name varchar(90) ,
  tel varchar(18),
  email varchar(90),
  address varchar(90),
  reTime timestamp default now()
);
insert into account values (1,'张三','1827475461','234@ff.com','湖南长沙',default);
insert into account values (2,'李四','1827475461','234@ff.com','湖南长沙',default);
insert into account values (3,'万五','1827475461','234@ff.com','湖南长沙',default);
