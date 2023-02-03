create database enchere;


\c enchere;


CREATE TABLE Admin (
  id       SERIAL NOT NULL, 
  email    varchar(255) NOT NULL, 
  password varchar(255) NOT NULL, 
  PRIMARY KEY (id)
);

create table tokenadmin(
   id serial not null,
   expiration timestamp,
   idadmin integer references admin(id),
   token text
);

CREATE TABLE Comission (
  pourcentage integer NOT NULL
);

CREATE TABLE Categorie (
  id  SERIAL NOT NULL, 
  nom varchar(255) NOT NULL UNIQUE, 
  PRIMARY KEY (id)
);

CREATE TABLE DureeEnchere (
  duree time NOT NULL
);

CREATE TABLE Produit (
  id          SERIAL NOT NULL, 
  nom         varchar(255) NOT NULL, 
  idcategorie integer NOT NULL, 
  PRIMARY KEY (id)
);

CREATE TABLE Utilisateur (
  id         SERIAL NOT NULL, 
  nom        varchar(255) NOT NULL, 
  prenom     varchar(255) NOT NULL, 
  email      varchar(255) NOT NULL, 
  motdepasse varchar(255) NOT NULL, 
  PRIMARY KEY (id));

CREATE TABLE Enchere (
  id            SERIAL NOT NULL, 
  description   text NOT NULL, 
  prixminimal   double precision NOT NULL, 
  durree        time NOT NULL, 
  "datetime"    timestamp NOT NULL default now() , 
  etat          integer NOT NULL, 
  idUtilisateur integer NOT NULL, 
  idProduit     integer NOT NULL, 
  PRIMARY KEY (id));

CREATE TABLE FicheEchere (
  id           SERIAL NOT NULL, 
  montant      double precision NOT NULL, 
  "datetime"   timestamp NOT NULL, 
  idutilsateur integer NOT NULL, 
  etat         integer NOT NULL, 
  idenchere    integer NOT NULL, 
  PRIMARY KEY (id)
);

CREATE TABLE Mouvement (
  id           SERIAL NOT NULL, 
  montant      double precision NOT NULL, 
  "datetime"       timestamp NOT NULL, 
  idutilisateur integer NOT NULL, 
  etat         integer NOT NULL default 0 , 
  PRIMARY KEY (id)
);


CREATE TABLE Photo (
   id serial NOT NULL,
   idenchere integer, 
  "base64"    text
);

ALTER TABLE Produit ADD CONSTRAINT FKProduit57998 FOREIGN KEY (idcategorie) REFERENCES Categorie (id);
ALTER TABLE Enchere ADD CONSTRAINT FKEnchere460209 FOREIGN KEY (idUtilisateur) REFERENCES Utilisateur (id);
ALTER TABLE Enchere ADD CONSTRAINT FKEnchere390744 FOREIGN KEY (idProduit) REFERENCES Produit (id);
ALTER TABLE FicheEchere ADD CONSTRAINT FKFicheEcher745849 FOREIGN KEY (idutilisateur) REFERENCES Utilisateur (id);
ALTER TABLE Mouvement ADD CONSTRAINT FKMouvement44540 FOREIGN KEY (idutilisateur) REFERENCES Utilisateur (id);
ALTER TABLE FicheEchere ADD CONSTRAINT FKFicheEcher21052 FOREIGN KEY (idenchere) REFERENCES Enchere (id);
ALTER TABLE Photo ADD CONSTRAINT FKPhoto782066 FOREIGN KEY (idenchere) REFERENCES Enchere (id);
INSERT INTO Admin(id, email, password) VALUES (1, 'admin@gmail.com', 'admin');
INSERT INTO comission(pourcentage) VALUES (20);
INSERT INTO categorie(id, nom) VALUES (1, 'Technologie');
INSERT INTO categorie(id, nom) VALUES (2, 'Alimentation');
INSERT INTO categorie(id, nom) VALUES (3, 'Sport');
INSERT INTO categorie(id, nom) VALUES (4, 'Sante et beaute');
INSERT INTO produit(id, nom, idcategorie) VALUES (1, 'Ordinateur', 1);
INSERT INTO produit(id, nom, idcategorie) VALUES (2, 'Pain au lait', 2);
INSERT INTO produit(id, nom, idcategorie) VALUES (3, 'Maillot', 3);
INSERT INTO produit(id, nom, idcategorie) VALUES (4, 'Creme', 4);
INSERT INTO utilisateur(id, nom, prenom, email, motdepasse) VALUES (1, 'Ward', 'Farel', 'ward@gmail.com', 'ward');
INSERT INTO Utilisateur(id, nom, prenom, email, motdepasse) VALUES (2, 'NicolaTi', 'Murphy', 'murphy@gmail.com', 'murphy');
INSERT INTO Utilisateur(id, nom, prenom, email, motdepasse) VALUES (3, 'Valiah', 'Karen', 'valiah@gmail.com', 'valiah');
INSERT INTO Utilisateur(id, nom, prenom, email, motdepasse) VALUES (4, 'Feno', 'Sue', 'feno@gmail.com', 'fenosoa');
INSERT INTO Utilisateur(id, nom, prenom, email, motdepasse) VALUES (5, 'Luc', 'Luc', 'luc@gmail.com', '123');
INSERT INTO Utilisateur(id, nom, prenom, email, motdepasse) VALUES (6, 'Jade', 'Michel', 'jade@gmail.com', '123');
insert into mouvement values(default , 5000,'2023-01-17 01:30:00',1,0)

