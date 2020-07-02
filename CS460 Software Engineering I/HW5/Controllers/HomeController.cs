using HW5.DAL;
using System.Data;
using System.Data.Entity;
using HW5.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace HW5.Controllers
{
    public class HomeController : Controller
    {
        private HomeworkContext db = new HomeworkContext();

        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Create()
        {
            return View();
        }

        public ActionResult ViewAll()
        {
            var table = db.Homeworks.ToList();
            return View(table);
        }

        public ActionResult Confirmation()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Create([Bind(Include = "Title,Priority,Date,Time,Department,Course,Notes")] Homework hw)
        {
            if (ModelState.IsValid)
            {
                db.Homeworks.Add(hw);
                db.SaveChanges();
                return RedirectToAction("Confirmation");
            }
            return View(hw);
        }
    }
}