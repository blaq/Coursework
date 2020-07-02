using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace HW8.Models
{
    public class PointsViewModel
    {
        public PointsViewModel(AthleteViewModel r)
        {
            x = r.MeetDate.Subtract(new DateTime(1970, 1, 1)).TotalMilliseconds;
            y = r.Time;
        }
        public double x { get; set; }
        public decimal y { get; set; }
    }
}