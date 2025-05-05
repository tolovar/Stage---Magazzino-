drop database MagazzinoResistenze;
create database if not exists MagazzinoResistenze;
use MagazzinoResistenze;
create table `Articoli` (
`IdArticolo` int not null auto_increment,
`Descrizione` varchar(100) not null, 
`N pz per locazione` int not null, 
primary key(`IdArticolo`)
);
create table `Locazioni` (
`IdLocazione` int not null auto_increment,
`Magazzino` varchar(50) not null,
`Corridoio` char(1) not null,
`Scaffale` int not null,
`Ripiano` int not null,
`Cella` char(1) not null,
primary key(`IdLocazione`)	
);
create table `Movimenti` (
`IdMovimento` int not null auto_increment,
`DataOraIn` datetime,
`DataOraOut` datetime,
`IdArticolo` int not null,
`Lotto` varchar(20) not null, 
`IdLocazione` int not null,
`Assegnato S/N` bit not null, 
`InEntrata` bit,
`InUscita` bit, 
`IdOrdineR` int not null,
`Confermato` bit not null,
primary key (`IdMovimento`),
foreign key (`IdArticolo`) REFERENCES `Articoli`(`IdArticolo`),
foreign key (`IdLocazione`) REFERENCES `Locazioni`(`IdLocazione`),
foreign key (`IdOrdineR`) REFERENCES `OrdiniR`(`IdOrdineR`)
);
create table `Missioni T` (
`IdMissioneT` int not null auto_increment,
`Assegnatario` varchar(50) not null, 
`Data` date not null,
primary key(`IdMissioneT`)
);
create table `MissioniR` (
`IdMissioneR` int not null auto_increment,
`IdMissioneT` int not null,
`IdMovimento` int not null, 
primary key (`IdMissioneR`),
foreign key (`IdMissioneT`) REFERENCES `Missioni T`(`IdMissioneT`),
foreign key (`IdMovimento`) REFERENCES `Movimenti`(`IdMovimento`)
);
create table `OrdiniT` (
`IdOrdineT` int not null auto_increment,
`Cliente` varchar(50) not null,
 `Data` date not null, 
 `NumeroOrdine` int not null,
 primary key (`IdOrdineT`)
);
 create table `OrdiniR` (
 `IdOrdineR` int not null auto_increment,
 `IdOrdineT` int not null,
 `IdArticolo` int not null,
 primary key (`IdOrdineR`),
 foreign key (`IdOrdineT`) REFERENCES `OrdiniT`(`IdOrdineT`),
 foreign key (`IdArticolo`) REFERENCES `Articoli`(`IdArticolo`)
 );
 create table `Utenti` (
 `IdUtente` int not null auto_increment,
 `Cognome` varchar (30) not null,
 `Nome` varchar (30) not null,
 `Username` varchar (20) unique not null,
 `Password` varchar (20) not null,
 primary key (`IdUtente`)
 ); 
 
