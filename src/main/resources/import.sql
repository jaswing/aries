INSERT INTO aries.t_message(id, message, title) VALUES (1, "こんにちは！", "Welcome!");
INSERT INTO aries.t_user (id, enabled, password, username) VALUES (1, true, '1234', 'admin');
INSERT INTO aries.t_user (id, enabled, password, username) VALUES (2, true, '1234', 'user1');
INSERT INTO aries.t_role (id, role_name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO aries.t_role (id, role_name) VALUES (2, 'ROLE_USER');
INSERT INTO aries.t_user_roles (role_id, user_id) VALUES (1, 1);
INSERT INTO aries.t_user_roles (role_id, user_id) VALUES (2, 2);
