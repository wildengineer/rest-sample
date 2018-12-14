connect 'jdbc:derby:memory:sample;create=true';

-- in case these are left over from previous tests...
drop table Pet;
drop table Person;

create table Person (
	id bigint not null generated always as identity (start with 1, increment by 1) constraint person_pk primary key,
	firstname varchar(50),
	middlename varchar(50),
	lastname varchar(50)
);

create table Pet(
	id bigint not null generated always as identity (start with 1, increment by 1) constraint pets_pk primary key,
	personId bigint not null constraint pet_fk references Person on delete cascade on update restrict,
	name varchar(50)
);

insert into person (firstname, middlename, lastname) values ('George', null, 'Washington');
insert into person (firstname, middlename, lastname) values ('John', null, 'Adams');
insert into person (firstname, middlename, lastname) values ('Thomas',null,'Jefferson');
insert into person (firstname, middlename, lastname) values ('James',null,'Madison');
insert into person (firstname, middlename, lastname) values ('James' ,null, 'Monroe');
insert into person (firstname, middlename, lastname) values ('John','Quincy','Adams');
insert into person (firstname, middlename, lastname) values ('Andrew',null,'Jackson');
insert into person (firstname, middlename, lastname) values ('Martin',null,'Van Buren');
insert into person (firstname, middlename, lastname) values ('William','Henry','Harrison');
insert into person (firstname, middlename, lastname) values ('John',null,'Tyler');

insert into pet (personId, name) values (1, 'Thomas');
insert into pet (personId, name) values (1, 'Gage');
insert into pet (personId, name) values (2, 'Lucy');
insert into pet (personId, name) values (3, 'Daisy');
insert into pet (personId, name) values (4, 'Luna');
insert into pet (personId, name) values (5, 'Lola');
insert into pet (personId, name) values (6, 'Sadie');
insert into pet (personId, name) values (7, 'Molly');
insert into pet (personId, name) values (8, 'Maggie');
insert into pet (personId, name) values (9, 'Sophie');
insert into pet (personId, name) values (10, 'Bailey');
