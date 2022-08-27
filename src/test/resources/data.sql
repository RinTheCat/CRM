insert into products(name) values ('Яблоко');
insert into products(name) values ('Груша');
insert into products(name) values ('Ананас');

insert into clients(name) values ('ИП Иванов Иван');
insert into clients(name) values ('ОАО Ромашка');

-- users

insert into users(username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled)
    values ('petrov.ae', 'qwerty', true , true, true, true);
insert into users(username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled)
    values ('ivanova.ys', 'qwerty1', true , true, true, true);

insert into authorities(authority) values ('ROLE_CLIENT_MANAGER');
insert into authorities(authority) values ('ROLE_HEAD_MANAGER');

insert into user_authorities (user_id, authority_id) values (1, 1);
insert into user_authorities (user_id, authority_id) values (2, 2);

--

insert into orders(status, user_id, client_id) values ('CREATED', 1, 1);
insert into orders(status, user_id, client_id) values ('ASSEMBLY', 1, 1);

insert into product_quantity(order_id, product_id, quantity) values (1, 1, 9);
insert into product_quantity(order_id, product_id, quantity) values (1, 2, 4);
insert into product_quantity(order_id, product_id, quantity) values (2, 1, 4);
insert into product_quantity(order_id, product_id, quantity) values (2, 2, 4);

insert into comments(order_id, text) values(1, 'Документы переданы бухгалтерии');
insert into comments(order_id, text) values(2, 'Пожелание от заказчика: праздничная коробка');
insert into comments(order_id, text) values(1, 'Изменен адрес доставки');
insert into comments(order_id, text) values(2, 'Посылка собрана');