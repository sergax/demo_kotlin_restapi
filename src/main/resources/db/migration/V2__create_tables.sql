create table if not exists photos
(
    id          int          not null primary key auto_increment,
    name        varchar(50)  not null,
    description varchar(100) not null,
    date        datetime     not null,
    url         varchar(1000)  not null,
    user_id     int,
    foreign key (user_id) references users (id) on delete cascade
);

