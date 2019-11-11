CREATE TABLE userinfo(
  id SERIAL PRIMARY KEY ,
  name VARCHAR(255) NOT NULL ,
  username VARCHAR(50) ,
  email VARCHAR(50) ,
  password VARCHAR(100) ,
  roleName VARCHAR(50)
);