create or replace view rechargement as  Select  u.id as idutilisateur , u.nom,u.prenom, u.email,m.montant, m.etat,m.datetime, m.id from utilisateur u join mouvement m on m.idutilisateur = u.id ;

create or replace view rechargement as  Select  u.id as idutilisateur , u.nom,u.prenom, u.email,m.montant, m.etat,m.datetime from utilisateur u join mouvement m on m.idutilisateur = u.id ;



  alter table ficheechere drop column idutilsateur;
  alter table ficheechere drop column enchere;




insert into enchere (description,prixminimal,durree,datetime,etat,idutilisateur,idproduit) values('Hp corei5 5th gen',1800000,'05:00:00','2023-01-17 10:16:00',1,1,1);
insert into enchere (description,prixminimal,durree,datetime,etat,idutilisateur,idproduit) values('Asus raizen 5 16Go ram 500go',3000000,'05:00:00','2023-01-17 10:16:00',1,1,1);
insert into enchere (description,prixminimal,durree,datetime,etat,idutilisateur,idproduit) values('Lenovo corei5 5th gen 8go ram 1To',1500000,'05:00:00','2023-01-17 10:16:00',1,1,1);
insert into enchere (description,prixminimal,durree,datetime,etat,idutilisateur,idproduit) values('Mixa beure de karité 500ml corps',10000,'05:00:00','2023-01-17 10:16:00',1,3,4);
insert into enchere (description,prixminimal,durree,datetime,etat,idutilisateur,idproduit) values('Creme Ultra doux 500ml corps',10000,'05:00:00','2023-01-17 10:16:00',1,3,4);


insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(1850000,'2023-01-17 10:26:00',2,1,1);
insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(1900000,'2023-01-17 10:29:00',3,1,1);
insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(2000000,'2023-01-17 10:35:00',4,1,1);

insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(12000,'2023-01-17 10:30:00',2,1,4);
insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(13000,'2023-01-17 10:34:00',4,1,4);
insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(15000,'2023-01-17 10:35:00',2,1,4);
insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(20000,'2023-01-17 10:36:00',4,1,4);
insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(25000,'2023-01-17 10:37:00',1,1,4);
insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(26000,'2023-01-17 10:38:00',4,1,4);

insert into enchere (description,prixminimal,durree,datetime,etat,idutilisateur,idproduit) values('Hp ',2800000,'05:00:00','2023-01-17 10:16:00',1,1,1);
insert into enchere (description,prixminimal,durree,datetime,etat,idutilisateur,idproduit) values('Asus',5000000,'05:00:00','2023-01-17 10:16:00',1,1,1);
insert into enchere (description,prixminimal,durree,datetime,etat,idutilisateur,idproduit) values('Lenovo',1900000,'05:00:00','2023-01-17 10:16:00',1,1,1);
insert into enchere (description,prixminimal,durree,datetime,etat,idutilisateur,idproduit) values('Mixa ',5000,'05:00:00','2023-01-17 10:16:00',1,3,4);
insert into enchere (description,prixminimal,durree,datetime,etat,idutilisateur,idproduit) values('Ultra doux 500ml corps',10000,'05:00:00','2023-01-17 10:16:00',1,3,4);


