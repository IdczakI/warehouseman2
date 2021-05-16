insert into item(id, name, description, quantity_on_one_pallet, pallets)
values (1, 'Hiper product', 'this is the best description of hiper product', 50, 10),
       (2, 'My super first product', 'this is my super product description', 100, 5),
       (3, 'Galactic one', 'galactic description of galactic product', 75, 10),
       (4, 'Special', 'Top Secret', 26, 1),
       (5, 'Joker', 'one, two, Joker', 56, 0);

insert into transporter(id, name, first_name, last_name, company, vehicle_number)
values (1, 'H&H', 'Brian', 'House', 'House&House', 'XX YYWQY'),
       (2, 'VT', 'Jerry', 'Value', 'Value Transports', 'QQ WWWQE'),
       (3, 'TC', 'John', 'Smith', 'Transport Company', 'XX ZZXXZ');

insert into warehouseman(id, name, first_name, last_name, password)
values (1, '110A', 'John', 'Example', '{noop}123'),
       (2, '120A', 'Maria', 'Smith','{noop}123'),
       (3, '130A', 'Daniel', 'Beer','{bcrypt}$2a$10$hD7XOspIHd09GDbMwbapVO/oas9NB/2eT3VZmhhSI7TZ9xUCbrHCm');

insert into delivery(id, date, pallets_quantity, departure, item_id, transporter_id, warehouseman_id)
values (1, '2021-02-02 16:00:00', 20, false, 1, 1, 1),
       (2, '2021-03-03 17:30:00', 10, false, 2, 2, 2),
       (3, '2021-04-04 09:00:30', 15, false, 3, 3, 3),
       (4, '2021-05-05 10:10:10', 20, true, 1, 2, 3),
       (5, '2021-01-06 11:00:00', 12, true, 2, 3, 1),
       (6, '2021-02-07 12:12:00', 12, true, 3, 1, 2),
       (7, '2021-02-07 15:15:23', 1, false, 4, 1, 2);

insert into user_role(id, role, description)
values (1, 'USER_ROLE', 'default');

insert into roles(user_id, role_id)
values (1, 1),
       (2, 1),
       (3, 1);

