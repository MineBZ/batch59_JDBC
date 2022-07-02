Feature: US1002 kullanıcı DB Utils ile database e bağlanabilmeli

  @DBUtils
  Scenario: TC01 kullanıcı DB Utils ile  database deki bilgileri okur

    Given kullanıcı DBUtil ile HMC veri tabanına bağlanır
    And kullanıcı DBUtil ile "tHOTELROOM" tablosundaki "Price" verilerini alir
     # SELECT Price FROM tHOTELROOM
    And kullanıcı DBUtil ile "Price" sütünundaki verileri okur