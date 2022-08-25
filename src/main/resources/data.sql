insert into products(name) values ('Валенки');
insert into products(name) values ('Трактор');
insert into products(name) values ('Мультиварка');
insert into products(name) values ('Статуэтка');
insert into products(name) values ('Тетрадь');
insert into products(name) values ('Памперсы');

insert into clients(name) values ('ИП Иванов И.И.');
insert into clients(name) values ('ООО Ромашка');
insert into clients(name) values ('ОАО Рога и копыта');
insert into clients(name) values ('ФЛ Щербаков Юрий');

insert into users(username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled)
    values ('petrov.ae', 'qwerty', true , true, true, true);
insert into users(username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled)
    values ('kolibelkin.sp', 'qwerty', true , true, true, true);
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

insert into orders(status, user_id, client_id) values ('CREATED', 1, 2);
insert into orders(status, user_id, client_id) values ('CREATED', 3, 4);

insert into product_quantity(order_id, product_id, quantity) values (1, 1, 1);
insert into product_quantity(order_id, product_id, quantity) values (1, 3, 4);
insert into product_quantity(order_id, product_id, quantity) values (2, 6, 1);
insert into product_quantity(order_id, product_id, quantity) values (2, 5, 5);

insert into comments(order_id, text) values(1, 'Документы переданы бухгалтерии');
insert into comments(order_id, text) values(1, 'Пожелание от заказчика: праздничная коробка');
insert into comments(order_id, text) values(2, 'Изменен адрес доставки');
insert into comments(order_id, text) values(2, 'Посылка собрана');