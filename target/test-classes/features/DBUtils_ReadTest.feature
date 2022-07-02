Feature: US1003 kullanıcı DBUtil ile istenen değeri test eder

  Scenario: TC03 Kullanıcı istenen değeri test edebilmeli

    Given kullanıcı DBUtil ile HMC veri tabanına bağlanır
    And kullanıcı DBUtil ile "tHOTELROOM" tablosundaki "Price" verilerini alir
    And kullanıcı DBUtil ile "Price" sütünundaki verileri okur
    Then DBUtil le 2. "Price" in 4000 olduğunu test eder