insert into enchere (description,prixminimal,durree,datetime,etat,idutilisateur,idproduit) values(' Iphone 12 64 go',2800000,'05:00:00','2023-03-17 10:16:00',1,1,1);
insert into enchere (description,prixminimal,durree,datetime,etat,idutilisateur,idproduit) values('Predator raizen 5 1To',5000000,'05:00:00','2023-03-17 10:16:00',1,1,1);
insert into enchere (description,prixminimal,durree,datetime,etat,idutilisateur,idproduit) values('Lotion corps Baby shamel ',15000,'05:00:00','2023-03-17 10:16:00',1,3,4);
insert into enchere (description,prixminimal,durree,datetime,etat,idutilisateur,idproduit) values('Nivea Deodorant anti transpirant',20000,'05:00:00','2023-03-17 10:16:00',1,3,4);



insert into enchere (description,prixminimal,durree,datetime,etat,idutilisateur,idproduit) values('Mixa ',10000,'05:00:00','17-02-2023 10:16:00',1,3,4);
insert into enchere (description,prixminimal,durree,datetime,etat,idutilisateur,idproduit) values('Ultra doux 500ml corps',10000,'05:00:00','17-02-2023 10:16:00',1,3,4);


insert into enchere (description,prixminimal,durree,datetime,etat,idutilisateur,idproduit) values('Mixa ',10000,'05:00:00','17-02-2023 10:16:00',1,3,4);
insert into enchere (description,prixminimal,durree,datetime,etat,idutilisateur,idproduit) values('Ultra doux 500ml corps',10000,'05:00:00','17-02-2023 10:16:00',1,3,4);


insert into enchere (description,prixminimal,durree,datetime,etat,idutilisateur,idproduit) values('Mixa ',10000,'05:00:00','17-03-2023 10:16:00',1,3,4);
insert into enchere (description,prixminimal,durree,datetime,etat,idutilisateur,idproduit) values('Shampoing',20000,'05:00:00','17-03-2023 10:16:00',1,3,4);

insert into enchere (description,prixminimal,durree,datetime,etat,idutilisateur,idproduit) values('Loreal Soin cheveux ',10000,'05:00:00','17-03-2023 10:16:00',1,3,4);
insert into enchere (description,prixminimal,durree,datetime,etat,idutilisateur,idproduit) values('Masque',20000,'05:00:00','17-03-2023 10:16:00',1,3,4);
insert into enchere (description,prixminimal,durree,datetime,etat,idutilisateur,idproduit) values('Loreal Soin cheveux ',10000,'05:00:00','17-03-2023 10:16:00',1,3,4);
insert into enchere (description,prixminimal,durree,datetime,etat,idutilisateur,idproduit) values('Masque',20000,'05:00:00','17-03-2023 10:16:00',1,3,4);

insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(1850000,'17-02-2023 10:26:00',2,1,36);
insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(1900000,'17-02-2023 10:29:00',3,1,37);
insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(2000000,'17-02-2023 10:35:00',4,1,37);

insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(12000,'17-03-2023 10:30:00',2,1,37);
insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(13000,'17-03-2023 10:34:00',4,1,37);
insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(15000,'17-03-2023 10:35:00',2,1,37);
insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(20000,'17-03-2023 10:36:00',4,1,37);
insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(25000,'17-03-2023 10:37:00',1,1,37);
insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(26000,'17-03-2023 10:38:00',4,1,37);


insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values
(5200000,'2023-03-17 10:38:00',3,1,11),
(5300000,'2023-03-17 10:38:00',2,1,11),
(3000000,'2023-03-17 10:41:00',3,1,12),
(3100000,'2023-03-17 10:42:00',2,1,12),
(3900000,'2023-03-17 10:43:00',5,1,12),
(4000000,'2023-03-17 10:44:00',6,1,13),
(2900000,'2023-03-17 10:45:00',3,1,2),
(3100000,'2023-03-17 10:46:00',2,1,2),
(3200000,'2023-03-17 10:47:00',3,1,2),
(3300000,'2023-03-17 10:48:00',6,1,2),
(3400000,'2023-03-17 10:48:00',5,1,2),
(4000000,'2023-03-17 10:50:00',5,1,2),
(26000,'17-03-2023 10:38:00',3,1,37),
(26000,'17-03-2023 10:38:00',2,1,37),


insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(1850000,'17-03-2023 10:26:00',2,1,36);
insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(1900000,'17-03-2023 10:29:00',3,1,37);
insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(2000000,'17-03-2023 10:35:00',4,1,37);

insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(12000,'17-03-2023 10:30:00',2,1,37);
insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(13000,'17-03-2023 10:34:00',4,1,37);
insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(15000,'17-03-2023 10:35:00',2,1,37);
insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(20000,'17-03-2023 10:36:00',4,1,37);
insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(25000,'17-03-2023 10:37:00',1,1,37);
insert into ficheechere(montant,datetime,idutilisateur,etat,idenchere) values(26000,'17-03-2023 10:38:00',4,1,37);

update produit set nom = 'Technologie' where idcategorie = 1;
update produit set nom = 'Alimentation' where idcategorie = 2;
update produit set nom = 'Sport' where idcategorie = 3;
update produit set nom = 'Sante et Beaute' where idcategorie = 3;


-- statique max enchere par mois 

create or replace view ca as 
select count(c.id) as idcategorie,c.id,extract(month from e.datetime) as mois 
from enchere e join produit p on p.id = e.idproduit  join categorie c on c.id = p.idcategorie group by c.id ,extract(month from e.datetime) order by  (count(c.id))desc;

create or replace view  caa as 
 select max(idcategorie)as maxcategorie ,mois from ca  group by  mois;


create or replace view  maxencherimois as 
 select caa.*,cat.nom,cat.id from ca c join caa  on caa.mois = c.mois and caa.maxcategorie = c.idcategorie join categorie cat on cat.id = c.id order by mois;


--- statistique des personnes 
create or replace view chiffrerapporteEnchere as 
select count(f.idutilisateur) as nombreuser , e.id as idenchere, p.nom as produit, e.description, e.durree,(e.prixminimal),e.etat, e.idutilisateur ,u.nom,u.prenom ,p.id as idproduit , ((max(f.montant))/(e.prixminimal)) as chiffre
from enchere e join ficheechere f on f.idenchere = e.id join produit p on p.id = e.idproduit 
Join utilisateur u on u.id = e.idutilisateur
group by  e.id ,p.nom , e.description, e.durree,e.prixminimal,e.etat, e.idutilisateur,p.id ,u.nom,u.prenom order by count(f.idutilisateur) desc;

-- nombre enchere maximum 

create table 
--murphy
-- get solde par utilisateur

create view sommerechargement
as
select idutilisateur,sum(montant) solde from mouvement where etat=1 group by idutilisateur;

create view sommeblocker
as
select idutilisateur,sum(montant) montant 
from utilisateur u
left join  ficheechere f
on  u.id=f.idutilisateur
where etat=1 group by idutilisateur;

select sr.idutilisateur,(solde-montant) solde from sommerechargement sr 
left join sommeblocker sb
 on sr.idutilisateur=sb.idutilisateur group by sr.idutilisateur ;


select f.idutilisateur,sum(montant) 
from ficheechere f 
join enchere e on e.id=f.idenchere 
where f.etat=1 and e.etat=1 group by f.idutilisateur;
select * from ficheechere where idenchere=3  order by datetime desc  limit 1;

ALTER TABLE enchere alter column datetime set DEFAULT CURRENT_DATE ;

host: containers-us-west-82.railway.app

database : railway
port : 6800

user :postgres
mdp : 0ZKn0eo0VApTxxve4j4v
