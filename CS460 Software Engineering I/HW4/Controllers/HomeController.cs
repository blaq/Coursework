using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.UI.WebControls;

namespace HW4.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        [HttpGet]
        public ActionResult RGBColor()
        {
            try
            {
                var r = Int32.Parse(Request.QueryString["R"]);
                var g = Int32.Parse(Request.QueryString["G"]);
                var b = Int32.Parse(Request.QueryString["B"]);

                var myColor = Color.FromArgb(r, g, b);
                string hexColor = '#' + myColor.R.ToString("X2") + myColor.G.ToString("X2") + myColor.B.ToString("X2");

                ViewBag.Color = hexColor;
            }
            catch (System.ArgumentNullException) { }
            catch (System.FormatException) { }

            return View();
        }
    }
}