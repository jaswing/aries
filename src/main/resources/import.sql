INSERT INTO aries.t_message(id, message, title) VALUES (1, "こんにちは！", "Welcome!");
INSERT INTO aries.t_user (id, enabled, password, username, first_name, last_name, email_address, male) VALUES (1, true, '1234', 'admin', 'Administrator', 'Root', 'admin@xperad.com', 1);
INSERT INTO aries.t_user (id, enabled, password, username, first_name, last_name, email_address, male) VALUES (2, true, '1234', 'user1', 'Gerry', 'Dicaprio', 'user1@xperad.com', 1);
INSERT INTO aries.t_user (id, enabled, password, username, first_name, last_name, email_address, male) VALUES (3, true, '1234', 'user2', 'Cameron', 'Diaz', 'user2@xperad.com', 0);
INSERT INTO aries.t_role (id, role_name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO aries.t_role (id, role_name) VALUES (2, 'ROLE_USER');
INSERT INTO aries.t_user_role (role_id, user_id) VALUES (1, 1);
INSERT INTO aries.t_user_role (role_id, user_id) VALUES (2, 2);
