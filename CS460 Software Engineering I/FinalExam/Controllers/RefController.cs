using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace FinalExam.Controllers
{
    public class RefController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        //[HttpGet] use this if updating page form html variables
        public ActionResult QueryString(int? number)
        {
            if (number == null)
            {
                return new HttpStatusCodeResult(System.Net.HttpStatusCode.BadRequest);
            }

            ViewBag.QS = number;

            return View();
        }
    }
}