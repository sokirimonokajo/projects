select * from doctor
select * from patient
select * from bills
select * from inpatient
SELECT * from outpatient
select * from room
--

create table if not exists Doctor(
	doctor_id serial PRIMARY KEY, 
    firstname VARCHAR(20) not NULL,
    lastname VARCHAR(20) not null, 
     gender varchar (20) not null,
     address VARCHAR (50) not null,
	taskdateAndTime VARCHAR(30),
	task varchar(100)
	--patient_id int,
   -- FOREIGN key (patient_id)references Patient(patient_id)
)


create table if not exists Patient(
	 patient_id serial primary key ,
     firstname varchar(20) not null,
     lastname varchar(20) not null,
     address VARCHAR(20) not null,
     phone varchar(20),
     disease VARCHAR(20) not null,
     gender varchar(20) not NULL,
	 medication varchar(100),
	appointment_date_time  varchar(20) not null,
	 doctor_id int,
	  FOREIGN key (doctor_id)references Doctor(doctor_id)
     )
	 
create table if not exists bills(
     bills_id serial primary key,
	 days_num int not null,
	 room_charges int,
	 doctor_charges int,
	patient_id int,
	foreign key( patient_id) references Patient(patient_id)
)
	 
CREATE table if  not exists outpatient(
	     patient_id int,
         out_date date not null,
         primary key (patient_id)
)

create table if not exists room(
    room_num int primary key,
	patient_id int,
	foreign key(patient_id)references Patient (patient_id)
)

create table if not exists inpatient(
	patient_id int,
	admin_date varchar(20) not null,
	disc_date varchar(20) not null,
	gender varchar(5) not null,
	primary key(patient_id)
  )


insert into doctor(firstname,lastname,address,gender,task,taskdateAndTime)
values('Oscar','Fosu','1133 39th Ave','M','perform routine check on patient','2030-11-09 @2:00pm'),
      ('Ahmad','Gaal','214 8th st','M','perform surgery on patient 2','2015-04-02 @1:00pm'),
	  ('Sokiri','Aaaaa','1111 6th Ave','F','test blood for patient 3','2050=09-07 @3;30am'),
	  ('Lionel','Messi','1234 Bar Ca','M','assess symptoms','2016-06-03 @1:25pm'),
	  ('CR7','Etihad','8746 78th Ave','F','update patient medicatioon','2014-01-01 @1:40pm');
	  
insert into Patient(firstname,lastname,address,gender,disease,phone,medication,appointment_date_time ,doctor_id)
values('Lipid','Gbae','1133 39th Ave','M','pneumonia','1234456','250g zzzQuil,85g Peso','2030-02-05 @4:00pm',1),
      ('Ava','Zee','214 8th st','M','BP','4562987','60 tylenol,85g antidote','2080-03-01 @2:35am',2),
	  ('Ike','Aaaaa','1111 6th Ave','M','Diabetes','0987124','250g gybenol,70g vaseline','2000-11-12 @1:45pm',3),
	  ('Zee','Fub','1234 Bar Ca','M','Herpes','6789145','80kg lymph,85g distilled','111-07-13 @6:00am',2),
	  ('Nick','Brentz','8746 78th Ave','F','Dumb','7777777','30g zzzQuil,92kg AMP','2030-02-05 @4:00am',5);
	  
insert into bills(days_num,room_charges,doctor_charges,patient_id)
VALUES(10,109,20000,1),
      (5,50,1500,2),
	  (1,12,34200,3),
	  (20,350,45000,4),
	  (100,3200,100000,5);
	  
	  
insert into outpatient(patient_id,out_date)
values(1,'2000-10-12'),(2,'2018-02-25'),(3,'2005-10-03'),
      (4,'1720-03-04'),(5,'2000-09-07');
	  
	  
	  
insert into room(room_num,patient_id)
VALUES(104,1),(204,2),(304,3),(404,4),(504,5);

insert into inpatient(patient_id,admin_date,disc_date,gender)  
values (1,'2002-10-02','2002-11-03','M'),(2,'2004-11-22','2002-11-26','M'),
       (3,'2005-01-26','2005-04-03','M'),(4,'2006-09-04','2006-09-08','M'),
       (5,'2025-01-01','2026-04-08','F');

