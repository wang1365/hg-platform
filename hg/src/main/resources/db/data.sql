select 'x';

insert into sys_user values (1, 'admin', '$2a$04$A0dCCXZo4ub2tm1MCwQSx.Ps9KaRbbUkmkKC0RdD45AfhtqOy.kEy', 'wangxiaochuan01@163.com', 1, now(), null, '2099-01-01');
insert into sys_user values (2, 'sangjia', '$2a$04$5R22m7KPYkQ.wQg/Bm97zesZsHtrgIVa90f2hXDFlSyPfNqm7d0VS', 'wangxiaochuan01@163.com', 1, now(), null, '2099-01-01');


-- 公司表
insert into company values (1, '北京果龙仓兴农科技有限公司', '北京市经济开发区荣华中路7号院3号楼518', '王晓森', '18734803709', now());
insert into company values (2, '寿光果龙仓电子商务有限公司', '寿光市洛城街办羊田路与洛兴街路口西北角（东城工业园）', '尹鹏', '', now());


--- 职员表
insert into person values (1, '于松', 4, '男', null, null, null, '1234546678', '寿光果龙仓电子商务有限公司', now());
insert into person values (2, '尹鹏', 5, '男', null, null, null, '1234546789', '北京果龙仓兴农科技有限公司', now());


-- 用户
insert into `user` values (1, '风清扬', 2, 'oocDpw1m6HiGs_N5wcaadao-hJSI', '', true, 2, '2018-04-10 13:38:51', '2018-04-10 13:38:11');
insert into `user` values (2, '薄荷柠檬', 1, 'oocDpw_hGX-4TnU5swv_3FGvcu1w', '', true, 2, '2018-10-12 13:01:57', '	2018-10-12 13:01:27');

-- 商品
insert into goods_category values (1, '蔬菜', '寿光蔬菜', now());
insert into goods_brand values (1, '果龙仓','中国优质蔬菜品牌', now());
insert into goods values (1, '黄瓜3斤装', 1, 1, '2154321412', 2.35, 5.50, 'kg', 1.5, 6, '规格：1.5kg', true, now());
insert into goods values (2, '黄瓜4斤装', 1, 1, '2154321413', 2.55, 6.50, 'kg', 2.0, 6, '规格：2.0kg', true, now());



-- 行政区
insert into `region` values (370700000000, '潍坊市', '潍', '370700000000', null, 2, now());


-- 片区
insert into `area` values (240, '北京市丰台区', 1, 1, 1, '北京市丰台区丽泽路60号', 116.329, 39.874, null, now());
insert into `area` values (241, '北京市西城区', 1, 1, 2, '北京市海淀区民族大学西路62号', 116.3222, 39.955, null, now());

-- 售货柜
insert into `container` values (1, '点位2274', 'GLC000002274', 'HGOBOX-C700', 1, 0, 240, 1, 2, null, null, null, null, now());
insert into `container` values (2, '点位2275', 'GLC000002275', 'HGOBOX-C700', 1, 1, 240, 2, 1, '', 116.415612, 39.909984, null, now());

-- 订单
-- insert into `order` values (1, 1, '2018-09-25', 1500, 'kg', 120, '南京市雨花台区', 1, 1, 1, 1, null);

-- 图片
insert into `image_category` values (1, '质检报告', 0, '/root/hg/static/upload', 'http://www.tiaocaishi.com:9527/resources', '', now());
insert into `image_category` values (2, '资质证书', 0, '/root/hg/static/upload', 'http://www.tiaocaishi.com:9527/resources', '', now());
insert into `image_category` values (3, '蔬菜种植', 0, '/root/hg/static/upload', 'http://www.tiaocaishi.com:9527/resources', '存储蔬菜相关的图片', now());
insert into `image_category` values (10, '其他', 0, '/root/hg/static/upload', 'http://www.tiaocaishi.com:9527/resources', '', now());

insert into `image_category` values (11, '质检报告', 1, 'c:/hg/static/upload', 'http://localhost:8080/resources', '', now());
insert into `image_category` values (12, '资质证书', 1, 'c:/hg/static/upload', 'http://localhost:8080/resources', '', now());
insert into `image_category` values (13, '蔬菜种植', 1, 'c:/hg/static/upload', 'http://localhost:8080/resources', '存储蔬菜相关的图片', now());
insert into `image_category` values (20, '其他', 1, 'c:/hg/static/upload', 'http://localhost:8080/resources', '', now());

insert into `image` values (1, 1, 'huanggua.png', '/home/root/static/huanggua.png', 'http://upload.pig66.com/uploadfile/2017/0602/20170602032600406.jpg', now());


