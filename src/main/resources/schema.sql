CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) DEFAULT NULL,
  `password` VARCHAR(255) DEFAULT NULL ,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `sys_role` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `sys_permission` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) DEFAULT NULL,
  `controller` VARCHAR(255) DEFAULT NULL ,
  `value` INT(4),
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `user_id` INT(10) NOT NULL ,
  `role_id` INT(10) NOT NULL ,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_user_role` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `FK_role_user` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
);

CREATE TABLE IF NOT EXISTS `sys_role_permission` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `role_id` INT(10) NOT NULL ,
  `permission_id` INT(10) NOT NULL ,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_permission_role` FOREIGN KEY (`permission_id`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `FK_role_permission` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
);






