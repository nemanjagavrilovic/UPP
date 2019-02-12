insert into magazine (id, title,issn,client_id,client_secret)
  values (21, 'Computer World','0262-4079','AaJJBmqJpI_ZHjM3PyQ366h2juyx0CwZltdLHoYnoeVDft8HCP9r7SepH6_Aam7xmiLIb58HJRGHJq2g','ELsxYoTheXamWCOsQ0i2zKSv2ZeB73JhX0r3T0HM6n0A082tT1olPCP5SeyagtsxaMWfv5W156ogHJ7M');

insert into magazine (id, title,issn)
  values (22, 'Galileu','1415-9856');


insert into user (id,password,username)
	values (1,'1234','admin');

insert into magazine_memberships (magazine_id,memberships_id)
	values (1,1);

insert into article (id,abstracts,content,magazine_name,scientific_field,title) 
	values (1,'Opis abstract','Tekst za test clanak','Computer World','IT','Nauci programiranje');
