Create Table [dbo].[Team]
(
	[Id] INT identity (1,1) NOT NULL,
	[TeamName] NCHAR(32) NOT NULL,
	[Coach] NCHAR(32) NOT NULL,
	PRIMARY KEY ([Id])
);

Create Table [dbo].[Athlete]
(
	[Id] INT identity (1,1) NOT NULL,
	[AthleteName] NCHAR(32) NOT NULL,
	[Gender] NCHAR(8) NOT NULL,
	[TeamId] INT NOT NULL,
	PRIMARY KEY ([Id]),
	FOREIGN KEY ([TeamId]) REFERENCES Team([Id]) ON DELETE CASCADE
);

Create Table [dbo].[Meet]
(
	[Id] INT identity (1,1) NOT NULL,
	[MeetLocation] NCHAR(64) NOT NULL,
    [MeetDate] DATETIME NOT NULL,
	PRIMARY KEY ([Id])
);

Create Table [dbo].[Race]
(
	[Id] INT identity (1,1) NOT NULL,
	[AthleteId] INT NOT NULL,
	[MeetId] INT NOT NULL,
	[Event] NCHAR(16) NOT NULL,
	[RecordedTime] Numeric(8,2) NOT NULL,
	PRIMARY KEY ([Id]),
	FOREIGN KEY ([AthleteId]) REFERENCES Athlete([Id]) ON DELETE CASCADE,
	FOREIGN KEY ([MeetId]) REFERENCES Meet([Id]) ON DELETE CASCADE
);


