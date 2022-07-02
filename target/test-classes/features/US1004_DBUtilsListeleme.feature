Feature: US1004 Kullanici istenen tablodaki istenen fieled'i listeleyebilir

  Scenario: TC04 Kullanıcı field listesi yazdırabilmeli

    Given kullanıcı DBUtil ile HMC veri tabanına bağlanır
    And kullanıcı DBUtil ile "tHOTEL" tablosundaki "Email" verilerini alir
    And kullanıcı DBUtil ile "Email" sütünundaki verileri okur
    Then DBUtil ile tüm "Email" değerlerini sira numarasi ile yazdirir
