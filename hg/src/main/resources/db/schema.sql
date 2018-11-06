-- create database hg default character set utf8mb4 collate utf8mb4_unicode_ci;

-- 商品分类
create table goods_category
(
  id   int auto_increment   primary key,
  name varchar(256) not null unique,
  desc varchar(1024),
  create_time timestamp not null default current_timestamp
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

-- 商品品牌
create table goods_brand
(
  id   int auto_increment   primary key,
  name varchar(256) not null unique,
  desc varchar(1024),
  create_time timestamp not null default current_timestamp
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
  `valid` tinyint(1) default true,
  create_time timestamp not null default current_timestamp
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

-- 片区
create table `area`
(
  `id` int auto_increment primary key,
  `name` varchar(256) not null unique,
  `enabled` tinyint(1) not null,
  `company_id` int not null comment '所属机构',
  `head_id` int comment '负责人',
  `address` varchar(256) comment '详细地址',
  `longitude` float comment '经度',
  `latitude` float comment '纬度',
  `comment` varchar(1024),
  create_time timestamp not null default current_timestamp
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

-- 售货柜
create table `vm`
(
  `id` int auto_increment primary key,
  `name` varchar(128) not null unique,
  `code` varchar(128) not null unique,
  `device_mode` varchar(128) not null comment '设备型号',
  `enabled` tinyint(1) not null comment '启用',
  `run` tinyint(1) not null comment '运行状态',
  `area_id` int,
  `head_id` int comment '负责人',
  `distribution_id` int comment '配送人员',
  `address` varchar(256),
  `longitude` float,
  `latitude` float,
  `comment` varchar(1024),
  create_time timestamp not null default current_timestamp
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

-- 促销
create table `promotion`
(
  id int auto_increment primary key,
  name varchar(128) not null comment '',
  start_time datetime not null comment '',
  end_time datetime not null comment '',
  limit_times int not null default 0 comment '限制使用的次数，0：不限制',
  rule_type int not null comment '1:首单立减  2:商品满减 3:随机立减 4:优惠折扣',
  rule_id int,
  include_all_cat tinyint(1) not null default false comment '是否所有商品分类都参加',
  include_all_brand tinyint(1) not null default false comment '是否所有商品品牌都参加',
  include_all_hg tinyint(1) not null default false comment '是否所有货柜都参加',
  audited tinyint(1) not null default false comment '是否审核',
  desc varchar(1028),
  create_time datetime not null default current_timestamp
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

-- 首单立减
create table `promotion_rule_first_reduction`
(
  id int auto_increment primary key,
  promotion_id int not null unique,
  reduce_value decimal(6, 2) not null,
  create_time timestamp not null default current_timestamp
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

-- 满减
create table `promotion_rule_full_reduction`
(
  id int auto_increment primary key,
  promotion_id int not null,
  full_value decimal(6,2) not null,
  reduce_value decimal(6, 2) not null,
  create_time timestamp not null default current_timestamp
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

-- 随机立减
create table `promotion_rule_random_reduction`
(
  id int auto_increment primary key,
  promotion_id int not null,
  min_value decimal(6,2) not null,
  max_value decimal(6, 2) not null,
  create_time timestamp not null default current_timestamp
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

-- 优惠折扣
create table `promotion_rule_discount`
(
  id int auto_increment primary key,
  promotion_id int not null unique,
  rate decimal(3, 2) not null comment '折扣率',
  create_time timestamp not null default current_timestamp
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

-- 分类促销
create table promotion_category
(
  id int auto_increment primary key,
  promotion_id int not null,
  cat_id int not null,
  create_time timestamp not null default current_timestamp
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

-- 品牌促销
create table promotion_brand
(
  id int auto_increment primary key,
  promotion_id int not null,
  brand_id int not null,
  create_time timestamp not null default current_timestamp
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

-- 用户（下订单的用户）
create table user
(
  id int auto_increment primary key,
  nick_name varchar(128) not null,
  type int not null comment '用户类型 1：微信 2：支付宝',
  platform_code varchar(128) not null comment '平台ID',
  phone varchar(26),
  credit_audited tinyint(1) not null,
  credit_level int not null,
  register_time datetime not null,
  create_time datetime not null default current_timestamp
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;


create table `company`
(
  id   int auto_increment
    primary key,
  name varchar(256) not null unique ,
  address varchar(256),
  owner varchar(20) comment '法人',
  telephone varchar(20),
  create_time timestamp not null default current_timestamp
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

-- 用户订单
create table `order`
(
  id int auto_increment primary key,
  status int not null comment '订单状态 0；创建 1：完成 2：支付中 3：支付成功 4：支付失败 -1：取消',
  audit_status int not null comment '审核状态 0：未审核 1：完成审核',
  amount decimal(10,2) not null comment '订单金额',
  reduce_amount decimal(10,2)  comment '折扣金额',
  goods_count int not null comment '商品数量',
  cat_count int not null comment '商品分类数量',
  area_id int not null comment '片区ID',
  area_name varchar(56) not null comment '片区名称',
  point_id int not null comment '点位ID',
  point_name varchar(56) not null comment '点位名称',
  user_id int not null comment '用户ID',
  user_nick_name varchar(56) not null comment '用户昵称',
  user_type int not null comment '用户类型 1：微信 2：支付宝',
  order_time datetime not null comment '订单创建时间',
  create_time datetime not null default current_timestamp
)  DEFAULT CHARSET=utf8mb4;

create table `person`
(
  id             int auto_increment   primary key,
  name           varchar(64)  not null,
  type int default 10 comment  '1-农户 2-采购商 3-司机 4-负责人? 5-配送员 10-其他',
  gender         varchar(64)  null,
  birthday       date         null,
  id_card        varchar(64)  null  comment '身份证',
  family_address varchar(256) null  comment '家庭住址',
  mobile_no      varchar(64)  null  comment '手机号码',
  company        varchar(256) null  comment '公司',
  create_time timestamp not null default current_timestamp
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `region` (
  `id` bigint auto_increment primary key,
  `name` varchar(50) NOT NULL COMMENT '地区名称',
  `short_name` varchar(10) DEFAULT NULL COMMENT '地区缩写',
  `code` varchar(20) DEFAULT NULL COMMENT '行政地区编号',
  `parent_id` bigint DEFAULT NULL COMMENT '地区父id',
  `level` int(2) DEFAULT NULL COMMENT '地区级别 1-省、自治区、直辖市 2-地级市、地区、自治州、盟 3-市辖区、县级市、县',
  create_time timestamp not null default current_timestamp
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table sys_role
(
  long   int auto_increment primary key,
  name varchar(64) not null,
  create_time timestamp not null default current_timestamp
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;


-- 系统用户表
create table sys_user
(
  id                  int auto_increment    primary key,
  user_name                varchar(64) unique     not null,
  password            varchar(256)           not null,
  email               varchar(256)           null,
  enabled             tinyint(1) default '1' null  comment '账号是否生效',
  create_time         datetime               null  comment '账号创建时间',
  password_reset_time datetime               null  comment '最近一次密码重置时间',
  expired_time        datetime default '2099-01-01 00:00:00' not null  comment '账号过期时间'
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
  description varchar(256),
  create_time timestamp default current_timestamp
) engine = InnoDB DEFAULT CHARSET = utf8mb4;

create table `image` (
  id integer auto_increment primary key ,
  cat_id integer not null,
  name varchar(256) not null unique ,
  local_path varchar(1024) not null,
  url_path varchar(1024) not null,
  create_time timestamp default current_timestamp
) engine = InnoDB DEFAULT CHARSET = utf8mb4;
