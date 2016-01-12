DROP TABLE IF EXISTS `app_client`;

CREATE TABLE `app_client` (
  `client_id` varchar(100) NOT NULL,
  `client_secret` varchar(100) NOT NULL,
  `client_name` varchar(300) NOT NULL,
  `description` varchar(400) NOT NULL,
  `client_url` varchar(300) NOT NULL,
  `client_type` varchar(20) NOT NULL,
  `scope` varchar(300) DEFAULT NULL,
  `redirect_uri` varchar(400) NOT NULL,
  `reg_date` date DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `client_id_UNIQUE` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
