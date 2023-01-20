create database gestionflotteavion;


create or replace view assuranceavion as(select v.*, a.date_fin ,date_debut, a.montant from assurance a join avion v on a.id_avion = v.id);

create or replace view assuranceavio as (select *,(date_fin- current_date)as jourMois from assuranceavion) ;
