using System;
using System.Collections.Generic;
using System.Linq;
using System.Web.Mvc;
using HW8.DAL;
using HW8.Models;
using Newtonsoft.Json;

namespace HW8.Controllers
{
    public class CoachController : Controller
    {
        private RTContext DB = new RTContext();

        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Athletes()
        {
            var table = DB.Athletes.ToList();
            return View(table);
        }

        public ActionResult AddAthlete()
        {
            ViewBag.Success = "";
            ViewBag.Teams = DB.Teams.ToList();
            return View();
        }

        public ActionResult AddMeet()
        {
            ViewBag.Success = "";
            return View();
        }

        public ActionResult AddRace()
        {
            ViewBag.Athletes = DB.Athletes.ToList();
            ViewBag.Meets = DB.Meets.ToList();
            ViewBag.Races = DB.Races.Select(row => row.Event).Distinct().ToList();
            ViewBag.Success = "";
            return View();
        }

        public ActionResult Athlete(int? id)
        {
            ViewBag.Athletes = DB.Athletes.ToList();

            if (id == null)
            {
                return new HttpStatusCodeResult(System.Net.HttpStatusCode.BadRequest);
            }

            var list = DB.Races.Where(x => x.AthleteId == id);

            if (list == null)
            {
                return HttpNotFound();
            }

            var results = new List<AthleteViewModel>();
            foreach (var item in list)
            {
                var temp = new AthleteViewModel(item);
                results.Add(temp);
            }

            ViewBag.CurrentAthlete = DB.Athletes.Find(id).AthleteName;

            return View(results);
        }

        public ActionResult Graphs()
        {
            var list = DB.Races.Where(x => x.AthleteId == 1).Where(x => x.Event == "3000").OrderBy(x => x.MeetId);
            var results = new List<AthleteViewModel>();
            var points = new List<PointsViewModel>();

            foreach (var item in list)
            {
                var temp = new AthleteViewModel(item);
                var temper = new PointsViewModel(temp);
                points.Add(temper);
            }


            return View(points);
        }


        [HttpPost]
        public ActionResult AddAthlete([Bind(Include = "AthleteName,Gender,TeamId")] Athlete racer)
        {

            ViewBag.Teams = DB.Teams.ToList();
            if (ModelState.IsValid)
            {
                DB.Athletes.Add(racer);
                DB.SaveChanges();
                ViewBag.Success = "Athlete was saved";
            }
            else
            {
                ViewBag.Success = "Athlete was not saved";
            }
            return View(racer);
        }

        [HttpPost]
        public ActionResult AddMeet([Bind(Include = "MeetLocation,MeetDate")] Meet meet)
        {
            if (ModelState.IsValid)
            {
                DB.Meets.Add(meet);
                DB.SaveChanges();
                ViewBag.Success = "Meet was saved";
            }
            else
            {
                ViewBag.Success = "Meet was not saved";
            }
            return View(meet);
        }

        [HttpPost]
        public ActionResult AddRace([Bind(Include = "AthleteId,MeetId,Event,RecordedTime")] Race record)
        {
            ViewBag.Athletes = DB.Athletes.ToList();
            ViewBag.Meets = DB.Meets.ToList();
            ViewBag.Races = DB.Races.Select(row => row.Event).Distinct().ToList();

            if (ModelState.IsValid)
            {
                DB.Races.Add(record);
                DB.SaveChanges();
                ViewBag.Success = "Race was saved";
            }
            else
            {
                ViewBag.Success = "Race was not saved";
            }
            return View(record);
        }
    }
}