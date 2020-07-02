using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using HW6.DAL;
using HW6.Models.ViewModels;

namespace HW6.Controllers
{
    public class StockItemController : Controller
    {
        private WorldWideImportersContext db = new WorldWideImportersContext();

        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(System.Net.HttpStatusCode.BadRequest);
            }

            var found = db.StockItems.Find(id);

            if (found == null)
            {
                return HttpNotFound();
            }

            StockItemDetailsViewModel viewModel = new StockItemDetailsViewModel(found);
            return View(viewModel);
        }
    }
}