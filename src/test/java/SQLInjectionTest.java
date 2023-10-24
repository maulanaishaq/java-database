import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLInjectionTest {


    @Test
    void SqlInjectionTest() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String username = "admin'; #";
        String password = "salah";

        String sql = "SELECT * FROM admin WHERE username = '" + username +
                "' AND PASSWORD = '" + password + "'";

        System.out.println(sql);

        ResultSet resultSet = statement.executeQuery(sql);


        if (resultSet.next()){

            System.out.println("Sukses Login " + resultSet.getString("username"));

        }else {
            System.out.println("Gagal Login");
        }

        resultSet.close();
        statement.close();
        connection.close();


    }



}
