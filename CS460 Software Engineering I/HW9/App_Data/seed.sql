
-- ################### SEED DATA ######################

-- Extract data from .csv file and load into our db

-- Create a staging table to hold all the seed data.  We'll query this 
-- table in order to extract what we need to then insert into our real
-- tables.

CREATE TABLE [dbo].[AllData]
(
	[Location] NVARCHAR(50),
	[MeetDate] DATETIME,
	[Team] NVARCHAR(50),
	[Coach] NVARCHAR(50),
	[Event] NVARCHAR(20),
	[Gender] NVARCHAR(20),
	[Athlete] NVARCHAR(50),
	[RaceTime] REAL
);

BULK INSERT [dbo].[AllData]
	FROM 'D:\school\CS460\racetimes.csv'
	WITH
	(
		FIELDTERMINATOR = ',',
		ROWTERMINATOR = '\n',
		FIRSTROW = 2
	);


INSERT INTO [dbo].[Team] (TeamName, Coach)
	SELECT DISTINCT Team, Coach 
	FROM [dbo].[AllData];


INSERT INTO [dbo].[Athlete] (AthleteName, Gender, TeamId)
	SELECT DISTINCT Athlete, Gender, ( SELECT Id FROM Team WHERE Team.TeamName = Team ) 
	FROM [dbo].[AllData];


INSERT INTO [dbo].[Meet] (MeetLocation, MeetDate)
	SELECT DISTINCT Location, MeetDate
	FROM [dbo].[AllData];


INSERT INTO [dbo].[Race] (AthleteId, MeetId, Event, RecordedTime)
	SELECT DISTINCT
		( SELECT Id FROM Athlete WHERE Athlete.AthleteName = Athlete ),
		( SELECT Id FROM Meet WHERE Meet.MeetLocation = Location ),
		Event,
		RaceTime
	FROM [dbo].[AllData];

DROP TABLE [dbo].[AllData];