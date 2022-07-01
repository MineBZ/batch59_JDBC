package stepdefinitions;

import io.cucumber.java.en.Given;

import java.sql.*;

public class HMC_db_Stepdefinations {

    String url="jdbc:sqlserver://184.168.194.58:1433;databaseName=hotelmycamp ; " +
            "user=techproed;password=P2s@rt65";
    String username="techproed";
    String password="P2s@rt65";

    Connection connection;
    Statement statement;
    ResultSet resultSet;


    @Given("kullanıcı HMC veritabanına bağlanır")
    public void kullanıcı_hmc_veritabanına_bağlanır() throws SQLException {
        connection= DriverManager.getConnection(url,username,password);
        statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }
    @Given("kullanıcı {string} tablosundaki {string} verilerini bağlanır")
    public void kullanıcı_tablosundaki_verilerini_bağlanır(String table, String field) throws SQLException {
        String query = "SELECT "+field+" FROM "+ table;
        resultSet = statement.executeQuery(query);
    }
    @Given("kullanıcı {string} sütünundaki verileri okur")
    public void kullanıcı_sütünundaki_verileri_okur(String field) throws SQLException {
        // resultset iterator gibi calisir
        //
        resultSet.first();
        System.out.println(resultSet.getString("Price"));// 225.0000
        resultSet.next(); // iterator'a benzer sekilde calisir
        // next()'u imleci bir sonraki degerin yanina goturur
        // bize true veya false doner
        System.out.println(resultSet.getString("Price")); // 4000.0000

        System.out.println(resultSet.next()); // true
        System.out.println(resultSet.getString("Price")); // 445.0000
        // next() kullanilirken cok dikkatli olmaliyiz
        // cunku nerede olursa olsun imleci bir sonraki elemente gecirecektir.

        System.out.println("===============Liste===============");
        resultSet.absolute(0);
        int sira=1;
        while(resultSet.next()){
            System.out.println(sira+". kayt : " + resultSet.getString("Price"));
            sira++;
        }


        // tabloda kac satir oldugunu nasil buluruz ?

        resultSet.last();
        System.out.println(resultSet.getRow()); // 416


    }
}



