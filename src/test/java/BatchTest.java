import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchTest {


    @Test
    void testStatement() throws SQLException{
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = "INSERT INTO comment (email,comment) VALUES ('eko@test.com', 'Hi')";

        for (int i = 0; i < 1000; i++){
            statement.addBatch(sql);
        }

        statement.executeBatch();
        statement.close();
        connection.close();
    }


    @Test
    void testPreparedStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "INSERT INTO comment (email,comment) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < 1000; i++){
            preparedStatement.clearParameters();
            preparedStatement.setString(1, "maulana@test.com");
            preparedStatement.setString(2, "Hello");
            preparedStatement.addBatch();
        }

        preparedStatement.executeBatch();
        preparedStatement.close();
        connection.close();


    }


}
