insert into products(name) values ('Валенки');
insert into products(name) values ('Трактор');
insert into products(name) values ('Мультиварка');
insert into products(name) values ('Статуэтка');
insert into products(name) values ('Тетрадь');
insert into products(name) values ('Памперсы');

insert into clients(name) values ('ИП Иванов И.И.');
insert into clients(name) values ('ООО Рога и копыта');
insert into clients(name) values ('ОАО Ромашка');
insert into clients(name) values ('ФЛ Щербаков Юрий');

insert into users(username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled)
    values ('petrov.ae', 'qwerty', false , false, false, true);
insert into users(username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled)
    values ('kolibelkin.sp', 'qwerty', false , false, false, true);
insert into users(username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled)
    values ('orlov.nk', 'qwerty', false , false, false, true);

insert into orders(status, user_id, client_id) values ('CREATED', 1, 2);
insert into orders(status, user_id, client_id) values ('CREATED', 3, 4);

insert into product_quantity(order_id, product_id, quantity) values (1,1,1);
insert into product_quantity(order_id, product_id, quantity) values (1, 3, 4);
insert into product_quantity(order_id, product_id, quantity) values (2, 6, 1);
insert into product_quantity(order_id, product_id, quantity) values (2, 5, 100);

insert into comments(order_id, text) values(1, 'Документы переданы бухгалтерии');
insert into comments(order_id, text) values(1, 'Пожелание от заказчика: праздничная коробка');
insert into comments(order_id, text) values(2, 'Изменен адрес доставки');
insert into comments(order_id, text) values(2, 'Посылка собрана');