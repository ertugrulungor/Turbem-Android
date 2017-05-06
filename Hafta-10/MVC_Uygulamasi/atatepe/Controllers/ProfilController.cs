using atatepe.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace atatepe.Controllers
{
    public class ProfilController : Controller
    {
        // GET: Profil
        public ActionResult Index()
        {
            Veritabani db = new Veritabani();
            ViewBag.kisiler = db.kisiler;
            return View();
        }

        public ActionResult Detay(int id)
        {
            Veritabani db = new Veritabani();
            if (db.kisiler.Any(x => x.id == id) == true)
            {
                Kisi k = db.kisiler.FirstOrDefault(x => x.id == id);
                ViewBag.kisi = k;
            }
            else
            {
                return RedirectToAction("Index");
            }
            return View();
        }

    }
}