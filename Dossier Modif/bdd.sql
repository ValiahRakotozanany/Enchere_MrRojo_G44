create database gestionflotteavion;


create or replace view assurancevehicule as(select v.*, a.date_fin ,date_debut, a.montant from assurance a join vehicule v on a.vehicule_id = v.id);

create or replace view assurancevehicul as (select *,(date_fin- current_date)as jourMois from assuranceVehicule) ;
