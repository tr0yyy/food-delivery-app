insert into user (username, nume, prenume, nr_telefon, adresa)
values ('Gica123', 'Gica', 'Georgel', '0746195138', 'Strada Apelor, nr 6');

insert into user (username, nume, prenume, nr_telefon, adresa)
values ('Achime11', 'Achimescu', 'Valentin', '0743532124', 'Strada Grui, nr 5');

insert into user (username, nume, prenume, nr_telefon, adresa)
values ('Theoss', 'Stana', 'Theodora', '0745423145', 'Strada Rezervelor, nr 7');

insert into firma_livrare (denumire) value ('FoodPanda');

insert into local (denumire_local, adresa, oras)
VALUES ('McDonalds', 'Bd. Republicii', 'Ploiesti');

insert into local (denumire_local, adresa, oras)
VALUES ('KFC', 'Str. Calomfirescu', 'Ploiesti');

insert into local (denumire_local, adresa, oras)
VALUES ('Hercule', 'DN1 KM.6', 'Blejoi');

insert into produs (local_id, denumire_produs, pret)
VALUES (1, 'McPuisor', 3.90);

insert into produs (local_id, denumire_produs, pret)
VALUES (1, 'Big Mac', 9.00);

insert into produs (local_id, denumire_produs, pret)
VALUES (1, 'Big Tasty', 11.00);

insert into produs (local_id, denumire_produs, pret)
VALUES (2, 'Smart Menu', 15.90);

insert into produs (local_id, denumire_produs, pret)
VALUES (2, 'Booster', 3.90);

insert into produs (local_id, denumire_produs, pret)
VALUES (2, 'Crispy Sandwich', 3.90);

insert into produs (local_id, denumire_produs, pret)
VALUES (3, 'Gyros pita', 18);

insert into produs (local_id, denumire_produs, pret)
VALUES (3, 'Gyros la farfurie', 9.00);

insert into produs (local_id, denumire_produs, pret)
VALUES (3, 'Souvlaki', 11.00);

insert into ingredient (denumire_ingredient) value ('Crispy Strips');

insert into ingredient (denumire_ingredient) value ('Hot Wings');

insert into ingredient (denumire_ingredient) value ('Cartofi Prajiti');

insert into ingredient (denumire_ingredient) value ('Sos de usturoi');

insert into ingredient (denumire_ingredient) value ('Suc');

insert into ingredient (denumire_ingredient) value ('Chifla');

insert into ingredient (denumire_ingredient) value ('Apa');

insert into ingredient (denumire_ingredient) value ('Zahar');

insert into ingredient (denumire_ingredient) value ('Ulei');

insert into ingredient (denumire_ingredient) value ('Carne');

insert into ingredient (denumire_ingredient) value ('Maioneza');

insert into ingredient (denumire_ingredient) value ('Salata');

insert into ingredient (denumire_ingredient) value ('Cascaval');

insert into ingredient (denumire_ingredient) value ('Castraveti');

insert into ingredient (denumire_ingredient) value ('Ketchup');

insert into ingredient (denumire_ingredient) value ('Rosii');

insert into ingredient (denumire_ingredient) value ('Piept de pui');

insert into ingredient (denumire_ingredient) value ('Varza');

insert into ingredient (denumire_ingredient) value ('Ceapa');

insert into ingredient (denumire_ingredient) value ('Usturoi');

insert into ingredient (denumire_ingredient) value ('Oregano');

insert into ingredient (denumire_ingredient) value ('Zeama de lamaie');

insert into ingredient (denumire_ingredient) value ('Piper macinat');

insert into ingredient (denumire_ingredient) value ('Sare');

insert into ingredient (denumire_ingredient) value ('Ulei de masline');

insert into alocare (produs_id, ingredient, cantitate)
VALUES (1, 'Chifla', 40);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (1, 'Apa', 10);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (1, 'Zahar', 20);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (1, 'Ulei', 20);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (1, 'Carne', 50);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (1, 'Maioneza', 30);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (2, 'Chifla', 60);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (2, 'Apa', 30);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (2, 'Salata', 40);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (2, 'Maioneza', 40);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (2, 'Carne', 70);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (2, 'Cascaval', 50);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (2, 'Castraveti', 20);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (3, 'Chifla', 80);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (3, 'Salata', 60);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (3, 'Maioneza', 80);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (3, 'Ketchup', 70);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (3, 'Rosii', 40);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (3, 'Carne', 100);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (3, 'Castraveti', 40);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (4, 'Cartofi Prajiti', 80);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (4, 'Hot Wings', 3);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (4, 'Crispy Strips', 2);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (4, 'Sos de usturoi', 1);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (4, 'Suc', 0.33);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (5, 'Chifla', 40);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (5, 'Apa', 10);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (5, 'Zahar', 20);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (5, 'Ulei', 20);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (5, 'Carne', 50);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (5, 'Maioneza', 30);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (6, 'Chifla', 40);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (6, 'Carne', 70);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (6, 'Maioneza', 20);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (6, 'Salata', 30);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (7, 'Piept de pui', 300);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (7, 'Castraveti', 300);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (7, 'Salata', 300);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (7, 'Varza', 40);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (7, 'Ceapa', 20);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (7, 'Rosii', 20);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (7, 'Maioneza', 10);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (7, 'Ulei', 10);

insert into alocare (produs_id, ingredient, cantitate)
VALUES (7, 'Usturoi', 5);

