using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace atatepe.Controllers
{
    public class DenemeController : Controller
    {
        // GET: Deneme
        public ActionResult Index()
        {
            ViewBag.siteBaslik = "Index Page";
             
            ViewBag.adsoyad = "Ertuğrul Üngör";
            ViewData["yas"] = 22;

            return View();
        }

        public ActionResult Sayfa()
        {
            ViewBag.siteBaslik = "Sayfa Page";
            List<string> takimlar = new List<string>();
            takimlar.Add("Beşiktaş");
            takimlar.Add("Galatasaray");
            takimlar.Add("Fenev");

            ViewData["takimlar"] = takimlar;

            ViewBag.takims = takimlar;
            return View();
        }
    }
}