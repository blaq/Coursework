using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Web;
using System.Web.Mvc;

namespace HW7.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        private string SendRequest(string uri, string credentials, string username)
        {
            HttpWebRequest request = (HttpWebRequest)WebRequest.Create(uri);
            request.Headers.Add("Authorization", "token " + credentials);
            request.UserAgent = username;       // Required, see: https://developer.github.com/v3/#user-agent-required
            request.Accept = "application/json";

            string jsonString = null;
            // TODO: You should handle exceptions here
            using (WebResponse response = request.GetResponse())
            {
                Stream stream = response.GetResponseStream();
                StreamReader reader = new StreamReader(stream);
                jsonString = reader.ReadToEnd();
                reader.Close();
                stream.Close();
            }
            return jsonString;
        }

        public JsonResult user()
        {
            string token = System.Web.Configuration.WebConfigurationManager.AppSettings["GithubAPIToken"];
            string user = System.Web.Configuration.WebConfigurationManager.AppSettings["GithubUser"];
            string url = @"https://api.github.com/users/" + user;

            var igot = SendRequest(url, token, user);
            JObject obj = JObject.Parse(igot);

            var jsonString = new
            {
                username = (string)obj["login"],
                avatar_url = (string)obj["avatar_url"],
                html_url = (string)obj["html_url"],
                name = (string)obj["name"],
                company = (string)obj["company"],
                location = (string)obj["location"],
                email = (string)obj["email"]
            };
            return Json(jsonString, JsonRequestBehavior.AllowGet);
        }

        public JsonResult repositories()
        {
            string token = System.Web.Configuration.WebConfigurationManager.AppSettings["GithubAPIToken"];
            string user = System.Web.Configuration.WebConfigurationManager.AppSettings["GithubUser"];
            string url = @"https://api.github.com/users/" + user + "/repos";

            var igot = SendRequest(url, token, user);
            JArray objects = JArray.Parse(igot);
            var myList = new List<object>();

            int count = 0;
            foreach (var obj in objects)
            {
                var temp = new 
                {
                    name = (string)objects[count]["name"],
                    owner = (string)objects[count]["owner"]["login"],
                    html_url = (string)objects[count]["html_url"],
                    full_name = (string)objects[count]["full_name"],
                    owner_avatar_url = (string)objects[count]["owner"]["avatar_url"],
                    updated_at = (string)objects[count]["updated_at"]
                };
                myList.Add(temp); 
                count++;
            }

            return Json(myList, JsonRequestBehavior.AllowGet);
        }

        public JsonResult commits(string user, string repo)
        {
            string token = System.Web.Configuration.WebConfigurationManager.AppSettings["GithubAPIToken"];
            string url = @"https://api.github.com/repos/" + user + "/" + repo + "/commits";

            var igot = SendRequest(url, token, user);
            JArray objects = JArray.Parse(igot);
            var myList = new List<object>();

            int count = 0;
            foreach (var obj in objects)
            {
                var temp = new
                {
                    sha = (string)objects[count]["sha"],
                    committer = (string)objects[count]["commit"]["committer"]["name"],
                    date = (string)objects[count]["commit"]["committer"]["date"],
                    message = (string)objects[count]["commit"]["message"],
                    html_url = (string)objects[count]["html_url"]
                };
                myList.Add(temp);
                count++;
            }

            return Json(myList, JsonRequestBehavior.AllowGet);
        }
    }
}