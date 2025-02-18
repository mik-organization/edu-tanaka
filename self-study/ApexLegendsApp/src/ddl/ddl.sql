drop schema if exists apex_db;
create schema apex_db;

create table apex_db.m_apex (
  regends_id int not null auto_increment comment 'ID',
  regends_name varchar(32) not null comment 'レジェンド名',
  real_name varchar(32) not null comment '本名',
  age varchar(32) not null comment '年齢',
  gender varchar(32) not null comment '性別',
  regends_class varchar(32) not null comment 'クラス名',
  abilities varchar(32) not null comment 'アビリティ名',
  abi_description varchar(255) not null comment 'アビリティの説明',
  passive varchar(32) not null comment 'パッシブ名',
  pas_description varchar(255) not null comment 'パッシブの説明',
  ult varchar(32) not null comment 'アルティメットアビリティ名',
  ult_description varchar(255) not null comment 'アルティメットアビリティの説明',
  words varchar(255) not null comment 'セリフ',
  picture_path varchar(255) not null comment '画像パス',
  primary key (regends_id)
) engine = innodb default charset = utf8mb4 comment='レジェンドマスタ';

create table apex_db.t_review (
  review_id int not null auto_increment comment 'ID',
  regends_id int not null comment 'ID',
  user_name varchar(32) not null comment '利用者名',
  play_date date not null comment 'プレイ日',
  rating int not null comment '評価',
  age int not null comment '年齢',
  comment varchar(255) not null comment 'コメント',
  primary key (review_id),
  key regends_id (regends_id),
  constraint t_review_ibfk_1 foreign key (regends_id) references m_apex (regends_id)
) engine = innodb default charset = utf8mb4 comment='レビュー情報';
