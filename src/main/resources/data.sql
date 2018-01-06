INSERT INTO sys_user (id, name,password)  SELECT 1,'admin','123456' FROM  dual WHERE NOT EXISTS(SELECT * from sys_user where name = 'admin');
INSERT INTO sys_role (id, name)  SELECT 1,'管理员' FROM  dual WHERE NOT EXISTS(SELECT  * from sys_role where name = '管理员');
INSERT INTO sys_user_role (id, user_id, role_id) SELECT 1,1,1 FROM dual WHERE NOT EXISTS(SELECT * from sys_user_role where id = 1);
INSERT INTO sys_permission (id,name,controller) SELECT 1,'用户管理','UserController' FROM dual WHERE NOT EXISTS(SELECT * from sys_permission  WHERE controller= 'UserController' and name='用户管理');
INSERT INTO sys_permission (id,name,controller) SELECT 2,'角色管理','RoleController' FROM dual WHERE NOT EXISTS(SELECT * from sys_permission  WHERE controller= 'RoleController' and name = '角色管理');
INSERT INTO sys_permission (id,name,controller) SELECT 3,'用户管理','PermissionController' FROM dual WHERE NOT EXISTS(SELECT * from sys_permission  WHERE controller= 'PermissionController' and name = '用户管理');
INSERT INTO sys_role_permission (id,role_id,permission_id,value) SELECT 1,1,1,15 FROM dual WHERE NOT EXISTS(SELECT * FROM sys_role_permission WHERE role_id = 1 and permission_id = 1);
INSERT INTO sys_role_permission (id,role_id,permission_id,value) SELECT 2,1,2,15 FROM dual WHERE NOT EXISTS(SELECT * FROM sys_role_permission WHERE role_id = 1 and permission_id = 2);
INSERT INTO sys_role_permission (id,role_id,permission_id,value) SELECT 3,1,3,15 FROM dual WHERE NOT EXISTS(SELECT * FROM sys_role_permission WHERE role_id = 1 and permission_id = 3);