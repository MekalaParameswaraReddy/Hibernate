-- one - to - Many
create table Stock(stockId int(10), stockName varchar(200), PRIMARY KEY (sotckId) );

create table stockDetails(
stockDetailsId int(10),
qid int(10), index_list int(10), openPrice int(10), closePrice int(10), valuems int(10), month varchar(200),
-- PRIMARY KEY (stockDetailsId),
FOREIGN KEY (qid) REFERENCES  Stock(stockId) );

-- End --

-- Many - to - Many

-- User ----|>> UserRole <<|---- Role

select * from User
select * from Role
select * from UserRole

CREATE TABLE User (
  id int(10),
  name varchar(50), 
  PRIMARY KEY (id) 
);

CREATE TABLE Role (
  id int(10), 
  description varchar(50),
  PRIMARY KEY (id) 
);


CREATE TABLE UserRole (
  user_id int(10),
  role_id int(10),
  FOREIGN KEY (user_id) REFERENCES  User(id ),
  FOREIGN KEY (role_id) REFERENCES  Role(id)
);
-- End --

-------- one to one

CREATE TABLE student (
  id int(10),
  name varchar(50), 
  PRIMARY KEY (id) 
);


CREATE TABLE contact_info (
  student_id int(10),
  personal_number int(10),
  home_number int (10),
  FOREIGN KEY (student_id) REFERENCES  student(id)
);
