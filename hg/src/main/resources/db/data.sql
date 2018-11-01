select 'x';

insert into sys_user values (1, 'admin', 'admin123456', 'wangxiaochuan01@163.com', 1, now(), null, '2099-01-01', 0);
insert into sys_user_role values (1, 'admin', 'ADMIN', now());

-- 公司表
insert into company values (1, '北京果龙仓兴农科技有限公司', '北京市经济开发区荣华中路7号院3号楼518', '王晓森', '18734803709');
insert into company values (2, '寿光果龙仓电子商务有限公司', '寿光市洛城街办羊田路与洛兴街路口西北角（东城工业园）', '尹鹏', '');

-- 用户
insert into `user` values (1, '风清扬', 2, 'oocDpw1m6HiGs_N5wcaadao-hJSI', '', true, 2, '2018-04-10 13:38:51', '2018-04-10 13:38:11');
insert into `user` values (2, '薄荷柠檬', 1, 'oocDpw_hGX-4TnU5swv_3FGvcu1w', '', true, 2, '2018-10-12 13:01:57', '	2018-10-12 13:01:27');

-- 商品
insert into goods_category values (1, '蔬菜', '寿光蔬菜');
insert into goods_brand values (1, '果龙仓','中国优质蔬菜品牌');
insert into goods values (1, '黄瓜3斤装', 1, 1, '2154321412', 2.35, 5.50, 'kg', 1.5, 6, '规格：1.5kg', true);
-- 行政区
insert into `region` values (370700000000, '潍坊市', '潍', '370700000000', null, 2);

insert into `region` values (370701000000, '市辖区', null, '370700000000', 370700000000, 3);
insert into `region` values (370702000000, '潍城区', null, '370700000000', 370700000000, 3);
insert into `region` values (370703000000, '寒亭区', null, '370700000000', 370700000000, 3);
insert into `region` values (370783000000, '寿光市', null, '370783000000', 370700000000, 3);

insert into `region` values (370783003000, '文家街道', null, '370783000000', 370783000000, 4);

insert into `region` values (370783003001, '文家庄', null, null, 370783003000, 5);
insert into `region` values (370783003002, '桑家庄', null, null, 370783003000, 5);

-- 片区
insert into `area` values (240, '北京', 1, '寿光果龙仓电子商务有限公司', '王晓森', '18734803709', '北京市北京市东城区', 116.415612, 39.909984, null);


-- 订单
-- insert into `order` values (1, 1, '2018-09-25', 1500, 'kg', 120, '南京市雨花台区', 1, 1, 1, 1, null);

-- 图片
insert into `image_category` values (1, '质检报告', 0, '/root/hg/static/upload', 'http://www.tiaocaishi.com:9527/resources', '');
insert into `image_category` values (2, '资质证书', 0, '/root/hg/static/upload', 'http://www.tiaocaishi.com:9527/resources', '');
insert into `image_category` values (3, '蔬菜种植', 0, '/root/hg/static/upload', 'http://www.tiaocaishi.com:9527/resources', '存储蔬菜相关的图片');
insert into `image_category` values (10, '其他', 0, '/root/hg/static/upload', 'http://www.tiaocaishi.com:9527/resources', '');

insert into `image_category` values (11, '质检报告', 1, 'c:/hg/static/upload', 'http://localhost:8080/resources', '');
insert into `image_category` values (12, '资质证书', 1, 'c:/hg/static/upload', 'http://localhost:8080/resources', '');
insert into `image_category` values (13, '蔬菜种植', 1, 'c:/hg/static/upload', 'http://localhost:8080/resources', '存储蔬菜相关的图片');
insert into `image_category` values (20, '其他', 1, 'c:/hg/static/upload', 'http://localhost:8080/resources', '');

insert into `image` values (1, 1, 'huanggua.png', '/home/root/static/huanggua.png', 'http://upload.pig66.com/uploadfile/2017/0602/20170602032600406.jpg', '2018-08-08 10:00:00');


