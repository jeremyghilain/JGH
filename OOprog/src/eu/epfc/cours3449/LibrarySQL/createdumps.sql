select * from books;

alter table books modify column identifier varchar auto_increment;

insert into books (Identifier,Location,Buy_date,Edition,ISBN,Format,Language,Author_Name,Author_Family_Name,Title,First_publication,Original_Language)
values ('jer1','livingroom','2015','Galimar','5678','poche','English','Brandon','Sanderson','Steelheart','2014','English');

insert into books (Identifier,Location,Buy_date,Edition,ISBN,Format,Language,Author_Name,Author_Family_Name,Title,First_publication,Original_Language)
values ('jer2','livingroom','2015','Galimar','45679','poche','English','Brandon','Sanderson','Firefight','2015','English');

insert into books (Identifier,Location,Buy_date,Edition,ISBN,Format,Language,Author_Name,Author_Family_Name,Title,First_publication,Original_Language)
values ('jer3','bedroom','2015','Soleil','135792','Poche','French','Peter','V.Brent','L''homme rune','2014','English');




