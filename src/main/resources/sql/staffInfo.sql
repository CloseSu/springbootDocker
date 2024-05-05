CREATE TABLE `staffInfo`
(
    `ID`          int(11) NOT NULL AUTO_INCREMENT,
    `EMAIL`       varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
    `PASSWORD`    varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
    `POSITION`    varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
    `PHONE`       varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
    `CREATE_DATE` datetime                            DEFAULT NULL,
    PRIMARY KEY (`ID`)
);