create table login(
username varchar(50) not null,
password varchar(50));


insert into login values("admin", "admin@123"); 
insert into login values("naveen", "testing@123"); 





 create table register(
    firstname varchar(50) not null,
    lastname varchar(50),
    email varchar(50),
    telephone varchar(50),
    address1 varchar(50),
    address2 varchar(50),
    city varchar(50),
    postalcode varchar(50),
    country varchar(50),
    region varchar(50),
    password varchar(50),
    confirmpasword varchar(50));

     insert into register values("abdul", "Syed", "abdsye@gmail.com", "9876565678", "APHB colony", "gachibowli", "Hyderabad", "500033", "India", "Telangana", "abdul1", "abdul1"); 
     
     insert into register values("ahmed", "mohammed", "moha@gmail.com", "9876565600", "KPHB colony", "kukatpally", "Hyderabad", "500039", "India", "Telangana", "abdul2", "abdul2"); 