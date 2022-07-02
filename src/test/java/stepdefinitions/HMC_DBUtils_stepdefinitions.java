package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.lang.reflect.Field;
import java.sql.SQLException;

public class HMC_DBUtils_stepdefinitions {

    @Given("kullanıcı DBUtil ile HMC veri tabanına bağlanır")
    public void kullanıcı_db_utils_ile_hmc_veri_tabanına_bağlanır() {
        DBUtils.getConnection();
    }
    @Given("kullanıcı DBUtil ile {string} tablosundaki {string} verilerini alir")
    public void kullanıcı_db_util_ile_tablosundaki_verilerini_alir(String table, String field) {
        String query = "SELECT "+field+" FROM "+ table;
        DBUtils.executeQuery(query);
    }
    @Given("kullanıcı DBUtil ile {string} sütünundaki verileri okur")
    public void kullanıcı_db_util_ile_sütünundaki_verileri_okur(String field) throws SQLException {
        DBUtils.getResultset().first();
        System.out.println(DBUtils.getResultset().getString(field));
        }
    @Then("DBUtil ile tüm {string} değerlerini sira numarasi ile yazdirir")
    public void dbutilIleTümDeğerleriniSiraNumarasiIleYazdirir(String field) throws SQLException {
        DBUtils.getResultset().last();
        int sonSatirNo=DBUtils.getResultset().getRow();
        DBUtils.getResultset().first();

        for (int i = 1; i <sonSatirNo; i++) {

            System.out.println(i+".kayit : "+DBUtils.getResultset().getString(field));
            DBUtils.getResultset().next();
        }
    }

    @Then("DBUtil le {int}. {string} in {int} olduğunu test eder")
    public void dbutilLeInOlduğunuTestEder(int istenenSiraNo, String field, int expectedDeger) throws SQLException {
        DBUtils.getResultset().absolute(istenenSiraNo);
        double actualDeger=DBUtils.getResultset().getDouble(field);
        System.out.println("expected deger : " + expectedDeger);
        System.out.println("actual deger : " + actualDeger);
        Assert.assertTrue(actualDeger==expectedDeger);

    }

    @Then("tHOTEL tablosundaki IDHotel degeri {int} olan kaydin Email bilgisini {string} yapar")
    public void thotelTablosundakiIDHotelDegeriOlanKaydinEmailBilgisiniYapar(int idHotel, String yeniEmail) {

        String updateQuery="UPDATE tHOTEL SET Email='"+yeniEmail+"' WHERE IDHotel="+idHotel+";";
        DBUtils.executeQuery(updateQuery);

    }
}
