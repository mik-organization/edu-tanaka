drop schema if exists apex_db;
create schema apex_db;

create table apex_db.m_legend (
  id int auto_increment comment 'ID',
  name varchar(32) not null comment 'レジェンド名',
  real_name varchar(32) comment '本名',
  age int comment '年齢',
  age_note varchar(32) 'ageに付随する特記事項'
  gender varchar(32) not null comment '性別',
  regends_class varchar(32) comment 'クラス名',
  abilities varchar(32) comment 'アビリティ名',
  abi_description varchar(255) comment 'アビリティの説明',
  passive varchar(32) comment 'パッシブ名',
  pas_description varchar(255) comment 'パッシブの説明',
  ult varchar(32) comment 'アルティメットアビリティ名',
  ult_description varchar(255) comment 'アルティメットアビリティの説明',
  words varchar(255) comment 'セリフ',
  picture_path varchar(255) comment '画像パス',
  primary key (id)
) engine = innodb default charset = utf8mb4 comment='レジェンドマスタ';

create table apex_db.t_review (
  id int auto_increment comment 'ID',
  legend_id int not null comment 'ID',
  user_name varchar(32) not null comment '利用者名',
  play_date date not null comment 'プレイ日',
  rating int not null comment '評価',
  age int comment '年齢',
  comment varchar(255) comment 'コメント',
  primary key (id),
  key regends_id (regends_id),
  constraint t_review_ibfk_1 foreign key (legend_id) references m_legend (id)
) engine = innodb default charset = utf8mb4 comment='レビュー情報';
