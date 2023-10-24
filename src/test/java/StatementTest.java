import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementTest {

    @Test
    void testCreateStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        statement.close();
        connection.close();
    }

    @Test
    void testExecuteUpdate() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = """
                     INSERT INTO customers(id, name, email) 
                     VALUES ('maulana', 'maulana', 'maulana@test.com')
                      """;

        int update = statement.executeUpdate(sql);
        System.out.println(update);

        statement.close();
        connection.close();

    }

    @Test
    void testExecuteDelete() throws SQLException{
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = """
                DELETE FROM customers;
                """;

        int update = statement.executeUpdate(sql);
        statement.close();
        connection.close();
    }


    @Test
    void testExecuteQuery() throws SQLException{
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = """
                    SELECT * FROM customers
                """;

        ResultSet  resultSet =  statement.executeQuery(sql);
        resultSet.close();
        statement.close();
        connection.close();

    }

    @Test
    void testInsertData() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = """
                     INSERT INTO admin(username, password) 
                     VALUES ('admin', 'admin')
                      """;

        int update = statement.executeUpdate(sql);
        System.out.println(update);

        statement.close();
        connection.close();

    }


}
