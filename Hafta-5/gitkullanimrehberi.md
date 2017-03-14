#Git Kullanma Rehberi

**Bir projeyi bilgisayarınıza indirmek:**
>git clone **sunucu**

**Tüm dosyaları github'a atmak:**
Klonladığınız projede yaptığınız tüm değişiklikleri sunucuya atmak için aşağıdaki komutlaru sırayla çalıştırın
>git add *
>git commit -m "Açıklama"
>git push

**Yeni bir depo oluşturmak:**
Depoya atmak istediğiniz klasöre gidin ve aşağıdaki komutları sırayla çalıştırın
>git init
>git add *
>git commit -m "Açıklama"
>git remote add origin **sunucu**
>git push -u origin master

**Sunucudaki dosyaları bilgisayara almak (Güncelleme):**
>git pull

**Tek bir dosya atmak**
>git add **dosyaadı**
>git commit -m "Açıklama"
>git push
