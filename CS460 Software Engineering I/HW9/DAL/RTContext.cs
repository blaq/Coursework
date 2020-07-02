using HW8.Models;

namespace HW8.DAL
{
    using System;
    using System.Data.Entity;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Linq;

    public partial class RTContext : DbContext
    {
        public RTContext()
            : base("name=TrackFieldDB_Azure")
        {
        }

        public virtual DbSet<Athlete> Athletes { get; set; }
        public virtual DbSet<Meet> Meets { get; set; }
        public virtual DbSet<Race> Races { get; set; }
        public virtual DbSet<Team> Teams { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Athlete>()
                .Property(e => e.AthleteName)
                .IsFixedLength();

            modelBuilder.Entity<Athlete>()
                .Property(e => e.Gender)
                .IsFixedLength();

            modelBuilder.Entity<Meet>()
                .Property(e => e.MeetLocation)
                .IsFixedLength();

            modelBuilder.Entity<Race>()
                .Property(e => e.RecordedTime)
                .HasPrecision(8, 2);

            modelBuilder.Entity<Team>()
                .Property(e => e.TeamName)
                .IsFixedLength();

            modelBuilder.Entity<Team>()
                .Property(e => e.Coach)
                .IsFixedLength();
        }
    }
}
