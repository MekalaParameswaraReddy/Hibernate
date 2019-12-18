
-- List example
create table benifitPlanList (
memid int(10),
indexs varchar(50),
plans varchar(50),
FOREIGN KEY (memid) REFERENCES  member(memberId))

-- Bag Example
create table benifitPlan (
memid int(10),
plans varchar(50),
FOREIGN KEY (memid) REFERENCES  member(memberId))

-- set Example
create table uniqueBenifitPlan (
memid int(10),
plans varchar(50),
FOREIGN KEY (memid) REFERENCES  member(memberId))

-- Map example
create table planNameAndExplanation (
memberID int(10),
plan varchar(50),
Description varchar(50),
FOREIGN KEY (memid) REFERENCES  member(memberId))