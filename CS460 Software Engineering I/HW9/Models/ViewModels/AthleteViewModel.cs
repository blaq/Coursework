using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using HW8.Models;
using HW8.DAL;

namespace HW8.Models.ViewModels
{
    public class AthleteViewModel
    {
        private RTContext DB = new RTContext();

        public AthleteViewModel()
        { }

        public int AthleteId { get; private set; }
        public string AthleteName { get; private set; }
        public string AthleteGender { get; private set; }
        public int AthleteTeamId { get; private set; }
        public List<string> GenderList { get; private set; }
        public IQueryable<string> TeamList { get; private set; }
    }
}