create table if not exists users (
  id int not null primary key auto_increment,
  name varchar(50) not null ,
  age int not null
);