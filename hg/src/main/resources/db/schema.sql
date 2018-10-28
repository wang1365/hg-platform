-- create database hg default character set utf8mb4 collate utf8mb4_unicode_ci;

-- 商品分类
create table goods_category
(
  id   int auto_increment   primary key,
  name varchar(256) not null unique,
  desc varchar(1024)
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

-- 商品品牌
create table goods_brand
(
  id   int auto_increment   primary key,
  name varchar(256) not null unique,
  desc varchar(1024)
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

-- 商品信息
create table `goods`
(
  `id` int auto_increment    primary key,
  `name` varchar(256) not null unique,
  `cat_id` int not null,
  `brand_id` int not null,
  `bar_code` varchar(128),
  `purchase_price` decimal(8,2) comment '采购价格，单位分',
  `sale_price` decimal(8,2) comment '零售价格，单位分',
  `unit` varchar(16) comment '单位',
  `weight` decimal(8,2) comment '净含量，单位g',
  `expire_days` int comment '保质期天数',
  `desc` varchar(1024),
  `valid` tinyint(1) default true
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

-- 商品标签
create table `goods_label`
(
  id int auto_increment primary key,
  bar_code varchar(56) not null  comment '条形码' unique,
  label_code varchar(128) not null comment '标签码(RFID)',
  product_date datetime not null comment '生产日期',
  expire_days int not null,
  status int not null default 0,
  create_time datetime default current_timestamp
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

-- 商品信息
create table `area`
(
  `id` int auto_increment primary key,
  `name` varchar(256) not null unique,
  `enabled` tinyint(1) not null,
  `charge_org` varchar(256) not null comment '所属机构',
  `charge_owner` varchar(256) comment '负责人',
  `owner_phone` varchar(11) comment '负责人手机号码',
  `address` varchar(256) comment '详细地址',
  `longitude` float comment '经度',
  `latitude` float comment '纬度',
  `comment` varchar(1024)
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

create table `company`
(
  id   int auto_increment
    primary key,
  name varchar(256) not null unique ,
  address varchar(256),
  owner varchar(20) comment '法人',
  telephone varchar(20),
  constraint company_id_uindex
  unique (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

create table `order`
(
  id         int auto_increment    primary key,
  goods_id   int                       not null  comment '采购商品ID',
  order_time datetime                  not null  comment '采购时间',
  quantity     int                      not null  comment '数量',
  unit varchar(26)                     not null comment '单位',
  price int comment '分/kg',
  address    varchar(256) null  comment '采购地点',
  seller_id  int                       null,
  buyer_id   int                       null,
  report_id  int                       null comment '质检报告ID',
  plant_id   bigint comment '种植计划ID',
  pick_id bigint comment '种植条目中对应的采摘ID',
  constraint order_id_uindex  unique (id)
)  DEFAULT CHARSET=utf8mb4;

create table `person`
(
  id             int auto_increment
    primary key,
  name           varchar(64)  not null,
  type int default 10 comment  '1-农户 2-采购商 3-司机 10-其他',
  gender         varchar(64)  null,
  birthday       date         null,
  id_card        varchar(64)  null
  comment '身份证',
  family_address varchar(256) null
  comment '家庭住址',
  mobile_no      varchar(64)  null
  comment '手机号码',
  company        varchar(256) null
  comment '公司',
  constraint person_id_uindex
  unique (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `region` (
  `id` bigint auto_increment primary key,
  `name` varchar(50) NOT NULL COMMENT '地区名称',
  `short_name` varchar(10) DEFAULT NULL COMMENT '地区缩写',
  `code` varchar(20) DEFAULT NULL COMMENT '行政地区编号',
  `parent_id` bigint DEFAULT NULL COMMENT '地区父id',
  `level` int(2) DEFAULT NULL COMMENT '地区级别 1-省、自治区、直辖市 2-地级市、地区、自治州、盟 3-市辖区、县级市、县',
  constraint region_id_uindex
  unique (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table sys_role
(
  id   int auto_increment,
  name varchar(64) not null
    primary key,
  constraint role_id_uindex
  unique (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

create table town
(
  id   int auto_increment
    primary key,
  name varchar(1024) not null,
  constraint town_id_uindex
  unique (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;


create table sys_user
(
  id                  int auto_increment
    primary key,
  name                varchar(64) unique                 not null,
  password            varchar(256)                       not null,
  email               varchar(256)                           null,
  enabled             tinyint(1) default '1'                 null
  comment '账号是否生效',
  create_time         datetime                               null
  comment '账号创建时间',
  password_reset_time datetime                               null
  comment '最近一次密码重置时间',
  expired_time        datetime default '2099-01-01 00:00:00' not null
  comment '账号过期时间',
  person_id           int                                    null
  comment '个人ID（用户资料表person）',
  constraint user_id_uindex
  unique (id),
  constraint user_name_uindex
  unique (name)
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

create table sys_user_role
(
  id integer primary key ,
  username        varchar(56)     unique not null,
  role_name       varchar(1024)   ,
  update_time     timestamp default current_timestamp
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

create table `image_category` (
  id integer primary key auto_increment,
  name varchar(26) not null,
  profile_type tinyint not null default 0 comment '0:online 1:dev',
  local_path varchar(256) not null ,
  url_path varchar(256) not null,
  description varchar(256)
) engine = InnoDB DEFAULT CHARSET = utf8mb4;

create table `image` (
  id integer auto_increment primary key ,
  cat_id integer not null,
  name varchar(256) not null unique ,
  local_path varchar(1024) not null,
  url_path varchar(1024) not null,
  create_time timestamp default current_timestamp
) engine = InnoDB DEFAULT CHARSET = utf8mb4;
