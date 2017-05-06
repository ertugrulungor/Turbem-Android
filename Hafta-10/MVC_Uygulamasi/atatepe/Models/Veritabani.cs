using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace atatepe.Models
{
    public class Veritabani
    {
        public List<Kisi> kisiler = new List<Kisi>();

        public Veritabani()
        {
            kisiler.Add(new Kisi() { id = 1, adsoyad = "Ertugrul Ungor", dogumtarihi = Convert.ToDateTime("03.01.1995") });

            kisiler.Add(new Kisi() { id = 2, adsoyad = "Damla Demir", dogumtarihi = Convert.ToDateTime("01.01.1995") });

            kisiler.Add(new Kisi() { id = 3, adsoyad = "Fatma Kaya", dogumtarihi = Convert.ToDateTime("05.11.1996") });
        }
    }
}