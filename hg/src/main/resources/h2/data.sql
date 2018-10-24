select 'x';

insert into sys_user values (1, 'admin', 'admin123456', 'wangxiaochuan01@163.com', 1, now(), null, '2099-01-01', 0);
insert into sys_user_role values (1, 'admin', 'ADMIN', now());

-- 商品表metadata
insert into goods values (1, '黄瓜', 'http://img2.imgtn.bdimg.com/it/u=3765457875,3576756579&fm=26&gp=0.jpg');
insert into goods values (2, '西瓜', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2814490810,3054837474&fm=26&gp=0.jpg');
insert into goods values (3, '南瓜', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3644621908,1128380761&fm=26&gp=0.jpg');
insert into goods values (4, '西红柿', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2814490810,3054837474&fm=26&gp=0.jpg');
insert into goods values (5, '茄子', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=285706841,1084773042&fm=26&gp=0.jpg');
insert into goods values (6, '丝瓜', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=790900326,1949651647&fm=26&gp=0.jpg');
insert into goods values (7, '韭菜', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=128985081,71651006&fm=26&gp=0.jpg');
insert into goods values (8, '胡萝卜', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=19567285,2651903905&fm=26&gp=0.jpg');

-- 公司表
insert into company values (1, '北京果龙仓兴农科技有限公司', '北京市经济开发区荣华中路7号院3号楼518', '王晓森', '18734803709');
insert into company values (2, '寿光果龙仓电子商务有限公司', '寿光市洛城街办羊田路与洛兴街路口西北角（东城工业园）', '尹鹏', '');

-- person
insert into person values (1, '陈建国', 1, '男', '1977-09-20', '320101201809201110', '山东省寿光市文家街道桑家村', '13712341234', '桑家村');
insert into person values (2, '孙有福', 2, '男', '1980-09-21', '320101201809211120', '山东省寿光市孙家集街道杨家村', '13712341244', '杨家村');

-- 行政区
insert into `region` values (370700000000, '潍坊市', '潍', '370700000000', null, 2);

insert into `region` values (370701000000, '市辖区', null, '370700000000', 370700000000, 3);
insert into `region` values (370702000000, '潍城区', null, '370700000000', 370700000000, 3);
insert into `region` values (370703000000, '寒亭区', null, '370700000000', 370700000000, 3);
insert into `region` values (370783000000, '寿光市', null, '370783000000', 370700000000, 3);

insert into `region` values (370783003000, '文家街道', null, '370783000000', 370783000000, 4);

insert into `region` values (370783003001, '文家庄', null, null, 370783003000, 5);
insert into `region` values (370783003002, '桑家庄', null, null, 370783003000, 5);


-- 订单
insert into `order` values (1, 1, '2018-09-25', 1500, 'kg', 120, '南京市雨花台区', 1, 1, 1, 1, null);

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


