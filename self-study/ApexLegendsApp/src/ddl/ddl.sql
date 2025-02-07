/* Apexマスタ作成 */
-- apex_db.m_apex definition
CREATE TABLE m_apex (
  regends_id		int 		 NOT NULL AUTO_INCREMENT,
  regends_name		varchar(32)  NOT NULL,
  real_name 		varchar(32)  NOT NULL,
  age 				varchar(32)  NOT NULL,
  gender 			varchar(32)  NOT NULL,
  regends_class 	varchar(32)  NOT NULL,
  abilities 		varchar(32)  NOT NULL,
  abi_description 	varchar(255) NOT NULL,
  passive 			varchar(32)  NOT NULL,
  pas_description 	varchar(255) NOT NULL,
  ult 				varchar(32)  NOT NULL,
  ult_description 	varchar(255) NOT NULL,
  words 			varchar(255) NOT NULL,
  picture_path 		varchar(255) NOT NULL,
  PRIMARY KEY (regends_id)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb3;

/* レビューテーブル作成 */
-- apex_db.t_review definition
CREATE TABLE t_review (
  review_id 		int			 NOT NULL 	AUTO_INCREMENT,
  regends_id 		int 		 NOT NULL,
  user_name 		varchar(32)  NOT NULL,
  play_date 		date 		 NOT NULL,
  rating 			int 		 NOT NULL,
  age 				int 		 NOT NULL,
  comment 			varchar(255) NOT NULL,
  PRIMARY KEY (review_id),
  KEY regends_id (regends_id),
  CONSTRAINT t_review_ibfk_1 FOREIGN KEY (regends_id) REFERENCES m_apex (regends_id)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
