using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using turbemblog.Models;

namespace turbemblog.Controllers
{
    public class HomeController : Controller
    {
        turbemblogEntities db = new turbemblogEntities();
        // GET: Home
        public ActionResult Index()
        {
            return View(db.Makales.OrderByDescending(x => x.yayimTarihi.Value));
        }

        public ActionResult Content(int? id)
        {
            if(db.Makales.Any(x=>x.id == id))
            {
                return View(db.Makales.Find(id));
            }else if(id == 0)
            {
                return RedirectToAction("Index");
            }
            else
            {
                return RedirectToAction("Index");
            }
            
        }

        public ActionResult tag(int? id)
        {
            if (db.EtiketMakales.Any(x => x.EtiketId == id))
            {
                return View(db.EtiketMakales.Where(x => x.EtiketId == id));
            }
            else if (id == 0)
            {
                return RedirectToAction("Index");
            }
            else
            {
                return RedirectToAction("Index");
            }
        }
    }
}