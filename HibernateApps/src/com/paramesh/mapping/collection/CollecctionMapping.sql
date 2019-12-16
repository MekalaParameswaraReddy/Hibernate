
-- List example
create table benifitPlanList (
memid int(10),
indexs varchar(50),
plans varchar(50),
FOREIGN KEY (memid) REFERENCES  member(memberId))