using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

/*
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
	CONSTRAINT [PK_dbo.Homeworks] PRIMARY KEY CLUSTERED ([Id] ASC)
);
*/


namespace HW5.Models
{
    public class Homework
    {
        [Key]
        public int ID { get; set; }

        [DisplayName("Title")]
        [StringLength(64)]
        [Required]
        public string Title  { get; set; }

        [DisplayName("Priority")]
        [Required]
        public int Priority { get; set; }

        [DisplayName("Date")]
        [Required]
        public DateTime Date { get; set; }

        [DisplayName("Time")]
        [Required]
        public TimeSpan Time { get; set; }

        [DisplayName("Department")]
        [StringLength(64)]
        [Required]
        public string Department { get; set; }

        [DisplayName("Course")]
        [StringLength(64)]
        [Required]
        public string Course { get; set; }

        [DisplayName("Notes")]
        [StringLength(128)]
        public string Notes { get; set; }
    }
}