using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace HW7
{
    public class RouteConfig
    {
        public static void RegisterRoutes(RouteCollection routes)
        {
            routes.IgnoreRoute("{resource}.axd/{*pathInfo}");

            routes.MapRoute(
                name: "regularAPI",
                url: "api/{action}",
                defaults: new { controller = "Home", action = "{action}" }
            );

            routes.MapRoute(
                name: "commitsAPI",
                url: "api/commits{user}",
                defaults: new { controller = "Home", action = "{action}"  }
            );

            routes.MapRoute(
                name: "Default",
                url: "{controller}/{action}/{id}",
                defaults: new { controller = "Home", action = "Index", id = UrlParameter.Optional }
            );
        }
    }
}
