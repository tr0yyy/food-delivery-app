CREATE TABLE user(
	username varchar(255) not null,
    nume varchar(255) not null,
    prenume varchar(255) not null,
    nr_telefon varchar(255) not null,
    adresa varchar(255) not null,
    primary key (username)
    );
    
CREATE TABLE firma_livrare(
	firma_livrare_id int not null,
    denumire varchar(255) not null,
    primary key (firma_livrare_id),
    unique (denumire)
    );
    
CREATE TABLE local(
	local_id int not null,
    denumire_local varchar(255) not null,
    adresa varchar(255) not null,
    oras varchar(255) not null,
    primary key (local_id),
    unique (denumire_local)
    );
    
CREATE TABLE produs(
	produs_id int not null,
    local_id int,
    denumire_produs varchar(255) not null,
    pret float,
    primary key (produs_id),
    foreign key (local_id) references local(local_id)
    );
    
CREATE TABLE ingredient(
	ingredient_id int not null,
    produs_id int,
    denumire_ingredient varchar(255) not null,
    cantitate float not null,
    primary key (ingredient_id),
    foreign key (produs_id) references produs(produs_id)
    );
    
CREATE TABLE comanda(
	comanda_id int not null,
    username varchar(255) not null,
    denumire_local varchar(255) not null,
    firma_livrare varchar(255) not null,
    pret float not null,
    primary key (comanda_id),
    foreign key (username) references user(username),
    foreign key (denumire_local) references local(denumire_local),
    foreign key (firma_livrare) references firma_livrare(denumire)
)
    