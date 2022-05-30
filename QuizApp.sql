use `QuizDB`;

CREATE TABLE `Quiz` (
  `quizID` BIGINT NOT NULL AUTO_INCREMENT,
  `tID` BIGINT,
  `courseID` BIGINT,
  `Title` TEXT(65535),
  `Description` TEXT(65535),
  `Score` INT,
  `StartsAt` DATETIME,
  `EndsAt` DATETIME,
  `PublishedAt` DATETIME,
  `Published` BOOL,
  PRIMARY KEY (`quizID`),
  FOREIGN KEY (`tID`) REFERENCES `Teacher` (`tID`),
  FOREIGN KEY (`courseID`) REFERENCES `Course` (`courseID`)   
);

CREATE TABLE `Choice` (
  `chID` BIGINT NOT NULL AUTO_INCREMENT,
  `qID` BIGINT,
  `isCorrect` BOOL,
  `CreatedAt` DATETIME,
  `UpdatedAt` DATETIME,
  `Content` TEXT(65535) NOT NULL,
  `FlashCard` TEXT(65535),
  PRIMARY KEY (`chID`),
  FOREIGN KEY (`qID`) REFERENCES `Questions` (`qID`)  
);

CREATE TABLE `Questions` (
  `qID` BIGINT NOT NULL AUTO_INCREMENT,
  `quizID` BIGINT,
  `Type` TEXT(65535),
  `UpdatedAt` DATETIME,
  `CreatedAt` DATETIME,
  `Content` TEXT(65535) NOT NULL,
  PRIMARY KEY (`qID`),
  FOREIGN KEY (`quizID`) REFERENCES `Quiz` (`quizID`)
);

CREATE TABLE `Course` (
  `courseID` BIGINT NOT NULL AUTO_INCREMENT,
  `tID` BIGINT,
  `CourseName` VARCHAR(255),
  `Description` TEXT(65535),
  PRIMARY KEY (`courseID`),
  FOREIGN KEY (`tID`) REFERENCES `Teacher` (`tID`)  
);

CREATE TABLE `Student` (
  `sID` BIGINT NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(255) NOT NULL,
  `LastName` VARCHAR(255) NOT NULL,
  `Username` VARCHAR(255) NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  `Password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`sID`),
  KEY `UNIQUE` (`Username`, `Email`, `Password`)
);

CREATE TABLE `Admin` (
  `aID` BIGINT NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(255) NOT NULL,
  `LastName` VARCHAR(255) NOT NULL,
  `Username` VARCHAR(255) NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  `Password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`aID`),
  KEY `UNIQUE` (`Username`, `Email`, `Password`)
);

CREATE TABLE `Teacher` (
  `tID` BIGINT NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(255) NOT NULL,
  `LName` VARCHAR(255) NOT NULL,
  `Username` VARCHAR(255) NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  `Password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`tID`),
  KEY `UNIQUE` (`Username`, `Email`, `Password`)
);

CREATE TABLE `Result` (
  `rID` BIGINT NOT NULL AUTO_INCREMENT,
  `quizID` BIGINT,
  `sID` BIGINT,
  `ScoredMarks` INT,
  `Date` DATETIME,
  PRIMARY KEY (`rID`),
  FOREIGN KEY (`quizID`) REFERENCES `Quiz`(`quizID`),
  FOREIGN KEY (`sID`) REFERENCES `Student`(`sID`)
);

CREATE TABLE `StdAnswer` (
  `ansID` BIGINT NOT NULL AUTO_INCREMENT,
  `chID` BIGINT,
  `sID` BIGINT,
  `CreatedAt` DATETIME,
  `UpdatedAt` DATETIME,
  PRIMARY KEY (`ansID`),
  FOREIGN KEY (`sID`) REFERENCES `Student`(`sID`),
  FOREIGN KEY (`chID`) REFERENCES `Choice`(`chID`)
);












