import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {


    @Test
    void testConnection(){
        String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_java_database?serverTimezone=Asia/Jakarta";
        String username = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl,username,password);
            System.out.println("Sukses konek ke database");
        }catch (SQLException exception){
            Assertions.fail(exception);
        }
    }


}
