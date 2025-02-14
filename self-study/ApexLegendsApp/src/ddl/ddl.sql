/* Apexマスタ作成 */
-- apex_db.m_apex definition
create table m_apex (
  regends_id int not null auto_increment,
  regends_name varchar(32) not null,
  real_name varchar(32) not null,
  age varchar(32) not null,
  gender varchar(32) not null,
  regends_class varchar(32) not null,
  abilities varchar(32) not null,
  abi_description varchar(255) not null,
  passive varchar(32) not null,
  pas_description varchar(255) not null,
  ult varchar(32) not null,
  ult_description varchar(255) not null,
  words varchar(255) not null,
  picture_path varchar(255) not null,
  primary key (regends_id)
) engine = innodb default charset = utf8mb4;

/* レビューテーブル作成 */
-- apex_db.t_review definition
create table t_review (
  review_id int not null auto_increment,
  regends_id int not null,
  user_name varchar(32) not null,
  play_date date not null,
  rating int not null,
  age int not null,
  comment varchar(255) not null,
  primary key (review_id),
  key regends_id (regends_id),
  constraint t_review_ibfk_1 foreign key (regends_id) references m_apex (regends_id)
) engine = innodb default charset = utf8mb4;
