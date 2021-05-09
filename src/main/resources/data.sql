insert into item(id, name, description, quantity_on_one_pallet, pallets)
values (1, 'Hiper product', 'this is the best description of hiper product', 50, 10),
       (2, 'My super first product', 'this is my super product description', 100, 5),
       (3, 'Galactic one', 'galactic description of galactic product', 75, 10);

insert into transporter(id, name, first_name, last_name, company, vehicle_number)
values (1, 'H&H', 'Brian', 'House', 'House&House', 'XX YYWQY'),
       (2, 'VT', 'Jerry', 'Value', 'Value Transports', 'QQ WWWQE'),
       (3, 'TC', 'John', 'Smith', 'Transport Company', 'XX ZZXXZ');

insert into warehouseman(id, name, first_name, last_name)
values (1, '110A', 'John', 'Example'),
       (2, '120A', 'Maria', 'Smith'),
       (3, '130A', 'Daniel', 'Beer');

insert into delivery(id, date, items_quantity, departure, transporter_id, warehouseman_id)
values (1, '2020-02-02 16:00:00', 1000, false, 1, 1),
       (2, '2020-03-03 17:30:00', 1000, false, 2, 2),
       (3, '2020-04-04 09:00:30', 1500, false, 3, 3),
       (4, '2020-05-05 10:10:10', 500, true, 2, 3),
       (5, '2020-06-06 11:00:00', 500, true, 3, 1),
       (6, '2020-07-07 12:12:00', 750, true, 1, 2);

insert into delivery_item(delivery_id, item_id)
values (1, 1),
       (2, 2),
       (3, 3),
       (4, 1),
       (5, 2),
       (6, 3);
