using HW8.DAL;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace HW8.Models
{
    public class AthleteViewModel
    {
        private RTContext DB = new RTContext();
        public AthleteViewModel(Race r)
        {
            AthleteName = DB.Athletes.Find(r.AthleteId).AthleteName;
            MeetDate = DB.Meets.Find(r.MeetId).MeetDate;
            EventTitle = r.Event;
            MeetTitle = DB.Meets.Find(r.MeetId).MeetLocation;
            Time = r.RecordedTime;
        }

        public string AthleteName { get; private set; }
        public DateTime MeetDate { get; private set; }
        public string EventTitle { get; private set; }
        public string MeetTitle { get; private set; }
        public decimal Time { get; private set; }
    }
}