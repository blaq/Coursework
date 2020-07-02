using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using HW6.DAL;

namespace HW6.Controllers
{
    public class HomeController : Controller
    {
        private WorldWideImportersContext db = new WorldWideImportersContext();

        [HttpGet]
        public ActionResult Index()
        {
            var ls = new List<HW6.Models.StockItem>();

            var search = Request.QueryString["search"];
            ViewBag.Found = "";

            if (search == string.Empty)
            {
                ViewBag.Found = "No search term entered.";
            }
            else if (search != null)
            {
                ls = db.StockItems.Where(r => r.StockItemName.Contains(search)).ToList();

                if (ls.Count() == 0)
                {
                    ViewBag.Found = "No results for \"" + search + "\".";
                }

                else
                {
                    ViewBag.Found = "Results for \"" + search + "\".";
                }
            }

            return View(ls);
        }
    }
}