Create Table [dbo].[Homework]
(
	[Id] INT identity (1,1) NOT NULL, 
	[Title] NCHAR(10) NOT NULL,
	[Priority] INT NOT NULL, 
    [Date] DATE NOT NULL, 
	[Time] TIME NOT NULL,
	[Department] NCHAR(10) NOT NULL,
    [Course] NCHAR(10) NOT NULL,
    [Notes] NCHAR(10) NULL
	CONSTRAINT [PK_dbo.Homework] PRIMARY KEY CLUSTERED ([Id] ASC)
);

INSERT INTO [dbo].[Homework] (Title, Priority, Date, Time, Department, Course, Notes) VALUES
		('one', 1, '2019-10-7', '01:00:00', 'cs', '460', null),
		('one', 2, '2019-10-2', '00:01:00', 'mth', '341', null),
		('two', 3, '2019-10-4', '00:00:01', 'mth', '341', null),
		('two', 4, '2019-11-4', '00:00:20', 'cs', '460', null),
		('spare', 99, '2019-12-4', '00:03:00', 'mth', '341', 'optional')
GO