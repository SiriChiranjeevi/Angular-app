create database stage;
create database shadow;
create database latest;
create database load;
create database training;
create database producation;

sbc.PRODUCTBUILDERLOG

create table PRODUCTBUILDERLOG(PBL_DATE varchar(20), GT_CODE varchar(20),
 PBL_RETMSG varchar(20),ACTION varchar(20),CHANNEL varchar(20));


create table user (id integer not null auto_increment, email varchar(255), first_name varchar(255), last_name varchar(255), primary key (id))