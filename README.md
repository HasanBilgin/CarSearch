Bu proje txt dosyası içerindenn okuduğu araba bilgilerini kriter ve kelime türüne göre filtreleyerek getirmektedir.

Ekteki projeyi çalıştırmak için aşağıdaki adımları takip edebilirsiniz.

1) Java 1.8 ve maven 3.x sürümleri kurulu olmalıdır.
2)Projeyi klonladıktan sonra proje dizininde komut satırını açarak aşağıdaki iki komuttan biri ile uygulamayı çalıştırabilirsiniz

java - jar target/CarSearch-1.0.0-SNAPSHOT.jar
mvn spring-boot:run
 
Uygulama başladıktan sonra aşağıdaki gibi araba arama servisini çapırabilirsiniz

Rest Api Araba Arama İşlemi
----------------------------------------------------------------------------------------
URL : localhost:8080/cars
Method : GET
Örnek input:

```{
    "key": "a",
    "criteria": "marka"
}
```
criteria alanına "marka","model","sınıf","hepsi" kriterlerine göre araba dosyası içerisinde key bilgisi geçen tüm arabaları listeler.

```[
    {
        "brand": "Audi",
        "model": "A3",
        "type": "Otomobil"
    },
    {
        "brand": "Audi",
        "model": "A4",
        "type": "Otomobil"
    },
    {
        "brand": "Audi",
        "model": "A5",
        "type": "Otomobil"
    }
]
```
----------------------------------------------------------------------------------------
Aynı sorgu parametre vermeden aşağıdaki gibi çalışabilmektedir.
localhost:8080/{criteria}/{key}
criteria ve key yazan alanlara sorgu parametreleri girildiğinde aynı sonuçlar alınabilmektedir.
----------------------------------------------------------------------------------------
SOAP Araba Arama İşlemi

URL : http://localhost:8080/ws
Örnek İnput:

src/main/resources/car-search-request.xml dizininde bulunmaktadır
