insert into products(name) values ('Яблоко');
insert into products(name) values ('Груша');
insert into products(name) values ('Ананас');
insert into products(name) values ('Картошка');
insert into products(name) values ('Сельдерей');
insert into products(name) values ('Капуста');
insert into products(name) values ('Арбуз');
insert into products(name) values ('Земляника');
insert into products(name) values ('Клубника');
insert into products(name) values ('Нектарин');
insert into products(name) values ('Персик');
insert into products(name) values ('Дыня');
insert into products(name) values ('Укроп');
insert into products(name) values ('Мандарин');
insert into products(name) values ('Апельсин');

insert into clients(name) values ('ИП Иванов Иван');
insert into clients(name) values ('ООО Ромашка');
insert into clients(name) values ('ФЛ Щербаков Юрий');
insert into clients(name) values ('ФЛ Новицкий Владислав');
insert into clients(name) values ('ФЛ Степанова Ирина');

-- users

insert into users(username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled)
    values ('petrov.ae', 'qwerty', true , true, true, true);
insert into users(username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled)
    values ('dobrotin.va', 'qwerty', true , true, true, true);
insert into users(username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled)
    values ('orlov.nk', 'qwerty', true , true, true, true);
insert into users(username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled)
    values ('ivanova.ys', 'qwerty1', true , true, true, true);

insert into authorities(authority) values ('ROLE_CLIENT_MANAGER');
insert into authorities(authority) values ('ROLE_HEAD_MANAGER');

insert into user_authorities (user_id, authority_id) values (1, 1);
insert into user_authorities (user_id, authority_id) values (2, 1);
insert into user_authorities (user_id, authority_id) values (3, 1);
insert into user_authorities (user_id, authority_id) values (4, 2);

--

insert into orders(status, user_id, client_id) values ('CREATED', 1, 1);
insert into orders(status, user_id, client_id) values ('CREATED', 2, 2);
insert into orders(status, user_id, client_id) values ('CREATED', 3, 3);
insert into orders(status, user_id, client_id) values ('CREATED', 1, 4);
insert into orders(status, user_id, client_id) values ('CREATED', 2, 5);
insert into orders(status, user_id, client_id) values ('ASSEMBLY', 3, 1);
insert into orders(status, user_id, client_id) values ('ASSEMBLY', 1, 2);
insert into orders(status, user_id, client_id) values ('ASSEMBLY', 2, 3);
insert into orders(status, user_id, client_id) values ('ASSEMBLY', 3, 4);
insert into orders(status, user_id, client_id) values ('ASSEMBLY', 1, 5);
insert into orders(status, user_id, client_id) values ('INSPECTION', 2, 1);
insert into orders(status, user_id, client_id) values ('INSPECTION', 3, 2);
insert into orders(status, user_id, client_id) values ('INSPECTION', 1, 3);
insert into orders(status, user_id, client_id) values ('INSPECTION', 2, 4);
insert into orders(status, user_id, client_id) values ('INSPECTION', 3, 5);
insert into orders(status, user_id, client_id) values ('SENT', 1, 1);
insert into orders(status, user_id, client_id) values ('SENT', 2, 2);
insert into orders(status, user_id, client_id) values ('SENT', 3, 3);
insert into orders(status, user_id, client_id) values ('SENT', 1, 4);
insert into orders(status, user_id, client_id) values ('SENT', 2, 5);
insert into orders(status, user_id, client_id) values ('CLOSED', 3, 1);
insert into orders(status, user_id, client_id) values ('CLOSED', 1, 2);
insert into orders(status, user_id, client_id) values ('CLOSED', 2, 3);
insert into orders(status, user_id, client_id) values ('CLOSED', 3, 4);
insert into orders(status, user_id, client_id) values ('CLOSED', 1, 5);
insert into orders(status, user_id, client_id) values ('CANCELLED', 2, 1);
insert into orders(status, user_id, client_id) values ('CANCELLED', 3, 2);
insert into orders(status, user_id, client_id) values ('CANCELLED', 1, 3);
insert into orders(status, user_id, client_id) values ('CANCELLED', 2, 4);
insert into orders(status, user_id, client_id) values ('CANCELLED', 3, 5);

