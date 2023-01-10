USE isld;

CREATE TABLE singleplayer(
No INT,
Name VARCHAR(10),
Score INT,
Enemy VARCHAR(5));

CREATE TABLE multiplayer(
No INT,
Name1 VARCHAR(10),
Name2 VARCHAR(10),
Score INT,
Enemy VARCHAR(5));

INSERT INTO singleplayer VALUES (1,"Ali", 537, "PRT");
INSERT INTO singleplayer VALUES (2,"Aisyah", 509,"JPN");
INSERT INTO singleplayer VALUES (3,"Ilpi", 476,"NLD");
INSERT INTO singleplayer VALUES (4,"Rifqi", 393,"JPN");
INSERT INTO singleplayer VALUES (5,"Ajis", 366,"PRT");
INSERT INTO singleplayer VALUES (6,"Jesika", 312,"JPN");
INSERT INTO singleplayer VALUES (7,"Tiara",222 ,"PRT");
INSERT INTO singleplayer VALUES (8,"Kohwan", 182,"NLD");
INSERT INTO singleplayer VALUES (9,"Nana", 110,"PRT");
INSERT INTO singleplayer VALUES (10,"Reyhan", 64,"JPN");
INSERT INTO singleplayer VALUES (11,"", 0,"");

INSERT INTO multiplayer VALUES (1,"Ali","Ilpi", 419,"JPN");
INSERT INTO multiplayer VALUES (2,"Ajis","Jesika", 382,"PRT");
INSERT INTO multiplayer VALUES (3,"Nana", "Kohwan",318,"JPN");
INSERT INTO multiplayer VALUES (4,"Aisyah","Tri", 254,"NLD");
INSERT INTO multiplayer VALUES (5,"Refrisca", "Fajar",226,"PRT");
INSERT INTO multiplayer VALUES (6,"Tiara","Steven", 179,"JPN");
INSERT INTO multiplayer VALUES (7,"Khalid","Iki", 144,"PRT");
INSERT INTO multiplayer VALUES (8,"Adi", "Fauzi",105,"JPN");
INSERT INTO multiplayer VALUES (9,"Ihsan","Lintang", 93,"NLD");
INSERT INTO multiplayer VALUES (10,"Rifqi","Sajidah", 68,"NLD");
INSERT INTO multiplayer VALUES (11,"","", 0,"");

SELECT * FROM singleplayer;
SELECT * FROM historymultiplayer;
select * from singleplayer order by score desc limit 10;

Delete FROM singleplayer WHERE No =10;
DROP table singleplayer;
UPDATE multiplayer SET Name2 = 'Ali' WHERE No = 10;
SELECT * FROM historysingleplayer ORDER BY NoID DESC LIMIT 4;

CREATE TABLE historysingleplayer(
NoID INT AUTO_INCREMENT PRIMARY KEY,
Name VARCHAR(10),
Score INT,
Enemy VARCHAR(5));

CREATE TABLE historymultiplayer(
NoID INT AUTO_INCREMENT PRIMARY KEY,
Name1 VARCHAR(10),
Name2 VARCHAR(10),
Score INT,
Enemy VARCHAR(5));

INSERT INTO historysingleplayer (Name,Score,Enemy) VALUES ("Ali", 537, "PRT");
INSERT INTO historysingleplayer (Name,Score,Enemy)VALUES ("Aisyah", 509,"JPN");
INSERT INTO historysingleplayer (Name,Score,Enemy)VALUES ("Ilpi", 476,"NLD");
INSERT INTO historysingleplayer (Name,Score,Enemy)VALUES ("Rifqi", 393,"JPN");
INSERT INTO historysingleplayer (Name,Score,Enemy)VALUES ("Ajis", 366,"PRT");
INSERT INTO historysingleplayer(Name,Score,Enemy) VALUES ("Jesika", 312,"JPN");
INSERT INTO historysingleplayer(Name,Score,Enemy) VALUES ("Tiara",222 ,"PRT");
INSERT INTO historysingleplayer (Name,Score,Enemy)VALUES ("Kohwan", 182,"NLD");
INSERT INTO historysingleplayer (Name,Score,Enemy)VALUES ("Nana", 110,"PRT");
INSERT INTO historysingleplayer (Name,Score,Enemy)VALUES ("Reyhan", 64,"JPN");

INSERT INTO historymultiplayer(Name1,Name2,Score,Enemy) VALUES ("Ali","Ilpi", 419,"JPN");
INSERT INTO historymultiplayer (Name1,Name2,Score,Enemy)VALUES ("Ajis","Jesika", 382,"PRT");
INSERT INTO historymultiplayer (Name1,Name2,Score,Enemy)VALUES ("Nana", "Kohwan",318,"JPN");
INSERT INTO historymultiplayer (Name1,Name2,Score,Enemy)VALUES ("Aisyah","Tri", 254,"NLD");
INSERT INTO historymultiplayer(Name1,Name2,Score,Enemy) VALUES ("Refrisca", "Fajar",226,"PRT");
INSERT INTO historymultiplayer (Name1,Name2,Score,Enemy)VALUES ("Tiara","Steven", 179,"JPN");
INSERT INTO historymultiplayer(Name1,Name2,Score,Enemy) VALUES ("Khalid","Iki", 144,"PRT");
INSERT INTO historymultiplayer (Name1,Name2,Score,Enemy)VALUES ("Adi", "Fauzi",105,"JPN");
INSERT INTO historymultiplayer (Name1,Name2,Score,Enemy)VALUES ("Ihsan","Lintang", 93,"NLD");
INSERT INTO historymultiplayer (Name1,Name2,Score,Enemy)VALUES ("Rifqi","Sajidah", 68,"NLD");