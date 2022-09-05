create table viajante(
id_viajante int primary key auto_increment,
nome varchar(40),
data_viagem_ida date,
data_viagem_volta date,
id_local int,
foreign key (id_local) REFERENCES locais(id_local)

)
create table locais(
id_local int primary key,
nome_local varchar(40),
valor int
)