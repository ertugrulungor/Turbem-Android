using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using turbemblog.Models;

namespace turbemblog.Controllers
{
    public class AdminController : Controller
    {
        turbemblogEntities db = new turbemblogEntities();
        // GET: Admin
        public ActionResult Index()
        {
            return View();
        }

        public JsonResult GirisYap(string kulAdi, string sifre)
        {
            if(db.Kullanicis.Any(x=>x.kullaniciAdi == kulAdi && x.sifre == sifre))
            {
                Kullanici k = db.Kullanicis.FirstOrDefault(x => x.kullaniciAdi == kulAdi && x.sifre == sifre);

                var jsonObject = new
                {
                    username = k.kullaniciAdi,
                    email = k.email,
                    success = 1
                };
                return Json(jsonObject, JsonRequestBehavior.AllowGet);
            }
            else
            {
                var jsonObject = new
                {
                    username = "",
                    email = "",
                    success = 0
                };
                return Json(jsonObject, JsonRequestBehavior.AllowGet);
            }
        }
    }
}