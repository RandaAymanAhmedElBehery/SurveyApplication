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
    foreign key(creatorEmail) references Users(email)
);

create table Questions
(
	questionNumber	int	,
	question		varchar(100),
    questionType	varchar(100),
    surveyName		varchar(100),
    creatorEmail	varchar(100),
    foreign key (surveyName,creatorEmail) references Surveys(surveyName, creatorEmail),
    primary key (questionNumber,surveyName,creatorEmail)
);

create table choices
(
	choice			varchar(100),
    questionNumber	int,
    surveyName		varchar(100),
    creatorEmail	varchar(100),
    foreign key(questionNumber,surveyName,creatorEmail) references Questions(questionNumber,surveyName,creatorEmail)
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
    questionNumber	int,
    answer			varchar(200),
    
    foreign Key (userEmail) references Users (email),
    foreign key(questionNumber,surveyName,creatorEmail) references Questions(questionNumber,surveyName,creatorEmail)
    
);

create table Messages
(
	msgID	int		auto_increment,
	msg		varchar(500),
    primary key (msgID)
);

create table userMsg
(
	email	varchar(100),
	msgID	int,
	primary key (email, msgID),
    foreign key (email) references users(email),
    foreign key (msgID) references Messages(msgID)
);

