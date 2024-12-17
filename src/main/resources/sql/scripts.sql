CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `pwd` varchar(200) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`)
);

CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `roles_ibfk_1` FOREIGN KEY(`user_id`) REFERENCES `userinfo`(`user_id`)
);

Insert into `roles` (`user_id`, `role`) values ('1', 'ROLE_USER');
Insert into `roles` (`user_id`, `role`) values ('1', 'ROLE_ADMIN');
Insert into `roles` (`user_id`, `role`) values ('2', 'ROLE_ADMIN');
Insert into `roles` (`user_id`, `role`) values ('3', 'ROLE_USER');

CREATE TABLE `orderitem` (
    `itemOrderId` INT AUTO_INCREMENT PRIMARY KEY,
    `quantity` INT NOT NULL,
    `order_id` INT NOT NULL,
    `item_id` INT NOT NULL,
    FOREIGN KEY (`order_id`) REFERENCES `orderdetails`(`id`)
    FOREIGN KEY (`item_id`) REFERENCES `item`(`item_id`)
);

CREATE TABLE `orderdetails` (
    id INT AUTO_INCREMENT PRIMARY KEY
);



