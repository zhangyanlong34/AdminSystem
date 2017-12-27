INSERT INTO sys_user (id, name,password)  SELECT 1,'admin','123456' FROM  dual WHERE NOT EXISTS(SELECT * from sys_user where name = 'admin');
INSERT INTO sys_role (id, name)  SELECT 1,'管理员' FROM  dual WHERE NOT EXISTS(SELECT  * from sys_role where name = '管理员');
INSERT INTO sys_user_role (id, user_id, role_id) SELECT 1,1,1 FROM dual WHERE NOT EXISTS(SELECT * from sys_user_role where id = 1);
