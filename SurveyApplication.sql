create database surveyApplication;

create table Users
(
	userName	varchar(100),
    email		varchar(100)	primary key,
    pass		varchar(100),
    isAdmin		boolean,
    isSuspended	boolean
);

create table Sessions
(
	sessionID	varchar(100)	primary key,
    email		varchar(100),
    foreign key (email) references Users(email)
);

create table Surveys
(
	surveyName		varchar(100),
	creatorEmail	varchar(100),
    isClosed		boolean,
    isSuspended		boolean,
    primary key (surveyName, creatorEmail),
    foreign key(userEmail) references Users(email)
);

create table Questions
(
	questionID		varchar(100)	primary key,
	question		varchar(100),
    questionType	varchar(100),
    surveyName		varchar(100),
    creatorEmail	varchar(100),
    foreign key (surveyName,creatorEmail) references Surveys(surveyName, creatorEmail)
);

create table choices
(
	choice			varchar(100),
    questionID		varchar(100),
    foreign key(questionID) references Questions(questionID)
);

create table Reports
(
	reportMsg				varchar(200),
    reportUser				varchar(100),
    surveyName				varchar(100),
    surveyCreatorEmail		varchar(100),
    foreign key (surveyName,surveyCreatorEmail) references Surveys(surveyName, creatorEmail)
);

create table answeredQuestions
(
	surveyName	varchar(100),
    creatorEmail	varchar(100),
    userEmail		varchar(100),
    questionID		varchar(100),
    answer			varchar(200),
    
    foreign key (surveyName,creatorEmail) references Surveys(surveyName, creatorEmail),
    foreign Key (userEmail) references Users (email),
	foreign Key (questionID) references Questions (questionID)
    
);