insert into product_quantity(order_id, product_id, quantity) values (1, 1, 1);
insert into product_quantity(order_id, product_id, quantity) values (1, 2, 4);
insert into product_quantity(order_id, product_id, quantity) values (2, 3, 4);
insert into product_quantity(order_id, product_id, quantity) values (2, 4, 4);
insert into product_quantity(order_id, product_id, quantity) values (3, 5, 1);
insert into product_quantity(order_id, product_id, quantity) values (3, 6, 4);
insert into product_quantity(order_id, product_id, quantity) values (4, 7, 4);
insert into product_quantity(order_id, product_id, quantity) values (4, 8, 4);
insert into product_quantity(order_id, product_id, quantity) values (5, 9, 1);
insert into product_quantity(order_id, product_id, quantity) values (5, 10, 4);
insert into product_quantity(order_id, product_id, quantity) values (6, 11, 4);
insert into product_quantity(order_id, product_id, quantity) values (6, 12, 4);
insert into product_quantity(order_id, product_id, quantity) values (7, 13, 1);
insert into product_quantity(order_id, product_id, quantity) values (7, 14, 4);
insert into product_quantity(order_id, product_id, quantity) values (8, 15, 4);
insert into product_quantity(order_id, product_id, quantity) values (8, 1, 4);
insert into product_quantity(order_id, product_id, quantity) values (9, 2, 1);
insert into product_quantity(order_id, product_id, quantity) values (9, 3, 4);
insert into product_quantity(order_id, product_id, quantity) values (10, 4, 4);
insert into product_quantity(order_id, product_id, quantity) values (10, 5, 4);
insert into product_quantity(order_id, product_id, quantity) values (11, 6, 1);
insert into product_quantity(order_id, product_id, quantity) values (11, 7, 4);
insert into product_quantity(order_id, product_id, quantity) values (12, 8, 4);
insert into product_quantity(order_id, product_id, quantity) values (12, 9, 4);
insert into product_quantity(order_id, product_id, quantity) values (13, 10, 1);
insert into product_quantity(order_id, product_id, quantity) values (13, 11, 4);
insert into product_quantity(order_id, product_id, quantity) values (14, 12, 4);
insert into product_quantity(order_id, product_id, quantity) values (14, 13, 4);
insert into product_quantity(order_id, product_id, quantity) values (15, 14, 4);
insert into product_quantity(order_id, product_id, quantity) values (15, 15, 1);
insert into product_quantity(order_id, product_id, quantity) values (16, 1, 4);
insert into product_quantity(order_id, product_id, quantity) values (16, 2, 4);
insert into product_quantity(order_id, product_id, quantity) values (17, 3, 4);
insert into product_quantity(order_id, product_id, quantity) values (17, 4, 1);
insert into product_quantity(order_id, product_id, quantity) values (18, 5, 4);
insert into product_quantity(order_id, product_id, quantity) values (18, 6, 4);
insert into product_quantity(order_id, product_id, quantity) values (19, 7, 4);
insert into product_quantity(order_id, product_id, quantity) values (19, 8, 1);
insert into product_quantity(order_id, product_id, quantity) values (20, 9, 4);
insert into product_quantity(order_id, product_id, quantity) values (20, 10, 4);
insert into product_quantity(order_id, product_id, quantity) values (21, 11, 4);
insert into product_quantity(order_id, product_id, quantity) values (21, 12, 2);
insert into product_quantity(order_id, product_id, quantity) values (22, 13, 4);
insert into product_quantity(order_id, product_id, quantity) values (22, 14, 4);
insert into product_quantity(order_id, product_id, quantity) values (23, 15, 4);
insert into product_quantity(order_id, product_id, quantity) values (23, 1, 2);
insert into product_quantity(order_id, product_id, quantity) values (24, 2, 4);
insert into product_quantity(order_id, product_id, quantity) values (24, 3, 4);
insert into product_quantity(order_id, product_id, quantity) values (25, 4, 4);
insert into product_quantity(order_id, product_id, quantity) values (25, 5, 2);
insert into product_quantity(order_id, product_id, quantity) values (26, 6, 4);
insert into product_quantity(order_id, product_id, quantity) values (26, 7, 4);
insert into product_quantity(order_id, product_id, quantity) values (27, 8, 4);
insert into product_quantity(order_id, product_id, quantity) values (27, 9, 2);
insert into product_quantity(order_id, product_id, quantity) values (28, 10, 4);
insert into product_quantity(order_id, product_id, quantity) values (28, 11, 4);
insert into product_quantity(order_id, product_id, quantity) values (29, 12, 4);
insert into product_quantity(order_id, product_id, quantity) values (29, 13, 4);
insert into product_quantity(order_id, product_id, quantity) values (30, 14, 4);
insert into product_quantity(order_id, product_id, quantity) values (30, 15, 4);

insert into comments(order_id, text) values(1, 'Документы переданы бухгалтерии');
insert into comments(order_id, text) values(2, 'Пожелание от заказчика: праздничная коробка');
insert into comments(order_id, text) values(3, 'Изменен адрес доставки');
insert into comments(order_id, text) values(4, 'Посылка собрана');