Drop table if exists bookedTicket;
Drop table if exists ticket;
Drop table if exists carriage;
Drop table if exists accordanceTypeCarriageSeats;
Drop table if exists seats;
Drop table if exists stops;
Drop table if exists trips;
Drop table if exists cities;
Create Table cities (
name varchar Primary key
);

Create Table trips(
ID serial primary key,
number varchar,
city_from varchar references cities(name) ON DELETE RESTRICT,
city_to varchar references cities(name) ON DELETE RESTRICT,
departure_date timestamp
--foreign key(city_to)references cities(name) ON DELETE RESTRICT
);

create Table stops(
ID serial primary key,
arrive_date timestamp,
tripID integer references trips(ID),
city varchar references cities(name)
);

create table seats(
ID serial primary key,
typeSeat varchar,
numberSeat integer,
typeCarriage varchar,
);

create table accordanceTypeCarriageSeats(
typeCarriage varchar primary key,
);


create table carriage(
ID serial primary key,
tripID integer references trips(ID),
typeCarr varchar references accordanceTypeCarriageSeats(typeCarriage) ON DELETE RESTRICT,
numberCarriage integer
);

create Table ticket(
ID serial primary key,
tripID integer references trips(ID),
city_from varchar references cities(name) ON DELETE RESTRICT,
city_to varchar references cities(name) ON DELETE RESTRICT,
departure_date timestamp,
seatID integer references seats(ID),
carrID integer references carriage(ID),
customerFirstName varchar
);

create table bookedTicket(
ID serial primary key,
ticketID integer references ticket(ID),
stopFromID integer references stops(ID) ON DELETE RESTRICT,
stopToID integer references stops(ID) ON DELETE RESTRICT
);



insert into cities values('msk');
insert into cities values('chelybinsk');
insert into cities values('omsk');
insert into cities values('novosibirsk');
insert into cities values('krasnoyrsk');
insert into cities values('irkutsk');
insert into cities values('habarovsk');
insert into cities values('vladivostok');




--Владивосток-Москва

--1. москва-Владивосток
--2. Омск -Владивосток -trip
--3.москва-Омск
--4.Иркутск- Владивосток
-- Москва-Иркутск


--insert into trips values(,'A-1','msk','omsk','2018-04-01 21:00:00');
insert into trips(id, number,city_from,city_to,departure_date)
values(100,'A-1','vladivostok','msk','2018-04-01 21:00:00');
insert into trips(number,city_from,city_to,departure_date)
values(101,'A-2','omsk','krasnoyrsk','2018-04-15 19:30:00'),
values(102,'A-2','omsk','krasnoyrsk','2018-04-15 19:30:00');

insert into accordanceTypeCarriageSeats values
('малый'),
('крупный');

insert into seats(typeSeat,numberSeat, typeCarriage) values
('Стоячие', 1, 'small'),
('Стоячие', 2, 'small'),
('Стоячие', 3, 'large'),
('Стоячие', 4, 'large'),
('Лежачие', 5, 'large'),
('Лежачие', 6, 'large'),
('Лежачие', 1, 'small'),
('Лежачие', 2, 'small');

insert into carriage(tripID, typeCarr, numberCarriage) values
values(100,'малый','2');
values(100,'крупный','1');
values(101,'малый','2');
values(101,'крупный','1');
values(102,'крупный','2');
values(102,'малый','1');
values(103,'крупный','2');
values(103,'малый','1');


