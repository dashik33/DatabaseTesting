import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBPractice2 {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        String userName = "syntax_hrm";
        String password = "syntaxhrm123";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(dbUrl, userName, password);
            statement = connection.createStatement();
            String query = "select * from person";
            resultSet = statement.executeQuery(query);

            System.out.println(DBUtils.getListOfMapFromResultSet(resultSet));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConnection(connection);
            DBUtils.closeStatement(statement);
            DBUtils.closeResultSet(resultSet);
        }
    }
}



