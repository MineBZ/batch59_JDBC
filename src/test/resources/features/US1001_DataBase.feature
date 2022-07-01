Feature: US1001 kullanıcı doğru bilgilerle database e bağlanabilmeli

  @db
  Scenario: TC01 kullanıcı database deki bilgileri okur

  Given kullanıcı HMC veritabanına bağlanır
  And kullanıcı "tHOTELROOM" tablosundaki "Price" verilerini bağlanır
     # SELECT Price FROM tHOTELROOM
  And kullanıcı "Price" sütünundaki verileri okur