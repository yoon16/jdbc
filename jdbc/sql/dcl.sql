-- 1. DB 생성
create database webdb;

-- 2. user 생성
create user 'webdb'@'localhost' identified by 'webdb';

-- 3. grant privileges
grant all PRIVILEGES on webdb.* to 'webdb'@'localhost';