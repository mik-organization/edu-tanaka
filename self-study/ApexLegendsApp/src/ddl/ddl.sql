-- apex_db.m_apex definition

/* ApexÉ}ÉXÉ^çÏê¨ */
CREATE TABLE `m_apex` (
  `regends_id` int NOT NULL AUTO_INCREMENT,
  `regends_name` varchar(32) NOT NULL,
  `real_name` varchar(32) NOT NULL,
  `age` varchar(32) NOT NULL,
  `gender` varchar(32) NOT NULL,
  `regends_class` varchar(32) NOT NULL,
  `abilities` varchar(32) NOT NULL,
  `abi_description` varchar(255) NOT NULL,
  `passive` varchar(32) NOT NULL,
  `pas_description` varchar(255) NOT NULL,
  `ult` varchar(32) NOT NULL,
  `ult_description` varchar(255) NOT NULL,
  `words` varchar(255) NOT NULL,
  `picture_path` varchar(255) NOT NULL,
  PRIMARY KEY (`regends_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb3;