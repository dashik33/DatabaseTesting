import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBPractice1 {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        String userName = "syntax_hrm";
        String password = "syntaxhrm123";
        Connection connection = DriverManager.getConnection(dbUrl, userName, password);
        Statement statement = connection.createStatement();
        String query = "select * from person";
        ResultSet resultSet = statement.executeQuery(query);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        //storing all data of rows in a Map (column name, column value), storing all rows in a List
        List<Map<String, String>> tableData= new ArrayList<>();
        while (resultSet.next()) {
            Map<String, String> row=new LinkedHashMap<>();
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) { //in DB column's index starts with 1
                String columnName = resultSetMetaData.getColumnLabel(i);
                String columnValue = resultSet.getString(columnName);
                row.put(columnName, columnValue);
            }
            tableData.add(row);

        }
        for (Map<String, String> data:tableData)
        System.out.println(data);

    }

}
