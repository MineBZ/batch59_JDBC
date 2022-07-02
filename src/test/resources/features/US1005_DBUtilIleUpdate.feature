Feature: US1005 Kullanici database update yapar

  Scenario: TC05 kullanıcı update yapabilmeli

    Given kullanıcı DBUtil ile HMC veri tabanına bağlanır
    Then tHOTEL tablosundaki IDHotel degeri 1017 olan kaydin Email bilgisini "BendenBuKadar@gmail.com" yapar
    # UPDATE tHOTEL SET Email='sizOldunuz@gmail.com' WHERE IDHotel=1016