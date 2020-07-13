create database People;
use People;
create table subscriber(
        id int  auto_increment,
       user varchar(20) not null  comment '用户账号',
        password varchar(20) not null comment '密码'
);
insert into subscriber(user,password) values (('余振晗','2280629901')
                                            ,('李平','20150302'));
# insert into subscriber(user,password) values ('李平' , '20150302');

