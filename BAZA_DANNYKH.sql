CREATE DATABASE Progress;
USE Progress;
CREATE TABLE User 
(IDUser int not null auto_increment,
UserName varchar(40) not null,
UserPassword varchar(100) not null,
CONSTRAINT PK_User PRIMARY KEY(IDUser));

CREATE TABLE Title
(IDTitle int not null auto_increment,
Name varchar (255) not null,
Description text not null,
CONSTRAINT PK_Title PRIMARY KEY(IDTitle));

CREATE TABLE Episode
(IDEpisode int not null auto_increment,
Name varchar (200) not null,
Description text not null,
Length decimal (6, 2) not null,
IDTitle int not null,
CONSTRAINT PK_Episode PRIMARY KEY(IDepisode),
CONSTRAINT FK_Title_Episode FOREIGN KEY(IDTitle)
	REFERENCES Title (IDTitle)
		ON DELETE CASCADE
        ON UPDATE CASCADE);

CREATE TABLE Now_Watching
(IDEpisode int not null,
IDUser int not null,
IDTitle int not null,
CONSTRAINT PK_Now_Watching PRIMARY KEY(IDEpisode, IDUser, IDTitle),
CONSTRAINT FK_User_Now_watching FOREIGN KEY(IDUser)
	REFERENCES User (IDUser)
		ON DELETE CASCADE
        ON UPDATE CASCADE,
CONSTRAINT FK_Title_Now_Watching FOREIGN KEY(IDTitle)
	REFERENCES Title (IDTitle)
		ON DELETE CASCADE
        ON UPDATE CASCADE,
CONSTRAINT FK_Episode_Now_watching FOREIGN KEY(IDepisode)
	REFERENCES Episode (IDEpisode)
		ON DELETE CASCADE
        ON UPDATE CASCADE);



