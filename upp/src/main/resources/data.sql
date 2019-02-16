insert into magazine (id, title,issn,client_id,client_secret,editor_id)
  values (21, 'Computer World','0262-4079',
  'AaJJBmqJpI_ZHjM3PyQ366h2juyx0CwZltdLHoYnoeVDft8HCP9r7SepH6_Aam7xmiLIb58HJRGHJq2g',
  'ELsxYoTheXamWCOsQ0i2zKSv2ZeB73JhX0r3T0HM6n0A082tT1olPCP5SeyagtsxaMWfv5W156ogHJ7M',1);

insert into magazine (id, title,issn)
  values (22, 'Galileu','1415-9856');


insert into camunda_user (id,password,username,first_name ,last_name,email)
	values (1,'1234','admin','Admin','Admin','nemanja.gavrilovic1995@gmail.com');
insert into camunda_user (id,password,username,first_name ,last_name,email)
	values (2,'1234','nemanja','Nemanja','Gavrilović','nemanja.gavrilovic@gmail.com');
insert into camunda_user (id,password,username,first_name ,last_name,email)
	values (3,'1234','marko','Marko','Markovski','marko.markovic@gmail.com');
insert into camunda_user (id,password,username,first_name ,last_name,email)
	values (4,'1234','dragan','Dragan','Ivanovic','dragan.ivanovic@gmail.com');
insert into camunda_user (id,password,username,first_name ,last_name,email)
	values (5,'1234','editor','Nikola','Nikolovski','nikola@gmail.com');

insert into magazine_memberships (magazine_id,memberships_id)
	values (21,1);
insert into magazine_memberships (magazine_id,memberships_id)
	values (21,2);
insert into magazine_memberships (magazine_id,memberships_id)
	values (21,3);
insert into article (id,abstracts,content,magazine_name,scientific_field,title) 
	values (1,'Opis abstract','Tekst za test clanak','Computer World','IT','Nauci programiranje');
