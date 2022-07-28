# Bootcamp-Final-Project

- Bootcamp eğitimi bitirme ödevidir.
  - Projeyi başlatmak için run butonuna tıklamak yeterlidir.
  - Proje başladıktan sonra ;
    - Bizi bir login ekranı karşılıyor ,eğer kayıt yoksa kayıt ol butonuna tıklayıp ordan yeni bir kayıt oluşturabilirsiniz.
    - Başarılı bir şekilde giriş yaptıktan sonra bizi kayıtlı Adminlerini listesini gösteren ve finansal datalara erişmek için bir `Listele` butonu karşılıyor.
    - Listele butonuna tıkladığınızda bizi Customer Policyleri gösteren bir tablo görüyor.
    - Burada `tabbedPane` yapısı mevcut .Sırasıla -customer policy,policy amount ve compare two policy adında 3 tabbed var.
    - Bu panelerin hemen altlarında oluşturulmak istene grafik yapısının butonarı mevcut
      - `Line Chart` butonu ile  çizgi grafik oluşturabilirsiniz.
      - `Bar Chart` butonu ile çubuk grafik oluşturabilirsiniz.
      - `Pie Chart` butonu ile yuvarlak grafik oluşturabilirsiniz.
      - `Reports` butonu ile raporlarınızı excel formatında masaüstünüze kayıt edebilirsiniz.
    - `Compare Two Policy` butonuna tıkladığınızda iki policy arasında karşılaştırma grafiği oluşturabilirsiniz.
      - `Compare Show Table` butonu ile tablo görünümüne geçebilirsiniz.
      - `Compare Show Bar` butonu ile bar grafik görünümüne geçebilirsiniz.
      - Ancak Tabloda göstermeden bar formatında gösteremezsiniz! .


- Veritabanını ayağa kaldırmak için `docker-compose up` komutunu kullanın.
  - Docker içerisinde `postgresql` veriabanı konfigurasyonları yapılmıştır.

- ### ÖNEMLİ NOT 1 !!!
    - Er-Diagram ve Use-Case Diagramları `./resources` klasörüne eklenmiştir.

- ### ÖNEMLİ NOT 2 !!!
    - Bootcamp eğitimi bitirme Ödevidir.