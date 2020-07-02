namespace HW8.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("Race")]
    public partial class Race
    {
        public int Id { get; set; }

        public int AthleteId { get; set; }

        public int MeetId { get; set; }

        [Required]
        [StringLength(32)]
        public string Event { get; set; }

        [Column(TypeName = "numeric")]
        public decimal RecordedTime { get; set; }

        public virtual Athlete Athlete { get; set; }

        public virtual Meet Meet { get; set; }
    }
}
