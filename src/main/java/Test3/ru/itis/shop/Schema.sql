create table product (
                         id serial unique not null,
                         name char(35) not null,
                         cost integer check(cost > -1)
);

insert into product (name, cost) values ('Kefir', 75);
insert into product (name, cost) values ('Apple', 110);
insert into product (name, cost) values ('Bread', 40);
insert into product (name, cost) values ('Chocolate MILKA', 150);
insert into product (name, cost) values ('Chupa chups', 9);
