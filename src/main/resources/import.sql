 --the password hash is generated by BCrypt Calculator Generator(https://www.dailycred.com/article/bcrypt-calculator)
INSERT INTO USERS (id, username, password, first_name, last_name, email, phone_number, enabled, last_password_reset_date) VALUES (1, 'user', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Fan', 'Jin', 'user@example.com', '+1234567890', true, '2017-10-01 21:58:58');
INSERT INTO USERS (id, username, password, first_name, last_name, email, phone_number, enabled, last_password_reset_date) VALUES (2, 'admin', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Jing', 'Xiao', 'admin@example.com', '+0987654321', true, '2017-10-01 18:57:58');
INSERT INTO AUTHORITY (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO AUTHORITY (id, name) VALUES (2, 'ROLE_ADMIN');
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 2);

-- insert into meal_type (id, name) values (1, 'BREAKFAST');
-- insert into meal_type (id, name) values (2, 'LUNCH');
-- 
 

--



--INSERT INTO ORDER_BASE (remark, status, sales_order_amount) VALUES ('3DAYS', 'PENDING', 50000);
--INSERT INTO ORDER_BASE (remark, status, sales_order_amount) VALUES ('3DAYS', 'PENDING', 50000);
--INSERT INTO ORDER_BASE (remark, status, sales_order_amount) VALUES ('3DAYS', 'PENDING', 50000);
--INSERT INTO ORDER_BASE (remark, status, sales_order_amount) VALUES ('3DAYS', 'PENDING');
--INSERT INTO ORDER_BASE (remark, status, sales_order_amount) VALUES ('3DAYS', 'PENDING');

--INSERT INTO MEAL(name, cost, volume, description, recipe, sale) VALUES('banh xeo', 30000, 40, 'description for test', 'recipe for test', 30000);
--INSERT INTO MEAL(name, cost, volume, description, recipe, sale) VALUES('banh gai', 25000, 30, 'description for test', 'recipe for test', 30000);
--INSERT INTO MEAL(name, cost, volume, description, recipe, sale) VALUES('banh u', 35000, 35, 'description for test', 'recipe for test', 30000);
--INSERT INTO MEAL(name, cost, volume, description, recipe, sale) VALUES('banh hoi', 15000, 40, 'description for test', 'recipe for test', 30000);
--INSERT INTO MEAL(name, cost, volume, description, recipe, sale) VALUES('banh gio', 30000, 20, 'description for test', 'recipe for test', 30000);
--INSERT INTO MEAL(name, cost, volume, description, recipe, sale) VALUES('banh chung', 25000, 25, 'description for test', 'recipe for test', 30000);
--INSERT INTO MEAL(name, cost, volume, description, recipe, sale) VALUES('banh tao lao', 30000, 40, 'description for test', 'recipe for test', 30000);
--INSERT INTO MEAL(name, cost, volume, description, recipe, sale) VALUES('banh banh', 25000, 40, 'description for test', 'recipe for test', 30000);
--INSERT INTO MEAL(name, cost, volume, description, recipe, sale) VALUES('banh xe', 30000, 40, 'description for test', 'recipe for test', 30000);

--INSERT INTO SHIPMENT (actual_deliver_cost, status) VALUES (20000, 'PENDING');
--
--INSERT INTO SHIP_UNIT (status, shipment_id) VALUES ('PENDING', 1);
--INSERT INTO SHIP_UNIT (status, shipment_id) VALUES ('PENDING', 1);
--INSERT INTO SHIP_UNIT (status, shipment_id) VALUES ('PENDING', 1);
--
--insert into order_detail(day, week_type, menu_type, meal_type, status, meal_id, order_id) values ('MONDAY', 'ONE', 'BREAKFAST','MAINCOURSE', 'PENDING', 1, (select ob.id from order_base ob where ob.id = 1));
--insert into order_detail(day, week_type, menu_type, meal_type, status, meal_id, order_id) values ('MONDAY','ONE', 'BREAKFAST','SIDEDISH', 'PENDING', 2, (select ob.id from order_base ob where ob.id = 1));
--insert into order_detail(day, week_type, menu_type, meal_type, status, meal_id, order_id) values ('TUESDAY','ONE', 'BREAKFAST','DRINK', 'PENDING', 3, (select ob.id from order_base ob where ob.id = 1));
--insert into order_detail(day, week_type, menu_type, meal_type, status, meal_id, order_id) values ('TUESDAY','ONE', 'LUNCH','DRINK', 'PENDING', 4, (select ob.id from order_base ob where ob.id = 1));
--insert into order_detail(day, week_type, menu_type, meal_type, status, meal_id, order_id) values ('WEDNESDAY','ONE',  'LUNCH','MAINCOURSE', 'PENDING', 5, (select ob.id from order_base ob where ob.id = 1));
--insert into order_detail(day, week_type, menu_type, meal_type, status, meal_id, order_id) values ('WEDNESDAY','ONE',  'BREAKFAST','MAINCOURSE', 'PENDING', 4, (select ob.id from order_base ob where ob.id = 1));
--
--insert into order_detail(day, week_type, menu_type, meal_type, status, meal_id, order_id) values ('MONDAY', 'TWO','DINNER', 'MAINCOURSE', 'PENDING', 3, (select ob.id from order_base ob where ob.id = 2));
--insert into order_detail(day, week_type, menu_type, meal_type, status, meal_id, order_id) values ('MONDAY','ONE',  'BREAKFAST','SIDEDISH', 'PENDING', 7, (select ob.id from order_base ob where ob.id = 2));
--insert into order_detail(day, week_type, menu_type, meal_type, status, meal_id, order_id) values ('TUESDAY','ONE', 'BREAKFAST','DRINK', 'PENDING', 1, (select ob.id from order_base ob where ob.id = 2));
--insert into order_detail(day, week_type, menu_type, meal_type, status, meal_id, order_id) values ('TUESDAY','ONE', 'LUNCH','DRINK', 'PENDING', 4, (select ob.id from order_base ob where ob.id = 2));
--insert into order_detail(day, week_type, menu_type, meal_type, status, meal_id, order_id) values ('WEDNESDAY','ONE',  'LUNCH','MAINCOURSE', 'PENDING', 8, (select ob.id from order_base ob where ob.id = 2));
--insert into order_detail(day, week_type, menu_type, meal_type, status, meal_id, order_id) values ('WEDNESDAY','ONE',  'BREAKFAST','MAINCOURSE', 'PENDING', 9, (select ob.id from order_base ob where ob.id = 2));
--
