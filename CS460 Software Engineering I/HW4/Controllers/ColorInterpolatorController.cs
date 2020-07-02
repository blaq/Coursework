using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace HW4.Controllers
{
    public class ColorInterpolatorController : Controller
    {
        // GET: ColorInterpolator
        public ActionResult Index()
        {
            return View();
        }

        [HttpGet]
        public ActionResult Create()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Create(string color1, string color2, int? num)
        {
            try
            {
                System.Diagnostics.Debug.WriteLine(color1);
                System.Diagnostics.Debug.WriteLine(color2);
                System.Diagnostics.Debug.WriteLine(num);
                List<string> colors = new List<string>();
                colors.Add("Hello");
                ViewBag.test = colors;
                if (num == null)
                {
                    num = 0;
                }
                ViewBag.Color1 = "";
                ViewBag.Color2 = "";

                if (CheckIfHex(color1) == true && CheckIfHex(color2) == true)
                {
                    System.Diagnostics.Debug.WriteLine("Both are hex");

                    Color first = ColorTranslator.FromHtml(color1);
                    Color last = ColorTranslator.FromHtml(color2);

                    colors.Add(color1);
                    colors.Add(color2);

                    ViewBag.Color1 = color1;
                    ViewBag.Color2 = color2;
                    ViewBag.Num = num;
                }


            }
            catch { }

            return View();
        }  

        public bool CheckIfHex(string str)
        {
            str = str.Remove(0, 1);
            if (str.Length != 6)
            {
                return false;
            }
            else
            {
                return System.Text.RegularExpressions.Regex.IsMatch(str, @"\A\b[0-9a-fA-F]+\b\Z");
            }
        }

        public static void ColorToHSV(Color color, out double hue, out double saturation, out double value)
        {
            int max = Math.Max(color.R, Math.Max(color.G, color.B));
            int min = Math.Min(color.R, Math.Min(color.G, color.B));

            hue = color.GetHue();
            saturation = (max == 0) ? 0 : 1d - (1d * min / max);
            value = max / 255d;
        }

        public static Color ColorFromHSV(double hue, double saturation, double value)
        {
            int hi = Convert.ToInt32(Math.Floor(hue / 60)) % 6;
            double f = hue / 60 - Math.Floor(hue / 60);

            value = value * 255;
            int v = Convert.ToInt32(value);
            int p = Convert.ToInt32(value * (1 - saturation));
            int q = Convert.ToInt32(value * (1 - f * saturation));
            int t = Convert.ToInt32(value * (1 - (1 - f) * saturation));

            if (hi == 0)
                return Color.FromArgb(255, v, t, p);
            else if (hi == 1)
                return Color.FromArgb(255, q, v, p);
            else if (hi == 2)
                return Color.FromArgb(255, p, v, t);
            else if (hi == 3)
                return Color.FromArgb(255, p, q, v);
            else if (hi == 4)
                return Color.FromArgb(255, t, p, v);
            else
                return Color.FromArgb(255, v, p, q);
        }
    }
}