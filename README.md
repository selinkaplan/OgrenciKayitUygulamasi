# Öğrenci Kayıt Uygulaması

Bu proje, Java ve Groovy dilleri kullanılarak geliştirilmiş bir öğrenci kayıt uygulamasını içermektedir.

## Kullanılan Teknolojiler
Java
Groovy (IntelliJ IDEA kullanılarak)

## Anasayfa Formu (Anasayfa):
Bu form, programın başlangıç noktasıdır. Anasayfada, ders kaydı, öğrenci kaydı ve çıkış işlemleri için butonlar bulunur.

Butonlar:
"Ders Kayıt": DersKayitForm'u açar.
"Öğrenci Kayıt": OgrenciKayitForm'u açar.
"Çıkış": Programı kapatır.

## Ders Kayıt Formu (DersKayitForm):
Bu form, yeni ders kayıtlarını oluşturmak için kullanılır.

Alanlar:
Ders Kodu (TextField)
Ders Adı (TextField)
Dönem (ComboBox)
Butonlar:
"Kaydet": Girilen ders bilgilerini data klasörü içindeki dersler.csv dosyasına kaydeder.

## Öğrenci Kayıt Formu (OgrenciKayitForm):
Bu form, yeni öğrenci kayıtlarını oluşturmak için kullanılır.

Alanlar:

Öğrenci No (TextField)
Öğrenci Adı (TextField)
Öğrenci Soyadı (TextField)
Öğrenci Bölümü (ComboBox)
Ders Seçimi (ComboBox)
Dönem Seçimi (ComboBox)
Butonlar:

"Kaydet": Girilen öğrenci bilgilerini data klasörü içindeki ogrenciler.csv dosyasına kaydeder.
Ek Açıklamalar:

"Öğrenci Bölümü" ComboBox'ı, önceden tanımlanan bölümleri içerir.
"Ders Seçimi" ComboBox'ı, DersKayitForm'u üzerinden alınan dersleri içerir.

## Yardımcı Sınıf (FileIO):
Bu sınıf, dosya giriş/çıkış işlemlerini yönetir.

Metodlar:
readFromFile(fileName: String): List<String>: Belirtilen dosyadan satırları okur ve liste olarak döndürür.
writeToFile(fileName: String, content: String): Belirtilen dosyaya içeriği yazar.

