create
    database mentorTest;

create table developer
(
    id     int auto_increment primary key,
    name   varchar(255),
    age    int,
    gender enum ('MALE', 'FEMALE')
);

alter table developer
    modify name varchar(255) unique;